package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.ConcreteModel;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("controllers")
class VetControllerTest {

    private VetService vetService;
    private SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        // create dummy models
        Vet vet1 = new Vet(1L, "Alaa", "Zamel", null);
        Vet vet2 = new Vet(2L, "Fares", "Dobsi", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {

        // prepare controller
        VetController controller = new VetController(vetService);

        // prepare the model
        ConcreteModel model = new ConcreteModel();

        // given that
        String result = controller.listVets(model);

        // test view
        assertThat(result).isEqualTo("vets/index");

        // test model saving functionality
        Set dataSet = (Set) model.getPropertiesMap().get("vets");
        assertThat(dataSet.size())
                .isEqualTo(2);
    }
}