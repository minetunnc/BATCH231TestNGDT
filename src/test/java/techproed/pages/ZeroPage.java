package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class ZeroPage {

    public ZeroPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }





    @FindBy (id = "signin_button")
    public WebElement signin;

    @FindBy (id = "user_login")
    public WebElement login;

    @FindBy (id = "user_password")
    public WebElement password;

    @FindBy (name = "submit")
    public WebElement sign;

    @FindBy (xpath = "//strong [.='Online Banking']")
    public WebElement onlinebanking;

    @FindBy (id = "pay_bills_link")
    public WebElement paybills;

    @FindBy (xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    public WebElement foreign;

    @FindBy (id = "pc_currency")
    public WebElement currency;




}