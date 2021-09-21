package co.perficient.university.application.service.schedule;

import co.perficient.university.service.schedule.DeleteScheduleByIdService;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleByIdApplicationService {
    private final DeleteScheduleByIdService deleteScheduleByIdService;

    public DeleteScheduleByIdApplicationService(DeleteScheduleByIdService deleteScheduleByIdService) {
        this.deleteScheduleByIdService = deleteScheduleByIdService;
    }

    public void run(Long id) {
        deleteScheduleByIdService.deleteById(id);
    }
}
