package com.investmentcenter.automate.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;
    private final By charges = By.xpath("//a[@href='/platform/charges' and @class='button waves-effect' and text()='FIND OUT MORE']");
    private final By register = By.xpath("//ul[@class='menu'] //a[@href='/AdviserRegistration/EnterFSRNumber' and @class='user-register' and text()='Register']");


    public HomePage(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCharges() {
        return driver.findElement(charges);
    }

    public WebElement getRegister() {
        return driver.findElement(register);

    }
}
