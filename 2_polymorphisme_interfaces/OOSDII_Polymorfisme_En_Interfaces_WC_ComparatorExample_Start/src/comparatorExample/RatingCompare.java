package comparatorExample;

import java.util.Comparator;

public class RatingCompare implements Comparator<Movie> {
    @Override
    public int compare(Movie movie, Movie t1) {
        double r1 = movie.getRating();
        double r2 = t1.getRating();
        return r1 == r2 ? 0 : r1 < r2 ? 1 : -1;
    }
}
