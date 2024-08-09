package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.ShoppingBagControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shoppingBag")
public class ShoppingBagController implements ShoppingBagControllerDocs {
  @Override
  public ResponseEntity<ShoppingBag.shoppingbagResponse> createShoppingbag(String loginId) {
    return null;
  }

  @Override
  public ResponseEntity<ShoppingBag.shoppingbagResponse> updateShoppingbag(ShoppingBag.shoppingbagRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<ShoppingBag.shoppingbagResponse> getShoppingbag(String loginId) {
    return null;
  }

  @Override
  public ResponseEntity<ShoppingBag.shoppingbagResponse> deleteShoppingbag(String loginId) {
    return null;
  }
}
