package co.perficient.university.application.service.dayschedule;

import co.perficient.university.service.dayschedule.DeleteDayService;
import org.springframework.stereotype.Service;

@Service
public class DeleteDayApplicationService {
    private final DeleteDayService deleteDayService;

    public DeleteDayApplicationService(DeleteDayService deleteDayService) {
        this.deleteDayService = deleteDayService;
    }

    public void run(DaySchedule daySchedule) {
        deleteDayService.delete(daySchedule);
    }
}
