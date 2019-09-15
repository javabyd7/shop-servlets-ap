package pl.sda.shop.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;

public class DependencyContainer {
    private DependencyMapping dependencyMapping;

    public DependencyContainer(DependencyMapping dependencyMapping) {
        this.dependencyMapping = dependencyMapping;
    }

    public <T> T get(Class<T> type) {
        Constructor<?>[] constructors = dependencyMapping.getImplementationForInterface(type).getConstructors();
        if (thereIsMoreThanOneConstructor(constructors)) {
            throw new DepeendencyContainerException("Only one constructor is allowed");
        }
        Constructor<T> constructor = (Constructor<T>) constructors[0];
        Parameter[] parameters = constructor.getParameters();
        Collection<Object> allParams = new ArrayList<>();
        for (Parameter parameter : parameters) {
            Class<?> paramType = parameter.getType();
            Object paramValue = get(paramType);
            allParams.add(paramValue);
        }
        try {
            return constructor.newInstance(allParams.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new DepeendencyContainerException("Failed to instantiate because of fucked up exceptions");
        }
    }

    private static boolean thereIsMoreThanOneConstructor(Constructor<?>[] constructors) {
        return false;
    }
}
