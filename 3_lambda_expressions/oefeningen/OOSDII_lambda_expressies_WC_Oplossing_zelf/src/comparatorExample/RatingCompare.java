package comparatorExample;

import java.util.Comparator;

public class RatingCompare implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2) {
        return m2.getRating().compareTo(m1.getRating());
    }
}
