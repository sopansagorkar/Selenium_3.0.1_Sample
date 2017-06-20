package com.test.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Drivers {
	static WebDriver driver;

	public static WebDriver chooseDriver() {
		String getDriver = System.getProperty("driver");
		String os = System.getProperty("os.name");
		String osarch = System.getProperty("os.arch");
		if ("Windows 8".equalsIgnoreCase(os) || "Windows 7".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)) {
			if (getDriver.equalsIgnoreCase("firefox")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
				driver = new FirefoxDriver(capabilities);
			}
			if (getDriver.equalsIgnoreCase("phantomjs")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						"src/test/resources/phantomjs.exe");
				driver = new PhantomJSDriver(capabilities);
			}

		} else if ("Linux".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)) {
			if (getDriver.equalsIgnoreCase("firefox")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("webdriver.gecko.driver", "src/test/resources/geckodriver");
				driver = new FirefoxDriver(capabilities);
			}
			if (getDriver.equalsIgnoreCase("phantomjs")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						"src/test/resources/phantomjs");
				driver = new PhantomJSDriver(capabilities);
			}
		}

		return driver;

	}
}
