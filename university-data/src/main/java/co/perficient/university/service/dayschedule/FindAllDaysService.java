package co.perficient.university.service.dayschedule;


import co.perficient.university.model.dto.DayScheduleDto;
import co.perficient.university.port.DayScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllDaysService {

    private final DayScheduleRepository dayScheduleService;

    public FindAllDaysService(DayScheduleRepository dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }


    public Set<DayScheduleDto> findAll() {
        return dayScheduleService.findAll();
    }


}
