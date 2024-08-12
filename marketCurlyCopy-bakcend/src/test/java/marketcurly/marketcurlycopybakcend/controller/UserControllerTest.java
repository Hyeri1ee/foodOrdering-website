package marketcurly.marketcurlycopybakcend.controller;

import jakarta.persistence.EntityManager;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.UserRepository;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.UserRepositoryInterface;
import marketcurly.marketcurlycopybakcend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserControllerTest {
  private UserController userController;
  private UserService userService;


  private User.UserRequest goodUserRequest;

  @BeforeEach
  public void makeInstance(){
    Date date = new Date(1995,12,17);
    goodUserRequest = new User.UserRequest(
            "hHhH", "1234","hyeri","hyeriLee",false, date
    );
    userController = new UserController(userService);

  }

  @Test
  void GivenGoodUserRequest_ThenUserIsCreated_() {
    ResponseEntity<?> returnOne = userController.createUser(goodUserRequest);
    assertEquals(returnOne.getStatusCode(),HttpStatus.OK);
  }

  @Test
  void GivenChangedRequest_ThenUserIsUpdated_() {
    //given
    goodUserRequest.setPassword("1234444");
    goodUserRequest.setName("miss.duckydkcu");

    //then
    System.out.println(userController.updateUser(goodUserRequest).getBody());
  }

  @Test
  void getUser() {
  }

  @Test
  void deleteUser() {
  }
}