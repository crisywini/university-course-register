package co.perficient.university.application.service.dayschedule;

import co.perficient.university.service.dayschedule.DeleteDayByIdService;
import org.springframework.stereotype.Service;

@Service
public class DeleteDayByIdApplicationService {
    private final DeleteDayByIdService deleteDayByIdService;

    public DeleteDayByIdApplicationService(DeleteDayByIdService deleteDayByIdService) {
        this.deleteDayByIdService = deleteDayByIdService;
    }

    public void run(Long id) {
        deleteDayByIdService.deleteById(id);
    }
}
