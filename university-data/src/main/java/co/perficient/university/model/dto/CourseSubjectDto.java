package co.perficient.university.model.dto;

import co.perficient.university.model.Methodology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSubjectDto {
    private Long id;
    private String description;
    private String name;
    private Methodology methodology;
}
