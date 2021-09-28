package co.perficient.university.service.schedule;

import co.perficient.university.model.Schedule;
import co.perficient.university.model.dto.ScheduleDto;
import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveScheduleService {

    private final ScheduleRepository scheduleService;

    private static final String SCHEDULE_REPEATED_MESSAGE = "The schedule already exists!";

    public SaveScheduleService(ScheduleRepository scheduleService) {
        this.scheduleService = scheduleService;
    }

    public ScheduleDto save(Schedule schedule) {
        validateNonRepeated(schedule);
        return scheduleService.save(schedule);
    }

    private void validateNonRepeated(Schedule schedule) {
        if (schedule.getId() != null && scheduleService.findById(schedule.getId()) != null) {
            throw new RuntimeException(SCHEDULE_REPEATED_MESSAGE);
        }
    }

}
