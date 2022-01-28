package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateCourseSubjectServiceTest {

    @Mock
    private CourseSubjectRepository courseSubjectRepository;

    private UpdateCourseSubjectService updateCourseSubjectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateCourseSubjectService = new UpdateCourseSubjectService(courseSubjectRepository);
    }

    @Test
    void update_givenExistingId_shouldCallAService() {
        // Given
        Long id = 1L;
        CourseSubject courseSubjectDto = CourseSubject.builder().id(id).name("Machine Learning").build();
        String newName = "Knowledge Discovery in Databases";
        CourseSubject newCourseSubject = CourseSubject.builder().id(id).name(newName).build();
        given(courseSubjectRepository.findById(id)).willReturn(Optional.of(courseSubjectDto));
        CourseSubject updatedCourseSubjectDto = CourseSubject.builder().id(courseSubjectDto.getId())
                .name(newCourseSubject.getName()).build();
        given(courseSubjectRepository.update(id, newCourseSubject)).willReturn(Optional.of(updatedCourseSubjectDto));
        // When
        Optional<CourseSubject> updatedCourse = updateCourseSubjectService.update(id, newCourseSubject);
        Assertions.assertTrue(updatedCourse.isPresent());
        Assertions.assertEquals(newName, updatedCourse.get().getName());
        verify(courseSubjectRepository, times(1)).findById(id);
    }

    @Test
    void update_givenNonExistingId_shouldThrowsException() {
        // Given
        Long id = 2L;
        CourseSubject newCourseSubject = CourseSubject.builder().id(id).build();
        given(courseSubjectRepository.findById(id)).willReturn(Optional.empty());
        // When
        Assertions.assertThrows(NullEntityException.class,
                // Then
                () -> updateCourseSubjectService.update(id, newCourseSubject));
        // Then
        verify(courseSubjectRepository, times(1)).findById(id);
        verify(courseSubjectRepository, times(0)).update(id, newCourseSubject);
    }

}