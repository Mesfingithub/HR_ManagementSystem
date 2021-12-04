package util;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

@CucumberOptions(features = "src/test/resources/features")
public class TestConfig extends AbstractTestNGCucumberTests {

    //1. setup chrome and firefox
    //2. Setup Cucumber
    //3. Log file  ---> TODO
    //4. Config File
    //5. Element reading from file
    //6. global method from find by
    //7. sendKey, click and clear

    public static WebDriver browser;
    public static Properties config;
    public static Properties locators;
    public static FileInputStream inputStream;

    //Will load browser and related function
    public void loadConfigFile() throws IOException {
        config = new Properties();
        inputStream = new FileInputStream("src/test/resources/config/browser.properties");
        config.load(inputStream);

    }

    //Will read and load locators value from file
    public void loadElements()throws IOException{
        locators = new Properties();
        inputStream = new FileInputStream("src/test/resources/config/locators.properties");
        locators.load(inputStream);
    }

    // find the type and load the element
    public WebElement elementType(String type, String element){
        try {
            loadElements();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        WebElement locator = null;

        if (type.equals("XPATH")){
            return locator = browser.findElement(By.xpath(locators.getProperty(element)));
        }else if(type.equals("ID")){
            return locator = browser.findElement(By.id(locators.getProperty(element)));

        }else if(type.equals("CSS")){
            return locator = browser.findElement(By.cssSelector(locators.getProperty(element)));
        }
        return locator;
    }

    public void configureDriver() throws IOException{
        loadConfigFile();
       if (config.getProperty("browserType").equals("chrome")){

  //         ChromeOptions options = new ChromeOptions();
//               options.addArguments("--incognito");
//               options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.setExperimentalOption("useAutomationExtension", false);

           browser = new ChromeDriver();
       }
       else if (config.getProperty("browserType").equals("firefox")){
           browser = new FirefoxDriver();
       }

    }
    public void validation(String actualResult, String expectedResult){
        assertEquals(actualResult, expectedResult);
    }


    @Deprecated
    public void implicitWait(int time){
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void deleteAllCookies(){
        browser.manage().deleteAllCookies();
    }

//    @BeforeSuite(alwaysRun = true)
    public void setUp()throws IOException{
        configureDriver();
        implicitWait(30);
        deleteAllCookies();
    }
//    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        try{
            Thread.sleep(2000);
            inputStream.close();

        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
        browser.quit();

    }
}
