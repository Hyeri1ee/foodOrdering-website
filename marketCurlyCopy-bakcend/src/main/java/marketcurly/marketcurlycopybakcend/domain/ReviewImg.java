package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review_img")
@Getter
public class ReviewImg {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "imgURL")
  private String imgUrl;

  @ManyToOne
  @JoinColumn(name = "REVIEW_ID")
  private Review review;

  @Getter
  @Setter
  public static class ReviewImgRequest{
    private String imgUrl;
    private Review review;
  }
  @Getter
  @AllArgsConstructor
  public static class ReviewImgResponse{
    private String imgUrl;
    private Review review;
  }
}
