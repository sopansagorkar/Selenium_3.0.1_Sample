package com.cybage.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("sopan");
		driver.findElement(By.name("password")).sendKeys("sopan");
		driver.findElement(By.name("login")).click();
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
