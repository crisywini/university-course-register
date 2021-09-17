package co.perficient.university.service.schedule;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Schedule;
import co.perficient.university.port.CourseSubjectService;
import co.perficient.university.port.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class SaveScheduleService {

    private final ScheduleService scheduleService;

    private static final String SCHEDULE_REPEATED_MESSAGE = "The schedule already exists!";

    public SaveScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public Schedule save(Schedule schedule) {
        validateNonRepeated(schedule);
        return scheduleService.save(schedule);
    }

    private void validateNonRepeated(Schedule schedule) {
        if (scheduleService.findById(schedule.getId()) != null) {
            throw new RuntimeException(SCHEDULE_REPEATED_MESSAGE);
        }
    }

}
