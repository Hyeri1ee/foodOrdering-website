package marketcurly.marketcurlycopybakcend.controller.controllerInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketcurly.marketcurlycopybakcend.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "USER API", description = "user related apis")
public interface UserControllerDocs {

  //1.create
  @Operation(summary = "POST: create user", description = "create user with its values")
  @Parameters(value = {
          @Parameter(name = "login_id", description = "user's login ID", required = true),
          @Parameter(name = "password", description = "user's password", required = true),
          @Parameter(name = "nickname", description = "user's nickname", required = true),
          @Parameter(name = "name" , description = "user's real name", required = true),
          @Parameter(name = "birthday", description = "user's birthday", required = false),
          @Parameter(name = "is_admin", description = "whether user is admin or not", required = true),
          @Parameter(name = "register_time", description = "registered time", required = false)
  })
  @ApiResponse(responseCode = "200", description = "user created successfully", content = @Content(
          schema = @Schema(implementation = User.UserResponse.class)

  ))
  @PostMapping("/create")
  public ResponseEntity<User.UserResponse> createUser (@RequestBody User.UserRequest request);


  //2.update
  @Operation(summary = "PUT: update user", description = "update user with its values")
  @Parameters(value = {
          @Parameter(name = "login_id", description = "user's login ID", required = true),
          @Parameter(name = "password", description = "user's password", required = true),
          @Parameter(name = "nickname", description = "user's nickname", required = true),
          @Parameter(name = "name" , description = "user's real name", required = true),
  })
  @ApiResponse(responseCode = "200", description = "user updated successfully", content = @Content(
          schema = @Schema(implementation = User.UserResponse.class)

  ))
  @PutMapping("/update")
  public ResponseEntity<User.UserResponse> updateUser(@RequestBody User.UserRequest request);


  //3.read
  @Operation(summary = "GET: get user", description = "get user with its values")
  @Parameters(value = {
          @Parameter(name = "login_id", description = "user's login ID", required = true),
  })
  @ApiResponse(responseCode = "200", description = "got userinfo successfully", content = @Content(
          schema = @Schema(implementation = User.UserResponse.class)

  ))
  @GetMapping("/getinfo")
  public ResponseEntity<User.UserResponse> getUser(@RequestBody User.UserRequest request);


  //4. delete
  @Operation(summary = "DELETE: delete user", description = "delete user with its values")
  @Parameters(value = {
          @Parameter(name = "login_id", description = "user's login ID", required = true),
  })
  @ApiResponse(responseCode = "200", description = "user deleted successfully", content = @Content(
          schema = @Schema(implementation = User.UserResponse.class)

  ))
  @DeleteMapping("/delete")
  public ResponseEntity<User.UserResponse> deleteUser(@RequestBody User.UserRequest request);
}
