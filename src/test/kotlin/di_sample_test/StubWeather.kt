package di_sample_test

import di_sample.IWeather

/**
 * 建立一個假的Weather物件，準備待會測試時使用
 */
class StubWeather : IWeather {
    // 建立屬性，讓外部可以設定要回傳晴天或雨天
    var fakeIsSunny = false

    override fun isSunny(): Boolean {
        return fakeIsSunny
    }
}