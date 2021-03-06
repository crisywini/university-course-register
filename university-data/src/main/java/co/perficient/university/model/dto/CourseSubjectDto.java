package co.perficient.university.model.dto;

import co.perficient.university.model.Methodology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSubjectDto implements Serializable {
    private Long id;
    private String description;
    private String name;
    private Methodology methodology;
}
