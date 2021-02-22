package com.tabachenko.test2Brain;

import lombok.extern.java.Log;
import org.openqa.selenium.WebElement;
@Log

public class Computer {
    private ComponentComp videocard;
    private ComponentComp processor;
    private ComponentComp motherboard;
    private ComponentComp ram;
    private ComponentComp harddrive;
    private ComponentComp corps;
    private ComponentComp powerSupply;
    private ComponentComp soundcard;
    private ComponentComp networkcard;
    private ComponentComp monik;
    private ComponentComp mouse;
    private ComponentComp keyboards;
    private ComponentComp audioSpeakers;

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
                ", networkcard=" + networkcard +
                ", monik=" + monik +
                ", mouse=" + mouse +
                ", keyboards=" + keyboards +
                ", audioSpeakers=" + audioSpeakers +
                '}';
    }

    public ComponentComp getVideocard() {
        return videocard;
    }

    public void setVideocard(ComponentComp videocard) {
        this.videocard = videocard;
    }

    public ComponentComp getProcessor() {
        return processor;
    }

    public void setProcessor(ComponentComp processor) {
        this.processor = processor;
    }

    public ComponentComp getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(ComponentComp motherboard) {
        this.motherboard = motherboard;
    }

    public ComponentComp getRam() {
        return ram;
    }

    public void setRam(ComponentComp ram) {
        this.ram = ram;
    }

    public ComponentComp getHarddrive() {
        return harddrive;
    }

    public void setHarddrive(ComponentComp harddrive) {
        this.harddrive = harddrive;
    }

    public ComponentComp getCorps() {
        return corps;
    }

    public void setCorps(ComponentComp corps) {
        this.corps = corps;
    }

    public ComponentComp getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(ComponentComp powerSupply) {
        this.powerSupply = powerSupply;
    }

    public ComponentComp getSoundcard() {
        return soundcard;
    }

    public void setSoundcard(ComponentComp soundcard) {
        this.soundcard = soundcard;
    }

    public ComponentComp getNetworkcard() {
        return networkcard;
    }

    public void setNetworkcard(ComponentComp networkcard) {
        this.networkcard = networkcard;
    }

    public ComponentComp getMonik() {
        return monik;
    }

    public void setMonik(ComponentComp monik) {
        this.monik = monik;
    }

    public ComponentComp getMouse() {
        return mouse;
    }

    public void setMouse(ComponentComp mouse) {
        this.mouse = mouse;
    }

    public ComponentComp getKeyboards() {
        return keyboards;
    }

    public void setKeyboards(ComponentComp keyboards) {
        this.keyboards = keyboards;
    }

    public ComponentComp getAudioSpeakers() {
        return audioSpeakers;
    }

    public void setAudioSpeakers(ComponentComp audioSpeakers) {
        this.audioSpeakers = audioSpeakers;
    }

    public Computer(ComponentComp videocard, ComponentComp processor, ComponentComp motherboard, ComponentComp ram, ComponentComp harddrive, ComponentComp corps, ComponentComp powerSupply, ComponentComp soundcard, ComponentComp networkcard, ComponentComp monik, ComponentComp mouse, ComponentComp keyboards, ComponentComp audioSpeakers) {
        this.videocard = videocard;
        this.processor = processor;
        this.motherboard = motherboard;
        this.ram = ram;
        this.harddrive = harddrive;
        this.corps = corps;
        this.powerSupply = powerSupply;
        this.soundcard = soundcard;
        this.networkcard = networkcard;
        this.monik = monik;
        this.mouse = mouse;
        this.keyboards = keyboards;
        this.audioSpeakers = audioSpeakers;
    }
}

