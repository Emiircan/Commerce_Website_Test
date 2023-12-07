package Utlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Locale;

public class BrowserParameters {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                break;

            case "edge": driver=new EdgeDriver(); break;

            case "safari": driver= new SafariDriver(); break;

            case "chrome":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }


    @AfterClass
    public void quitDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
