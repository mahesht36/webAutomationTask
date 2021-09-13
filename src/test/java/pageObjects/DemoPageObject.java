package pageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoPageObject {

    int lowestPrice = 0;
    By productLink = By.xpath("//div[@class='header-search-form']//input[@class='header-search-input']");
    By searchButton = By.xpath("//button[@class='header-search-button']");
    By productAddWishListLink = By.xpath("//div[@class='summary entry-summary']//div[@class='yith-wcwl-add-button']//a//span");
    By homeButton = By.xpath("//a[@class='nav-link' and @title='Home']");
    By browseWishListButton = By.xpath("//div[@class='summary entry-summary']//a[contains(text(),'Browse wishlist')]");
    By countCart = By.xpath("//td[@class='product-add-to-cart']");
    By productPrice = By.xpath("//td[@class='product-price']/span | //td[@class='product-price']/ins");

    By textMessage = By.xpath("//div[@class='woocommerce-notices-wrapper']");

    WebElelemtHelper webElelemtHelper = new WebElelemtHelper();

    public void addItemInWishList(WebDriver driver) {
        driver.findElement(searchButton).click();
        webElelemtHelper.waitForElement(productAddWishListLink, driver);
        driver.findElement(productAddWishListLink).click();
    }

    public void searchProductsAndInWishList(WebDriver driver) {
        driver.findElement(productLink).sendKeys("Modern");
        addItemInWishList(driver);

        driver.findElement(productLink).sendKeys("Bikini");
        addItemInWishList(driver);

        driver.findElement(productLink).sendKeys("Hard top");
        addItemInWishList(driver);

        driver.findElement(productLink).sendKeys("Evening trousers");
        addItemInWishList(driver);

    }

    public void viewWishList(WebDriver driver) {
        webElelemtHelper.waitForElement(browseWishListButton, driver);
        driver.findElement(browseWishListButton).click();
    }

    public void countTheNumberOfProduct(WebDriver driver) {
        webElelemtHelper.waitForElement(countCart, driver);
        List<WebElement> cardList = driver.findElements(countCart);
        Assert.assertEquals(cardList.size(), 4);
    }

    public void getProductPrice(WebDriver driver) {
        webElelemtHelper.waitForElement(productPrice, driver);
        List<WebElement> priceElementList = driver.findElements(productPrice);
        List<Integer> priceList = new ArrayList<>();
        for (WebElement element : priceElementList) {
            String value = element.getText().replaceAll("£", "").replaceAll(".00", "");
            priceList.add(Integer.valueOf(value));
        }
        lowestPrice = Collections.min(priceList);
    }

    public void addingLowestPriceProductInCart(WebDriver driver) {
        By lowestPriceElement = By.xpath("//td[@class='product-price']/span//bdi[contains(text(),'" + lowestPrice + "')] | //td[@class='product-price']/ins//span//bdi[contains(text(),'" + lowestPrice + "')]/following::td[2]");
        webElelemtHelper.waitForElement(lowestPriceElement, driver);
        driver.findElement(lowestPriceElement).click();
    }

    public void verifyItemAddedToCart(WebDriver driver) {
        webElelemtHelper.waitForElement(textMessage, driver);
        String successMessage = driver.findElement(textMessage).getText();
        Assert.assertEquals("Product added to cart successfully", successMessage);
    }
}
