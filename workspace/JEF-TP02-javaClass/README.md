JavaEtFrameworks - TP02
=======================

PART 1:
	Create a class Bike
	Add some fields (with accessors) :
		color
		model
		counter
		speed
	Override the toString method (use Eclipse to generate the code)

	Create a class Main
	Add a runnable method public static void main (String[] args)
	In this method
		create a Bike
		print the bike to the console System.out.println()


PART 2:
	Create a class User with a name (getter, setter, constructor, toString)

	Create a class SwapTest
		In main method, create 2 int variables and swap the values
		In main method, create 2 User variables and swap the values

	Create a class BadSwapTest
		In main method, create 2 int variables and call a swapInt method
		In the swapInt method, swap the values
		In main method, create 2 User variables and call a swapUser method
		In the swapUser method, swap the values

PART 3:
	Model
		Radiator
 		  - brand : String
		  - model : String
		  - on : boolean
		  - powerMax : int
		  + getConsumption() : int
		  + start() : void
		  + stop() : void
		  
		RegulatedRadiator extends Radiator
		  - level : int
		  + getConsumption() : int
	
	Code Radiator
		getConsumption return 0 when radiator is off
		getConsumption return powerMax when radiator is on

	Code RegulatedRadiator
		Level is a positive number less (or equal) than 10
		getConsumption return 0 when radiator is off
		getConsumption return powerMax*level/10 when radiator is on

	Code RadiatorTest
		One method to test Radiator
		One method to test RegulatedRadiator
		One method to play with a collection of Radiator and RegulatedRadiator


