package by.htp.gameCities;

import java.util.ArrayList;
import java.util.Random;

public class GameClient {
	private String inpMessage;
	private String outMessage;
	private String lastChar;
	private String nameGamer;
	private boolean game;
	private static final String SM_TECH_DEFEAT = "Technical defeat: The city was already called.";

	ArrayList<String> usedCities = new ArrayList<String>();
	//ArrayList<String> listCitiesStartsWithLastChar = new ArrayList<String>();
	SeleniumGetCities seleniumGetCities = new SeleniumGetCities();
	Random random = new Random();
	
	
	public GameClient(String nameGamer) {
		super();
		this.nameGamer = nameGamer;
		this.game = true;
	}
	

	public boolean isGame() {
		return game;
	}
	
	public void randomCity() {
		int size = seleniumGetCities.getListCities().size();
		String randomCity = seleniumGetCities.getListCities().get(random.nextInt(size));
		usedCities.add(randomCity);
		outMessage = randomCity;
	}


	public void citiesExchange() {
		game = false;
		if (usedCities.contains(inpMessage)) {
			outMessage = SM_TECH_DEFEAT;
		} else if (SM_TECH_DEFEAT.contains(inpMessage)) {
			System.out.println(nameGamer +" lost!");
		} else if ("No answer!".contains(inpMessage)) {
			System.out.println(nameGamer +" win!");
		} else {
			usedCities.add(inpMessage);
			seleniumGetCities.getListCities().remove(inpMessage);

			lastChar = inpMessage.toLowerCase().substring(inpMessage.length() - 1);
			
			outMessage = "No answer!";
			for(int i=0; i<seleniumGetCities.getListCities().size(); i++) {
				String nextCity = seleniumGetCities.getListCities().get(i);
				if(nextCity.toLowerCase().startsWith(lastChar)){
					if (!usedCities.contains(nextCity)) {
						outMessage = nextCity;
						usedCities.add(outMessage);
						game = true;
						break;
					}
				}
			}
		}
	}

	public String getInpMessage() {
		return inpMessage;
	}

	public void setInpMessage(String inpMessage) {
		this.inpMessage = inpMessage;
	}

	public String getOutMessage() {
		return outMessage;
	}

	public void setOutMessage(String outMessage) {
		this.outMessage = outMessage;
	}


	

}