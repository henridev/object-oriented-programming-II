package ui;

import domein.DomeinController;
import domein.KostenRepository;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;
import persistentie.KostenMapper;

public class VerplaatsingApplicatie
{
    public void start()
    {
        KostenMapper km = new KostenMapper();
        km.addCost(new VerplaatsingPerAuto("HoGent campus Schoonmeersen Gent","EFFIX Waregem", 35.4, 1.32, 0.049));
        km.addCost(new VerplaatsingPerAuto("HoGent campus Aalst","Brenso NV Affligem", 11.9, 1.37, 0.058));
        km.addCost(new VerplaatsingPerBusTram("HoGent campus Schoonmeersen Gent","Technologiepark Zwijnaarde", 4.7, 70, true, true));
        km.addCost(new VerplaatsingPerBusTram("Sint-Pietersstation Gent","Vijfwindgatenstraat Gent", 3, 22, false, true));

        KostenRepository kr = new KostenRepository(km);
        DomeinController dc = new DomeinController(kr);
       
        System.out.printf(dc.geefOverzichtAantalDocumenten());
        System.out.printf(dc.geefKostenLijst());
  }
}
