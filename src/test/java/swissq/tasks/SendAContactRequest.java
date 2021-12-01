package swissq.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static swissq.ui.ContactPage.*;
import static swissq.ui.LandingPage.LINK_CONTACT_US;

public class SendAContactRequest implements Task {

    private final String name;

    private final String message;

    protected SendAContactRequest(String name, String message) {
        this.name = name;
        this.message = message;
    }

    @Step("Send contact request for #name with message: #message")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_CONTACT_US)
        );
        actor.attemptsTo(
                Enter.theValue(name).into(INPUT_NAME)
        );
        actor.attemptsTo(
                Enter.theValue(message).into(INPUT_MESSAGE)
        );
        actor.attemptsTo(
                Click.on(BUTTON_SUBMIT_MESSAGE)
        );
    }

    public static SendAContactRequest withMessage(String name, String message) {
        return instrumented(SendAContactRequest.class, name, message);
    }

}
