package co.perficient.university.service.schedule;


import co.perficient.university.model.dto.ScheduleDto;
import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllSchedulesService {

    private final ScheduleRepository scheduleService;

    public FindAllSchedulesService( ScheduleRepository scheduleService) {
        this.scheduleService = scheduleService;
    }


    public Set<ScheduleDto> findAll() {
        return scheduleService.findAll();
    }


}
