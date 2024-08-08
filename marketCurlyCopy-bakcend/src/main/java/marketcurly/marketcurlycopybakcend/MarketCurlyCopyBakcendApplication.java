package marketcurly.marketcurlycopybakcend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MarketCurlyCopyBakcendApplication {

  public static void main(String[] args) {
    SpringApplication.run(MarketCurlyCopyBakcendApplication.class, args);
  }

}
