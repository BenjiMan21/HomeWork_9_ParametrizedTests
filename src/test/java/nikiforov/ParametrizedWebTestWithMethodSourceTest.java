package nikiforov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("����������������� ���� ��� �������� ������")

public class ParametrizedWebTestWithMethodSourceTest extends TestBase {

    static Stream<Arguments> searchForVideoGameAtSteamService() {
        return Stream.of(
                Arguments.of("Baldur's Gate 3", "1999 ���"),
                Arguments.of("Stray", "1250 ���")
        );
    }

    @MethodSource
    @ParameterizedTest (name = "����� ��������� {0} � ������� Steam � ����� {1}" )
    @Tags({
            @Tag ("WEB"),
            @Tag ("BLOCKER")
    })
    void searchForVideoGameAtSteamService(String searchGame, String price) {
        $("#store_nav_search_term").setValue(searchGame).pressEnter();
        $("#search_resultsRows a").shouldHave(text(price));
    }
}
