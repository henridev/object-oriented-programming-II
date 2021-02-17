package ui;

import domein.DomeinController;

import java.util.List;

public class BeheerKostenApplicatie {
    public static final String RED= "\u001B[41m";
    public static final String GREEN = "\u001B[42m";
    public static final String YELLOW= "\u001B[43m";
    public static final String RESET = "\033[0m";  // Text Reset
    private final DomeinController dc;

    public BeheerKostenApplicatie(DomeinController dc)
    {
        this.dc = dc;
    }

    public void geefBeheerKostenOverzichte()
    {
        // hier gebruik je de domeincontroller om met de domeinlaag te communiceren
        List<String> titels = dc.geefTitelsSBeheersKosten();
        int limit = titels.size();
        for (int i = 0; i < limit; i++) {
            String titel = titels.get(i);
            System.out.print(GREEN + titel + RESET);
            System.out.println();
            System.out.print(YELLOW + dc.geefDetailsBeheersKost(i) + RESET);
            System.out.println();
            System.out.print(RED + String.format("%.2f",dc.geefBeheersKostenWaarde(i)) + RESET);
            System.out.println();
            System.out.println();
        }

    }
}