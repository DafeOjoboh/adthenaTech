# adthenaTech


BasketPricer is a simple Scala program that calculates the total price of a shopping basket, taking into account product prices and special discounts. 

**Table of Contents**
Overview
Features
Usage
Discounts
Customization
Getting Started
Contributing

**Overview**
BasketPricer is a command-line tool that allows you to input a list of items in your shopping basket and calculates the total price. It takes into account individual product prices and applies special discounts on specific items, such as discounts on apples and half-price bread when buying two tins of soup.

**Features**
Calculates the subtotal of your shopping basket.
Applies discounts on specific items.
Provides a breakdown of discounts applied.
Calculates the final total price.


**Usage**
To use BasketPricer, follow these steps:

Ensure you have Scala installed on your system. If not, you can download and install it from https://www.scala-lang.org/download/.

Clone this repository or download the BasketPricer.scala file.

Open your terminal or command prompt and navigate to the directory containing BasketPricer.scala.

Run the program with the following command, replacing item1, item2, item3, etc., with the items you want to include in your shopping basket:

*shell code*

scala BasketPricer.scala item1 item2 item3 ...
Example:

*shell code*
scala BasketPricer.scala Soup Bread Milk Apples

The program will calculate the subtotal, applied discounts (if any), and the total price, displaying the results in your terminal.

**Discounts**
BasketPricer supports the following discounts:

Apples Discount: £0.10 off per apple.
Soup and Bread Discount: Buy two tins of soup, get half-price bread (up to the number of soups purchased).

**Customization**
You can customize and extend the program's pricing and discount logic by modifying the prices and specialOffers maps in the BasketPricer object.

You can also customize and extend the program to input to take in item and quantity so you do not have to repeat items in the command-line input.

**Getting Started**
To get started with BasketPricer, ensure that you have Scala installed, and follow the usage instructions mentioned above.

**Contributing**
Contributions to BasketPricer are welcome! If you have ideas for improvements, bug fixes, or new features, please consider opening an issue or creating a pull request on the GitHub repository.


