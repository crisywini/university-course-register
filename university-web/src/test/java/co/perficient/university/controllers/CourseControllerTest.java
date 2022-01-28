package co.perficient.university.controllers;

import co.perficient.university.application.service.course.CourseApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    @Mock
    private CourseApplicationService courseApplicationService;

    @InjectMocks
    private CourseController courseController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(courseController)
                .build();
    }

    @Test
    void save() {
    }

    @Test
    void findAll() throws Exception {

        mockMvc.perform(get("/api/courses"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findById() {
    }

    @Test
    void findByAcademicLevel() {
    }

    @Test
    void findByFaculty() {
    }

    @Test
    void findByModality() {
    }

    @Test
    void findByUser() {
    }

    @Test
    void findByName() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

}