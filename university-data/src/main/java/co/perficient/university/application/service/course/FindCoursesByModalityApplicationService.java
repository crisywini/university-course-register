package co.perficient.university.application.service.course;

import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.FindCourseByModalityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCoursesByModalityApplicationService {

    private final FindCourseByModalityService findCourseByModalityService;

    public FindCoursesByModalityApplicationService(FindCourseByModalityService findCourseByModalityService) {
        this.findCourseByModalityService = findCourseByModalityService;
    }

    public List<CourseDto> run(Modality modality) {
        return findCourseByModalityService.findByModality(modality);
    }
}
