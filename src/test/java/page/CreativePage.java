package page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static com.codeborne.selenide.Selenide.$;

public class CreativePage {
    protected WebDriver webdriver;


    public CreativePage(WebDriver driver) {
        this.webdriver = driver;
    }

    PageObject po = new PageObject();

    @Step("Нажать на меню сайта креатив")
    public CreativePage clickOnMenu() {
        $(By.xpath("//input[@type='checkbox']")).click();
        return this;
    }

    @Step("Выбрать раздел контакты")
    public CreativePage clickOnContactList() {
        $(By.xpath("//a[contains(text(),'контакты')]")).should(Condition.visible).click();
        return this;
    }

    @Step("Получения текста с раздела контакты")
    public String getNumber() {
        return $(By.xpath("//a[normalize-space()='+"))
                .should(Condition.visible)
                .getText();
    }

    @Step("Получения мейл адреса с раздела контакты")
    public String getMail() {
        return $(By.xpath("//a[@class='tn-atom'][normalize-space()='']"))
                .should(Condition.visible)
                .getText();
    }

    @Step("Получение значения вычисления")
    public String getAnswerData() {
        return $(By.xpath(po.numberAnswerField))
                .should(Condition.visible)
                .getValue();
    }
}
