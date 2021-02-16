package com.tabachenko.test1Brain;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BrainAutomation {
    private ChromeDriver driver;
    private List<WebElement> webElementList = null;

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
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class=\"hello-title\"])[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"modal-login-phone-field\"]"))).sendKeys(phone);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class=\"input-field br-login-pass-field\"]"))).sendKeys(pass);
    }

    void clickEnter() {
        driver.findElementByXPath("(//div[@class=\"text-center\"]/child::button)[1]").click();
    }


    void menu(String item) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::ul[@ class=\"menu-outer block-wrap\"]")));
        List<WebElement> webElementList = driver.findElements(By.xpath("//span[@class=\"menu-outer-text\"]"));
        for (WebElement element : webElementList) {
            System.out.println(element.getText());
            new Actions(driver).moveToElement(element).build().perform();
            new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class=\"menu-inner block-wrap\"]")));
            if (element.equals(driver.findElementByXPath("(//span[@class=\"menu-outer-text\"])[1]"))) {
                new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://brain.com.ua/ukr/category/Noutbuky-c1191/\"]")));
            }
        }
        // webElementList.stream().forEach(x -> new Actions(driver).moveToElement(x).build().perform());
    }

    void menuAccessories() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::ul[@ class=\"menu-outer block-wrap\"]")));
        WebElement accessories = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"https://brain.com.ua/ukr/Komplektuyuchi_do_PK-c204/\"]")));
        new Actions(driver).moveToElement(accessories).build().perform();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://brain.com.ua/ukr/category/Procesory-c1097-128/\"]"))).click();
    }

    WebElement bulkhead(String item) {
        WebElement webElement = null;
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::ul[@ class=\"menu-outer block-wrap\"]")));
        webElementList = driver.findElements(By.xpath("//span[@class=\"menu-outer-text\"]"));
        for (WebElement element : webElementList) {
            System.out.println(element.getText());
            new Actions(driver).moveToElement(element).build().perform();
            new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class=\"menu-inner block-wrap\"]")));
          if (element.getText().equals(item)){
              webElement=element;
          }
        }return webElement;
    }

    void itemSelection(String item) {
        new BrainAutomation(driver).bulkhead(item).click();

    }
}