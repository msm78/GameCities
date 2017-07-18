package by.htp.gameCities;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumGetCities {

	private static WebDriver driver;
	private static List<WebElement> listCity;
	private static ArrayList<String> listCities;

	public SeleniumGetCities() {
		initBrowser();
		getCities();
		quitBrowser();
	}

	public void initBrowser() {
		//System.setProperty("webdriver.gecko.driver", "D:\\students\\msm\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "c:\\Users\\GAMMA-LF\\AppData\\Local\\Temp\\java\\geckodriver\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "c:\\temp\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void getCities() {
		//driver.get("http://www.americancities.ru/info/usa_cities_in_alphabetical_order/");
		driver.get("file:///c:/Users/GAMMA-LF/AppData/Local/Temp/java/%D0%93%D0%BE%D1%80%D0%BE%D0%B4%D0%B0%20%D0%A1%D0%A8%D0%90%20%D0%BF%D0%BE%20%D0%B0%D0%BD%D0%B3%D0%BB%D0%B8%D0%B9%D1%81%D0%BA%D0%BE%D0%BC%D1%83%20%D0%B0%D0%BB%D1%84%D0%B0%D0%B2%D0%B8%D1%82%D1%83%20_%20%D0%90%D0%BC%D0%B5%D1%80%D0%B8%D0%BA%D0%B0%D0%BD%D1%81%D0%BA%D0%B8%D0%B5%20%D0%B3%D0%BE%D1%80%D0%BE%D0%B4%D0%B0.htm");

		listCity = driver.findElements(By.xpath("html/body/div[2]/div[2]/div[2]/table/tbody/tr/td[1]"));
		listCities = new ArrayList<String>();

		for (int i = 0; i < listCity.size(); i++) {
			listCities.add(listCity.get(i).getText());
		}

		Iterator<String> iterator = listCities.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("Количество городов в списке: " + listCities.size() + "\n");
	}

	public void quitBrowser() {
		driver.quit();
	}

	public ArrayList<String> getListCities() {
		return listCities;
	}

	public static void setListCities(ArrayList<String> listCities) {
		SeleniumGetCities.listCities = listCities;
	}

}