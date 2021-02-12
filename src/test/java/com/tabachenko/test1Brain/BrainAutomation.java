package com.tabachenko.test1Brain;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BrainAutomation {
    private ChromeDriver driver;
    Person person;

    public BrainAutomation(ChromeDriver driver) {
        this.driver = driver;
    }

    void openPage() {
        driver.get("https://brain.com.ua/ukr/");
    }

    void enterForPage() {
        driver.findElementByXPath("//button[@class = \"auth-popup-button\"]").click();
    }

    void createUser(Person person) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//li[@class=\"active\"]/child::a").click();
        driver.findElementByXPath("//input[@id=\"modal-registration-firstname\"]").sendKeys(person.getName());
        driver.findElementByXPath("//input[@id=\"modal-registration-tel\"]").sendKeys(person.getPhonenumber());
        driver.findElementByXPath("//button[@class=\"br-login-submit\"]/parent::div[@class=\"text-center text-center-s\"]").click();
    }

    void logInBrain(String phone, String pass) {
        driver.findElementByXPath("//input[@class=\"input-field phone_mask\"]").sendKeys(phone);
        driver.findElementByXPath("//input[@class=\"input-field br-login-pass-field\"]").sendKeys(pass);
    }

    void clickEnter() {
        driver.findElementByXPath("(//div[@class=\"text-center\"]/child::button)[1]").click();
    }

    void menu() {

        WebElement webElementFirst = driver.findElementByXPath("(//span[@class=\"menu-outer-text\"])[1]");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        List<WebElement> webElementList = driver.findElements(By.xpath("//span[@class=\"menu-outer-text\"]"));
        /*for (WebElement element : webElementList) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class=\"menu-inner block-wrap\"]")));
            actions.moveToElement(element).build().perform();
        }*/
        webElementList.stream().forEach(x -> new Actions(driver).moveToElement(x).build().perform());
        boolean isPresent = driver.findElements(By.xpath("//div[@class=\"menu-inner-icon\"]")).size() > 0;
        System.out.println(isPresent);

    }
}