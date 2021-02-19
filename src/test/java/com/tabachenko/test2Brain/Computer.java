package com.tabachenko.test2Brain;

import org.openqa.selenium.WebElement;

public class Computer {
    private WebElement videocard;
    private WebElement processor;
    private WebElement motherboard;
    private WebElement ram;
    private WebElement harddrive;
    private WebElement corps;
    private WebElement powerSupply;
    private WebElement soundcard;

    @Override
    public String toString() {
        return "Computer{" +
                "videocard=" + videocard +
                ", processor=" + processor +
                ", motherboard=" + motherboard +
                ", ram=" + ram +
                ", harddrive=" + harddrive +
                ", corps=" + corps +
                ", powerSupply=" + powerSupply +
                ", soundcard=" + soundcard +
                '}';
    }

    public WebElement getVideocard() {
        return videocard;
    }

    public WebElement getProcessor() {
        return processor;
    }

    public WebElement getMotherboard() {
        return motherboard;
    }

    public WebElement getRam() {
        return ram;
    }

    public WebElement getHarddrive() {
        return harddrive;
    }

    public WebElement getCorps() {
        return corps;
    }

    public WebElement getPowerSupply() {
        return powerSupply;
    }

    public WebElement getSoundcard() {
        return soundcard;
    }

    public Computer(WebElement videocard, WebElement processor, WebElement motherboard, WebElement ram, WebElement harddrive, WebElement corps, WebElement powerSupply, WebElement soundcard) {
        this.videocard = videocard;
        this.processor = processor;
        this.motherboard = motherboard;
        this.ram = ram;
        this.harddrive = harddrive;
        this.corps = corps;
        this.powerSupply = powerSupply;
        this.soundcard = soundcard;
    }
}
