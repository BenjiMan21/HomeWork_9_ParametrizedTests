package nikiforov;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeEach
    void beforeEach() {
        open("https://store.steampowered.com/");
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;//
        Configuration.timeout = 5000; // default 4000
    }
    @AfterEach()
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
