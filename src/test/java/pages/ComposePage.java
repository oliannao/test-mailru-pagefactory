package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ComposePage extends Page {
    private final String URL = "https://e.mail.ru/compose/?1506079150826";

    @FindBy(css = "textarea.js-input.compose__labels__input")
    private WebElement textPad;

    @FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
    private WebElement composeEditor;

    @FindBy(id = "tinymce")
    private WebElement elementMessageBody;

    @FindBy(xpath = "//span[contains(text(),\"Отправить\")]")
    private WebElement enter;

    private String text = "rebenokan@inbox.ru";
    private String message = "Hey! It's my home work! ))";
    private final By m = By.cssSelector("span.b-toolbar__btn__text");

    public ComposePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(URL);
    }

    public void findAdressFraimeSend() {
        PageFactory.initElements(driver, this);

        textPad.sendKeys(text);
        driver.switchTo().frame(composeEditor);
        elementMessageBody.sendKeys(message);
        driver.switchTo().defaultContent();
        enter.click();
    }
}