package marketcurly.marketcurlycopybakcend.service.serviceInterface;

import marketcurly.marketcurlycopybakcend.domain.Item;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface ItemService {
  public void save(Item.ItemRequest reqeust);

  public Optional<Item.ItemResponse> getItem(String name);
  public void deleteItem(String name);
}
