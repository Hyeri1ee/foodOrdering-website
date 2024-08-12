package marketcurly.marketcurlycopybakcend.repository.repositoryInterface;

import marketcurly.marketcurlycopybakcend.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item, Long> {

  public Item findByName(String name);

  void delete(Optional<Item.ItemResponse> found);
}
