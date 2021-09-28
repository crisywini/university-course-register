package co.perficient.university.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
}
