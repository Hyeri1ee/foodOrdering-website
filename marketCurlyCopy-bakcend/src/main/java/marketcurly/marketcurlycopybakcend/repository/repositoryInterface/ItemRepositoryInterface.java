package marketcurly.marketcurlycopybakcend.repository.repositoryInterface;

import marketcurly.marketcurlycopybakcend.domain.Item;

import java.util.Optional;
public interface ItemRepositoryInterface{
  

  public Item findByName(String name);

  void delete(Optional<Item.ItemResponse> found);

  Item save(Item entity);
}
