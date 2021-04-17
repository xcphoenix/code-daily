package top.xcphoenix.code.kotlin.dik.four.discount

sealed class Coupon {
    companion object {
        val CashType = "CASH"
        val DiscoutType = "DISCOUNT"
        val GiftType = "GIFT"
    }

    class CashCoupon(val id: Long, val type: String, val leastCost: Long, val reduceCost: Long) : Coupon()
    class DiscountCoupon(val id: Long, val type: String, val discount: Int) : Coupon()
    class GiftCoupon(val id: Long, val type: String, val gift: String) : Coupon()

}