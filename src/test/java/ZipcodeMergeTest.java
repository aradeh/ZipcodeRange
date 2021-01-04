import org.junit.Test;
import java.util.*;
import junit.framework.TestCase;

import static org.junit.Assert.*;

public class ZipcodeMergeTest {

    @Test
    public void sortZipcodebyLower() {
        Zipcode zipcode1 = new Zipcode(41000,41005);
        Zipcode zipcode2 = new Zipcode(41002,41006);
        List<Zipcode> zipcodeList = new LinkedList <Zipcode>();
        zipcodeList.add(zipcode2);
        zipcodeList.add(zipcode1);
        ZipcodeMerge zipcodeMerge = new ZipcodeMerge();
        List<Zipcode> sortedList = zipcodeMerge.sortZipcodebyLower(zipcodeList);
        assertTrue(sortedList.get(0) == zipcode1);
    }

    @Test
    public void mergeZipcodes() {
        String inputData = "[94133,94133] [94200,94299] [94600,94699]";
        ZipcodeProcess zipcodeProcess = new ZipcodeProcess(inputData);
        List<Zipcode> zipcodeList = zipcodeProcess.splitZipcode();
        ZipcodeMerge  zipcodeMerge = new ZipcodeMerge();
        List<Zipcode> sortedZipCode = zipcodeMerge.sortZipcodebyLower(zipcodeList);
        List<Zipcode> mergedZipCode = zipcodeMerge.mergeZipcodes(sortedZipCode);
        assertTrue(mergedZipCode.size() > 0);
    }
}