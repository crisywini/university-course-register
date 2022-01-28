package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
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
class DeleteCourseSubjectByIdServiceTest {

    @Mock
    private CourseSubjectRepository courseSubjectRepository;

    private DeleteCourseSubjectByIdService deleteCourseSubjectByIdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteCourseSubjectByIdService = new DeleteCourseSubjectByIdService(courseSubjectRepository);
    }

    @Test
    void deleteById_givenExistingId_shouldCallAService() {
        // Given
        given(courseSubjectRepository.findById(anyLong())).willReturn(Optional.of(CourseSubject.builder().id(1L).build()));
        // When
        deleteCourseSubjectByIdService.deleteById(anyLong());
        // Then
        verify(courseSubjectRepository, times(1)).deleteById(anyLong());
        verify(courseSubjectRepository, times(1)).findById(anyLong());
    }

    @Test
    void deleteById_givenNonExistingId_shouldThrowsException(){
        // Given
        Long id = 2L;
        given(courseSubjectRepository.findById(anyLong())).willReturn(Optional.empty());

        // When
        Assertions.assertThrows(NullEntityException.class,
                // Then
                () -> deleteCourseSubjectByIdService.deleteById(anyLong()));
        // Then
        verify(courseSubjectRepository, times(0)).deleteById(anyLong());
    }

}