package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name = "shoppingBag")
@NoArgsConstructor
public class ShoppingBag {

  @Id
  @Column(name = "SHOPPINGBAG_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "shoppingBag")
  private List<Item> itemList= new ArrayList<>();

  @OneToOne(mappedBy = "shoppingBag")
  private User user;

  @Builder
  public ShoppingBag(List<Item> itemList, User user){
    this.itemList = itemList;
    this.user = user;
  }


  @Getter
  @Setter
  public static class shoppingbagRequest{
    private List<Item> itemList;
    private User user;

    public ShoppingBag toEntity(){
      return ShoppingBag.builder()
              .user(this.user)
              .itemList(this.itemList)
              .build();
    }
  }

  @Getter
  @AllArgsConstructor
  public static class shoppingbagResponse{
    private List<Item> itemList;
  }
}
