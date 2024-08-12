package marketcurly.marketcurlycopybakcend.repository.repositoryInterface;

import jakarta.persistence.EntityManager;
import marketcurly.marketcurlycopybakcend.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {

  User save(User user);

  Optional<User> findByLoginId(String loginId);
  List<User> findAll();

  void delete(String loginId);
}
