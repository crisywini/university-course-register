package co.perficient.university.application.service.schedule;

import co.perficient.university.model.dto.ScheduleDto;
import co.perficient.university.service.schedule.FindScheduleByIdService;
import org.springframework.stereotype.Service;

@Service
public class FindScheduleByIdApplicationService {
    private final FindScheduleByIdService findScheduleByIdService;

    public FindScheduleByIdApplicationService(FindScheduleByIdService findScheduleByIdService) {
        this.findScheduleByIdService = findScheduleByIdService;
    }

    public ScheduleDto run(Long id) {
        return findScheduleByIdService.findById(id);
    }
}
