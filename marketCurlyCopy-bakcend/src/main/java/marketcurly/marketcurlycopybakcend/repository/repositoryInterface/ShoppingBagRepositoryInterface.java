package marketcurly.marketcurlycopybakcend.repository.repositoryInterface;

import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;

public interface ShoppingBagRepositoryInterface{
  ShoppingBag findByUser(String loginId);

  void save(ShoppingBag entity);

  void deleteById(Long id);
}
