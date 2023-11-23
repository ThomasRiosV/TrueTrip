package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="personals")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;  // Fecha de nacimiento
    private String address;
    private String city;
    private String state;
    private String country;
    private String phoneNumber;
    // Otros atributos personales, como género, intereses, etc.

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

  /*  public Personal(Long id,String firstName, String lastName,String email,Date dateOfBirth , String address, String city,String state,String country , String phoneNumber , User user) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.dateOfBirth = dateOfBirth;
      this.address = address;
      this.city = city;
      this.state = state;
      this.country = country;
      this.phoneNumber = phoneNumber;
      this.user = user;

    }*/

}
