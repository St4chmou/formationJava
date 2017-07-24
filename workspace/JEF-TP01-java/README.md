JavaEtFrameworks - TP01
=======================

PART 1:
	The Euclid's algorithm is used to determine the Greatest Common Denominator (GCD) of two positive integers. 
	The GCD of two numbers a and b is the largest number n such that n is a divisor of a and b
	Calculate r = a % b
	while r is different from zero
	    set the value of b in a
	    set the value of r in b
	    r = a % b
	end
	GCD is b
    Code a method with 2 parameters and test it with {72;56} and {21;214}

PART 2:
	The class CollectionTest contains a collection of strings.
	Display and count all items starting with ‘A’.
	To display, use System.out.println();
	The String class contains many useful methods
	Test your code with an empty collection
	Test your code with a null collection 

PART 3: 
	The class ComparatorTest contains 2 collections.
	Create some comparator classes like this one to compare LISTE_APPAREILS 
		by modele asc
		by modele desc
		by puissanceMax desc
		by marque et modele asc
	Example of code:
	+-------------------------------------------------------------------------------+
	|	public class AppareilElectriqueComparatorParModelAsc 						|
	| 		implements Comparator<AppareilElectrique> {								|
	|																				|
	|		@Override																|
	|		public int compare(AppareilElectrique _c1, AppareilElectrique _c2) {	|
	|			return _c1.getModele().compareTo(_c2.getModele());					|
	|		}																		|
	|	}																			|
	+-------------------------------------------------------------------------------+

	Modify AppareilElectriqueComparable to implement Comparable
		Use this code to sort by modele
	Example of code:
	+-----------------------------------------------------------+
	|	System.out.println("\n\nTri naturel avec Comparable");	|
	|	Collections.sort(LISTE_APPAREILS_COMPARABLE);			|
	|	System.out.println(LISTE_APPAREILS_COMPARABLE);			|
	+-----------------------------------------------------------+