package marketcurly.marketcurlycopybakcend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.UserControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController implements UserControllerDocs {


  @Override
  public ResponseEntity<User.UserResponse> createUser(User.UserRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<User.UserResponse> updateUser(User.UserRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<User.UserResponse> getUser(User.UserRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<User.UserResponse> deleteUser(User.UserRequest request) {
    return null;
  }
}
