package com.google.pages;

import com.google.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#APjFqb")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='tyYmIf']")
    public WebElement calculator;


    public void navigateDigitButton(int number) {
        String locator = "//div[.='"+ number +"']";
        Driver.getDriver().findElement(By.xpath(locator)).click();

    }


    public void navigateOperatorButton(String operator) {
        String locator = "//div[.='"+operator+"']";

        WebElement operatorButton =  Driver.getDriver().findElement(By.xpath(locator));

        BrowserUtils.waitForClickablility(operatorButton,20);
        operatorButton.click();


}


    @FindBy(id= "cwos")
    public WebElement actualResult;



    }

