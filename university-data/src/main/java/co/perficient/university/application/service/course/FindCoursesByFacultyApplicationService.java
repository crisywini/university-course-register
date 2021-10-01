package co.perficient.university.application.service.course;

import co.perficient.university.model.Faculty;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.FindCourseByFacultyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCoursesByFacultyApplicationService {
    private final FindCourseByFacultyService findCourseByFacultyService;

    public FindCoursesByFacultyApplicationService(FindCourseByFacultyService findCourseByFacultyService) {
        this.findCourseByFacultyService = findCourseByFacultyService;
    }

    public List<CourseDto> run(Faculty faculty) {
        return findCourseByFacultyService.findByFaculty(faculty);
    }
}
