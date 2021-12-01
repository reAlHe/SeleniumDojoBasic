package swissq.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static swissq.ui.LandingPage.GRID_SEARCH_RESULTS;

public class TheSearchResults implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return GRID_SEARCH_RESULTS.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> visibility() {
        return new TheSearchResults();
    }
}