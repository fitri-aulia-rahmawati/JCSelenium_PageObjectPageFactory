package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
//    public void Login() {
//        Actions actions = new Actions(driver);
//        WebElement btnDismiss = driver.findElement(By.xpath("//a[@class='dismiss-link'"));
//        actions.moveToElement(btnDismiss).click().perform();
//        WebElement btnMyAcc = driver.findElement(By.xpath("//a[normalize-space()='My Account']"));
//        actions.moveToElement(btnMyAcc).click().perform();
//    }

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Locator @FindBy
//    @FindBy(xpath = "//a[@class='dismiss-link']")
//    WebElement dismiss;
//
//    @FindBy(xpath = "//a[normalize-space()='My Account']")
//    WebElement btnMyAcc;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(@class, 'login__submit')]")
    WebElement btnLogin;

    @FindBy(className = "woocommerce-MyAccount-content")
    WebElement textLoginSuccess;


    // Custom Method
    public void login(){
//        dismiss.click();
//        btnMyAcc.click();
        username.sendKeys("fitriauliaa3112@gmail.com");
        password.sendKeys("Fitriaulia");
        btnLogin.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("https://shop.demoqa.com/");
    }


    // Method return
    public String getTextLoginSuccess(){
        return textLoginSuccess.getText();
    }
}
