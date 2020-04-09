package mock_sample_test

import mock_sample.IEmailUtil
import mock_sample.Order
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * 驗證測試通常有三種方式
 * 1. 驗證回傳值
 * 2. 驗證物件狀態的改變
 * 3. 驗證目標與相依物件/介面的互動
 *
 * 1 與 2 通常遇到外部相依，會使用Stub輔助驗證回傳值或是物件狀態的改變。
 * 3 則會使用Mock。
 * 請盡量將互動測試作為最後的選擇，應盡量使用驗證回傳值或物件狀態改變。
 * 因為互動測試會造成測試結果的複雜化。
 *
 * 補充:
 * Stub: 關注在當外部相依物件(Stub)回傳什麼樣的資料時，會導致目標物件內部的狀態或邏輯變化。
 * Mock: 變動性較大、通常在驗證Void類型的行為會使用到。
 */
class OrderTest {

    // 使用Mockito Annotation來建立Mock物件
    @Mock
    lateinit var mockEmailUtil: IEmailUtil

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testInsertOrder(){
        val mockEmailUtil = MockEmailUtil()
        val order = Order(mockEmailUtil)

        val email = "test@gmail.com"
        order.insertOrder(email, 3,200)

        // 用mockEmailUtil.receiveEmail來驗證order.insertOrder中
        // 是否真的有呼叫IEmailUtil.sendToCustomer
        Assert.assertEquals(email,mockEmailUtil.receiveEmail)
    }

    @Test
    fun testInsertOrderWithMockito(){
        // 用Mockito產生Mock物件
        val mockEmailUtil = mock(IEmailUtil::class.java)
        val order = Order(mockEmailUtil)

        val email = "test@gmail.com"
        order.insertOrder(email, 3,200)

        // 用mockEmailUtil.receiveEmail來驗證order.insertOrder中
        // 是否真的有呼叫IEmailUtil.sendToCustomer
        // 使用mockito的verify來驗證互動結果
        verify(mockEmailUtil).sendToCustomer(email)
    }

    @Test
    fun testInsertOrderWithMockitoInit(){
        // 使用Annotation所建立的Mock物件
        val order = Order(mockEmailUtil)

        val email = "test@gmail.com"
        order.insertOrder(email, 3,200)

        // 用mockEmailUtil.receiveEmail來驗證order.insertOrder中
        // 是否真的有呼叫IEmailUtil.sendToCustomer
        // 使用mockito的verify來驗證互動結果 (anyXXX() => 任何參數皆可)
        verify(mockEmailUtil).sendToCustomer(ArgumentMatchers.anyString())

        /**
         * 補充:
         *
         * //驗證呼叫1次
         * verify(mockEmailUtil, times(1)).sendCustomer(userEmail)
         *
         * //驗證不能呼叫此方法
         * verify(mockEmailUtil, never()).sendCustomer(userEmail)
         *
         * //驗證最少呼叫1次
         * verify(mockEmailUtil, atLeast(1)).sendCustomer(userEmail)
         *
         * //驗證最多呼叫1次
         * verify(mockEmailUtil, atMost(1)).sendCustomer(userEmail)
         */
    }
}