package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class AllovercommercePage {

    public AllovercommercePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = "input[type='search']")
    public WebElement searchBox;

    @FindBy (xpath = "//img[@height='179']")
    public WebElement macbook;

    @FindBy (xpath = "(//div[contains(@class,'btn-product-icon wishlist-fragment on-first-load')])[1]")
    public WebElement wishListSymbol;

    @FindBy (xpath = "//img[@width='300'][1]")
    public WebElement iphone;

    @FindBy (className = "w-icon-heart")
    public WebElement wishListIcon;

    @FindBy(xpath = "//*[.='Sign In']")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccountLink;

    @FindBy(partialLinkText = "My Account")
    public WebElement myAccountButton;

    @FindBy(xpath = "//div[.='Sign Out']")
    public WebElement signOutButton;

    @FindBy(partialLinkText = "Store Manager")
    public WebElement storeManager;

    @FindBy(css ="a[href='https://allovercommerce.com/store-manager/coupons/']")
    public WebElement couponsButton;

    @FindBy(id ="add_new_coupon_dashboard")
    public WebElement addNewButton;

    @FindBy (className = "wishlist-items-wrapper")
    public List<WebElement> products;
    @FindBy(xpath ="(//button[contains(text(),'Quick View')])[2]")
    public WebElement quickViewButton1;

    @FindBy(className ="mfp-close")
    public WebElement closeButton;
    @FindBy(xpath ="(//button[contains(text(),'Quick View')])[1]")
    public WebElement quickViewButton2;

    @FindBy(xpath ="(//a[text()='Add to cart'])[2]")
    public WebElement addToCartButton1;


    @FindBy(xpath ="(//a[text()='Add to cart'])[1]")
    public WebElement addToCartButton2;

    @FindBy(xpath ="//a[@class='cart-toggle']")
    public WebElement cartIcon;

    @FindBy(xpath ="(//a[@href='https://allovercommerce.com/cart/'])[2]")
    public WebElement viewCartButton;

    @FindBy(xpath = "(//figure/a)[1]")
    public WebElement urun;



}