
import java.util.*;

public class ZipcodeProcess {
    private String zipCodeRanges;

    public ZipcodeProcess(String zipCodeRanges) {
        this.zipCodeRanges = zipCodeRanges;
    }

    public List<Zipcode> splitZipcode(){
        String[] zipcodes = zipCodeRanges.split(" ");
        return loadZipcode(zipcodes);
    }

    public int stringToInt(String zipcode){
        return Integer.parseInt(zipcode);
    }

    public boolean checkZipcodeLength(int zipcode){
        if((int) (Math.log10(zipcode) + 1) != 5)
            return false;
        return true;
    }

    public boolean comapreZipcode(int lowerzipcode, int upperzipcode){
        if(lowerzipcode > upperzipcode)
            return false;
        return true;
    }

    public boolean validateZipcode(int lowerzipcode, int upperzipcode){
        if(!checkZipcodeLength(lowerzipcode) && !checkZipcodeLength(upperzipcode))
            throw new IllegalArgumentException(lowerzipcode + " " + upperzipcode + ": "+ "Zipcode must have 5 digits");
        if(comapreZipcode(lowerzipcode,upperzipcode) == false)
            throw new IllegalArgumentException(lowerzipcode + " " + upperzipcode + ": "+ "lowerZipcode must be less than upperZipcode");
        return true;
    }

    public Zipcode validateAndAdd(String[] zipRange) {
        if (zipRange.length != 2)
            throw new IllegalArgumentException(zipRange[0] + "Zipcode should have lower and upper bounds");
        int lowerBound = stringToInt(zipRange[0]);
        int upperBound = stringToInt(zipRange[1]);
        Zipcode zipcode = null;
        if (validateZipcode(lowerBound, upperBound) == true)
            zipcode = new Zipcode(lowerBound, upperBound);
        return zipcode;
    }

    public Zipcode getZipcodeRange(String zipcodeRange) {
        return validateAndAdd(zipcodeRange.replaceAll("\\[|\\]", "").split(","));
    }

    public List<Zipcode> loadZipcode(String[] zipcodeRange) {
        List<Zipcode> zipcodesList = new LinkedList<Zipcode>();
        for (int i = 0; i < zipcodeRange.length; i++) {
            zipcodesList.add(getZipcodeRange(zipcodeRange[i]));
        }
        return zipcodesList;
    }
}
