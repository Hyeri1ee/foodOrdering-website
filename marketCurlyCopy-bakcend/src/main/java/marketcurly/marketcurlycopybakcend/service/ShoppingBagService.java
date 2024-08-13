package marketcurly.marketcurlycopybakcend.service;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ShoppingBagRepositoryInterface;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.UserRepositoryInterface;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class  ShoppingBagService {
  private final ShoppingBagRepositoryInterface shoppingBagRepository;
  private final UserRepositoryInterface userRepository;

  public ShoppingBag getShoppingBag(String loginId) {
    ShoppingBag userShoppingBag = shoppingBagRepository.findByUser(loginId);
    return userShoppingBag;
  }

  public void deleteShoppingBag(String loginId) {
    Long id = shoppingBagRepository.findByUser(loginId).getUser().getId();
    shoppingBagRepository.deleteById(id);
  }


  //create 용 save
  public ShoppingBag.shoppingbagResponse save(UserService userService, String loginId) {
    User user = userService.findByLoginId(loginId);
    ShoppingBag shoppingBag = new ShoppingBag().builder()
            .user(user)
            .itemList(null)
            .build();
    shoppingBagRepository.save(shoppingBag);
    user.setShoppingBag(shoppingBag);
    userRepository.save(user);
    return new ShoppingBag.shoppingbagResponse(
            shoppingBag.getItemList(),shoppingBag.getUser());
  }

  //update 용 save
  public ShoppingBag.shoppingbagResponse save(ShoppingBag.shoppingbagRequest request) {
    ShoppingBag shoppingBag = request.toEntity();
    shoppingBagRepository.save(shoppingBag);
    return new ShoppingBag.shoppingbagResponse(
            shoppingBag.getItemList(),shoppingBag.getUser());
  }
}
