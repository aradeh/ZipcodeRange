
/*
* Application driver class
*
* */


import java.util.*;


public class App {
    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        String zipCodeRanges = scan.nextLine();
        //System.out.println(zipCodeRanges);

        ZipcodeProcess zipcodeProcess = new ZipcodeProcess(zipCodeRanges);
        //System.out.println(zipCodeRanges.toString());

        List<Zipcode> zipcodeList = zipcodeProcess.splitZipcode();
        ZipcodeMerge zipcodeMerge = new ZipcodeMerge();

        List<Zipcode> sortedZipcode = zipcodeMerge.sortZipcodebyLower(zipcodeList);
        List<Zipcode> mergedZipcode = zipcodeMerge.mergeZipcodes(sortedZipcode);

        for(Zipcode zip: mergedZipcode){
            System.out.println("[" + zip.getLower_zip() + "," + zip.getUpper_zip() + "]");
        }


    }
}
