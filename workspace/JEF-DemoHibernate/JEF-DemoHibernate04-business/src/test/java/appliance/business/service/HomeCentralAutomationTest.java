package appliance.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeCentralAutomationTest {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(HomeCentralAutomationTest.class);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext-test.xml");) {
			HomeCentralAutomation homeCentralAutomation = context.getBean(HomeCentralAutomation.class);

			homeCentralAutomation.loadAllElectricalAppliances();
			homeCentralAutomation.showAll();
			homeCentralAutomation.startAllSecurely();
			homeCentralAutomation.showAll();
			homeCentralAutomation.saveAllElectricalAppliances();

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}
		logger.info("finished !");
	}
}
