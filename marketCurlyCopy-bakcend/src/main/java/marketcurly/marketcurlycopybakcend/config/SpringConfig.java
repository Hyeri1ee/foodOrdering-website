package marketcurly.marketcurlycopybakcend.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.repository.UserRepository;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ItemRepository;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.UserRepositoryInterface;
import marketcurly.marketcurlycopybakcend.service.ItemServiceImpl;
import marketcurly.marketcurlycopybakcend.service.UserService;
import marketcurly.marketcurlycopybakcend.service.serviceInterface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  
  /*
  자바 코드로 빈 수동 주입하기
   */
  //UserController 부분
  @PersistenceContext
  private EntityManager em;

  @Bean
  public UserService userService(){
    return new UserService(UserRepositoryInterface());
  }
  
  @Bean
  public UserRepositoryInterface UserRepositoryInterface(){
    return new UserRepository(em);
  }


}
