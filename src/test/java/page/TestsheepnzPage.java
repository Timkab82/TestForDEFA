package page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class TestsheepnzPage {
    private final String HOMEPAGE_URL = "https://testsheepnz.github.io/BasicCalculator.html ";
    public static WebDriver webDriver;

    PageObject po = new PageObject();

    public TestsheepnzPage(WebDriver driver) {
        this.webDriver = driver;
    }

    @Step("Открытие браузер")
    public TestsheepnzPage openPage() {
        Selenide.open(HOMEPAGE_URL);
        return this;
    }

    @Step("Проскроллить вниз до конца")
    public TestsheepnzPage scrollDownOnPage() {
        $(By.xpath(po.textAtTheEndOfPage)).should(visible).scrollTo();
        return this;
    }

    @Step("Выбрать сборку (Build) «Prototype»")
    public TestsheepnzPage selectPrototypeBuild() {
        //actions().click($(By.xpath(po.dropDownBuild))).build().perform();
        $("#selectBuild").selectOptionContainingText("Prototype");
        return this;
    }

    @Step("Заполнить поле First number")
    public TestsheepnzPage fillingFirstNumberFld() {
        $(By.xpath(po.firstNumberField)).should(visible).sendKeys(po.ValueTwo);
        return this;
    }

    @Step("Заполнить поле Second number")
    public TestsheepnzPage fillingSecondNumberFld() {
        $(By.xpath(po.SecondNumberField)).should(visible).sendKeys(po.ValueThree);
        return this;
    }

    @Step("Выбрать сборку (Operation) «Subtract»")
    public TestsheepnzPage selectSubtractOperation() {
        $("#selectOperationDropdown").selectOptionContainingText("Subtract");
        return this;
    }

    @Step("Нажать на кнопку «Calculate»")
    public TestsheepnzPage clickToCalculateBtn() {
        $(By.xpath(po.calculateButtonLocator)).click();
        return this;
    }

    @Step("Проверить, что в поле ответа (Answer) значение равно «-1»")
    public TestsheepnzPage answerEqualsMinusOne() {
        $(By.xpath(po.numberAnswerField)).getValue();
        return this;
    }

    @Step("Поиск страницы креатив в гугл")
    public TestsheepnzPage startSearchByKeyWords() {
        $(By.xpath("//input[@type='text']")).should(visible).sendKeys("crtweb.ru");
        $(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
        return this;
    }

    @Step("Выбрать найденную ссылку")
    public TestsheepnzPage chooseItemFromSearchResults() {
        $(By.xpath("//h3[normalize-space()='Creative']")).should(visible).click();
        return this;
    }


}