package ui;

import java.util.*;

import domein.Container;
import domein.ContainerEigenaarCompare;
import domein.ContainerMassaCompare;

public class ContainerApplicatie {
    static Comparator<Container> eigenaarCompare = (Container c1, Container c2) -> c1.getEigenaar().compareTo(c2.getEigenaar());
    static Comparator<Container> serieCompare = Comparator.comparing(Container::getSerialNumber);
    static Comparator<Container> massaCompare = new ContainerMassaCompare() {
        public int compare(Container c1, Container c2){
            return c1.getMassa() - c2.getMassa();
        }
    };

    public static void main(String[] args) {
        List<Container> containers = new ArrayList<>();
        
        containers.add(new Container("Antwerpen", 60, 150, 1234));
        containers.add(new Container("Rotterdam", 70, 110, 2568));
        containers.add(new Container("Calais", 80, 90, 8569));
        containers.add(new Container("Brugge", 70, 100, 8564));
                
        Collections.sort(containers);

        System.out.printf("Containers bij natuurlijk sorteren: %n");
        for (Container container : containers) {
            System.out.printf("%dm² - %s - %dkg%n", 
                    container.getVolume(),
                    container.getEigenaar(),
                    container.getMassa());
        }

        System.out.printf("%nContainers bij sorteren op massa: %n");
        containers.sort(massaCompare);
        for (Container container : containers) {
            System.out.printf("%dkg - %s - %dm²%n",
                     container.getMassa(),
                     container.getEigenaar(),
                     container.getVolume());
        }

        System.out.printf("%nContainers bij sorteren op eigenaar: %n");
        containers.sort(eigenaarCompare);
        for (Container container : containers) {
            System.out.printf("%s - %dm² - %dkg%n",
                    container.getEigenaar(),
                    container.getVolume(),
                    container.getMassa());
        }

        System.out.printf("%nContainers bij sorteren op serienummer: %n");
        containers.sort(serieCompare);
        for (Container container : containers) {
            System.out.printf("%s - %s - %dm² - %dkg%n",
                    container.getSerialNumber(),
                    container.getEigenaar(),
                    container.getVolume(),
                    container.getMassa());
        }


        Container nieuweContainer = new Container("Antwerpen", 70, 75, 8564);
        boolean isReedsToegevoegd = false;
        
        for (Container container : containers) {
            if (container.equals(nieuweContainer))
            {
                isReedsToegevoegd = true;
                break;
            }
        }
        
        System.out.printf("%n%s%n",
                isReedsToegevoegd ? 
                        "Fout: De container was reeds aanwezig in de lijst."
                        :
                        "De container is toegevoegd aan de lijst.");
    }


}