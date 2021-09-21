package co.perficient.university.service.schedule;

import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleByIdService {

    private final ScheduleRepository scheduleService;
    private static final String NON_EXISTING_SCHEDULE_MESSAGE = "The schedule does not exists!";

    public DeleteScheduleByIdService( ScheduleRepository scheduleService) {
        this.scheduleService = scheduleService;
    }

    public void deleteById(Long id) {
        validateExisting(id);
        scheduleService.deleteById(id);
    }

    private void validateExisting(Long id) {
        if (scheduleService.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_SCHEDULE_MESSAGE);
        }
    }
}
