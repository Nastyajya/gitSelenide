package githab;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class TestSelenide extends TestBase  {

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
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
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
    }
}

