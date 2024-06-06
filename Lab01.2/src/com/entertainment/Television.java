package com.entertainment;

import java.util.Objects;

/*
 *  NOTE: to be "consistent with equals" you must use the same sort key(s)
 *  as you're using in your equals() method - for us, that's (brand, volume)
 *  Natural order is thus defined by brand(String), then by volume (int)
 *  when tied on brand
 */
public class Television implements Comparable<Television> {
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
        boolean result = false;

        //  'this'(me) and 'obj' refer to the same physical object in memory
        if(this == obj) {
            result = true; //   and we're done, return result(true)
        }
        //  'obj' is not-null and my Class object is the same as its Class object, proceed
        //  otherwise, skip this while thing and return result (false)
        else if(obj != null && (this.getClass() == obj.getClass())) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   //  null-safe
                    this.getVolume() == other.getVolume();  //  primitives can't be null
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: brand = %s, volume = %s, currentChannel = %s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}