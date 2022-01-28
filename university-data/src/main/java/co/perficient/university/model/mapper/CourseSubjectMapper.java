package co.perficient.university.model.mapper;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import org.mapstruct.Mapper;

@Mapper
public interface CourseSubjectMapper {
    CourseSubjectDto courseSubjectToCourseSubjectDto(CourseSubject courseSubject);

    CourseSubject courseSubjectDtoToCourseSubject(CourseSubjectDto courseSubjectDto);
}
