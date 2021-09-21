package co.perficient.university.service.dayschedule;

import co.perficient.university.model.DaySchedule;
import co.perficient.university.port.DayScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class FindDayByIdService {

    private final DayScheduleRepository dayScheduleService;

    public FindDayByIdService(DayScheduleRepository dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }

    public DaySchedule findById(Long id) {
        return dayScheduleService.findById(id);
    }
}
