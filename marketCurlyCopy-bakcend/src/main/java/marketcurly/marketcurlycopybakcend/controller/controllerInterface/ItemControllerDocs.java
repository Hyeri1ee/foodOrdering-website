package marketcurly.marketcurlycopybakcend.controller.controllerInterface;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.domain.QnA;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ITEM API", description = "item related apis")
public interface ItemControllerDocs {
  //1.create
  @Operation(summary="POST: create item", description = "create item with its values")
  @Parameters(value ={
          @Parameter(name ="item_name", description = "item_name"),
          @Parameter(name ="category", description = "category"),
          @Parameter(name ="description", description = "description"),
          @Parameter(name ="detail", description = "detail"),
          @Parameter(name ="is_new", description = "is_new"),
          @Parameter(name ="price", description = "price"),
          @Parameter(name ="stock", description = "stock"),
  })
  @ApiResponse(responseCode = "200", description = "item created successfully", content = @Content(
          schema = @Schema(implementation = Item.ItemResponse.class )
  ))
  @PostMapping("/create")
  public ResponseEntity<Item.ItemResponse> createItem (@RequestBody Item.ItemRequest request);

  //2.update
  @Operation(summary="PUT: update item", description = "update item with its values")
  @Parameters(value ={
          @Parameter(name ="item_name", description = "item_name"),
          @Parameter(name ="category", description = "category"),
          @Parameter(name ="description", description = "description"),
          @Parameter(name ="detail", description = "detail"),
          @Parameter(name ="is_new", description = "is_new"),
          @Parameter(name ="price", description = "price"),
          @Parameter(name ="stock", description = "stock"),
  })
  @ApiResponse(responseCode = "200", description = "item updated successfully", content = @Content(
          schema = @Schema(implementation = Item.ItemResponse.class )
  ))
  @PutMapping("/update")
  public ResponseEntity<Item.ItemResponse> updateItem (@RequestBody Item.ItemRequest request);

  //3.read
  @Operation(summary="GET: get item info", description = "get item info with its values")
  @Parameters(value ={
          @Parameter(name ="itemId", description = "itemId"),
  })
  @ApiResponse(responseCode = "200", description = "got QnA info successfully", content = @Content(
          schema = @Schema(implementation = Item.ItemResponse.class )
  ))
  @GetMapping("/getinfo")
  public ResponseEntity<Item.ItemResponse> getinfoItem (@RequestParam String itemName);

  //4.delete
  @Operation(summary = "DELETE: delete item", description = "delete item with its values")
  @Parameters(value = {
          @Parameter(name ="itemId", description = "itemId"),  }
  )
  @ApiResponse(responseCode = "200", description = "item deleted successfully", content = @Content(
          schema = @Schema(implementation = Item.ItemResponse.class )

  ))
  @DeleteMapping("/delete")
  public ResponseEntity<Item.ItemResponse> deleteItem (@RequestParam String name);
}
