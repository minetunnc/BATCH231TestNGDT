package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

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








}