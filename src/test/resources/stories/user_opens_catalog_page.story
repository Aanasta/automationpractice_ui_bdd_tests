Scenario: Unregistered user filters and sorts Catalog page

Given main page is opened
When user goes to the catalog page
When user sets price slider
When user sorts products
Then loading spinner should be displayed
Then loading spinner image should be as expected
Then price filter should be applied
Then sorting order should be applied


Scenario: Unregistered user opens Catalog page and sees its basic elements

Given main page is opened
When user goes to the catalog page
Then products should be displayed
Then products quantity in the catalog should be <expectedProductsQuantity>

Examples:
|expectedProductsQuantity|
|7|
