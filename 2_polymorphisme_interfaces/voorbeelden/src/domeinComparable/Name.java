package domeinComparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//tag::codeExample[]
public class Name implements Comparable<Name> {
    private final String firstName, lastName; 

    public Name(String firstName, String lastName) { 
        if (firstName == null || lastName == null)
            throw new NullPointerException();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
    
    @Override
    public int compareTo(Name n) { // <1>
        int lastCmp = lastName.compareTo(n.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
    }

    @Override
    public int hashCode() { // <2>
        return 31*firstName.hashCode() + lastName.hashCode();
    }
    
    @Override
    public boolean equals(Object o) { // <3>
        if (!(o instanceof Name))
            return false;
        Name n = (Name) o;
        return n.firstName.equals(firstName) && n.lastName.equals(lastName);
    }

    @Override
    public String toString() { 
    	return firstName + " " + lastName;
    }
    
    public static void main(String[] args) {
        Name nameArray[] = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
        };

        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names); // <4>
        System.out.println(names);
    }
}
//end::codeExample[]
