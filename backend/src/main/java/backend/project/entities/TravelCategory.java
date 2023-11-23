package backend.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "travel_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;  // Nombre de la categoría (Ejemplo: "Aventura", "Cultura", "Playa", etc.)

    @OneToMany(mappedBy = "travelCategory")//, cascade = CascadeType.ALL)
    private List<PostCategory> travelPostCategories;  // Relación con publicaciones de viaje
}
