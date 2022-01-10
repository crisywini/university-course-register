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
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteCourseByIdServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private DeleteCourseByIdService deleteCourseByIdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteCourseByIdService = new DeleteCourseByIdService(courseRepository);
    }

    @Test
    void deleteById_givenAnExistingCourse_shouldCallAService() {
        // Given
        Course course = Course.builder().id(1L).build();
        // When
        given(courseRepository.findById(1L))
                .willReturn(Optional.of(CourseDto.builder()
                        .id(course.getId())
                        .build()));
        // Then
        deleteCourseByIdService.deleteById(1L);

        verify(courseRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteById_givenNonExistingCourse_shouldThrowsException() {
        // Given
        given(courseRepository.findById(anyLong())).willReturn(Optional.empty());
        // When
        Assertions.assertThrows(NullEntityException.class,
                // Then
                () -> deleteCourseByIdService.deleteById(anyLong()));
        // Then
        verify(courseRepository, times(0)).deleteById(anyLong());
    }

}