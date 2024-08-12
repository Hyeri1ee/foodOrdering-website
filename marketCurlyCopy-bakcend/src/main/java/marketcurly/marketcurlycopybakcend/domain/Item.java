package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "item")
@NoArgsConstructor
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

  @Builder
  public Item(boolean is_new, String name, String category, String description, String detail, int price, int stock){
    this.name = name;
    this.category = category;
    this.description = description;
    this.detail = detail;
    this.price = price;
    this.stock = stock;
    this.is_new = is_new;
  }


  @Getter
  @Setter
  @AllArgsConstructor
  public static class ItemRequest{
    private String itemName;
    private String category;
    private String description;
    private String detail;
    private boolean is_new;
    private int price;
    private int stock;

    public Item toEntity(){
      return Item.builder()
              .name(itemName)
              .category(category)
              .description(description)
              .detail(detail)
              .price(price)
              .stock(stock)
              .is_new(is_new)
              .build();
    }
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

    public ItemResponse(Item item){
      this.itemName = item.getName();
      this.category = item.getCategory();
      this.description = item.getDescription();
      this.detail = item.getDetail();
      this.is_new = item.is_new();
      this.price = item.getPrice();
      this.stock = item.getStock();
    }
  }

}
