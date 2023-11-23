package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "travel_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String destination;
    private double cost;
    private int maxParticipants;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "travelPost")//, cascade = CascadeType.ALL)
    private List<Comment> comments;  // Lista de comentarios asociados a esta publicación de viaje

    @OneToMany(mappedBy = "travelPost")//, cascade = CascadeType.ALL)
    private List<Participant> participants;

    @OneToMany(mappedBy = "travelPost")//, cascade = CascadeType.ALL)
    private List<PostCategory> travelPostCategories;  // Relación con publicaciones de viaje

    public TravelPost(String title, String description, Date startDate, Date endDate, String destination, double cost, int maxParticipants) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
        this.cost = cost;
        this.maxParticipants = maxParticipants;
    }
}
