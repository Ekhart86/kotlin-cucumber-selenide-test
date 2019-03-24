package pages

import com.codeborne.selenide.Selenide.`$`

class MavenCentralStartPage {

    var searchInput = `$`("#query")!!
    var searchButton = `$`("input.button")!!
}
