package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.ShoppingBagControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.service.ShoppingBagService;
import marketcurly.marketcurlycopybakcend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shoppingBag")
public class ShoppingBagController implements ShoppingBagControllerDocs {

  private final ShoppingBagService shoppingBagService;
  private final UserService userService;

  @Override
  public ResponseEntity createShoppingbag(String loginId) {

    ShoppingBag.shoppingbagResponse info = shoppingBagService.save(userService,loginId);
    return new ResponseEntity(info, HttpStatus.OK);
  }


  @Override
  public ResponseEntity<ShoppingBag.shoppingbagResponse> updateShoppingbag(ShoppingBag.shoppingbagRequest request, Item item) {
    request.getItemList().add(item);
    ShoppingBag.shoppingbagResponse info = shoppingBagService.save(request);
    return new ResponseEntity(info, HttpStatus.OK);  }

  @Override
  public ResponseEntity getShoppingbag(String loginId) {
    ShoppingBag ShoppingBag = shoppingBagService.getShoppingBag(loginId);

    return new ResponseEntity<>(ShoppingBag, HttpStatus.OK);
  }

  @Override
  public ResponseEntity deleteShoppingbag(String loginId) {
    shoppingBagService.deleteShoppingBag(loginId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
