package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MessagesPage extends Page {
    private final String URL = "https://e.mail.ru/messages/inbox/";

    @FindBy(css = "span.b-toolbar__btn__text.b-toolbar__btn__text_pad")
    private WebElement textPad;

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public ComposePage findMessage() {
        PageFactory.initElements(driver, this);
        System.out.println(driver.getTitle());
        textPad.click();
        return new ComposePage(driver);

    }
}