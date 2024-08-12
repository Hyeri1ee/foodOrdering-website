package marketcurly.marketcurlycopybakcend.service.serviceInterface;

import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.domain.User;

import java.util.List;

public interface ShoppingBagService {

  public void save(ShoppingBag.shoppingbagRequest request);
  public ShoppingBag getShoppingBag(String loginId);
  public void deleteShoppingBag(String loginId);
  //update 추가해야함
}
