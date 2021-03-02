package domeinArtCollection;

//tag::codeExample[]
public abstract class Huisdier extends Dier implements Drawable, Saleable {
    private String naam;
    
    public Huisdier(String naam) {
        setNaam(naam);
    } 

	public String getNaam() {
        return naam;
    }

    private void setNaam(String naam) {
        this.naam = naam;
    }
    
    public abstract String maakGeluid();
}
//end::codeExample[]
