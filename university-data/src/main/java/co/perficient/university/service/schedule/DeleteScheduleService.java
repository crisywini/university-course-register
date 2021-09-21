package co.perficient.university.service.schedule;

import co.perficient.university.model.Schedule;
import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleService {

    private final ScheduleRepository scheduleService;
    private static final String NON_EXISTING_SCHEDULE_MESSAGE = "The schedule does not exists!";

    public DeleteScheduleService(ScheduleRepository scheduleService) {
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
