package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private PetTypeService petTypeService;
    private PetService petService;

    @BeforeEach
    void setUp() {

        // initialization
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

    }

    @Test
    @DisplayName("Verify Zero Owners")
    void ownersAreZero() {
        int ownersCount = ownerMapService.findAll().size();
        assertThat(ownersCount).isZero();
    }

    @Nested
    @DisplayName("Pet Type - ")
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            // create pet types.
            PetType petType1 = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");

            // save them
            petTypeService.save(petType1);
            petTypeService.save(petType2);
        }

        @Test
        void testPetCount() {

            // check if the pets have been saved.
            int petCounts = petTypeService.findAll().size();
            assertThat(petCounts).isNotZero().isEqualTo(2);
        }

        @Nested
        @DisplayName("Save Owners Tests - ")
        class SaveOwnersTests {

            @BeforeEach
            void setUp() {

                // create two owners
                Owner owner1 = new Owner(1L, "Alaa", "Zamel");
                Owner owner2 = new Owner(2L, "Mounier", "Zamel");

                // save them
                ownerMapService.save(owner1);
                ownerMapService.save(owner2);
            }
        }
    }

    @Test
    void ownersAreStillZero() {
        int ownersCount = ownerMapService.findAll().size();
        assertThat(ownersCount).isZero();
    }
}