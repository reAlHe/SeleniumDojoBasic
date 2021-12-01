package swissq.features.shopping;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import swissq.questions.TheErrorMessageOnTheContactPage;
import swissq.tasks.OpenTheApplication;
import swissq.tasks.SendAContactRequest;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SerenityRunner.class)
public class SendContactRequestStory {

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
    public void send_contact_request_will_be_rejected_for_missing_email() {

        givenThat(roger).wasAbleTo(openTheApplication);

        when(roger).attemptsTo(SendAContactRequest.withMessage("Tom Tester", "Hello, this text contains at least 10 characters."));

        then(roger).should(eventually(seeThat(TheErrorMessageOnTheContactPage.withTextIsVisible("E-Mail Address does not appear to be valid!"), is(true))));
    }
}