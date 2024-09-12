package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(ValueNotFoundException.class, () -> controller.oupsHandler(), "ValueNotFound exception must be thrown");
    }
}