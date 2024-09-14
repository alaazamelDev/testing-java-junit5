package guru.springframework.sfgpetclinic.interfaces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("models")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ModelTest {

    @BeforeAll
    default void beforeAll() {
        System.out.println("Hi Model Class");
    }
}
