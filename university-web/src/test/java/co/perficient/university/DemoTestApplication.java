package co.perficient.university;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoTestApplication {


    @Test
    void itShouldAddTwoNumbers(){
        // Given
        int a = 1;
        int b = 2;
        // When
        int result = a+b;
        // Then
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }
}
