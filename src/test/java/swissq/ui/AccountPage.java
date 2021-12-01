package swissq.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AccountPage {
    public static Target LINK_EDIT_INFORMATION = Target.the("edit information link").locatedBy("//a[contains(text(), '{0}')]");
}
