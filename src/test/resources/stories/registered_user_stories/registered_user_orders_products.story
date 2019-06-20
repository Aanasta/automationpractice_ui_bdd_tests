Scenario: Registered user logs in and orders a product

Given login page is opened
Given registered user logs into account with <email> and <password>
Given user opens Main page
When user adds tshirt and opens the cart
When user makes his order in the order wizard
Then <confirmationMessage> should be displayed
Then order amount should be <expectedOrderAmount>
Then shopping cart should be empty
Then back to orders button should be available

Examples:
|email|password|confirmationMessage|expectedOrderAmount|
|validemail@gmail.com|11111|Your order on My Store is complete.|$18.51|