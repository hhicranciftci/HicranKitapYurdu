package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class BaseProcess {


    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected String firstUrl = "https://www.kitapyurdu.com/";


    @Before
    public void beforeMethod() {
        LogProcess.info("Test starting...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.setExperimentalOption("w3c", false);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        LogProcess.info("Driver builded.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        driver.manage().window().maximize();
        LogProcess.info("Driver open at maximize");


    }


    @After
    public void afterMethod() {
        if (driver != null) {
            driver.close();
            driver.quit();
            LogProcess.info("Test finished.");
        }
    }


}
