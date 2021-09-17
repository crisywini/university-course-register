package co.perficient.university.service.schedule;


import co.perficient.university.model.DaySchedule;
import co.perficient.university.model.Schedule;
import co.perficient.university.port.DayScheduleService;
import co.perficient.university.port.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllSchedulesService {

    private final ScheduleService scheduleService;

    public FindAllSchedulesService( ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    public Set<Schedule> findAll() {
        return scheduleService.findAll();
    }


}
