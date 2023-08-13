package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.Checkout;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.*;

public class MainApp {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account/");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        System.out.println("Test Login");
        DriverSingleton.assertEqual(loginPage.getTextLoginSuccess(), "Welcome");

        CartPage cartPage = new CartPage(driver);
        cartPage.addToCart();
        System.out.println("Product added to cart.");

        Checkout checkout = new Checkout();
        System.out.println("Checkout Failed");
        checkout.checkout(
                "Fitri Aulia",
                "Rahmawati",
                "Indonesia",
                "Kp. Lio",
                "Depok",
                "Jawa Barat",
                "16431",
                "081234567",
                "fitrhmwti@gmail.com",
                false);

        //(positive tc)
        System.out.println("Checkout Success");
        checkout.checkout(
                "Fitri Aulia",
                "Rahmawati",
                "Indonesia",
                "Kp. Lio",
                "Depok",
                "Jawa Barat",
                "16431",
                "08123456789",
                "fitrhmwti@gmail.com",
                true);

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}