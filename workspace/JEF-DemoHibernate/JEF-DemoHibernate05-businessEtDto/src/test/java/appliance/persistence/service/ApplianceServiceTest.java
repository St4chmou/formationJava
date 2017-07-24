package appliance.persistence.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import appliance.business.dto.ApplianceDto;

public class ApplianceServiceTest {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(ApplianceServiceTest.class);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");) {
			ApplianceService applianceService = context.getBean(ApplianceService.class);

			List<ApplianceDto> appDtos = applianceService.loadAllAppliances();

			applianceService.saveAllAppliances(appDtos);

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}
		logger.info("finished !");
	}
}
