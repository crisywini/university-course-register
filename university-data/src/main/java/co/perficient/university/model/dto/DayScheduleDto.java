package co.perficient.university.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayScheduleDto {
    private Long id;
    private String name;
    private String hours;
    private String classroom;

}
