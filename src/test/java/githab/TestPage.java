package githab;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPage extends TestBase {
    @Test
    void TestSolutions() {
        open("https://github.com/");
        $(byTagAndText("button","Solutions")).hover();
        $("[href='/enterprise']").click();
        $(".application-main").shouldHave(text("Build like the best"));
    }
}
