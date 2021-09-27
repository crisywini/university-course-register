package co.perficient.university.model.dto;

import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.Faculty;
import co.perficient.university.model.Modality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String name;
    private String title;
    private AcademicLevel academicLevel;
    private Faculty faculty;
    private Modality modality;
}
