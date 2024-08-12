package marketcurly.marketcurlycopybakcend.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import marketcurly.marketcurlycopybakcend.repository.ItemRepository;
import marketcurly.marketcurlycopybakcend.repository.UserRepository;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ItemRepositoryInterface;
import marketcurly.marketcurlycopybakcend.repository.ShoppingBagRepository;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ShoppingBagRepositoryInterface;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.UserRepositoryInterface;
import marketcurly.marketcurlycopybakcend.service.ItemService;
import marketcurly.marketcurlycopybakcend.service.ShoppingBagService;
import marketcurly.marketcurlycopybakcend.service.UserService;
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

  @Bean
  public ItemService itemService(){return new ItemService(ItemRepositoryInterface());}

  @Bean
  public ItemRepositoryInterface ItemRepositoryInterface(){return new ItemRepository(em);}

  @Bean
  public ShoppingBagService shoppingBagService(){return new ShoppingBagService(ShoppingBagRepositoryInterface());}

  @Bean
  public ShoppingBagRepositoryInterface ShoppingBagRepositoryInterface(){return new ShoppingBagRepository(em);}

}
