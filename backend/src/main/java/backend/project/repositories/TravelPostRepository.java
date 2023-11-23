package backend.project.repositories;

import backend.project.entities.TravelPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TravelPostRepository extends JpaRepository<TravelPost, Long> {

    @Query("SELECT t FROM TravelPost t WHERE " +
            "(:destination IS NULL OR t.destination = :destination) " +
            "AND (:startDate IS NULL OR t.startDate >= :startDate) " +
            "AND (:endDate IS NULL OR t.endDate <= :endDate) " +
            "AND (:cost IS NULL OR t.cost <= :cost)")
    List<TravelPost> findTravelPostsByFilters(String destination, Date startDate, Date endDate, Double cost);

    /*
    * En este ejemplo, hemos utilizado una consulta JPQL que permite filtrar
    * los viajes por los parámetros de destino, fecha de inicio, fecha de
    * finalización y costo. La consulta verifica si los parámetros son nulos o
    * coinciden con los atributos de la entidad TravelPost.
    * Si un parámetro es nulo, no se aplica el filtro correspondiente.
    *
    * */

}
