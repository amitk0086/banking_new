package com.intetbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {

    public String baseurl="https://demo.guru99.com/v3/index.php";
    public String username="mngr381956";
    public String Password ="Yhenyze";
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
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
