package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domein.Container;
import domein.ContainerByMassSorter;
import domein.ContainerByOwnerSorter;

public class ContainerApplicatie {

    public static void main(String[] args) {
    	System.out.print("Application initialization");  

    	List<Container> containers = new ArrayList<>();
     
        containers.add(new Container("Antwerpen", 60, 150, 1234));
        containers.add(new Container("Rotterdam", 70, 110, 2568));
        containers.add(new Container("Calais", 80, 90, 8569));
        containers.add(new Container("Brugge", 70, 100, 8564));
         
        // Stap 1
        Collections.sort(containers);    
        System.out.printf("\nContainers bij natuurlijk sorteren:\n");    
        printContainers(containers);
        
        // Stap 2
        Collections.sort(containers, new ContainerByMassSorter());
        System.out.printf("\nContainers bij sorteren op massa:\n");    
        printContainers(containers);
       
        // Stap 3
        Collections.sort(containers, new ContainerByOwnerSorter());
        System.out.printf("\nContainers bij sorteren op eigenaar:\n");    
        printContainers(containers);
        
    }
    
    public static void printContainers(List<Container> list) {
    	 for(Container c:list){  
         	String massa = String.valueOf(c.getMassa());
         	String eigenaar = c.getEigenaar();
         	String volume = String.valueOf(c.getVolume());
         	System.out.println(volume + "m^2 - " + eigenaar + " - " + massa + "kg");    
         }    
    }
}