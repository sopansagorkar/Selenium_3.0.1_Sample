package com.cybage.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.main.Drivers;

public class TestClass {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = Drivers.chooseDriver();
	}

	@Test
	public void firstTest() {
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys("sopan");
		driver.findElement(By.name("password")).sendKeys("sopan");
		driver.findElement(By.name("login")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
