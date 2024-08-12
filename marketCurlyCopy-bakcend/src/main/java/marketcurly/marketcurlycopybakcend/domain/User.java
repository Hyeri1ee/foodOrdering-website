package marketcurly.marketcurlycopybakcend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import marketcurly.marketcurlycopybakcend.domain.base.BaseTimeEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(name = "login_id", length = 30, nullable = false)
  private String loginId;

  @NotBlank
  @Column(length = 40, nullable = false)
  private String password;

  @NotBlank
  @Column(length = 30, nullable = false)
  private String nickName;

  @NotBlank
  @Column(nullable = false)
  private String name;

  private Date birthday;

  @NotBlank
  @Column(nullable = false)
  private boolean isAdmin;

  @OneToMany(mappedBy = "user")
  private List<Review> reviewList = new ArrayList<>();

  @OneToOne
  @JoinColumn(name = "SHOPPINGBAG_ID")
  private ShoppingBag shoppingBag;
  //update method
  public void update(UserRequest request){
    if (request.getName() != null){
      this.name = request.getName();
    }
    if (request.getNickName() != null){
      this.nickName = request.getNickName();
    }
    if (request.getPassword() != null){
      this.password = request.getPassword();
    }
    if (request.getLoginId() != null){
      this.loginId = request.getLoginId();
    }
  }

  //createUser method
  public void createUser(String loginId, String password,String nickName, String name, Date birthday, boolean isAdmin){
    this.loginId = loginId;
    this.password = password;
    this.nickName = nickName;
    this.name = name;
    this.isAdmin = isAdmin;
    this.birthday = birthday;
  }
  @Getter
  @Setter
  @AllArgsConstructor
  public static class UserRequest{

    private String nickName;

    private String password;

    private String name;

    private String loginId;

    private boolean isAdmin;
    private Date birthday;

  }

  @Getter
  @AllArgsConstructor
  public static class UserResponse{
    private String nickName;
    private String loginId;

    public UserResponse(User user) {
      this.nickName = user.getNickName();
      this.loginId = user.getLoginId();
    }
  }
}
