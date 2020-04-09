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

    /**
     * 測試物件的屬性
     */
    @Test
    fun addTestInResult(){
        val expected = 4
        val math = Math()
        math.add2Result(2,2)
        val addResult = math.result
        Assert.assertEquals(expected, addResult)
    }

    /**
     * 測試 Num1比Num2小
     */
    @Test
    fun testNum1LessNum2_minShouldBeNum1(){
        val expected = Math().minimum(1,3)
        val result = 1
        Assert.assertEquals(expected, result)
    }

    /**
     * 測試 Num2比Num1小
     * 使用 run with coverage 來檢查被測試類別Math是否都有被測試到
     */
    @Test
    fun testNum2LessNum1_minShouldBeNum2(){
        val expected = Math().minimum(3,1)
        val result = 1
        Assert.assertEquals(expected, result)
    }
}