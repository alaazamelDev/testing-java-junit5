package guru.springframework.sfgpetclinic.interfaces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("controllers")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllerTest {

    @BeforeAll
    default void beforeAll() {
        System.out.println("Hi Controller Class");
    }
}
