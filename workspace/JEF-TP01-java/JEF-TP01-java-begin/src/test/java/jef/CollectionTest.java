package jef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {

	private static final String[] ARRAY = { "Anatole", "Guillaume", "Marie", "Jessica", "Damien", "Antoine", "Raymond",
			"Jean Philippe", "Lucie", "Dorothée", "Denis", "Denise", "Daniel", "Aurélie" };

	public static void main(String[] args) {
		Collection<String> collection = Arrays.asList(ARRAY);

		// With values
		search("A", collection);

		// Empty
		search("A", new ArrayList<String>());

		// Null
		search("A", (Collection<String>) null);
	}

	private static void search(String toSearch, Collection<String> collection) {
		// TODO TO IMPLEMENT !
	}

}
