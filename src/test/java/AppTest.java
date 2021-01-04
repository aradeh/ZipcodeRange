
import static org.junit.Assert.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


public class AppTest  extends  TestCase{

    public AppTest(String test){
        super(test);
    }

    public static Test suite(){
        TestSuite suite =  new TestSuite(AppTest.class);
        return suite;
    }

    public void testFinalResult(){
        String inputData = "[94133,94133] [94200,94299] [94600,94699]";
        ZipcodeProcess zipcodeProcess = new ZipcodeProcess(inputData);
        List<Zipcode> zipcodeList = zipcodeProcess.splitZipcode();
        ZipcodeMerge zipcodeMerge = new ZipcodeMerge();
        List<Zipcode> sortedList = zipcodeMerge.sortZipcodebyLower(zipcodeList);
        List<Zipcode> mergedList = zipcodeMerge.mergeZipcodes(sortedList);
        assertTrue(mergedList.size() == 3);
        String result = "";

        for(Zipcode zip: mergedList){
            result = result + "[" + zip.getLower_zip() +","+zip.getUpper_zip() +"]" + " ";
        }
        //System.out.println(result);
        String expected  = "[94133,94133] [94200,94299] [94600,94699]";
        //System.out.println(result.compareTo(expected));
        assertTrue(result.compareTo(expected) == 1);
    }

    public void testIllegalArgument(){
        try{
            String inputData = "[41002,41001] [42003,42004]";
            ZipcodeProcess zipcodeProcess = new ZipcodeProcess(inputData);
            List<Zipcode> zipcodeList = zipcodeProcess.splitZipcode();
        } catch (IllegalArgumentException e){
            assertEquals("IllegalArgumentException",e.getClass().getSimpleName());
        }
    }

    public void testMoreThanTwoRanges(){
        try{
            String inputData = "[41101,41123,41199] [42201,42299]";
            ZipcodeProcess zipcodeProcess = new ZipcodeProcess(inputData);
            List<Zipcode> zipcodeList = zipcodeProcess.splitZipcode();
        } catch (IllegalArgumentException e){
            assertEquals("IllegalArgumentException",e.getClass().getSimpleName());
        }
    }

}