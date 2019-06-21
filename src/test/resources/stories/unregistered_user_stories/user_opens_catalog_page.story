Meta:
@acceptanceSuite

Scenario: Unregistered user filters and sorts Catalog page

Given main page is opened
When user goes to the catalog page
When user filters products by setting price slider
When user sorts products in <sortingOrder>
Then loading spinner should be displayed
Then loading spinner image should be as expected
Then price filter <priceRange> should be applied
Then <sortingOrder> should be applied

Examples:
|sortingOrder|priceFilter|
|Price: Highest first|$27.10 - $41.53|


Scenario: Unregistered user opens Catalog page and sees its basic elements

Given main page is opened
When user goes to the catalog page
Then products should be displayed
Then products quantity in the catalog should be <expectedProductsQuantity>

Examples:
|expectedProductsQuantity|
|7|
