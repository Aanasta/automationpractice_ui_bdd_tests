package com.automationpractice.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CatalogPage extends AbstractPage {

    @FindBy(className = "category-name")
    private WebElementFacade categoryNameText;

    @FindBy(className = "subcategory-image")
    private List<WebElement> subcategoryImages;

    @FindBy(id = "layered_block_left")
    private WebElement filtersBlock;

    @FindBy(className = "layered_filter")
    private List<WebElement> catalogFilters;

    @FindBy(xpath = "//div[@id='layered_price_slider']/a[1]")
    private WebElement lowestPriceSlider;

    @FindBy(xpath = "//div[@id='layered_price_slider']/a[2]")
    private WebElement highestPriceSlider;

    @FindBy(xpath = "//div[@id='layered_price_slider']/div")
    private WebElement priceSlider;

    @FindBy(id = "selectProductSort")
    private WebElement sortByDropdown;

    @FindBy(xpath = "//ul/p/img")
    private WebElement loadingSpinnerImage;

    @FindBy(id = "layered_price_range")
    private WebElement priceRangeValue;

    @FindBy(xpath = "//div[@id='uniform-selectProductSort']/span")
    private WebElement appliedSortingOption;

    public static String getLoadingSpinnerExpectedSrc() {
        return LOADING_SPINNER_EXPECTED_SRC;
    }

    public static String getCatalogPageUrl() {
        return CATALOG_PAGE_URL;
    }

    private static final String CATALOG_PAGE_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";

    private static final String LOADING_SPINNER_EXPECTED_SRC = "http://automationpractice.com/img/loader.gif";

    public String getCategoryNameText() {
        return this.categoryNameText.getText();
    }

    public int getSubcategoriesCount() {
        return subcategoryImages.size();
    }

    public boolean isFiltersBlockDisplayed() {
        return this.filtersBlock.isDisplayed();
    }

    public int getFiltersCount() {
        return catalogFilters.size();
    }

    //So far the offset for the slider is hardcoded because the slider width changes dynamically after applying the lowest price limit.
    //This will be a point for future enhancement
    public void setPriceFilterByMovingSlider() {
        int offset = (int) (getSliderWidth() * 0.3);
        Actions sliderAction = new Actions(getDriver());
        sliderAction.dragAndDropBy(lowestPriceSlider, offset, 0).build().perform();
        sliderAction.dragAndDropBy(highestPriceSlider, -offset, 0).build().perform();
    }

    //Set the sorting option for the Catalog page
    public void setSorting(String sortingOption) {
        Select sortBy = new Select(this.sortByDropdown);
        sortBy.selectByVisibleText(sortingOption);
    }

    //Check if loading spinner is displayed
    public boolean isLoadingSpinnerDisplayed() {
        return this.loadingSpinnerImage.isDisplayed();
    }

    //Check the image for the loading spinner
    public String getLoadingSpinnerSrc() {
        return this.loadingSpinnerImage.getAttribute("src");
    }

    //Check the price range set in the Price filter
    public String getPriceRange() {
        return this.priceRangeValue.getText();
    }

    //Check the sorting option currently applied to the Catalog
    public String getSorting() {
        return this.appliedSortingOption.getText();
    }

    private int getSliderWidth() {
        return this.priceSlider.getSize().getWidth();
    }

}
