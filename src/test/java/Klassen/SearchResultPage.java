package Klassen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

/**
 * Created by alexanderhe on 14.07.17.
 */
public class SearchResultPage {

    @FindBy (xpath="//ul[@class='product_list grid row']//li")
    private List<WebElement> resultList;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int countNumberOfResults(){
        return resultList.size();
    }

}
