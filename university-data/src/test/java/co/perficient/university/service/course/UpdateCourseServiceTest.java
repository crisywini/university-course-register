package co.perficient.university.service.course;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private UpdateCourseService updateCourseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateCourseService = new UpdateCourseService(courseRepository);
    }

    @Test
    void update_givenExistingCourse_shouldCallAService() {
        // Given
        Long id = 1L;
        Course course = Course.builder().id(id).name("Machine Learning").build();
        Course newCourse = Course.builder().id(id).name("Knowledge Discovery in Databases").build();
        given(courseRepository.findById(id)).willReturn(Optional.of(course));
        // When
        Optional<Course> updateCourse = updateCourseService.update(id, newCourse);
        // Then
        Assertions.assertNotNull(updateCourse);
        verify(courseRepository, times(1)).update(id, newCourse);
    }

    @Test
    void update_givenNonExistingCourse_shouldThrowsException() {
        // Given
        Long id = 1L;
        Course newCourse = Course.builder().id(id).name("Knowledge Discovery in Databases").build();
        given(courseRepository.findById(anyLong())).willReturn(Optional.empty());
        // When
        Assertions.assertThrows(NullEntityException.class,
                // Then
                () -> updateCourseService.update(id, newCourse));
        // Then
        verify(courseRepository, times(0)).update(id, newCourse);
    }

}