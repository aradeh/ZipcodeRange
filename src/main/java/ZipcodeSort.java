/*
* Sort zip code ranges
* */


import java.util.Comparator;

public class ZipcodeSort implements Comparator<Zipcode>{
    public int compare(Zipcode i1, Zipcode i2){
        if(i1.getLower_zip() > i2.getLower_zip())
            return 1;
        else
            return -1;
    }
}
