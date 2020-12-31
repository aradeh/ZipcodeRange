/*
* to store zip code data
* */

public class Zipcode {
    private int lower_zip;
    private int upper_zip;

    public Zipcode(int lower_zip, int upper_zip){
        this.lower_zip = lower_zip;
        this.upper_zip = upper_zip;
    }

    public int getLower_zip() {
        return lower_zip;
    }

    public void setLower_zip(int lower_zip) {
        this.lower_zip = lower_zip;
    }

    public int getUpper_zip() {
        return upper_zip;
    }

    public void setUpper_zip(int upper_zip) {
        this.upper_zip = upper_zip;
    }
}
