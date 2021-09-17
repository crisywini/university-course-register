package co.perficient.university.service.dayschedule;

import co.perficient.university.port.DayScheduleService;
import org.springframework.stereotype.Service;

@Service
public class DeleteDayByIdService {

    private final DayScheduleService dayScheduleService;
    private static final String NON_EXISTING_DAY_SCHEDULE_MESSAGE = "The day schedule does not exists!";

    public DeleteDayByIdService(DayScheduleService dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }

    public void deleteById(Long id) {
        validateExisting(id);
        dayScheduleService.deleteById(id);
    }

    private void validateExisting(Long id) {
        if (dayScheduleService.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_DAY_SCHEDULE_MESSAGE);
        }
    }
}
