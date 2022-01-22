package com.intetbanking.testCases;

import com.intetbanking.utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {

    ReadConfig readConfig= new ReadConfig();
    public String baseurl=readConfig.getApplicationURL();
    public String username=readConfig.getUserName();
    public String Password =readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver",readConfig.getchromeDriverPath());
        driver= new ChromeDriver();
        logger= Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");

        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
