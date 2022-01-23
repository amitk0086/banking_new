package com.intetbanking.testCases;

import com.intetbanking.utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

    ReadConfig readConfig= new ReadConfig();
    public String baseurl=readConfig.getApplicationURL();
    public String username=readConfig.getUserName();
    public String Password =readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void SetUp(String br)
    {
        logger= Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");
        if (br.equals("chrome")) {
              System.setProperty("webdriver.chrome.driver", readConfig.getchromeDriverPath());
               driver = new ChromeDriver();
               driver.manage().window().maximize();
        }
        else if (br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver= new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if (br.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver", readConfig.getIEDriverPath());
            driver= new InternetExplorerDriver();
            driver.manage().window().maximize();
        }
        driver.get(baseurl);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
