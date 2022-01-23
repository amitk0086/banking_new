package com.intetbanking.testCases;

import com.intetbanking.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_LoginTest_001 extends BaseClass {


    @Test
    public void loginTest() throws InterruptedException {

        logger.info("Url is Opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered UserName");
        lp.setPassword(Password);
        logger.info("Entered Password");
        lp.clickSubmit();
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            logger.info("Login Test Passed");
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
}
