package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name = "shoppingBag")
public class ShoppingBag {

  @Id
  @Column(name = "SHOPPINGBAG_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "shoppingBag")
  private List<Item> itemList= new ArrayList<>();

  @Getter
  @Setter
  public static class shoppingbagRequest{
    private List<Item> itemList;
  }

  @Getter
  @AllArgsConstructor
  public static class shoppingbagResponse{
    private List<Item> itemList;
  }
}
