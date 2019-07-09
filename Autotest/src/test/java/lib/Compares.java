package lib;

import org.testng.Assert;

public class Compares {

    public static void CompareTwoIntValue(int a, int b, String msg){
        Assert.assertEquals(a, b, msg);
    }
}
