package main;

import domein.DomeinController;
import domein.KostenRepository;
import ui.BeheerKostenApplicatie;
import ui.RekeningApplicatie;

public class StartUp
{

    public static void main(String[] args)
    {
        KostenRepository kr = new KostenRepository();
        new BeheerKostenApplicatie(new DomeinController(kr)).geefBeheerKostenOverzichte();
    }
}
