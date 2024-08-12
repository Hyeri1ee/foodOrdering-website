package marketcurly.marketcurlycopybakcend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ItemRepositoryInterface;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@AllArgsConstructor
@Transactional
public class ItemRepository implements ItemRepositoryInterface {

  private EntityManager em;

  @Override
  public Item save(Item item) {
    em.persist(item);
    return item;
  }
  @Override
  public Item findByName(String name) {
    try {
      Item item = em.createQuery("SELECT m FROM Item m WHERE m.name = :name", Item.class)
              .setParameter("name", name)
              .getSingleResult();
      return item;
    } catch (NoResultException e) {
      return null;
    }
  }

  @Override
  public void delete(Optional<Item.ItemResponse> found) {
    if (found.isPresent()) {
      String itemName = found.get().getItemName();
      Item item = findByName(itemName);
      em.remove(item);
    } else {
      throw new IllegalArgumentException("Item not found");
    }
  }


}
