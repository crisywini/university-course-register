package co.perficient.university.service.coursesubject;

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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FindCourseSubjectByIdServiceTest {

    @Mock
    private CourseSubjectRepository courseSubjectRepository;

    private FindCourseSubjectByIdService findCourseSubjectByIdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findCourseSubjectByIdService = new FindCourseSubjectByIdService(courseSubjectRepository);
    }

    @Test
    void findById_givenExistingId_shouldCallAService() {
        // Given
        Long id = 1L;
        CourseSubjectDto courseSubjectDto = CourseSubjectDto.builder().id(id).build();
        given(courseSubjectRepository.findById(id)).willReturn(Optional.of(courseSubjectDto));
        // When
        Optional<CourseSubjectDto> byId = findCourseSubjectByIdService.findById(id);
        // Then
        Assertions.assertEquals(Optional.of(courseSubjectDto), byId);
        verify(courseSubjectRepository, times(1)).findById(id);
    }

    @Test
    void findById_givenNonExistingId_shouldCallAService_andReturnEmpty() {
        // Given
        Long id = 2L;
        given(courseSubjectRepository.findById(id)).willReturn(Optional.empty());
        // When
        Optional<CourseSubjectDto> byId = findCourseSubjectByIdService.findById(id);
        // Then
        Assertions.assertEquals(Optional.empty(), byId);
        verify(courseSubjectRepository, times(1)).findById(id);
    }

}