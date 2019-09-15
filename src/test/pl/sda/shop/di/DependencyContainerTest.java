package pl.sda.shop.di;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class DependencyContainerTest {
    @Test
    void getSimpleGraphInstanceTest() {
        // given
        // prepare map with dependencies
        Map<Class<?>, Class<?>> map = new HashMap<>();
        map.put(ClassAInterface.class, ClassA.class);
        map.put(ClassBInterface.class, ClassB.class);
        map.put(ClassCInterface.class, ClassC.class);
        DependencyMapping dependencyMapping = new SimpleMapDepdendencyMapping(
                map
        );
        DependencyContainer container = new DependencyContainer(dependencyMapping);

        // when
        ClassAInterface classAInstance = container.get(ClassAInterface.class);
        Assertions.assertThat(classAInstance).isNotNull().isInstanceOf(ClassA.class);
    }
}