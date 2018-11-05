package rft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



 
public class Slf4jExample {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Slf4jExample.class);
	    logger.info("Testing slf4j");
	}
}