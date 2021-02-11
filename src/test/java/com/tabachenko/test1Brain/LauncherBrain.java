package com.tabachenko.test1Brain;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LauncherBrain {

    @Test
    public void brain() {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        BrainAutomation brainAutomation = new BrainAutomation(driver);
        brainAutomation.openPage();
        brainAutomation.enterForPage();
        brainAutomation.logInBrain("+38 (067) 472-59-58", "50175425");
        brainAutomation.clickEnter();
        brainAutomation.menu();


      //  driver.quit();
    }
}
