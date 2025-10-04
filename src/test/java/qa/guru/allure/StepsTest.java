package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private final String REPOSITORY = "novalserg/qa_guru_allure";
    private final String ISSUE = "New Issue for HW";

    @Test
    public void lambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем github", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("#qb-input-query").setValue("qa_guru_allure").pressEnter();
        });
        step("Кликаем на ссылку репозитория" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с именем " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }
}
