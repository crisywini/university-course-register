package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule extends BaseEntity<Schedule> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "day_schedules")
    @OneToMany(mappedBy = "schedule")
    private Set<DaySchedule> daySchedules;
    @OneToOne(mappedBy = "schedule")
    private CourseSubject courseSubject;

    @Override
    public Schedule updateWith(Schedule newItem) {
        return new Schedule(this.id,
                newItem.getStartDate(),
                newItem.getEndDate(),
                newItem.getDaySchedules(), newItem.getCourseSubject());

    }
}
