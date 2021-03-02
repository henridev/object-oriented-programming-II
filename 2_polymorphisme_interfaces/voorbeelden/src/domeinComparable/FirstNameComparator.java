package domeinComparable;

import java.util.Comparator;

//tag::codeExample[]
public class FirstNameComparator implements Comparator<Name> {

	@Override
	public int compare(Name o1, Name o2) {
		int firstCmp = o1.getFirstName().compareTo(o2.getFirstName());
        return (firstCmp != 0 ? firstCmp : o1.getLastName().compareTo(o2.getLastName()));
	}
}
//end::codeExample[]
