package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DaySchedule extends BaseEntity<DaySchedule> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    @Column(name = "start_hour")
    private int startHour;
    @Column(name = "end_hour")
    private int endHour;
    private String classroom;
    @ManyToOne
    private Schedule schedule;

    @Override
    public DaySchedule updateWith(DaySchedule newItem) {

        return new DaySchedule(this.id,
                newItem.getName(),
                newItem.getStartHour(),
                newItem.getEndHour(),
                newItem.getClassroom(),
                newItem.getSchedule());
    }
}
