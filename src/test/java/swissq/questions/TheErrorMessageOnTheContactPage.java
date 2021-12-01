package swissq.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static swissq.ui.ContactPage.ERROR_MESSAGE;

public class TheErrorMessageOnTheContactPage implements Question<Boolean> {

    private String errorMessage;

    protected TheErrorMessageOnTheContactPage(String messageText) {
        this.errorMessage = messageText;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ERROR_MESSAGE.of(errorMessage).resolveFor(actor).isVisible();
    }

    public static Question<Boolean> withTextIsVisible(String messageText) {
        return new TheErrorMessageOnTheContactPage(messageText);
    }
}