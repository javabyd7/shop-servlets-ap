package pl.sda.shop.di;

import java.util.Map;

public class SimpleMapDepdendencyMapping implements DependencyMapping {
    private Map<Class<?>, Class<?>> mapping;

    public SimpleMapDepdendencyMapping(Map<Class<?>, Class<?>> mapping) {
        this.mapping = mapping;
    }

    @Override
    public <I, C extends I> Class<C> getImplementationForInterface(Class<I> interfaceType) {
        return (Class<C>) mapping.get(interfaceType);
    }
}
