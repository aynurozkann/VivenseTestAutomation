package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step("Hesabım Bilgisi Alınır")
    public String Account(){

        String value = driver.findElement(By.cssSelector("[class='shortcut_column membership_wrapper_login headerMyAccount']")).getText();
        return value;
    }

}