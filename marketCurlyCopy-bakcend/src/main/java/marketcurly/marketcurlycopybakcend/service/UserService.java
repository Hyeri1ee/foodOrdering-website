package marketcurly.marketcurlycopybakcend.service;

import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
  private final UserRepositoryInterface userRepository;

  @Autowired
  public UserService(UserRepositoryInterface userRepository) {
    this.userRepository = userRepository;
  }

  /*
  회원가입
   */
  public void join(User user){
    validateDuplicateUser(user);
    userRepository.save(user);

  }

  private void validateDuplicateUser(User user) {
    userRepository.findByLoginId(user.getLoginId())
            .ifPresent(m ->{
              throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
  }

  /*
  회원 전체 조회
   */
  public List<User> findAll(){
    return userRepository.findAll();
  }

  /*
  회원 loginId 로 조회
   */
  public User findByLoginId(String loginId){
    User user = new User();
    Optional<User> found = userRepository.findByLoginId(loginId);
    found.ifPresent(m -> {
      user.createUser(m.getLoginId(), m.getPassword(), m.getNickName(), m.getName(), m.getBirthday(),m.isAdmin());
    });
    return user;
  }

  /*
   회원 정보 update
   */
  public User updateBasedOnRequest(String loginId, User.UserRequest request) {
    User user = userRepository.findByLoginId(loginId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

    user.update(request);
    return userRepository.save(user);
  }
  /*
  회원 삭제
   */
  public void delete(String loginId) {
    userRepository.delete(loginId);
  }
}
