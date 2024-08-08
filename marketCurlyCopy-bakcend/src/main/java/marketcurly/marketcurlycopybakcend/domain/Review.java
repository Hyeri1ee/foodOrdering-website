package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import marketcurly.marketcurlycopybakcend.domain.base.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "review")
@Getter
public class Review extends BaseTimeEntity {

  @Id
  @Column(name = "REVIEW_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "content")
  private String content;

  @ManyToOne
  @JoinColumn(name = "USER_ID")
  private User user;

  @OneToMany(mappedBy = "review")
  private List<ReviewImg> reviewImgList = new ArrayList<>();

}
