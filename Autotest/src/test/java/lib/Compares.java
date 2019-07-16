package lib;

import org.testng.Assert;

public class Compares {

    public static void CompareTwoIntValue(int frstArg, int scndArg, String message){
        Assert.assertEquals(frstArg, scndArg, message);
    }

    public static void CompareFrstArgBiigerThenSecond(int frstArg, int scndArg, String message){
        Assert.assertTrue(frstArg > scndArg, message);
    }
}
