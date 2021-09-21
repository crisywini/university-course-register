package co.perficient.university.application.service.dayschedule;

import co.perficient.university.model.DaySchedule;
import co.perficient.university.service.dayschedule.FindAllDaysService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllDaysApplicationService {

    private final FindAllDaysService findAllDaysService;

    public FindAllDaysApplicationService(FindAllDaysService findAllDaysService) {
        this.findAllDaysService = findAllDaysService;
    }

    public Set<DaySchedule> run() {
        return findAllDaysService.findAll();
    }
}
