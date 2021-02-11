package equalsExample;

// A class 'Movie' that implements Comparable 
public class Movie {

	private Double rating;
    private String name;
    private int year;

    // Constructor 
    public Movie(String nm, double rt, int yr) {
        setName(nm);
        setRating(rt);
        setYear(yr);
    }
    
    // Getter & setter methods for accessing private data 
    public Double getRating() { return rating; }
    public String getName() { return name; }
    public int getYear() { return year; }
    private void setRating(Double rating) { this.rating = rating; }
    private void setName(String name) { this.name = name; }
    private void setYear(int year) { this.year = year; }

	@Override
	public String toString() {
		return String.format("%s %.2f %d",
				 getName(),
				 getRating(),
				 getYear());
	}  
}


