package com.tabachenko.test2Brain;


import com.tabachenko.test1Brain.Person;
import lombok.val;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BrainAutoTest2 {


    private ChromeDriver driver;

    @val
    static Logger logger = Logger.getGlobal();


    public BrainAutoTest2(ChromeDriver driver) {
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
        new Actions(driver).pause(3000).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElementByXPath("//button[@class = \"auth-popup-button\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class=\"hello-title\"])[1]")));
        logger.info("Вводим логін");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"modal-login-phone-field\"]"))).sendKeys(phone);
        logger.info("Вводим пароль");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"input-field br-login-pass-field\"]"))).sendKeys(pass);
    }

    void clickEnter() { //клік в особистий кабінет
        logger.info("Заходим в особистий кабінет");
        driver.findElementByXPath("(//div[@class=\"text-center\"]/child::button)[1]").click();
    }

    void menu(String item) { //головне меню
        logger.info("Перебираєм меню");
        new Actions(driver).pause(2000).build().perform();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::ul[@ class=\"menu-outer block-wrap\"]")));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"main-menu-button-wrap" +
                "                                      with-disabled                                  disabled\"]"))).click();
        new Actions(driver).pause(1000).build().perform();
        List<WebElement> webElementList = driver.findElements(By.xpath("//span[@class=\"menu-outer-text\"]"));
        logger.info("Пунк меню: " + item);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class=\"menu-inner block-wrap\"]")));
        for (WebElement element : webElementList) {
            if (element.getText().contains(item)) {
                element.click();
                break;
            }
            logger.info("метод основної менюшки закінчив роботу");
        }
        // webElementList.stream().forEach(x -> new Actions(driver).moveToElement(x).build().perform());
    }

    void menuAccessories(String item) { // доп - менюшка
        logger.info("метод ДОП.МЕНЮШКИ почав роботу");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"br-category-block-left\"]")));
        new Actions(driver).pause(1000).build().perform();

        // WebElement webElement = driver.findElementByXPath("//h2[@class=\"category-sub-title\" and text()=\"" + item + "\"]");
        logger.info("Пошук елемента в доп меню");
        List<WebElement> webElementList = driver.findElements(By.xpath("//h2[@class=\"category-sub-title\"]"));
        for (WebElement webElement : webElementList) {
            if (webElement.getText().contains(item.toUpperCase())) {
                webElement.click();
                break;
            }
        }
        logger.info("Знайшло елемент на сторінці");
    }

    void sortByMaxPrice() { // сортування по ціні
        logger.info("Сортування : від дорожчого до дешевшого ");
        new Actions(driver).moveToElement(new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Сортування за ціною\"]")))).build().perform();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//li/child::a/child::button)[3]"))).click();
        new Actions(driver).pause(2000).build().perform();
    }

    void minPrice() {
        logger.info("Встановлення мінімальної ціни");
        new WebDriverWait(driver, 30).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 100%;'])[1]")));
        new WebDriverWait(driver, 30).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 0%;'])[1]")));

        WebElement element = driver.findElementByXPath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 0%;'])[1]");
        WebElement target = driver.findElementByXPath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 100%;'])[1]");
        new Actions(driver).clickAndHold(target).dragAndDrop(target, element).release().perform();
        logger.info("Вибираєм елемент з найменшою ціною");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//a[@class=\"btn price_filter btn-sumbit\"])[1]"))).click();
        logger.info("Елемент з найменшою ціною - знайдений!");
    }

    ComponentComp receivingElement() {
        new Actions(driver).pause(2000).build().perform();

        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"br-pp-img br-pp-img-grid\"]")));
        logger.info("Клік на елемент");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"br-pp-img br-pp-img-grid\"]/child::a"))).click();
        String elementInfo = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::h1[@id=\"br-pr-1\"]"))).getText();
        logger.info("Витягуєм інфо про елемент");
        double pricecomponen = Double.parseDouble(new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div/span[@itemprop=\"price\"])[1]"))).getText());
        logger.info("Витягуєм price елементa");

        return new ComponentComp(elementInfo, pricecomponen);
    }

    ComponentComp assembleComputer(String accessories, String item) {
        logger.info("Пошук " + item);
        BrainAutoTest2 brainAutoTest2 = new BrainAutoTest2(driver);
        brainAutoTest2.menu(accessories);
        brainAutoTest2.menuAccessories(item);
        brainAutoTest2.minPrice();
        ComponentComp element = brainAutoTest2.receivingElement();
        brainAutoTest2.updatePage();
        return element;
    }


    ComponentComp searchDopComponents(String accessories, String menu, String item) {
        BrainAutoTest2 brainAutoTest2 = new BrainAutoTest2(driver);
        brainAutoTest2.menu(accessories);
        brainAutoTest2.menuAccessories(accessories);
        brainAutoTest2.menuAccessories(menu);
        brainAutoTest2.menuAccessories(item);
        brainAutoTest2.minPrice();
        ComponentComp componentComp = brainAutoTest2.receivingElement();
        brainAutoTest2.updatePage();
        return componentComp;
    }

    double priceAllComponentsofComputer(Computer computer) {
        double sum = computer.getCorps().getPrice()+computer.getHarddrive()
                .getPrice()+computer.getKeyboards().getPrice()+computer.getMonik()
                .getPrice()+computer.getMotherboard().getPrice()+computer.getMouse()
                .getPrice()+computer.getNetworkcard().getPrice()+computer.getPowerSupply()
                .getPrice()+computer.getProcessor().getPrice()+computer.getRam().getPrice()+computer.getSoundcard().getPrice()+computer.getVideocard().getPrice();

        return sum;
    }

    void updatePage() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"svg-logo-gray\"]"))).click();
    }

}

