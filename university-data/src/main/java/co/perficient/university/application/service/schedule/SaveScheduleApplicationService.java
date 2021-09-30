package co.perficient.university.application.service.schedule;

import co.perficient.university.model.dto.ScheduleDto;
import co.perficient.university.service.schedule.SaveScheduleService;
import org.springframework.stereotype.Service;

@Service
public class SaveScheduleApplicationService {

    private final SaveScheduleService saveScheduleService;

    public SaveScheduleApplicationService(SaveScheduleService saveScheduleService) {
        this.saveScheduleService = saveScheduleService;
    }

    public ScheduleDto run(Schedule schedule) {
        return saveScheduleService.save(schedule);
    }
}
