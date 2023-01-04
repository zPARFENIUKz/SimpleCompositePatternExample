package Composite.Containers;

import Composite.HasPrice;
import Composite.Items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractContainer implements HasPrice {
    private final List<HasPrice> components = new ArrayList<>();

    public static class Builder {
        private AbstractContainer container;

        public Builder() {

        }

        public Builder withContainer(AbstractContainer container) {
            if (container == null) throw new NullPointerException("container can't be null");
            this.container = container;
            return this;
        }

        public Builder addItem(Item item) {
            if (item == null) throw new NullPointerException("item can't be null");
            container.addComponent(item);
            return this;
        }

        public Builder addContainer(AbstractContainer container) {
            if (container == null) throw new NullPointerException("container can't be null");
            this.container.addComponent(container);
            return this;
        }

        public AbstractContainer build() {
            return container;
        }
    }

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
