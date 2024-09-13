package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
class IndexControllerTest {

    private IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Testing the index method returning the desired view.")
    void index() {
        String result = controller.index();
        assertEquals("index", result);
        assertEquals("index", result, "Wrong View Returned");
    }

    @Disabled
    @Test
    void oupsHandler() {
        String result = controller.oupsHandler();
        assertEquals("notimplemented", result, "This is some expensive mesage");
    }

    @Test
    @DisplayName("test not found exception")
    void testException() {
        assertThatExceptionOfType(ValueNotFoundException.class).isThrownBy(() -> controller.oupsHandler());
    }

    @Test
    @DisplayName("test that has to run only in production mode")
    void testAssumption() {
        assumeTrue(
                "production".equalsIgnoreCase("production"),
                "App must be in production mode in order to run this test."
        );
    }
}