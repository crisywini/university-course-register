package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class FindCourseSubjectByMethodologyServiceTest {

    @Mock
    private CourseSubjectRepository courseSubjectRepository;

    private FindCourseSubjectByMethodologyService findCourseSubjectByMethodologyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findCourseSubjectByMethodologyService = new FindCourseSubjectByMethodologyService(courseSubjectRepository);
    }

    @Test
    void findByMethodology_givenValidMethodology_shouldCallAService() {
        // Given
        Methodology methodology = Methodology.FACE_TO_FACE;
        List<CourseSubjectDto> courseSubjectDtoList = List.of(CourseSubjectDto.builder().id(1L).build());
        given(courseSubjectRepository.findByMethodology(methodology)).willReturn(courseSubjectDtoList);
        // When
        List<CourseSubjectDto> byMethodology = findCourseSubjectByMethodologyService.findByMethodology(methodology);
        // Then
        Assertions.assertEquals(courseSubjectDtoList, byMethodology);
        verify(courseSubjectRepository, times(1)).findByMethodology(methodology);
    }

    @Test
    void findByMethodology_givenANoValidMethodology_shouldThrowsException() {
        // Given
        Methodology methodology = Methodology.n;
        // When
        Assertions.assertThrows(ParamNotFoundException.class,
                //Then
                () -> findCourseSubjectByMethodologyService.findByMethodology(methodology));
        // Then
        verifyNoInteractions(courseSubjectRepository);
    }

}