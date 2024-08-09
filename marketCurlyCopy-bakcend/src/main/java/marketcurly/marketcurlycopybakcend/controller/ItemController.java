package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.ItemControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController implements ItemControllerDocs {
  @Override
  public ResponseEntity<Item.ItemResponse> createItem(Item.ItemReqeust request) {
    return null;
  }

  @Override
  public ResponseEntity<Item.ItemResponse> updateItem(Item.ItemReqeust request) {
    return null;
  }

  @Override
  public ResponseEntity<Item.ItemResponse> getinfoItem(Long itemId) {
    return null;
  }

  @Override
  public ResponseEntity<Item.ItemResponse> deleteItem(Long itemId) {
    return null;
  }
}
