package com.automationpractice.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//ul[contains(@class,'product_list')]//a[@class='product-name']")
    private WebElementFacade searchResultName;

    //Please note this URL is valid for the "blouse" search query only. If you update the search query the URL should be updated accordingly.
    private static final String SEARCH_RESULTS_PAGE_URL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Blouse&submit_search=";

    public static String getSearchResultsPageUrl() {
        return SEARCH_RESULTS_PAGE_URL;
    }

    public String getSearchResultName() {
        return this.searchResultName.getText();
    }

}
