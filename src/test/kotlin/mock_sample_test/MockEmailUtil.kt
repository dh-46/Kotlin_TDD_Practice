package mock_sample_test

import mock_sample.IEmailUtil

/**
 * MockEmailUtil
 * > 假的EmailUtil來驗證是否有沒有呼叫成功
 */
class MockEmailUtil: IEmailUtil {
    var receiveEmail: String? = null
    override fun sendToCustomer(email: String) {
        receiveEmail = email
    }
}