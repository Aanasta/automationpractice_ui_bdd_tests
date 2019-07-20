Meta:
@acceptanceSuite

Scenario: Unregistered user opens main page

Given main page is opened
Then products should be displayed
Then number of products should be <expectedProductsNumber>
Then main logo should be displayed
Then main logo url should be <mainLogoUrl>
Then shopping cart button should be clickable

Examples:
|expectedProductsNumber|mainLogoUrl|
|7|http://automationpractice.com/|