package pl.sda.shop.di;

public interface DependencyMapping {
    <I, C extends I> Class<C> getImplementationForInterface(Class<I> interfaceType);
}
