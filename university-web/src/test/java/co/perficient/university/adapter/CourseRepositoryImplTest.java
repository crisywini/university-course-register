package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseJPARepository;
import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.Course;
import co.perficient.university.model.Faculty;
import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class CourseRepositoryImplTest {

    @Mock
    private CourseJPARepository courseJPARepository;
    private CourseRepositoryImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new CourseRepositoryImpl(courseJPARepository);
    }

    @AfterEach
    void tearDown() {
        underTest.findAll().forEach(x -> underTest.deleteById(x.getId()));
    }

    @Test
    void canFindAll() {
        underTest.findAll();
        verify(courseJPARepository).findAll();
    }

    @Test
    void canFindById() {
        // given
        long id = 1L;
        underTest.findById(id);
        verify(courseJPARepository).findById(id);
    }

    @Test
    void canSave() {
        Course course = new Course(1L,
                "Systems and Computer Engineering",
                "Systems and Computer Engineer",
                AcademicLevel.MASTER_DEGREE,
                Faculty.ENGINEERING,
                Modality.FACE_TO_FACE,
                340,
                new HashSet<>());
        given(underTest.save(course))
                .willReturn(new CourseDto());

        CourseDto save = underTest.save(course);
        ArgumentCaptor<Course> courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);

        then(courseJPARepository)
                .should()
                .save(courseArgumentCaptor.capture());
        Course courseCaptured = courseArgumentCaptor.getValue();
        assertThat(courseCaptured).isEqualTo(course);
    }

    @Test
    void canDelete() {
        // given
        Course course = new Course(1L,
                "Systems and Computer Engineering",
                "Systems and Computer Engineer",
                AcademicLevel.MASTER_DEGREE,
                Faculty.ENGINEERING,
                Modality.FACE_TO_FACE,
                340,
                new HashSet<>());
        // when
        underTest.delete(course);
        // then
        verify(courseJPARepository).delete(course);
    }

    @Test
    void canDeleteById() {
        // given
        long id = 1L;
        // when
        underTest.deleteById(id);
        // then
        verify(courseJPARepository).deleteById(id);
    }

    @Test
    void canUpdate() {
        // Given
        doUpdateScenario();
        Course course = new Course(1L,
                "Systems and Computer Engineering",
                "Systems and Computer Engineer",
                AcademicLevel.DOCTOR_DEGREE,
                Faculty.ENGINEERING,
                Modality.FACE_TO_FACE,
                130,
                new HashSet<>());
        long id = 1L;
        // When
        underTest.update(id, course);
        // Then
        verify(courseJPARepository).findById(id);
        verify(courseJPARepository).save(course);
    }

    private void doUpdateScenario() {
        Course course = new Course(1L,
                "Systems and Computer Engineering",
                "Systems and Computer Engineer",
                AcademicLevel.MASTER_DEGREE,
                Faculty.ENGINEERING,
                Modality.FACE_TO_FACE,
                340,
                new HashSet<>());
        underTest.save(course);
    }
}