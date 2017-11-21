# SeleniumDojoBasic

Ein Repository mit ein paar "unschön" geschriebenen Selenium-Tests um die Anwendung des Page Object Pattern zu üben :-)

Hier noch ein paar nützliche (basic) Selenium Commands aus unserer 2. Session:
```java
        // neues ChromeDriver-Object instanziieren
        ChromeDriver driver = new ChromeDriver();

        // eine URL im Browser öffnen
        driver.get("https://www.wikipedia.de");
        // Browser schließen
        driver.close();

        // Element anhand eines bestimmten Selektors identifizieren (z.B. ID, XPath, CSS)
        driver.findElementById("ichBinDieID");
        driver.findElementByXPath("ichBinEinXPath");
        driver.findElementByCssSelector("ichBinEinCSSSelector");

        // alternative Schreibweise eines Selektors am Bsp. ID
        driver.findElement(By.id("ichBinDieID"));

        // Element in einer Variable speichern
        WebElement element = driver.findElementById("ichBinDieID");

        // Aktionen ausführen
        element.click();
        element.sendKeys("deinEingabetext");

        // Methodenverkettung: Aktion direkt nach selektieren des Elements ausführen 
        // ohne das Element in einer Variablen zu speichern
        driver.findElementById("ichBinDieID").click();

        // Text eines Elements auslesen und in einer Variablen speichern
        String elementText = element.getText();

        // Assertion Bsp.
        Assert.assertTrue("Der Titel konnte nicht gefunden werden",driver.getPageSource().contains("Horst"));
        Assert.assertEquals("wrong success message", successMessage.getText(), "Done!");
 ```       
