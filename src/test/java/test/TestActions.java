package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CreativePage;
import page.TestsheepnzPage;


public class TestActions {
    WebDriver webdriver;


    @Test(priority = 1, description = "Кейс 1. Разница двух целых чисел")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверить, что в поле ответа (Answer) значение равно «-1»")
    @Step("Разница двух целых чисел")
    public void differenceOfTwoIntegers() {
        Selenide.clearBrowserCookies();
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        TestsheepnzPage testsheepnzPage = new TestsheepnzPage(webdriver);
        CreativePage creativePage = new CreativePage(webdriver);

        testsheepnzPage
                .openPage()
                .scrollDownOnPage()
                .selectPrototypeBuild()
                .fillingFirstNumberFld()
                .fillingSecondNumberFld()
                .selectSubtractOperation()
                .clickToCalculateBtn()
                .answerEqualsMinusOne();

        Assert.assertEquals(creativePage.getAnswerData(), "-1");

    }

//    @Test(priority = 2, description = "Проверить наличия и корректности данных в разделе контакты")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Проверить наличия и корректности указания следующих контактных данных: +")
//    public void checkForContentInWebSite() {
//        TestsheepnzPage testsheepnzPage = new TestsheepnzPage(webdriver);
//        CreativePage creativePage = new CreativePage(webdriver);
//        testsheepnzPage
//                .openPage()
//                .startSearchByKeyWords()
//                .chooseItemFromSearchResults();
//        creativePage
//                .clickOnMenu()
//                .clickOnContactList();
//
//
//        Assert.assertEquals(creativePage.getNumber(), "");
//        Assert.assertEquals(creativePage.getMail(), "");
//
//
//    }


}