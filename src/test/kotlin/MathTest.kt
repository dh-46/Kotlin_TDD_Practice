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
        // 作者表示:
        // 最好的撰寫方法，是先寫一個必定會失敗的測試，
        // 來驗證測試程式碼有無錯誤，避免被測試的程式怎麼寫，測試結果都是Passed。
    }
}