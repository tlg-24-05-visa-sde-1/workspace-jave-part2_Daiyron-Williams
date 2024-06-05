package com.entertainment;

import java.util.Objects;

public class Television {
    //  fields or instance variables
    private String brand;
    private int volume;

    //  Television HAS-A Tuner (for all things related to channel changing
    private final Tuner tuner = new Tuner();  //  instantiated internally, NOT exposed

    //  constructor methods

    public Television() {
        super(); //  no-op
    }

    public Television(String brand, int volume) {
        super();
        setBrand(brand);
        setVolume(volume);
    }

    //  business or "action" methods
    public int getCurrentChannel() {
        return tuner.getChannel();      //  delegate to contained Tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);      //  delegate to contained Tuner object
    }

    //  accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Television other = (Television) obj;
        return this.getVolume() == other.getVolume() &&
                Objects.equals(this.getBrand(), other.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }


    @Override
    public String toString() {
        return String.format("%s: brand = %s, volume = %s, currentChannel = %s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}