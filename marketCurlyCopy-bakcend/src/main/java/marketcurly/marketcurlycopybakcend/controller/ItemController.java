package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.ItemControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController implements ItemControllerDocs {
  private final ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @Override
  public ResponseEntity createItem(Item.ItemRequest request) {
    itemService.save(request);
    return new ResponseEntity<>(new Item.ItemResponse(request.toEntity()), HttpStatus.OK);
  }

  @Override
  public ResponseEntity updateItem(Item.ItemRequest request) {
    Optional<Item.ItemResponse> found;
    Item itemDefined;
    try {
      found = itemService.getItem(request.getItemName());

    } catch (Exception e) {
      Map<String, Object> result = new HashMap<>();
      result.put("message", e.getMessage());
      return ResponseEntity.badRequest().body(result);

    }
    itemDefined = itemService.updateBasedOnRequest(found,request);
    return new ResponseEntity<>(new Item.ItemResponse(itemDefined), HttpStatus.OK);
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
