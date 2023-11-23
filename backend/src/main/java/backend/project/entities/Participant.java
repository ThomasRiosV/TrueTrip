package backend.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "participants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private Date registrationDate;
    private String phoneNumber;
    private String email;
    private String address;
    private String notes;
    private boolean paymentStatus;  // Estado de pago
    private boolean confirmationStatus;  // Estado de confirmación
    private int numberOfCompanions;  // Número de acompañantes

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // El usuario que participa en el viaje

    @ManyToOne
    @JoinColumn(name = "travel_post_id")
    private TravelPost travelPost;  // La publicación de viaje en la que participa

    public Participant(User user, TravelPost travelPost) {
        this.user = user;
        this.travelPost = travelPost;
    }


    // Getters y setters
}