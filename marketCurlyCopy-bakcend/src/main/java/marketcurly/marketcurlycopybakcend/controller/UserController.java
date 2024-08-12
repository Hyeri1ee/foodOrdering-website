package marketcurly.marketcurlycopybakcend.controller;

import marketcurly.marketcurlycopybakcend.controller.controllerInterface.UserControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerDocs {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @Override
  public ResponseEntity createUser(User.UserRequest request) {

    User user = new User();
    try {
      user.createUser(request.getLoginId(), request.getPassword(), request.getNickName(), request.getName(),
              request.getBirthday(), request.isAdmin());
    }catch(Exception e){
      Map<String, Object> result = new HashMap<>();
      result.put("message", e.getMessage());
      return ResponseEntity.badRequest().body(result);

    }
    userService.join(user);
    return new ResponseEntity<>(new User.UserResponse(user), HttpStatus.OK);
  }

  @Override
  public ResponseEntity updateUser(User.UserRequest request) {
    User user;
    User userDefined;
    try {
      user = userService.findByLoginId(request.getLoginId());

    }catch(Exception e){
      Map<String, Object> result = new HashMap<>();
      result.put("message", e.getMessage());
      return ResponseEntity.badRequest().body(result);

    }

    userDefined = userService.updateBasedOnRequest(user.getLoginId(),request);
    return new ResponseEntity<>(new User.UserResponse(userDefined), HttpStatus.OK);
  }

  @Override
  public ResponseEntity getUser(User.UserRequest request) {
    User user;
    try {
      user = userService.findByLoginId(request.getLoginId());

    }catch(Exception e){
      Map<String, Object> result = new HashMap<>();
      result.put("message", e.getMessage());
      return ResponseEntity.badRequest().body(result);

    }
    return  new ResponseEntity<>(new User.UserResponse(user), HttpStatus.OK);
  }

  @Override
  public ResponseEntity deleteUser(@RequestParam String loginId) {

    userService.delete(loginId);

    return  new ResponseEntity<>(HttpStatus.OK);
  }
}
