import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Authorization {
    @BeforeMethod
    public void browser(){
        Configuration.browser = "chrome";
    }
    @Test
    public void test(){
        Selenide.open ("https://skyeng.ru/");
        Selenide.$(By.xpath("//*[@id=\"l-index\"]/div[3]/header/nav/div[3]/button[2]")).click();
        Selenide.$(By.xpath("//*[@id=\"b-ff-index-sign__form-1\"]/div[1]/input")).setValue("sviridovskiyao@gmail.com");
        Selenide.$(By.xpath("//*[@id=\"b-ff-index-sign__form-1\"]/div[2]/input")).setValue("Jeriko46");
        Selenide.$(By.xpath("//*[@id=\"b-ff-index-sign__form-1\"]/div[4]/button/span[1]")).click();
        Selenide.$(By.xpath("/html/body/div[1]/aside/div[3]/div/header/div/div/div/div[1]/div[2]/a[1]/div[2]")).shouldBe();
        Selenide.sleep(5000);
    }

}
