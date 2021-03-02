package domein;

import java.util.Comparator;

@FunctionalInterface
public interface ContainerMassaCompare extends Comparator<Container> {
    public int compare(Container c1, Container c2);
}