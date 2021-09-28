package co.perficient.university.service.schedule;

import co.perficient.university.model.Schedule;
import co.perficient.university.model.dto.ScheduleDto;
import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class FindScheduleByIdService {

    private final ScheduleRepository scheduleService;

    public FindScheduleByIdService(ScheduleRepository scheduleService) {
        this.scheduleService = scheduleService;
    }

    public ScheduleDto findById(Long id) {
        return scheduleService.findById(id);
    }
}
