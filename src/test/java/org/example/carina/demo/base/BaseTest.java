package org.example.carina.demo.base;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest implements IAbstractTest, ITestListener {
    String pathFile = "/Users/alexisvillamayor/Solvd/WebAutomationTask2/src/test/screenshots";
    protected ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public WebDriver getLocalDriver() {
        return driverThreadLocal.get();
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/alexisvillamayor/Solvd/Dev/chromedriver");
//                THESE CONFIGURATIONS ARE NEEDED JUST IN CASE YOU WANT TO RUN YOUR TESTS IN REMOTE USING SELENIUM GRID
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), firefoxOptions);

//        WebDriverFactory webDriverFactory = new WebDriverFactory();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        driverThreadLocal.set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        getLocalDriver().quit();
        }
    }

