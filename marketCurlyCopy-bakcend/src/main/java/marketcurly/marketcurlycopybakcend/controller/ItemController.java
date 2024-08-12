package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.ItemControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.service.serviceInterface.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController implements ItemControllerDocs {
  private final ItemService itemService;
  @Override
  public ResponseEntity createItem(Item.ItemRequest request) {
    itemService.save(request);
    return new ResponseEntity<>(new Item.ItemResponse(request.toEntity()), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Item.ItemResponse> updateItem(Item.ItemRequest request) {
    return null;
  }

  @Override
  public ResponseEntity getinfoItem(String name) {
    Optional<Item.ItemResponse> itemResponse = itemService.getItem(name);
    if (itemResponse != null)
      return ResponseEntity.ok(itemResponse);
    else
      return ResponseEntity.badRequest().build();
  }

  @Override
  public ResponseEntity deleteItem(String name) {
    itemService.deleteItem(name);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
