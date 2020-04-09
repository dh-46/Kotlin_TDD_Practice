/**
 * 要被測試的類別
 */
class Math {
    var result = 0
    fun add(number1: Int, number2: Int): Int {
        return number1 + number2
        // return number1 - number2 // 刻意製造錯誤的邏輯
    }

    /**
     * 改把結果儲存在result
     */
    fun add2Result(number1: Int, number2: Int) {
        result = number1 + number2;
    }

    /**
     * 測試涵蓋率
     * 這個方法會回傳兩數中誰為最小值
     */
    fun minimum(number1: Int, number2: Int): Int {
        return if (number1 > number2) {
            number2
        } else {
            number1
        }
    }

    /**
     * 利用快捷鍵建立測試程式碼
     * => 類別按下 command + N (Alt + Insert)
     */
    fun maximum(number1: Int, number2: Int): Int {
        return if (number1 > number2) {
            number1
        } else {
            number2
        }
    }
}