package co.perficient.university.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
@Entity
public class Schedule implements Serializable {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<DaySchedule> daySchedules;


    public Schedule() {
    }

    public Schedule(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Set<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void setDaySchedules(Set<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
