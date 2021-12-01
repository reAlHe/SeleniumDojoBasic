package swissq.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static swissq.ui.LandingPage.BUTTON_MY_ACCOUNT;
import static swissq.ui.LandingPage.LINK_LOGIN;
import static swissq.ui.LoginPage.*;

public class Login implements Task {

    private final String email;

    private final String password;

    protected Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Step("Login with #email and #email")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_MY_ACCOUNT)
        );
        actor.attemptsTo(
                Click.on(LINK_LOGIN)
        );
        actor.attemptsTo(
                Enter.theValue(email).into(INPUT_EMAIL)
        );
        actor.attemptsTo(
                Enter.theValue(password).into(INPUT_PASSWORD)
        );
        actor.attemptsTo(
                Click.on(BUTTON_LOGIN)
        );
    }

    public static Login withCredentials(String email, String password) {
        return instrumented(Login.class, email, password);
    }

}
