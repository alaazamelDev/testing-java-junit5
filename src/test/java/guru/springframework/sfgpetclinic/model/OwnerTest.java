package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.interfaces.ModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name is not matching"),
                        () -> assertEquals("Buck", owner.getLastName(), "Last Name is not matching")
                ),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City is not matching"),
                        () -> assertEquals("1231231234", owner.getTelephone(), "Telephone is not matching")
                )
        );

    }
}