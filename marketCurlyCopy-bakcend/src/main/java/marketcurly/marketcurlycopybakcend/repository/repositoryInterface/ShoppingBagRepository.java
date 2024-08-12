package marketcurly.marketcurlycopybakcend.repository.repositoryInterface;

import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBagRepository extends JpaRepository<ShoppingBag, Long> {
  ShoppingBag findByUser(String loginId);
}
