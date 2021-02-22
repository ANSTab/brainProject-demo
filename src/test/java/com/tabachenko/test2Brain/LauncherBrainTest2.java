package com.tabachenko.test2Brain;

import com.tabachenko.test1Brain.BrainAutomation;
import lombok.val;
import org.junit.Before;
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

        ComponentComp video = brainAutomation.assembleComputer("Комплектуючі", "ВІДЕОКАРТИ");
        ComponentComp proc = brainAutomation.assembleComputer("Комплектуючі", "ПРОЦЕСОРИ");
        ComponentComp mamka = brainAutomation.assembleComputer("Комплектуючі", "МАТЕРИНСЬКІ ПЛАТИ");
        ComponentComp ram = brainAutomation.assembleComputer("Комплектуючі", "МОДУЛІ ПАМ'ЯТІ ДЛЯ ПК");
        ComponentComp vinch = brainAutomation.assembleComputer("Комплектуючі", "ЖОРСТКІ ДИСКИ");
        ComponentComp corpus = brainAutomation.assembleComputer("Комплектуючі", "КОРПУСИ ДЛЯ ПК");
        ComponentComp blok = brainAutomation.assembleComputer("Комплектуючі", "БЛОКИ ЖИВЛЕННЯ");
        ComponentComp voice = brainAutomation.assembleComputer("Комплектуючі", "ЗВУКОВІ ПЛАТИ");
        ComponentComp networkcard = brainAutomation.searchDopComponents("Комплектуючі", "СЕРВЕРНІ КОМПЛЕКТУЮЧІ", "КОНТРОЛЕРИ");
        ComponentComp monik = brainAutomation.searchDopComponents("Ноутбуки і комп'ютери", "МОНІТОРИ ТА АКСЕСУАРИ", "МОНІТОРИ");
        ComponentComp mouse = brainAutomation.searchDopComponents("Ноутбуки і комп'ютери", "МАНІПУЛЯТОРИ", "МИШКИ");
        ComponentComp keyboards = brainAutomation.searchDopComponents("Ноутбуки і комп'ютери", "МАНІПУЛЯТОРИ", "КЛАВІАТУРИ");
        ComponentComp audioSpeakers = brainAutomation.assembleComputer("Навушники та акустика", "АКУСТИЧНІ СИСТЕМИ");

        Computer computer = new Computer(video, proc, mamka, ram, vinch, corpus, blok, voice, networkcard, monik, mouse, keyboards, audioSpeakers);

        System.out.println(brainAutomation.priceAllComponentsofComputer(computer) + " грн.");

        driver.quit();


    }
}
