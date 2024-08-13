package marketcurly.marketcurlycopybakcend.repository;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ShoppingBagRepositoryInterface;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
public class ShoppingBagRepository implements ShoppingBagRepositoryInterface {

  private EntityManager em;

  @Override
  public ShoppingBag findByUser(String loginId) {
    return null;
  }

  @Override
  public void save(ShoppingBag entity) {
    em.persist(entity);
  }

  @Override
  public void deleteById(Long id) {

    ShoppingBag shoppingBag = em.find(ShoppingBag.class, id);
    em.remove(shoppingBag);
  }
}
