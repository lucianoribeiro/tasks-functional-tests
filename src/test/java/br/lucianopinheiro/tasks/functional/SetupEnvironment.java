package br.lucianopinheiro.tasks.functional;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupEnvironment {
	
	@Test
	public void setupEnv() {
		System.setProperty("webdriver.chrome.driver","/home/lpribeiro/eclipse-workspace/chromedriver");
		WebDriver driver = new ChromeDriver();
	}
	

}
