package com.google.step_definitions;

import com.google.pages.BasePage;
import com.google.utilities.BrowserUtils;
import com.google.utilities.ConfigurationReader;
import com.google.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Calculator_StepDef {

    BasePage basePage = new BasePage();


    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));


    }
    @When("I search for {string}")
    public void i_search_for(String string) {
        basePage.searchInput.sendKeys(string + Keys.ENTER);

    }
    @When("the calculator should be visible")
    public void the_calculator_should_be_visible() {
      Assert.assertTrue(basePage.calculator.isDisplayed());

    }


    @When("I enter {int}")
    public void i_enter(Integer number)  {
        String numberStr = number.toString();
       for (char digit : numberStr.toCharArray()){
           int digitValue = Character.getNumericValue(digit);
            basePage.navigateDigitButton(digitValue);

        }

    }


    @When("I press {string}")
    public void i_press(String operator) {
        basePage.navigateOperatorButton(operator);
    }





    @Then("the result should be {int}")
    public void the_result_should_be(int expectedNumber) {
       String actualResult = basePage.actualResult.getText();
       String expectedResult = String.valueOf(expectedNumber);
       Assert.assertEquals(expectedResult,actualResult);


    }

    @Then("the display should be cleared")
    public void the_display_should_be_cleared() {
        String beforeClickingCEButton = basePage.actualResult.getText();
        String afterClickingCEButton = basePage.actualResult.getText();
        Assert.assertTrue(afterClickingCEButton.length() <= beforeClickingCEButton.length());


    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
        String actualResult =basePage.actualResult.getText();
        Assert.assertEquals(expectedResult,actualResult);

    }
}
