package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    @Step("Mail Adresi Doldurulur")
    public LoginPage fillMail(String text){
        WebElement element = driver.findElement(By.id("loginEmail"));

        element.clear();
        element.sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Parola Alanı Doldurulur")
    public LoginPage fillPassword(String text){
        WebElement element = driver.findElement(By.id("loginPassword"));

        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Step("Giriş Yap Butonuna Tıklanır")
    public LoginPage submitLogin(){
        driver.findElement(By.cssSelector("[class='btn btn-default user-register-button']")).submit();
        return this;
    }

    @Step("Hata Mesajı Alınır")
    public String getErrorMessage(){
        String value = driver.findElement(By.cssSelector("[class='generalErrorMessage']")).getText();
        screenshot();
        return value;
    }

    @Step("Giriş Yap Sayfasındaki Şifremi Unuttum Alanına Tıklar")
    public LoginPage submitForgetPassword(){
        driver.findElement(By.cssSelector("[class='vvns-forget-password-link']")).click();
        return this;
    }

}