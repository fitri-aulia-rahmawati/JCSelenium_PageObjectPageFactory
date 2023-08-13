package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='pink drop shoulder oversized t shirt']")
    private WebElement product;
    @FindBy(xpath = "//select[@id='pa_color']")
    private WebElement colorDropdown;
    @FindBy(xpath = "//select[@id='pa_size']")
    private WebElement sizeDropdown;
    @FindBy(xpath = "//input[@id='noo-quantity-3229']")
    private WebElement quantity;
    @FindBy(xpath = "//button[@class='add_to_cart_button']")
    private WebElement addToCartButton;

    public void addToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        Actions actions = new Actions(driver);
        actions.moveToElement(product).click().perform();
        js.executeScript("window.scrollBy(0,250)");
        Select selectColor = new Select(colorDropdown);
        selectColor.selectByValue("pink");
        Select selectSize = new Select(sizeDropdown);
        selectSize.selectByValue("37");
        Select selectQuantity = new Select(quantity);
        selectQuantity.selectByValue("2");
        addToCartButton.click();
        System.out.println("Button Add Cart Success");
    }
}
