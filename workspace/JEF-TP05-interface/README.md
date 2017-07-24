JavaEtFrameworks - TP05
=======================

The project already contains 
	Radiator.java, RegulatedRadiator.java, RadiatorTest.java
	log4j.xml
	dependencies to Junit, Slf4J and commons-collection

Models:
	Light
		- alight : boolean
		- roomName : String
		+ start() : void
		+ stop() : void
	HomeManager
		- ???
		+ startAll() : void
		+ stopAll() : void
		+ add(Radiator r) : void
		+ add(Light l) : void

Steps:
	Take a look at the existing JUnit class (RadiatorTest.java)

	Code Light and HomeManager without interface
	Code a class HomeManagerTest

	Modify your code to use interface
		for Radiator and Light
		to start and stop
