package githab;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestSelenide {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920 x 1080";
        Configuration.browser = "chrome";
        com.codeborne.selenide.Configuration.holdBrowserOpen = true;
    }

    @Test
    void GitHome() {
        //- Откройте страницу Selenide в Github   - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();
        $$("ul.repo-list").first().$("a").click();
        //- Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // Откройте страницу SoftAssertions
        $(".wiki-rightbar").find(byText("SoftAssertions")).click();
        // Проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("@ExtendWith" +
                                "({SoftAssertsExtension.class})\n" +
                                "class Tests {\n" +
                                "  @Test\n" +
                                "  void test() {\n" +
                                "    Configuration.assertionMode = SOFT;\n" +
                                "    open(\"page.html\");\n" +
                                "\n" +
                                "    $(\"#first\").should(visible).click();\n" +
                                "    $(\"#second\").should(visible).click();\n" +
                                "  }\n" +
                                "}"));






        //  boolean gfd = $(".Truncate-text text-bold py-1").exists();
        //if (gfd) {
        //  $(".Truncate-text text-bold py-1").click();
        // $("")
//sleep(5000);
    }
}

