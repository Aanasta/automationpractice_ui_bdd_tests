package com.automationpractice.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CatalogPage extends AbstractPage {

    @FindBy(className = "category-name")
    private WebElementFacade categoryNameText;

    @FindBy(className = "subcategory-image")
    private List<WebElementFacade> subcategoryImages;

    @FindBy(id = "layered_block_left")
    private WebElementFacade filtersBlock;

    @FindBy(className = "layered_filter")
    private List<WebElementFacade> catalogFilters;

    @FindBy(xpath = "//div[@id='layered_price_slider']/a[1]")
    private WebElementFacade lowestPriceSlider;

    @FindBy(xpath = "//div[@id='layered_price_slider']/a[2]")
    private WebElementFacade highestPriceSlider;

    @FindBy(xpath = "//div[@id='layered_price_slider']/div")
    private WebElementFacade priceSlider;

    @FindBy(id = "selectProductSort")
    private WebElementFacade sortByDropdown;

    @FindBy(xpath = "//ul/p/img")
    private WebElementFacade loadingSpinnerImage;

    @FindBy(id = "layered_price_range")
    private WebElementFacade priceRangeValue;

    @FindBy(xpath = "//div[@id='uniform-selectProductSort']/span")
    private WebElementFacade appliedSortingOption;

    public static String getLoadingSpinnerExpectedSrc() {
        return LOADING_SPINNER_EXPECTED_SRC;
    }

    private static final String LOADING_SPINNER_EXPECTED_SRC = "http://automationpractice.com/img/loader.gif";

    public String getCategoryNameText() {
        return categoryNameText.getText();
    }

    public int getSubcategoriesCount() {
        return subcategoryImages.size();
    }

    public boolean isFiltersBlockDisplayed() {
        return filtersBlock.isDisplayed();
    }

    public int getFiltersCount() {
        return catalogFilters.size();
    }

    public void setPriceFilterByMovingSlider() {
        int offset = (int) (getSliderWidth() * 0.3);
        Actions sliderAction = new Actions(getDriver());
        sliderAction.dragAndDropBy(lowestPriceSlider, offset, 0).build().perform();
        sliderAction.dragAndDropBy(highestPriceSlider, -offset, 0).build().perform();
    }

    public void setSorting(String sortingOption) {
        Select sortBy = new Select(sortByDropdown);
        sortBy.selectByVisibleText(sortingOption);
    }

    public boolean isLoadingSpinnerDisplayed() {
        return loadingSpinnerImage.isDisplayed();
    }

    public String getLoadingSpinnerSrc() {
        return loadingSpinnerImage.getAttribute("src");
    }

    public String getPriceRange() {
        return priceRangeValue.getText();
    }

    public String getSorting() {
        return appliedSortingOption.getText();
    }

    private int getSliderWidth() {
        return priceSlider.getSize().getWidth();
    }

}
