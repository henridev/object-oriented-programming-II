package ui;

import domein.DomeinController;

public class CryptoGraphieApplicatie {
    private DomeinController dc;
    public CryptoGraphieApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        dc.codeerBericht("angstschreeuw");
        System.out.println(dc.getGecodeerdBericht());


        dc.codeerBericht("de pannenkoek");
        System.out.println(dc.getGecodeerdBericht());

        dc.codeerBericht("bravo");
        System.out.println(dc.getGecodeerdBericht());

        dc.codeerBericht("aap");
        System.out.println(dc.getGecodeerdBericht());
    }
}
