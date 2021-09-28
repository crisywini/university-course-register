package co.perficient.university.service.dayschedule;

import co.perficient.university.model.dto.DayScheduleDto;
import co.perficient.university.port.DayScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class FindDayByIdService {

    private final DayScheduleRepository dayScheduleService;

    public FindDayByIdService(DayScheduleRepository dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }

    public DayScheduleDto findById(Long id) {
        return dayScheduleService.findById(id);
    }
}
