package domein;

import java.util.List;

public class DomeinController {

    private final BierWinkel bierWinkel;

    public DomeinController() {
        bierWinkel = new BierWinkel();
    }

    public long geefAantalBierenMetMinAlcoholPercentage(double percentage) {
        return bierWinkel.geefAantalBierenMetMinAlcoholPercentage(percentage);
    }

    public List<String> geefLijstAlleBierenMetMinAlcoholPercentage(double percentage) {
    	return null;
    }
    
    public String geefNamenBieren() {
    	return null;
    }
    
    public String geefAlleNamenBrouwerijen() {
    	return null;    }
    
    public List<String> geefAlleBieren() {
    	return null;
    }
    
    public String geefBierMetHoogsteAlcoholPercentage() {
        return bierWinkel.geefBierMetHoogsteAlcoholPercentage().toString();
    }

    public String geefBierMetLaagsteAlcoholPercentage() {
        return bierWinkel.geefBierMetLaagsteAlcoholPercentage().toString();
    }

    public List<String> sorteerOpAlcoholGehalteEnNaam() {
    	return null;
    }
    
    public String geefAlleNamenBrouwerijenMetWoord(String woord) {
    	return null;
    }

}
