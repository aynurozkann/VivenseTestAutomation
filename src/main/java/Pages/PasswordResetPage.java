package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PasswordResetPage extends BaseTest {

    @Step("Şifresini Almak İstediğimiz Mail Adresi Girilir")
    public PasswordResetPage resetFillMail(String text){
        WebElement element = driver.findElement(By.cssSelector("[class='vvns-inputs vivense-registration-page__email']"));

        element.sendKeys(text);
        return this;
    }

    @Step("Link Gönder Butonuna Tıklanır")
    public PasswordResetPage submitResetPassword(){
        driver.findElement(By.cssSelector("[class='buttontxt lgnbtn profile-ok-btn']")).submit();
        return this;
    }
}
