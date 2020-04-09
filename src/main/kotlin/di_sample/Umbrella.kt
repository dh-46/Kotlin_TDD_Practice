package di_sample


/**
 * 晴天9折，雨天沒折。
 *
 * Dependency Injection (DI 依賴注入)
 *     - 將某物件的控制權轉讓給第三方，以解開物件的耦合
 *
 * 種類:
 * 1. Method Injection:
 *     - 把方法中所需的物件提取成傳入的參數，這類方法就稱為Method Injection
 * 2. Constructor Injection:
 *     - 透過建構子傳入參數。
 *     - 確保被注入的物件在使用前一定被初始化
 *     - 透過建構子注入的參數將不再被修改?
 *     - 一般來說較推薦
 * 3. Property Dependency:
 *     - 直接修改Property來注入，實務上較不常用。
 * 4. Ambient Context:
 *     - 透過修改環境物件，如Singleton。
 *     - 較不建議。
 */
class Umbrella(private val weather: IWeather) {

    /**
     * 購買雨傘計價
     */
    fun totalPrice(quantity: Int, price: Int): Int { // 改建構式方式注入Weather
    // fun totalPrice(weather: IWeather, quantity: Int, price: Int): Int {
        // 把weather提取成參數解除相依，使其相依於IWeather介面
        /**
         * 取得是否為晴天
         *
         * => 這裡形成一個外部相依
         * 因為totalPrice方法會因為Weather物件的不同而有所變化，
         * 卻無法控制或得知Weather物件isSunny方法所回傳的值，
         * 如此一來會造成不可預期的結果，
         * 因此無法測試。
         *
         * ~外部相依將導致難以測試~
         *
         * >> 解法: DI 依賴注入
         * >> 使其依賴抽象(Interface)而非依賴實體
         * >> 這樣天氣就能夠是確定的 == 可以寫測試
         */
        val isSunny = weather.isSunny()

        // 購買數量*價錢
        val totalPrice = quantity * price

        // 判斷天氣
        return if (isSunny) {
            // 晴天打九折
            (totalPrice * 0.9).toInt()
        } else {
            totalPrice
        }
    }
}