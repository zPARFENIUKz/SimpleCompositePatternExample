package Composite.Containers;

import Composite.HasPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractContainer implements HasPrice {
    private final List<HasPrice> components = new ArrayList<>();

    public AbstractContainer() {

    }

    public boolean addComponent(HasPrice component) {
        if (component == null) throw new NullPointerException("component can't be null");
        return components.add(component);
    }

    public boolean removeComponent(HasPrice component) {
        if (component == null) throw new NullPointerException("component can't be null");
        return components.remove(component);
    }

    public List<HasPrice> getComponents() {
        return Collections.unmodifiableList(components);
    }

    @Override
    public double getPrice() {
        if (components.isEmpty()) return 0;
        return components.stream().mapToDouble(HasPrice::getPrice).reduce(Double::sum).getAsDouble();
    }
}
