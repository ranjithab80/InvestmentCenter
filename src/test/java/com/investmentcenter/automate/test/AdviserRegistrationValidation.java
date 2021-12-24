package com.investmentcenter.automate.test;

import java.io.IOException;

import com.investmentcenter.automate.BaseUtil.SeleniumDriver;
import com.investmentcenter.automate.pageobjects.HomePage;
import com.investmentcenter.automate.pageobjects.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdviserRegistrationValidation extends SeleniumDriver {
    private static final Logger LOG = LogManager.getLogger(AdviserRegistrationValidation.class.getName());
    private WebDriver driver;
    private RegistrationPage registrationPage = null;

    @BeforeTest
    public void initialiseAndNavigateRegistrationPage() throws IOException {
        driver = initialize();
        LOG.info("Browser is initialised");

        driver.get(getProperties().getProperty("url"));
        driver.findElement(By.cssSelector("input[id='gateway-adviser']")).click();

        final HomePage homepage = new HomePage(driver);
        homepage.getRegister().click();
        registrationPage = new RegistrationPage(driver);

    }

    @AfterTest
    public void tearDown() {
       // driver.close();
        LOG.info("Browser is closed!!");
    }

    @Test
    public void shouldTestRegistrationPageTitle() {
        LOG.info("title :", registrationPage.getRegTitle().getText());
        Assert.assertEquals(registrationPage.getRegTitle().getText(), "Adviser registration");
    }

    @Test
    public void shouldTestErrorMessageWhenFsrIsEmpty() {

        registrationPage.getFsrNo().sendKeys(" ");
        registrationPage.getSubmit().click();
        Assert.assertEquals(registrationPage.getFsrEmptyErrorMessage().getText(), "FSR number field is mandatory. Please try again.");

    }

    @Test
    public void shouldTestErrorMessageWhenFsrIsInvalid() {

        registrationPage.getFsrNo().sendKeys("123789-FSR");
        registrationPage.getSubmit().click();
        Assert.assertEquals(registrationPage.getFsrRandomNumberErrorMessage().getText(), "We could not locate your firm. Please check that you have entered your FSR number correctly.");

    }

}



