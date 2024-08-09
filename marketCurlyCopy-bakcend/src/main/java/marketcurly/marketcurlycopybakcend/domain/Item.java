package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "item")
public class Item {

  @Id
  @Column(name = "ITEM_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "item_name", length = 40, nullable = false)
  private String name;

  @Column(length = 40, nullable = false)
  private String category;

  private String description;
  private String detail;

  private boolean is_new;

  @Column(nullable = false)
  private int price;
  private int stock;

  @ManyToOne
  @JoinColumn(name= "SHOPPINGBAG_ID")
  private ShoppingBag shoppingBag;

  @Getter
  @Setter
  public static class ItemReqeust{
    private String itemName;
    private String category;
    private String description;
    private String detail;
    private boolean is_new;
    private int price;
    private int stock;
  }

  @Getter
  @AllArgsConstructor
  public static class ItemResponse{
    private String itemName;
    private String category;
    private String description;
    private String detail;
    private boolean is_new;
    private int price;
    private int stock;
  }

}
