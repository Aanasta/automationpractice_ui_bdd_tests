Meta:
@acceptanceSuite
@smokeSuite

Scenario: Unregistered user searches for products

Given main page is opened
When user searches for <searchedProduct>
Then search results page should be opened
Then search results should be displayed
Then number of search results should be <expectedNumberOfSearchResults>
Then <searchedProduct> should be displayed in search results

Examples:
|searchedProduct|expectedNumberOfSearchResults|
|Blouse|1|