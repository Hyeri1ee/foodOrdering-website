package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import marketcurly.marketcurlycopybakcend.domain.base.BaseTimeEntity;

@Entity
@Table(name = "QnA")
@Getter
public class QnA extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;
  private String content;

  @ManyToOne
  @JoinColumn(name = "ITEM_ID")
  private Item item;

  @Getter
  @Setter
  public static class QnARequest{
    private String title;
    private String content;
    private Item item;
  }

  @Getter
  @AllArgsConstructor
  public static class QnAResponse{
    private String title;
    private String content;
    private Item item;
  }
}
