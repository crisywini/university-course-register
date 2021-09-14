package co.perficient.university;

import co.perficient.university.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {

        //ApplicationContext run = SpringApplication.run(UniversityApplication.class, args);
        SpringApplication.run(UniversityApplication.class, args);

        //Course course = (Course) run.getBean("course");
        //System.out.println(course);
    }

}
