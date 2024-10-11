import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.PasswordResetPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Feature("Login Test Senaryoları")
public class LoginTest extends BaseTest {

    LoginPage login = new LoginPage();
    MainPage mainPage = new MainPage();
    PasswordResetPage passwordReset = new PasswordResetPage();

    @Test(description = "Başarılı Kullanıcı Girişi Kontrolü")
    public void LoginSuccessful() throws InterruptedException {

        login.fillMail(email)
                .fillPassword(password)
                .submitLogin();
        sleep(3000);
        String value = mainPage.Account();
        assertEquals("Hesabım", value);
    }

    @Test(description = "Başarısız Kullanıcı Girişi Kontrolü")
    public void LoginUnSuccessful() throws InterruptedException {

        login.fillMail(email);
        login.fillPassword("password")
                .submitLogin();
        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("Şifreni hatalı girdin. Lütfen tekrar dene.", value);
    }

    @Test(description = "Boş Karakter Kontrolü")
    public void RequiredControl() throws InterruptedException {
        login.submitLogin();
        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("E-posta adresini ya da şifreni hatalı girdin! Lütfen tekrar dene.", value);
        login.fillMail(email)
                .submitLogin();
        String value2 = login.getErrorMessage();
        assertEquals("E-posta adresini ya da şifreni hatalı girdin! Lütfen tekrar dene.", value2);
        login.fillPassword(password)
                .submitLogin();
        sleep(3000);
        String value3 = mainPage.Account();
        assertEquals("Hesabım", value3);
    }

    @Test(description = "Min Max Karakter Kontrolü")
    public void MinMaxCharacterControl() throws InterruptedException {

        login.fillMail("a")
                .fillPassword("A")
                .submitLogin();
        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("Bu email ile bir üyelik kaydı bulunmuyor.", value);
        login.fillMail(email)
                .submitLogin();
        sleep(3000);
        //String value2 = login.getErrorMessage();
        //assertEquals("Şifreni hatalı girdin. Lütfen tekrar dene.",value2);
        login.fillPassword(password)
                .submitLogin();
        sleep(4000);
        String value3 = mainPage.Account();
        assertEquals("Hesabım", value3);
    }

    @Test(description = "Şifremi Unuttum Alanı Kontrolü")
    public void PasswordReset() throws InterruptedException {
        login.fillMail(email)
                .fillPassword("123456")
                .submitLogin();
        sleep(3000);
        login.submitForgetPassword();
        passwordReset.resetFillMail(email)
                .submitResetPassword();
        sleep(3000);
    }
}