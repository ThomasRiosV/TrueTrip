package backend.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOUser {
    private Long id;
    private String userName;
    private String password;
    private String type;
}
