package swissq.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static swissq.ui.LoginPage.ERROR_MESSAGE;

public class TheErrorMessageOnTheLoginPage implements Question<Boolean> {

    private final String errorMessage;

    protected TheErrorMessageOnTheLoginPage(String messageText) {
        this.errorMessage = messageText;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ERROR_MESSAGE.of(errorMessage).resolveFor(actor).isVisible();
    }

    public static Question<Boolean> withTextIsVisible(String messageText) {
        return new TheErrorMessageOnTheLoginPage(messageText);
    }
}