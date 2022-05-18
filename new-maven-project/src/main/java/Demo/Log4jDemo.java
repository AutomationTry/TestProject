package Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		
		System.out.println("Hello World...! \n");
		
		logger.trace("This is a trace messgae");
		logger.info("This is information messgae");
		logger.error("Error message");
		logger.warn("A warning message");
		logger.fatal("This is fatal message");
		
		System.out.println("\n Completed");
		// TODO Auto-generated method stub

	}

}
