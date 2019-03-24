package runner


import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.SelenideLogger
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import io.qameta.allure.selenide.AllureSelenide
import org.junit.BeforeClass
import org.junit.runner.RunWith


@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/kotlin/features"],
    glue = ["steps"],
    tags = ["@mvn"]
)

class RunKukesTest {

    companion object {
        var BASE_URL = "https://mvnrepository.com"
        @BeforeClass
        @JvmStatic
        fun setUp() {
            Configuration.startMaximized = false
            SelenideLogger.addListener("AllureSelenide", AllureSelenide())
            Configuration.baseUrl = BASE_URL
            Configuration.browser = "chrome"
            Configuration.reportsFolder = "target/reports"
            Selenide.open(BASE_URL)
        }
    }

}