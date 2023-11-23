package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private boolean enabled;
    private Date passwordLastUpdate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_authorities",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "authority_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            }
    )
    private List<Authority> authorities;

    @OneToOne(mappedBy = "user")//, cascade = CascadeType.ALL)
    private Personal personal;

    @OneToMany(mappedBy = "user")//, cascade = CascadeType.ALL)
    private List<TravelPost> travelPosts;

    @OneToMany(mappedBy = "user")//, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")//, cascade = CascadeType.ALL)
    private List<Participant> participants;


  public User(String userName, String password, boolean enabled, Date passwordLastUpdate, List<Authority> authorities) {
    this.userName = userName;
    this.password = password;
    this.enabled = enabled;
    this.passwordLastUpdate = passwordLastUpdate;
    this.authorities = authorities;

  }
}
