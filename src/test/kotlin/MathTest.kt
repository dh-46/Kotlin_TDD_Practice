import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * JUnit 測試框架介紹
 * 1. 用在Java的單元測試框架，但是Kotlin也能用
 *
 * JUnit Annotation 介紹
 * 1. @Test: 用來表示這個方法為測試方法
 * 2. @Before: 表示這個方法需在每個測試執行前執行
 * 3. @After: 表示這個方法需在每個測試執行後執行
 * 4. @BeforeClass: 在這個類別開始執行第一個測試之前
 * 5. @AfterClass: 在這個類別全部測試完成之後
 * 6. @Ignore: 忽略此測試方法
 *
 * Assert 常用種類介紹
 * 1. Assert.assertEquals: 判斷兩物件是否相等
 * 2. Assert.assertNotEquals: 判斷兩物件是否不相等
 * 3. Assert.assertNull: 判斷物件是否為Null
 * 4. Assert.assertNotNull: 判斷物件是否不為Null
 * 5. Assert.assertArrayEquals: 驗證陣列是否相同
 * 6. Assert.assertTrue: 驗證是否為真
 *
 * Assert 注意:
 * 1. 比對物件相等時請用assertEquals
 * 2. 不要使用反向的寫法: Assert.assertTrue(!condition)
 *
 */
class MathTest {

    lateinit var math: Math

    /**
     * 每次測試前都執行
     * 所以把math物件提高為類別層級，
     * 並透過setup()在每次執行測試前初始化。(重構!!)
     *
     * P.s. 由於是每次測試前都執行，
     * 所以跟在類別建構式中初始化是不太一樣的哦。
     *
     * 注意:
     * 1. 避免在Before初始化只有特定測試會用到的物件。
     * 2. 避免在Before方法中撰寫太複雜的程式碼，會造成往後除錯不易。
     * 3. 可考慮使用工廠方法進行初始化。
     */
    @Before
    fun setup(){
        math = Math()
    }

    /**
     * 驗證Math物件的add方法是否正常
     */
    @Test
    fun addTest(){
        val expected = 3 // 預期結果
        // val actualNumber = Math().add(1,2) // 呼叫被測試的方法

        val actualNumber = math.add(1,2)

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
        // val math = Math()
        math.add2Result(2,2)
        val addResult = math.result
        Assert.assertEquals(expected, addResult)
    }

    /**
     * 測試 Num1比Num2小
     */
    @Test
    fun testNum1LessNum2_minShouldBeNum1(){
        // val expected = Math().minimum(1,3)
        val expected = math.minimum(1,3)
        val result = 1
        Assert.assertEquals(expected, result)
    }

    /**
     * 測試 Num2比Num1小
     * 使用 run with coverage 來檢查被測試類別Math是否都有被測試到
     */
    @Test
    fun testNum2LessNum1_minShouldBeNum2(){
        // val expected = Math().minimum(3,1)
        val expected = math.minimum(3,1)
        val result = 1
        Assert.assertEquals(expected, result)
    }
}