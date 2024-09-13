package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;

public class ConcreteModel implements Model {

    private final HashMap<String, Object> propertiesMap;

    public ConcreteModel() {
        propertiesMap = new HashMap<>();
    }


    public HashMap<String, Object> getPropertiesMap() {
        return propertiesMap;
    }


    @Override
    public void addAttribute(String key, Object o) {
        propertiesMap.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {

    }
}
