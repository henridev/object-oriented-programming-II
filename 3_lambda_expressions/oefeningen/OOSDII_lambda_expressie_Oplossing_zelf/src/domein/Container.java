package domein;

import java.io.*;
import java.util.*;

public class Container implements Comparable<Container> {

    private String eigenaar;
    private int volume;
    private int massa;
    private final Integer serialNumber;

    // Constructor 
    public Container(String eigenaar, int volume, int massa, int serialNumber) {
        setEigenaar(eigenaar);
        setVolume(volume);
        setMassa(massa);
        controleerSerialNumber(serialNumber);
        this.serialNumber = serialNumber;
    }
    
    public int compareTo(Container m) {
        return this.getVolume() - m.getVolume();
    }



    private void setEigenaar(String eigenaar) {
        if (eigenaar == null || eigenaar.isEmpty()) { throw new IllegalArgumentException("Er moet een eigenaar opgegeven worden."); }
        this.eigenaar = eigenaar;
    }

    private void setVolume(int volume) {
        if (volume <= 0) { throw new IllegalArgumentException("Geen geldig volume opgegeven."); }
        this.volume = volume;
    }

    private void setMassa(int massa) {
        if (massa <= 0) { throw new IllegalArgumentException("Geen geldige massa opgegeven."); }
        this.massa = massa;
    }

    public String getEigenaar() {
        return eigenaar;
    }

    public int getVolume() {
        return volume;
    }

    public int getMassa() {
        return massa;
    }
    
    public Integer getSerialNumber() {
        return serialNumber;
    }
    
    private void controleerSerialNumber(Integer serialNumber) {
        if (serialNumber <= 0) { throw new IllegalArgumentException("Ongeldig serienummer!"); }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.serialNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Container other = (Container) obj;
        return !this.getSerialNumber().equals(other.getSerialNumber());
    }
    
    
}



