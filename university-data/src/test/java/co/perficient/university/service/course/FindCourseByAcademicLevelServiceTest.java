package co.perficient.university.service.course;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import java.util.ArrayList;
import java.util.List;
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
class FindCourseByAcademicLevelServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private FindCourseByAcademicLevelService findCourseByAcademicLevelService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findCourseByAcademicLevelService = new FindCourseByAcademicLevelService(courseRepository);
    }

    @Test
    void findByAcademicLevel_givenAValidAcademicLevel_shouldCallAService() {
        // Given
        AcademicLevel academicLevel = AcademicLevel.MASTER_DEGREE;
        given(courseRepository.findByAcademicLevel(academicLevel)).willReturn(new ArrayList<>());
        // When
        List<CourseDto> byAcademicLevel = findCourseByAcademicLevelService.findByAcademicLevel(academicLevel);
        // Then
        Assertions.assertEquals(0, byAcademicLevel.size());
        verify(courseRepository, times(1)).findByAcademicLevel(academicLevel);
    }

    @Test
    void findByAcademicLevel_givenNoValidAcademicLevel_shouldThrowsException() {
        // Given
        AcademicLevel academicLevel = AcademicLevel.n;
        // When
        Assertions.assertThrows(ParamNotFoundException.class,
                // Then
                () -> findCourseByAcademicLevelService.findByAcademicLevel(academicLevel));
        // Then
        verify(courseRepository, times(0)).findByAcademicLevel(academicLevel);
    }

}