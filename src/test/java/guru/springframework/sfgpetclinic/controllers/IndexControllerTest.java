package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexControllerTest {

    private IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        String result = controller.index();
        assertEquals("index", result);
        assertEquals("index", result, "Wrong View Returned");
    }

    @Test
    void oupsHandler() {
        String result = controller.oupsHandler();
        assertEquals("notimplemented", result, "This is some expensive mesage");
    }
}