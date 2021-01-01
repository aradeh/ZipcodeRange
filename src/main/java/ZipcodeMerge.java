
import java.util.*;

public class ZipcodeMerge {

    public List<Zipcode> sortZipcodebyLower(List<Zipcode> zipcodeList){
        Collections.sort(zipcodeList, new ZipcodeSort());
        return zipcodeList;
    }

    public List<Zipcode> mergeZipcodes(List<Zipcode> sortedZipcodeList){
        List<Zipcode> finalZipcodes = new LinkedList <Zipcode>();
        Zipcode zipcode = null;
        for(Zipcode zipcode1 : sortedZipcodeList){
            if(zipcode == null)
                zipcode = zipcode1;
            else {
                if(zipcode.getUpper_zip() >= zipcode1.getLower_zip()){
                    zipcode.setUpper_zip(Math.max(zipcode.getUpper_zip(),zipcode1.getUpper_zip()));
                } else {
                    finalZipcodes.add(zipcode);
                    zipcode = zipcode1;
                }
            }
        }

        finalZipcodes.add(zipcode);
        return finalZipcodes;
    }
}
