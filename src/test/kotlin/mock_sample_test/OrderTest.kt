package mock_sample_test

import mock_sample.Order
import org.junit.Assert
import org.junit.Test

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
}