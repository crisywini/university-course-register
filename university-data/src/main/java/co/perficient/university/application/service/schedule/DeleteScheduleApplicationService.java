package co.perficient.university.application.service.schedule;

import co.perficient.university.model.Schedule;
import co.perficient.university.service.schedule.DeleteScheduleService;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleApplicationService {

    private final DeleteScheduleService deleteScheduleService;

    public DeleteScheduleApplicationService(DeleteScheduleService deleteScheduleService) {
        this.deleteScheduleService = deleteScheduleService;
    }

    public void run(Schedule schedule) {
        deleteScheduleService.delete(schedule);
    }
}
