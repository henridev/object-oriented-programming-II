package main;

import domein.DomeinController;
import ui.VoorwerpApplicatie;

public class StartUp 
{
    public static void main(String[] args) 
    {
        DomeinController dc = new DomeinController();
        new VoorwerpApplicatie(dc).start();
    }
}
