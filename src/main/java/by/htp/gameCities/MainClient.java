package by.htp.gameCities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClient {

	public static void main(String[] args) throws InterruptedException {
		
		private static final Logger logger = LogManager.getLogger("HelloWorld");
		logger.info("Hello, World!");
		

		Client client = new Client();
		client.clientServer();

	}

}