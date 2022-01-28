package co.perficient.university.model.mapper;

import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    CourseDto courseToCourseDto(Course course);

    Course courseDtoToCourse(CourseDto courseDto);
}
