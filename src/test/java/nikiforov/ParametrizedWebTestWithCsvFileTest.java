package nikiforov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("ѕараметризованный тест дл€ домашней работы")

public class ParametrizedWebTestWithCsvFileTest extends TestBase {
    @CsvFileSource(resources = "/TestData/DataForParametrizedTest.csv")
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
