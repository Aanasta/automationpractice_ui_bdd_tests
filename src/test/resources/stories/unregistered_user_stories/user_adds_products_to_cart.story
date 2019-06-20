Scenario: Unregistered user adds products to the shopping cart

Given main page is opened
When user adds blouse to cart
When user adds tshirt and opens the cart
Then blouse should be added to cart
Then total price for blouses should be <blouseTotal>
Then tshirt should be added to cart
Then total price for tshirts should be <expectedTshirtTotalBeforeEdit>
Then total price for cart should be <cartTotal>

Examples:
|blouseTotal|expectedTshirtTotalBeforeEdit|cartTotal|
|$27.00|$16.51|$45.51|

Scenario: Unregistered user edits products quantity in the shopping cart
Given main page is opened
When user adds blouse to cart
When user adds tshirt and opens the cart
When user sets blouse quantity to <editedBlouseQuantity>
When user removes tshirt from the cart
Then blouse quantity should be <editedBlouseQuantity>
Then tshirt should no longer be in the cart
Then total price for blouses should be <blouseTotal>
Then total price for cart should be <cartTotal>

Examples:
|editedBlouseQuantity|blouseTotal|cartTotal|
|5|$135.00|$137.00|
