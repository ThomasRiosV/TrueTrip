package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date createdAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // El usuario que hizo el comentario

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "travel_post_id")
    private TravelPost travelPost;  // La publicación de viaje a la que se refiere el comentario

}