package co.perficient.university.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
}
