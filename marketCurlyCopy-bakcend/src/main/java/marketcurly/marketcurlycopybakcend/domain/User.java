package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import marketcurly.marketcurlycopybakcend.domain.base.BaseTimeEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
public class User extends BaseTimeEntity {
  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "login_id", length = 30, nullable = false)
  private String loginId;

  @Column(length = 40, nullable = false)
  private String password;

  @Column(length = 30, nullable = false)
  private String nickName;

  @Column(nullable = false)
  private String name;

  private Date birthday;

  @Column(nullable = false)
  private boolean isAdmin;

  @OneToMany(mappedBy = "user")
  private List<Review> reviewList = new ArrayList<>();

  @Getter
  @Setter
  public static class UserRequest{
    private String nickName;
    private String password;
    private String loginId;
    private boolean isAdmin;
    private Date birthday;
  }

  @Getter
  @AllArgsConstructor
  public static class UserResponse{
    private String nickName;
    private String loginId;
  }
}
