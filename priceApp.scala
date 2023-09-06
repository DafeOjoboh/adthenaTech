/**
 * An object to hold program logic for pricing a shopping basket.
 */
object BasketPricer {

  // Look up Map to associate product names (as strings) 
  // with their respective prices (as doubles)
  val prices: Map[String, Double] = Map(
    "Soup" -> 0.65,
    "Bread" -> 0.80,
    "Milk" -> 1.30,
    "Apples" -> 1.00
  )

  // SpecialOffers look-up map to associate product names 
  // with tuples containing discount amounts (as doubles) 
  // and discount types (as strings)
  val specialOffers: Map[String, (Double, String)] = Map(
    "Apples" -> (0.10, "off"),
    "Soup_Bread" -> (0.50, "half_price")
  )

  /**
   * Entry point for the program.
   *
   * @param args An array of strings representing items in the basket.
   */
  def main(args: Array[String]): Unit = {

    // Check if the args array is empty, 
    // no items were provided as command-line arguments. 
    // If it's empty, print how to use the program.
    if (args.isEmpty) {
      println("Usage: PriceBasket item1 item2 item3 ...")

    } else {
      // Convert the args array to a list of items named basketItems.
      val basketItems = args.toList

      // Initiate priceBasket function and store return values in a tuple.
      val (subtotal, discounts, total) = priceBasket(basketItems)

      // Print Subtotal.
      println(s"Subtotal: £${"%.2f".format(subtotal)}")

      // Check for discounted items.
      if (discounts.nonEmpty) {
        discounts.foreach {
          case (item, (discountAmount, discountType)) =>
            println(s"$item $discountType: £${"%.2f".format(discountAmount)}")
        }
      } else {
        println("(No offers available)")
      }

      // Print Total price.
      println(s"Total price: £${"%.2f".format(total)}")
    }
  }

  /**
   * Calculate the total price of the basket including discounts.
   *
   * @param items A list of strings representing items in the basket.
   * @return A tuple containing subtotal, discounts, and total price.
   */
  def priceBasket(items: List[String]): (Double, Map[String, (Double, String)], Double) = {
    val subtotal = items.flatMap(prices.get).sum
    val discounts = calculateDiscounts(items)
    val totalDiscount = discounts.values.map(_._1).sum
    val total = subtotal - totalDiscount
    (subtotal, discounts, total)
  }

  /**
   * Calculate discounts based on the items in the basket.
   *
   * @param items A list of strings representing items in the basket.
   * @return A map of discounts with product names as keys and discount amounts and types as values.
   */
  private def calculateDiscounts(items: List[String]): Map[String, (Double, String)] = {
    val applesDiscount = items.count(_ == "Apples") * prices("Apples") * specialOffers("Apples")._1
    val soupCount = items.count(_ == "Soup")
    val breadCount = items.count(_ == "Bread")
    val breadPrice = prices("Bread")
    // Check if the bread count is more than half of the soup count
    val maxDiscountedBreads = if (breadCount >= soupCount / 2) soupCount / 2 else breadCount

    val soupBreadDiscount = (breadPrice * specialOffers("Soup_Bread")._1) * maxDiscountedBreads

    Map(
      "Apples" -> (applesDiscount, "off"),
      "Soup_Bread" -> (soupBreadDiscount, "half_price")
    ).filter { case (_, (discount, _)) => discount > 0 }
  }
}
