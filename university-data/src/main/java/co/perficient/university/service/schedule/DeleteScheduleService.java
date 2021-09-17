package co.perficient.university.service.schedule;

import co.perficient.university.model.Schedule;
import co.perficient.university.port.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleService {

    private final ScheduleService scheduleService;
    private static final String NON_EXISTING_SCHEDULE_MESSAGE = "The schedule does not exists!";

    public DeleteScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public void delete(Schedule schedule) {
        validateExisting(schedule);
        scheduleService.delete(schedule);
    }

    private void validateExisting(Schedule schedule) {
        if (scheduleService.findById(schedule.getId()) == null) {
            throw new RuntimeException(NON_EXISTING_SCHEDULE_MESSAGE);
        }
    }
}
