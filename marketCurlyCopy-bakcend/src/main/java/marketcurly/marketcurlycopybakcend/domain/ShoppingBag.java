package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "shoppingBag")
public class ShoppingBag {

  @Id
  @Column(name = "SHOPPINGBAG_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

}
