package marketcurly.marketcurlycopybakcend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.UserRepositoryInterface;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Transactional
public class UserRepository implements UserRepositoryInterface {

  private EntityManager em;
  @Override
  public User save(User user) {
    em.persist(user);
    return user;
  }

  @Override
  public Optional<User> findByLoginId(String loginId) {
    try {
      User user = em.createQuery("SELECT m FROM User m WHERE m.loginId = :loginId", User.class)
              .setParameter("loginId", loginId)
              .getSingleResult();
      return Optional.of(user);
    } catch (NoResultException e) {
      return Optional.empty();
    }
  }

  @Override
  public List<User> findAll() {
    return em.createQuery("SELECT u FROM User u", User.class).getResultList();
  }

  @Override
  public void delete(String loginId) {
    User user = findByLoginId(loginId)
            .orElseThrow(() -> new IllegalArgumentException("User not found with loginId: " + loginId));
    em.remove(user);
  }

}
