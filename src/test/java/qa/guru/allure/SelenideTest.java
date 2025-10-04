package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void IssueSearchTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $("#repositories-tab").click();
        $(By.linkText("QA_GURU_JUnit_HW")).click();

        $("#issue-tab").click();
        $(By.linkText("/novalserg/QA_GURU_JUnit_HW/issues/new/choose")).click();
        $("#issue-create-pane-title").shouldBe(Condition.visible);

    }
}
