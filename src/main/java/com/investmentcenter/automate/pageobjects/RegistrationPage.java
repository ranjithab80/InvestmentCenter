package com.investmentcenter.automate.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    private WebDriver driver;
    private By regTitle = By.xpath("//form[@class='form-horizontal']//h1[text()='Adviser registration']");
    private By fsrNo = By.id("FSRNumber_TextBox");
    private By submit = By.name("AdviserRegsitration_Login");
    private By fsrEmptyErrorMsg = By.cssSelector("span[class='field-validation-error']");
    private By fsrRandomNoErrorMsg = By.cssSelector("span[class='field-validation-error']");
    //webelements

    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getRegTitle() {
        return (driver.findElement(regTitle));
    }

    public WebElement getFsrNo() {
        return (driver.findElement(fsrNo));
    }

    public WebElement getSubmit() {
        return (driver.findElement(submit));
    }

    public WebElement getFsrEmptyErrorMessage() {
        return (driver.findElement(fsrEmptyErrorMsg));
    }

    public WebElement getFsrRandomNumberErrorMessage() {
        return (driver.findElement(fsrRandomNoErrorMsg));
    }
}