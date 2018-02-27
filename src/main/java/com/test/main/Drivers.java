package com.test.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
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

				System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
				System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "");
				driver = new FirefoxDriver();
			}
			if (getDriver.equalsIgnoreCase("phantomjs")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						"src/test/resources/phantomjs.exe");
				driver = new PhantomJSDriver(capabilities);
			}
			if (getDriver.equalsIgnoreCase("chrome")) {
				System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
						"src/test/resources/chromedriver_32.exe");
				driver = new ChromeDriver();
			}

		} else if ("Linux".equalsIgnoreCase(os) && "amd64".equalsIgnoreCase(osarch)) {
			if (getDriver.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
				driver = new FirefoxDriver();
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
