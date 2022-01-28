package co.perficient.university.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.port.CourseRepository;
import java.util.HashSet;
import java.util.Set;
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
class FindAllCoursesServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private FindAllCoursesService findAllCoursesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findAllCoursesService = new FindAllCoursesService(courseRepository);
    }

    @Test
    void findAll_shouldCallAService() {
        // Given
        given(courseRepository.findAll()).willReturn(new HashSet<>());
        // When
        Set<Course> all = findAllCoursesService.findAll();
        // Then
        Assertions.assertEquals(0, all.size());
        verify(courseRepository, times(1)).findAll();
    }

}