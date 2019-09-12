import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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
        Selenide.open ("file:///C:/Users/Peka/Desktop/qa/qa-test.html");
        Selenide.$(By.xpath("//*[@id=\"loginEmail\"]")).setValue("test@protei.ru");
        Selenide.$(By.xpath("//*[@id=\"loginPassword\"]")).setValue("test");
        Selenide.$(By.xpath("//*[@id=\"authButton\"]")).click();




        //Test1 Проверка имени
        Selenide.$(By.xpath("//*[@id=\"dataEmail\"]")).setValue("1@test.ru");
        Selenide.$(By.xpath("//*[@id=\"dataName\"]")).setValue("Test1");
        Selenide.$(By.xpath("//*[@id=\"dataSend\"]")).click();
        Selenide.$(By.xpath("/html/body/div[3]/div/div/div[2]/button")).click(); //данные добавлены. Ок
        String resultText= Selenide.$(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[2]")).getText();
        MatcherAssert.assertThat("Test1", Matchers.equalTo(resultText));

        //Test2 Повторная проверка имени. Проверка Вариант 1.1
        Selenide.$(By.xpath("//*[@id=\"dataEmail\"]")).setValue("2@test.ru");
        Selenide.$(By.xpath("//*[@id=\"dataName\"]")).setValue("Test2");
        Selenide.$(By.xpath("//*[@id=\"dataCheck11\"]")).click();
        Selenide.$(By.xpath("//*[@id=\"dataSend\"]")).click();
        Selenide.$(By.xpath("/html/body/div[3]/div/div/div[2]/button")).click(); //данные добавлены. Ок
        String resultText2= Selenide.$(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[2]/td[2]")).getText();
        String Variant111= Selenide.$(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[2]/td[4]")).getText();
        MatcherAssert.assertThat("Test2", Matchers.equalTo(resultText2));
        MatcherAssert.assertThat("1.1", Matchers.equalTo(Variant111));

        //Test3 Проверка Вариант 1.1, Вариант 2.1
        Selenide.$(By.xpath("//*[@id=\"dataEmail\"]")).setValue("0@test.ru");
        Selenide.$(By.xpath("//*[@id=\"dataName\"]")).setValue("Test0");
        Selenide.$(By.xpath("//*[@id=\"dataCheck11\"]")).click();
        Selenide.$(By.xpath("//*[@id=\"dataSend\"]")).click();
        Selenide.$(By.xpath("//*[@id=\"dataSelect21\"]")).click();
        Selenide.$(By.xpath("/html/body/div[3]/div/div/div[2]/button")).click(); //данные добавлены. Ок
        String Variant112= Selenide.$(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[3]/td[4]")).getText();
        String Variant212= Selenide.$(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[3]/td[5]")).getText();
        MatcherAssert.assertThat("1.1", Matchers.equalTo(Variant112));
        MatcherAssert.assertThat("2.1", Matchers.equalTo(Variant212));

        //Test4 Проверка Вариант 1.1, Вариант 2.2
        Selenide.$(By.xpath("//*[@id=\"dataEmail\"]")).setValue("0@test.ru");
        Selenide.$(By.xpath("//*[@id=\"dataName\"]")).setValue("Test0");
        Selenide.$(By.xpath("//*[@id=\"dataCheck11\"]")).click();
        Selenide.$(By.xpath("//*[@id=\"dataSend\"]")).click();
        Selenide.$(By.xpath("//*[@id=\"dataSelect21\"]")).click();
        Selenide.$(By.xpath("/html/body/div[3]/div/div/div[2]/button")).click(); //данные добавлены. Ок
        String Variant113= Selenide.$(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[3]/td[4]")).getText();
        String Variant213= Selenide.$(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[3]/td[5]")).getText();
        MatcherAssert.assertThat("1.1", Matchers.equalTo(Variant113));
        MatcherAssert.assertThat("2.1", Matchers.equalTo(Variant213));



        Selenide.sleep(5000);
    }


}
