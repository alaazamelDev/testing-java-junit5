package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.interfaces.ModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTest {

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