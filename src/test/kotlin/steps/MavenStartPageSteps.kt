package steps

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.withText
import com.codeborne.selenide.Selenide.`$`
import cucumber.api.java.ru.Дано
import cucumber.api.java.ru.И
import cucumber.api.java.ru.Когда
import cucumber.api.java.ru.Тогда
import pages.MavenCentralStartPage

class MavenStartPageSteps {


    var mvnCentralStartPage = MavenCentralStartPage()

    @Дано("^пользователь видит заголовок \"([^\"]*)\"$")
    fun пользовательНаходитсяНаСайте(title: String) {
        `$`(withText(title)).shouldBe(visible)
    }

    @Когда("^пользователь вводит в строку поиска \"([^\"]*)\"$")
    fun пользовательВводитВСтрокуПоиска(value: String) {
        mvnCentralStartPage.searchInput.`val`(value)
    }

    @И("^пользователь нажимает на кнопку поиска$")
    fun пользовательНажимаетНаКнопкуПоиска() {
        mvnCentralStartPage.searchButton.click()
    }

    @Тогда("^первый найденый результат это \"([^\"]*)\"$")
    fun первыйНайденыйРезультатЭто(text: String) {
        `$`(withText(text)).shouldBe(visible)
    }
}