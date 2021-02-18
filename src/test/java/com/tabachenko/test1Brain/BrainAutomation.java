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
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BrainAutomation {
    private ChromeDriver driver;
    private final static Logger logger = Logger.getGlobal();

    public BrainAutomation(ChromeDriver driver) {

        this.driver = driver;
    }

    void openPage() {
        logger.info("Відкриття сторінки");
        driver.get("https://brain.com.ua/ukr/");
    }

    void createUser(Person person) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//li[@class=\"active\"]/child::a").click();
        driver.findElementByXPath("//input[@id=\"modal-registration-firstname\"]").sendKeys(person.getName());
        driver.findElementByXPath("//input[@id=\"modal-registration-tel\"]").sendKeys(person.getPhonenumber());
        driver.findElementByXPath("//button[@class=\"br-login-submit\"]/parent::div[@class=\"text-center text-center-s\"]").click();
    }

    void logInBrain(String phone, String pass) {
        logger.info("Логінимся");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElementByXPath("//button[@class = \"auth-popup-button\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class=\"hello-title\"])[1]")));
        logger.info("Вводим логін");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"modal-login-phone-field\"]"))).sendKeys(phone);
        logger.info("Вводим пароль");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"input-field br-login-pass-field\"]"))).sendKeys(pass);
    }

    void clickEnter() {
        logger.info("Заходим в особистий кабінет");
        driver.findElementByXPath("(//div[@class=\"text-center\"]/child::button)[1]").click();
    }

    void menu(String item) {
        logger.info("Перебираєм меню");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::ul[@ class=\"menu-outer block-wrap\"]")));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"main-menu-button-wrap" +
                "                                      with-disabled                                  disabled\"]"))).click();
        List<WebElement> webElementList = driver.findElements(By.xpath("//span[@class=\"menu-outer-text\"]"));
        for (WebElement element : webElementList) {
            // System.out.println(element.getText());
            new Actions(driver).moveToElement(element).build().perform();
            new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class=\"menu-inner block-wrap\"]")));
            if (element.equals(driver.findElementByXPath("(//span[@class=\"menu-outer-text\"])[1]"))) {
                logger.info("Перевірка наявності елемента на сторінці");
                new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://brain.com.ua/ukr/category/Noutbuky-c1191/\"]")));
            }
        }
        // webElementList.stream().forEach(x -> new Actions(driver).moveToElement(x).build().perform());
    }

    void menuAccessories() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::ul[@ class=\"menu-outer block-wrap\"]")));
        logger.info("Пунк меню: комплектуючі");
        WebElement accessories = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"https://brain.com.ua/ukr/Komplektuyuchi_do_PK-c204/\"]")));
        new Actions(driver).moveToElement(accessories).build().perform();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://brain.com.ua/ukr/category/Procesory-c1097-128/\"]"))).click();
    }

    void sortByPrice() {
        logger.info("Сортування : від дорожчого до дешевшого ");
        new Actions(driver).moveToElement(new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Сортування за ціною\"]")))).build().perform();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//li/child::a/child::button)[3]"))).click();
        new Actions(driver).pause(2000).build().perform();
    }

    void maxPrice() {

        new WebDriverWait(driver, 15).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 0%;'])[1]")));
        new WebDriverWait(driver, 15).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 100%;'])[1]")));

        WebElement element = driver.findElementByXPath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 0%;'])[1]");
        WebElement target = driver.findElementByXPath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 100%;'])[1]");
        logger.info("Вказуєм найбільшу ціну");
        new Actions(driver).clickAndHold(element).dragAndDrop(element, target).release().perform();
        logger.info("Вибираєм елемент з найбільшою ціною");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//a[@data-linktpl=\"/ukr/category/Procesory-c1097-128/max_price=max_price;min_price=min_price;order=desc;sortby=price/\" " +
                        "and @class=\"btn price_filter btn-sumbit\"])[1]"))).click();
    }

    void receivingElement() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"br-pp-img br-pp-img-grid\"]")));
        //  WebElement element = driver.findElementByXPath("//div[@class=\"br-pp-img br-pp-img-grid\"]");
        logger.info("Інформація про елемент");
        WebElement elementInfo = driver.findElementByXPath("(//a[@href=\"/ukr/Procesor_AMD_Ryzen_Threadripper_3990X_100-100000163WOF-p654465.html\"])[3]");
        WebElement elementPrice = driver.findElementByXPath("(//span[@itemprop=\"price\"])[2]");
        System.out.println(elementInfo.getText());
        System.out.println(elementPrice.getText() + " грн.");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"br-pp-img br-pp-img-grid\"]"))).click();

    }
}