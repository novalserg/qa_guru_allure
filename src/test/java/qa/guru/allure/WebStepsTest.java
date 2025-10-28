package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest {

    private final Utils utils = new Utils();

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Переходим в репозиторий")
    public void openRepo(String repo) {
        $("#qb-input-query").setValue(repo).pressEnter();
    }

    @Step("Кликаем по ссылке на репозиторий")
    public void clickRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем Issues")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие issue с именем")
    public void checkNameIssue(String name) {
        $(withText("#" + name)).should(Condition.exist);
    }

    @Step("Делаем скриншот")
    public byte[] makeScreenshot(){
        return utils.makeScreenshot();
    }
}

