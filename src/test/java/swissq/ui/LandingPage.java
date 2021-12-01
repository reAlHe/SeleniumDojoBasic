package swissq.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LandingPage {
    public static Target BUTTON_MY_ACCOUNT = Target.the("button 'My Account'").locatedBy("//span[contains(text(),'My Account')]");
    public static Target LINK_LOGIN = Target.the("option 'login' under 'My Account'").locatedBy("//a[contains(text(),'Login')]");
    public static Target INPUT_SEARCH = Target.the("search field").locatedBy("//input[@name='search']");
    public static Target LINK_CONTACT_US = Target.the("link 'Contact Us'").locatedBy("//a[contains(text(),'Contact Us')]");
    public static Target BUTTON_START_SEARCH = Target.the("button to start the search").locatedBy("//*[@id='search']/span/button/i");
    public static Target GRID_SEARCH_RESULTS = Target.the("grid with the search results").locatedBy(".product-grid");
}
