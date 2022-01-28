package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseRepository;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FindCourseSubjectByCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseSubjectRepository courseSubjectRepository;

    private FindCourseSubjectByCourseService findCourseSubjectByCourseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findCourseSubjectByCourseService = new FindCourseSubjectByCourseService(courseSubjectRepository,
                courseRepository);
    }

    @Test
    void findByCourse_givenExistingCourseId_shouldCallAService() {
        // Given
        Long courseId = 1L;
        List<CourseSubjectDto> courseSubjectDtoList = List.of(CourseSubjectDto.builder().id(1L).build());
        given(courseRepository.findById(courseId)).willReturn(Optional.of(Course.builder().id(courseId).build()));
        given(courseSubjectRepository.findByCourse(courseId)).willReturn(courseSubjectDtoList);
        // When
        List<CourseSubjectDto> byCourse = findCourseSubjectByCourseService.findByCourse(courseId);
        // Then
        Assertions.assertEquals(1, byCourse.size());
        verify(courseRepository, times(1)).findById(courseId);
        verify(courseSubjectRepository, times(1)).findByCourse(courseId);
    }

    @Test
    void findByCourse_givenNonExistingCourseId_shouldThrowsException() {
        //Given
        Long courseId = 2L;
        given(courseRepository.findById(courseId)).willReturn(Optional.empty());
        // When
        Assertions.assertThrows(NullEntityException.class,
                // Then
                () -> findCourseSubjectByCourseService.findByCourse(courseId));
        // Then
        verify(courseRepository, times(1)).findById(courseId);
        verify(courseSubjectRepository, times(0)).findByCourse(courseId);
    }

}