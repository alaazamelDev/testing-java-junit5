package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("models")
class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Alaa", "Zamel");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Alaa", person.getFirstName(), "First Name is not matching"),
                () -> assertEquals("Zamel", person.getLastName(), "Last Name is not matching")
        );
    }
}