package co.perficient.university.service.dayschedule;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.DaySchedule;
import co.perficient.university.port.CourseSubjectService;
import co.perficient.university.port.DayScheduleService;
import org.springframework.stereotype.Service;

@Service
public class FindDayByIdService {

    private final DayScheduleService dayScheduleService;

    public FindDayByIdService(DayScheduleService dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }

    public DaySchedule findById(Long id) {
        return dayScheduleService.findById(id);
    }
}
