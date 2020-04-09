package mock_sample

import di_sample.Umbrella
import di_sample.Weather

/**
 * Day5: 假物件 Stub & Mock
 *
 * Stub => 用來模擬外部相依物件的回傳結果
 * Mock => 用來驗證測試目標與相依物件的互動
 *
 * ---------------Stub---------------------
 * Test(測試程式) --測試--> SUT(被測試物件) <--呼叫與回傳希望的結果--> Stub(假物件)
 * >> 如同前兩個commit的測試
 *
 * ---------------Mock---------------------
 * Test --測試--> SUT
 *      --驗證SUT與Mock的互動--> Mock
 * >> 用賣雨傘下訂單的範例說明
 * -----------------------------------------
 *
 */
class Order(private val emailUtil: IEmailUtil) {

    /**
     * 訂單成立
     * 1. 計算金額
     * 2. 新增訂單 (此略)
     * 3. 發送Email給使用者 (這次範例的重點)
     *
     * 如何確保新增訂單有確實呼叫發送Email的function，並傳入正確的參數?
     *
     * ----------------------------------
     * Test(testInsertOrder) --測試--> SUT (insertOrder)
     *                       --驗證SUT與Mock的互動--> Mock (MockEmailUtil.sendToCustomer)
     * >> 測試的重點會是:
     * >> 1. 成立訂單有沒有發送mail => 有沒有成功呼叫sendToCustomer
     */
    fun insertOrder(email: String, amount: Int, price: Int){
        // 1. 計算金額
        val weather = Weather()
        val umbrella = Umbrella(weather)
        umbrella.totalPrice(amount, price)

        // 省略...

        // 寄送Email給使用者
        // val emailUtil = EmailUtil() // 這裡又有一個外部相依了 ㄎㄎ 提取成Constructor Injection了
        emailUtil.sendToCustomer(email)
    }
}