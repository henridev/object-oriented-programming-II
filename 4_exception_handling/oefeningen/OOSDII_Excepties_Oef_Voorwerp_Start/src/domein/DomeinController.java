package domein;

public class DomeinController {

    private final DraagbaarRepository draagbaarRepo;

    public DomeinController() {
        draagbaarRepo = new DraagbaarRepository();
    }

    public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt) {
        draagbaarRepo.voegDraagbaarItemToe(new Wapen(naam, gewicht, niveau, kracht, gebruikt));
    }

    public void voegSleutelToe(String naam, double gewicht, int niveau, int deur) {
        draagbaarRepo.voegDraagbaarItemToe(new Sleutel(naam, gewicht, niveau, deur));
    }

    public String geefOverzicht() {
        return draagbaarRepo.geefOverzicht();
    }

    public void voegGebouwToe(String naam, double hoogte) {
        draagbaarRepo.voegDraagbaarItemToe(new Gebouw(naam, hoogte));
    }

}
