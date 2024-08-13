package marketcurly.marketcurlycopybakcend.controller.controllerInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "SHOPPINGBAG API", description = "shoppingbag related apis")
public interface ShoppingBagControllerDocs {

  //1.create
  @Operation(summary = "POST: create shoppingbag", description = "create shoppingbag with its values")
  @Parameters(value = {
          @Parameter(name = "login_id", description = "login id", required = true),
  })
  @ApiResponse(responseCode = "200", description = "shoppingbag created successfully", content = @Content(
          schema = @Schema(implementation = ShoppingBag.shoppingbagResponse.class)

  ))
  @PostMapping("/create")
  public ResponseEntity<ShoppingBag.shoppingbagResponse> createShoppingbag (@RequestParam String loginId);


  //2.update
  @Operation(summary = "PUT: update shoppingbag", description = "update shoppingbag with its values")
  @Parameters(value = {
          @Parameter(name = "itemList", description = "itemList in shoppingbag", required = true),
          @Parameter(name = "item" , description = "adding item", required = true)
  })
  @ApiResponse(responseCode = "200", description = "shoppingbag updated successfully", content = @Content(
          schema = @Schema(implementation = ShoppingBag.shoppingbagResponse.class)

  ))
  @PutMapping("/update")
  public ResponseEntity<ShoppingBag.shoppingbagResponse> updateShoppingbag (@RequestBody ShoppingBag.shoppingbagRequest request, @RequestParam Item item);



  //3.read
  @Operation(summary = "GET: get shoppingbag", description = "get shoppingbag with its values")
  @Parameters(value = {
          @Parameter(name = "login_id", description = "user's login ID", required = true),
  })
  @ApiResponse(responseCode = "200", description = "got shoppingbag info successfully", content = @Content(
          schema = @Schema(implementation = ShoppingBag.shoppingbagResponse.class)

  ))
  @GetMapping("/getinfo")
  public ResponseEntity<ShoppingBag.shoppingbagResponse> getShoppingbag (@RequestParam String loginId);


  //4. delete
  @Operation(summary = "DELETE: delete shoppingbag", description = "delete shoppingbag with its values")
  @Parameters(value = {
          @Parameter(name = "login_id", description = "user's login ID", required = true),
  })
  @ApiResponse(responseCode = "200", description = "user deleted successfully", content = @Content(
          schema = @Schema(implementation = User.UserRequest.class)

  ))
  @DeleteMapping("/delete")
  public ResponseEntity<ShoppingBag.shoppingbagResponse> deleteShoppingbag (@RequestParam String loginId);
}
