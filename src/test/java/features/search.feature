Feature: Search and place order for vegetables



@seleniumTest
Scenario: Search for items and validate results
Given User is on Greencart Langing page
When User seached for "Cucumber" vegetable
Then "Cucumber" results are displayed

 
 
 
@seleniumTest1
Scenario Outline: Search for items and then move to checkout page
Given User is on Greencart Langing page2
When User seached for <vegetal> vegetable2
And Added items to cart
And User proceeded to Checkout page for purchase
Then verify selected <vegetal> items are displayed in check	out page

Examples: 
|vegetal  |
|Cucumber |
|Brinjal  |