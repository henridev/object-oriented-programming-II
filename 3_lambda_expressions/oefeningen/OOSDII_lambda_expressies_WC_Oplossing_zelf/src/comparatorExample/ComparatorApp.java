
package comparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorApp {
    public ComparatorApp() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
  

        // Sorteer Movie objecten op 'rating' : 
        //	(1) Instantieer een object RatingCompare 
        //	(2) Roep Collections.sort aan en geef dit 
        //		object mee als tweede parameter 
        //	(3) Print de gesorteerde lijst

        // (1) anonymous class
        Comparator<Movie> ratingCompare = new Comparator<Movie>() {
            public int compare(Movie m1, Movie m2) { return m2.getRating().compareTo(m1.getRating()); }
        };

        // (2) lambda expression / thanks to double implementing comparable
        Comparator<Movie> ratingComparison = (m1, m2) -> m2.getRating().compareTo(m1.getRating());
        Comparator<Movie> nameComparison = (m1, m2) -> m2.getName().compareTo(m1.getName());

        list.sort(ratingCompare);
        printAllMovies(list, "rating");

        list.sort(ratingComparison);
        printAllMovies(list,"rating");

        list.sort(nameComparison);
        printAllMovies(list, "name");

        // (3) method reference
        list.sort(Comparator.comparingDouble(Movie::getRating).reversed());
        printAllMovies(list, "rating");
        list.sort(Comparator.comparing(Movie::getName).reversed());
        printAllMovies(list, "name");
    }

    private void printAllMovies(List<Movie> list,String by) {
        System.out.printf("========= sorted by %s ========\n", by);
        list.forEach((movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear())));
        System.out.println("<<<<<<<< end >>>>>>>\n");
    }
}
