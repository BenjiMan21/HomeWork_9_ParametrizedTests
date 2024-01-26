package nikiforov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Параметризованный тест для домашнего задания")

public class ParametrizedWebTestWithMethodSourceTest extends TestBase {

    static Stream<Arguments> dataForSearchVideoGameAtSteamService() {
        return Stream.of(
                Arguments.of("Baldur's Gate 3", "1999 руб"),
                Arguments.of("Stray", "1250 руб")
        );
    }

    @MethodSource ("dataForSearchVideoGameAtSteamService")
    @ParameterizedTest (name = "Поиск выдеоигры {0} в сервисе Steam с ценой {1}" )
    @Tags({
            @Tag ("WEB"),
            @Tag ("BLOCKER")
    })
    void searchForVideoGameAtSteamService(String searchGame, String price) {
        $("#store_nav_search_term").setValue(searchGame).pressEnter();
        $("#search_resultsRows a").shouldHave(text(price));
    }
}
