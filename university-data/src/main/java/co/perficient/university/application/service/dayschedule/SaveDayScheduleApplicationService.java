package co.perficient.university.application.service.dayschedule;

import co.perficient.university.model.DaySchedule;
import co.perficient.university.model.dto.DayScheduleDto;
import co.perficient.university.service.dayschedule.SaveDayService;
import org.springframework.stereotype.Service;

@Service
public class SaveDayScheduleApplicationService {
    private final SaveDayService saveDayService;

    public SaveDayScheduleApplicationService(SaveDayService saveDayService) {
        this.saveDayService = saveDayService;
    }

    public DayScheduleDto run(DaySchedule daySchedule) {
        return saveDayService.save(daySchedule);
    }
}
