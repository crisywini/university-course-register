package co.perficient.university.service.course;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.Faculty;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FindCourseByFacultyServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private FindCourseByFacultyService findCourseByFacultyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findCourseByFacultyService = new FindCourseByFacultyService(courseRepository);
    }

    @Test
    void findByFaculty_givenAValidFaculty_shouldCallAService() {
        // Given
        Faculty faculty = Faculty.ENGINEERING;
        given(courseRepository.findByFaculty(faculty)).willReturn(new ArrayList<>());
        // When
        List<CourseDto> byFaculty = findCourseByFacultyService.findByFaculty(faculty);
        // Then
        Assertions.assertEquals(0, byFaculty.size());
        verify(courseRepository, times(1)).findByFaculty(faculty);
    }

    @Test
    void findByFaculty_givenNoValidFaculty_shouldThrowsException(){
        // Given
        Faculty faculty = Faculty.n;
        // When
        Assertions.assertThrows(ParamNotFoundException.class,
                // Then
                () -> findCourseByFacultyService.findByFaculty(faculty));
        // Then
        verify(courseRepository, times(0)).findByFaculty(faculty);
    }

}