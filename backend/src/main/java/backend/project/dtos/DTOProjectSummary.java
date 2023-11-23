package backend.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOProjectSummary {

    private String name;
    private Integer employeesAssignedHomeOffice;
    private Integer employeesAssignedCentralOffice;
    private Double cost;
    private Integer effort;

}
