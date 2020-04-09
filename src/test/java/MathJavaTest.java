import org.junit.Assert;
import org.junit.Test;

public class MathJavaTest {

    @Test
    public void addTest(){
        int expected = 5;
        MathJava mathJava = new MathJava();
        int addResult = mathJava.add(2, 3);
        Assert.assertEquals(expected, addResult);
    }
}
