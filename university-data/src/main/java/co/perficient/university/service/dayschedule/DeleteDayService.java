package co.perficient.university.service.dayschedule;

import co.perficient.university.model.DaySchedule;
import co.perficient.university.port.DayScheduleService;
import org.springframework.stereotype.Service;

@Service
public class DeleteDayService {

    private final DayScheduleService dayScheduleService;
    private static final String NON_EXISTING_DAY_SCHEDULE_MESSAGE = "The day schedule does not exists!";

    public DeleteDayService(DayScheduleService dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }

    public void delete(DaySchedule daySchedule) {
        validateExistingCourse(daySchedule);
        dayScheduleService.delete(daySchedule);
    }

    private void validateExistingCourse(DaySchedule daySchedule) {
        if (dayScheduleService.findById(daySchedule.getId()) == null) {
            throw new RuntimeException(NON_EXISTING_DAY_SCHEDULE_MESSAGE);
        }
    }
}
