package com.cybage.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.main.Drivers;

public class TestClass {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = Drivers.chooseDriver();
	}

	@Test
	public void firstTest() {
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys("sopan");
		driver.findElement(By.name("password")).sendKeys("sopan");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
