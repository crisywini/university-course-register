package co.perficient.university.service.schedule;


import co.perficient.university.model.Schedule;
import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllSchedulesService {

    private final ScheduleRepository scheduleService;

    public FindAllSchedulesService( ScheduleRepository scheduleService) {
        this.scheduleService = scheduleService;
    }


    public Set<Schedule> findAll() {
        return scheduleService.findAll();
    }


}
