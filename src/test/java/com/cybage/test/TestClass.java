package com.cybage.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.firefox.marionette", "src/test/resources/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void firstTest() {
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys("sopan");
		driver.findElement(By.name("password")).sendKeys("sopan");
		driver.findElement(By.name("login")).click();
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
