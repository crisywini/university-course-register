package co.perficient.university.service.course;

import co.perficient.university.exception.RepeatedEntityException;
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
class SaveCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private SaveCourseService saveCourseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        saveCourseService = new SaveCourseService(courseRepository);
    }

    @Test
    void save_givenNonExistingCourse_shouldCallAService() {
        // Given
        Course course = Course.builder().id(1L).build();
        given(courseRepository.findById(anyLong())).willReturn(Optional.empty());
        // When
        Optional<CourseDto> save = saveCourseService.save(course);
        // Then
        Assertions.assertNotNull(save);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void save_givenExistingCourse_shouldThrowsException() {
        // Given
        Course course = Course.builder().id(1L).name("Data Visualization").build();
        CourseDto courseDto = CourseDto.builder().id(course.getId()).name(course.getName()).build();
        given(courseRepository.findById(anyLong())).willReturn(Optional.of(courseDto));
        // When
        Assertions.assertThrows(RepeatedEntityException.class,
                // Then
                () -> saveCourseService.save(course));
        // Then
        verify(courseRepository, times(0)).save(course);
    }

}