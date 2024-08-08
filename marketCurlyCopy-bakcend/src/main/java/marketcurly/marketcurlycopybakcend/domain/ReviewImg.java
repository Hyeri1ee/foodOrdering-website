package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.Getter;

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
}
