package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DaySchedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "start_hour")
    private int startHour;
    @Column(name = "end_hour")
    private int endHour;
    private String classroom;
    @ManyToOne
    private Schedule schedule;

}
