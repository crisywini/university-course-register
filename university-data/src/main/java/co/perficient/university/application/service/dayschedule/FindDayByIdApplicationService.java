package co.perficient.university.application.service.dayschedule;

import co.perficient.university.model.DaySchedule;
import co.perficient.university.service.dayschedule.FindDayByIdService;
import org.springframework.stereotype.Service;

@Service
public class FindDayByIdApplicationService {
    private final FindDayByIdService findDayByIdService;

    public FindDayByIdApplicationService(FindDayByIdService findDayByIdService) {
        this.findDayByIdService = findDayByIdService;
    }

    public DaySchedule run(Long id) {
        return findDayByIdService.findById(id);
    }
}
