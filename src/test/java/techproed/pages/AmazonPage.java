package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class AmazonPage {

    /*
     PageFactory.initElements() kodu bu classtaki ögeleri webdriver ile eslestirir
     Bu sayede classtaki webelementlere erismek icin @FindBy gibi PageFactory ye yardimci olan
     annotationlar kullanilabilir
     */
    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchbox;

    @FindBy(xpath="//*[.='Try different image']")
    public WebElement captchaHandling;

    public void handleCaptcha(){
        try {
            ReusableMethods.click(captchaHandling);
        }catch (Exception e){
            //captcha sayfada cikmamasi durumunda NoSuchElementExceptioni böylece ignore ettik
        }
    }











}