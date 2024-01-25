package nikiforov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Параметризованный тест для домашней работы")

public class ParametrizedWebTestWithValueSourceTest extends TestBase {
    @ValueSource (strings = {
            "Baldur's Gate 3",
            "Stray"
    })
    @ParameterizedTest (name = "Поиск видеоигры {0} в сервисе Steam" )
    @Tags({
            @Tag ("WEB"),
            @Tag ("BLOCKER")
    })
    void searchForVideoGameAtSteamService(String searchGame) {
        $("#store_nav_search_term").setValue(searchGame).pressEnter();
        $("#search_resultsRows a").shouldHave(text(searchGame));
    }
}
