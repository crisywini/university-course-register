package co.perficient.university.application.service.schedule;

import co.perficient.university.model.Schedule;
import co.perficient.university.service.schedule.FindAllSchedulesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllSchedulesApplicationService {
    private final FindAllSchedulesService findAllSchedulesService;

    public FindAllSchedulesApplicationService(FindAllSchedulesService findAllSchedulesService) {
        this.findAllSchedulesService = findAllSchedulesService;
    }

    public Set<Schedule> run() {
        return findAllSchedulesService.findAll();
    }
}
