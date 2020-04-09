import org.junit.Assert
import org.junit.Test

class MathTest {

    /**
     * 驗證Math物件的add方法是否正常
     */
    @Test
    fun addTest(){
        val expected = 3 // 預期結果
        val actualNumber = Math().add(1,2) // 呼叫被測試的方法
        Assert.assertEquals(expected, actualNumber) // 驗證預期與結果
    }
}