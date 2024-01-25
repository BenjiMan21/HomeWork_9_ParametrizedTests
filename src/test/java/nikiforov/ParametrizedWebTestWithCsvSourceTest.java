package nikiforov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("ѕараметризованный тест дл€ домашней работы")

public class ParametrizedWebTestWithCsvSourceTest extends TestBase {
    @CsvSource (value = {
            "Baldur's Gate 3 | 1999 руб",
            "Stray | 1250 руб"
    }, delimiter = '|')
    @ParameterizedTest (name = "ѕоиск видеоигры {0} в сервисе Steam с ценой {1}" )
    @Tags({
            @Tag ("WEB"),
            @Tag ("BLOCKER")
    })
    void searchForVideoGameAtSteamService(String searchGame, String price) {
        $("#store_nav_search_term").setValue(searchGame).pressEnter();
        $("#search_resultsRows a").shouldHave(text(price));
    }
}
