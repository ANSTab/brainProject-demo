package com.tabachenko.test2Brain;

import com.tabachenko.test1Brain.BrainAutomation;
import lombok.val;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LauncherBrainTest2 {
    @Test
    public void brain() {

        @val Logger logger = Logger.getGlobal();

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        BrainAutoTest2 brainAutomation = new BrainAutoTest2(driver);
        brainAutomation.openPage();
        brainAutomation.logInBrain("+38 (067) 472-59-58", "50175425");
        brainAutomation.clickEnter();

        String accessories = "Комплектуючі";

        WebElement video = brainAutomation.assembleComputer(accessories, "ВІДЕОКАРТИ");
        System.out.println(video.getTagName());
        brainAutomation.updatePage();
        WebElement proc = brainAutomation.assembleComputer(accessories, "ПРОЦЕСОРИ");
        brainAutomation.updatePage();
        WebElement mamka = brainAutomation.assembleComputer(accessories, "МАТЕРИНСЬКІ ПЛАТИ");
        brainAutomation.updatePage();
        WebElement ram = brainAutomation.assembleComputer(accessories, "МОДУЛІ ПАМ'ЯТІ ДЛЯ ПК");
        brainAutomation.updatePage();
        WebElement vinch = brainAutomation.assembleComputer(accessories, "ЖОРСТКІ ДИСКИ");
        brainAutomation.updatePage();
        WebElement corpus = brainAutomation.assembleComputer(accessories, "КОРПУСИ ДЛЯ ПК");
        brainAutomation.updatePage();
        WebElement blok = brainAutomation.assembleComputer(accessories, "БЛОКИ ЖИВЛЕННЯ");
        brainAutomation.updatePage();
        WebElement voice = brainAutomation.assembleComputer(accessories, "ЗВУКОВІ ПЛАТИ");


        Computer computer = new Computer(video,proc,mamka,ram,vinch,corpus,blok,voice);

        System.out.println(computer.getCorps());
        System.out.println(computer.getHarddrive().getText());
        System.out.println(computer.getMotherboard().getText());
        System.out.println(computer.getPowerSupply().getText());
        System.out.println(computer.getRam().getText());
        System.out.println(computer.getVideocard().getText());
        System.out.println(computer.getProcessor().getText());
        System.out.println(computer.getSoundcard().getText());
        driver.quit();

    }
}
