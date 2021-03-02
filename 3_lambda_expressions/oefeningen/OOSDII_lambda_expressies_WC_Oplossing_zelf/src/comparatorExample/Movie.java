package comparatorExample;

import java.util.Objects;

// A class 'Movie' that implements Comparable
public class Movie implements Comparable<Movie> {

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
	public String toString() { return String.format("%s %.2f %d", getName(), getRating(), getYear()); }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Movie other = (Movie) obj;
		return (name != null || other.name == null) && Objects.equals(name, other.name) && year == other.year;
	}
	
	// Used to sort movies by year 
    @Override
	public int compareTo(Movie m) {
        int result = this.name.compareTo(m.getName());
        if (result == 0) return this.getYear() - m.getYear();
        return result;
    }
}


