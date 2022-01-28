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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteCourseSubjectServiceTest {

    @Mock
    private CourseSubjectRepository courseSubjectRepository;

    private DeleteCourseSubjectService deleteCourseSubjectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteCourseSubjectService = new DeleteCourseSubjectService(courseSubjectRepository);
    }
    @Test
    void delete_givenNonExistingCourse_shouldThrowsException(){
        // Given
        given(courseSubjectRepository.findById(anyLong())).willReturn(Optional.empty());
        CourseSubject courseSubject = CourseSubject.builder().id(2L).build();
        // When
        Assertions.assertThrows(NullEntityException.class,
                // Then
                () -> deleteCourseSubjectService.delete(courseSubject));
        // Then
        verify(courseSubjectRepository, times(0)).delete(any());
        verify(courseSubjectRepository, times(1)).findById(anyLong());
    }

    @Test
    void delete_givenExistingCourse_shouldCallAService() {
        // Given
        CourseSubject courseSubject = CourseSubject.builder().id(1L).build();
        given(courseSubjectRepository.findById(1L)).willReturn(Optional.of(courseSubject));
        // When
        deleteCourseSubjectService.delete(courseSubject);
        // Then
        verify(courseSubjectRepository, times(1)).delete(courseSubject);
        verify(courseSubjectRepository, times(1)).findById(courseSubject.getId());
    }

}