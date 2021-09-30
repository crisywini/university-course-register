package co.perficient.university.service.dayschedule;

import co.perficient.university.port.DayScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteDayService {

    private final DayScheduleRepository dayScheduleService;
    private static final String NON_EXISTING_DAY_SCHEDULE_MESSAGE = "The day schedule does not exists!";

    public DeleteDayService(DayScheduleRepository dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }

    public void delete(DaySchedule daySchedule) {
        validateExisting(daySchedule);
        dayScheduleService.delete(daySchedule);
    }

    private void validateExisting(DaySchedule daySchedule) {
        if (dayScheduleService.findById(daySchedule.getId()) == null) {
            throw new RuntimeException(NON_EXISTING_DAY_SCHEDULE_MESSAGE);
        }
    }
}
