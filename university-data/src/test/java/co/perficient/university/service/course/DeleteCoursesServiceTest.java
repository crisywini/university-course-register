package co.perficient.university.service.course;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.Course;
import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
@ExtendWith(MockitoExtension.class)
class DeleteCoursesServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private DeleteCoursesService deleteCoursesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteCoursesService = new DeleteCoursesService(courseRepository);
    }


    @Test
    void delete_givenNonExistingCourse_shouldThrowException() {
        // Given
        Course course = Course.builder().id(1L).build();
        given(courseRepository.findById(anyLong())).willReturn(Optional.empty());

        // When
        assertThrows(NullEntityException.class,
                // Then
                () -> deleteCoursesService.delete(course));
        // Then
        verify(courseRepository, times(0)).delete(any());
    }

    @Test
    void delete_givenExistingCourse_shouldCallService() {
        // Given
        Course course = Course.builder()
                .id(1L)
                .academicLevel(AcademicLevel.TRAINING_SCHOOLS)
                .modality(Modality.FACE_TO_FACE)
                .name("Data Visualization")
                .build();
        Optional<CourseDto> courseDto = Optional.of(course).map(c -> CourseDto.builder().id(c.getId())
                .academicLevel(c.getAcademicLevel())
                .modality(c.getModality())
                .name(c.getName()).build());
        given(courseRepository.findById(1L)).willReturn(courseDto);
        // When
        deleteCoursesService.delete(course);
        // Then
        verify(courseRepository, times(1)).delete(course);
    }

}