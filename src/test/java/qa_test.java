import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

public class qa_test {
    @Test
    public void qatest() {
        open("file:///C:/Users/Peka/Desktop/qa/qa-test.html");
        $("#loginEmail").setValue("test@protei.ru");
        $("#loginPassword").setValue("test");
        $("#authButton").click();

        //Test1 Проверка имени. Смоук
        $("#dataEmail").setValue("1@test.ru");
        $("#dataName").setValue("Test1");
        $("#dataGender").selectOption("Мужской");
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter();
        //Проверка
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]")).shouldHave(text("Test1"));

        //Test2 Повторная проверка имени. Проверка Вариант 1.1. Смоук
        $("#dataEmail").setValue("2@test.ru");
        $("#dataName").setValue("Test2");
        $("#dataGender").selectOption("Мужской");
        $("#dataCheck11").click();
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter(); //данные добавлены. Ок
        //Проверка
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[2]")).shouldHave(text("Test2"));
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[2]")).shouldHave(text("1.1"));

        //Test3 Проверка: гендер, вариант 1.1,2.1. Смоук
        $("#dataEmail").setValue("0@test.ru");
        $("#dataName").setValue("Test0");
        $("#dataGender").selectOption("Женский");
        $("#dataSelect21").click();
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter(); //данные добавлены. Ок
        //Проверка
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[3]")).shouldHave(text("Женский"));
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[3]")).shouldHave(text("1.1"));
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[3]")).shouldHave(text("2.1"));


        //Заполняем базу данных
        //4
        $("#dataEmail").setValue("0@test.ru");
        $("#dataName").setValue("Test0");
        $("#dataGender").selectOption("Мужской");
        $("#dataCheck12").click();
        $("#dataSelect22").click();
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter();
        //5
        $("#dataEmail").setValue("0@test.ru");
        $("#dataName").setValue("Test0");
        $("#dataGender").selectOption("Женский");
        $("#dataCheck11").click();
        $("#dataSelect23").click();
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter();
        //6
        $("#dataEmail").setValue("0@test.ru");
        $("#dataName").setValue("Test0");
        $("#dataGender").selectOption("Мужской");
        $("#dataCheck11").click();
        $("#dataSelect21").click();
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter();
        //7
        $("#dataEmail").setValue("0@test.ru");
        $("#dataName").setValue("Test0");
        $("#dataGender").selectOption("Женский");
        $("#dataCheck12").click();
        $("#dataSelect23").click();
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter();
        //8
        $("#dataEmail").setValue("0@test.ru");
        $("#dataName").setValue("Test0");
        $("#dataGender").selectOption("Мужской");
        $("#dataSelect22").click();
        $("#dataSend").click();
        $(By.xpath("/html/body/div[3]/div/div/div[2]/button")).pressEnter();


        //Проверяем базу данных
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[4]")).shouldHave(text("0@test.ru Test0 Мужской 1.1, 1.2 2.2"));
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[5]")).shouldHave(text("0@test.ru Test0 Женский 1.2 2.3"));
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[6]")).shouldHave(text("0@test.ru Test0 Мужской 1.1, 1.2 2.1"));
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[7]")).shouldHave(text("0@test.ru Test0 Женский 1.1 2.3"));
        $(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[8]")).shouldHave(text("0@test.ru Test0 Мужской 1.1 2.2"));

    }
}
