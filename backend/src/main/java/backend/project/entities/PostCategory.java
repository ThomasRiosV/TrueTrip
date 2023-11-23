package backend.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "post_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "travel_post_id")
    private TravelPost travelPost;

    @ManyToOne
    @JoinColumn(name = "travel_category_id")
    private TravelCategory travelCategory;

}