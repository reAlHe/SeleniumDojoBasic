package swissq.features.shopping;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import swissq.questions.TheErrorMessageOnTheLoginPage;
import swissq.tasks.Login;
import swissq.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SerenityRunner.class)
public class LoginStory {

    Actor roger = Actor.named("Roger");

    @Managed(uniqueSession = true)
    public WebDriver hisBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void rogerCanBrowseTheWeb() {
        roger.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void login_with_valid_credentials_works() {

        givenThat(roger).wasAbleTo(openTheApplication);

        when(roger).attemptsTo(Login.withCredentials("vixeka1671@dukeoo.com", "12345Test"));

        then(roger).should(eventually(seeThat(TheWebPage.title(), is("My Account"))));
    }

    @Test
    public void login_with_invalid_credentials_should_be_() {

        givenThat(roger).wasAbleTo(openTheApplication);

        when(roger).attemptsTo(Login.withCredentials("badguy@bluewin.ch", "wrong_pw"));

        then(roger).should(eventually(seeThat(TheErrorMessageOnTheLoginPage.withTextIsVisible("Warning: No match for E-Mail Address and/or Password."), is(true))));
    }
}