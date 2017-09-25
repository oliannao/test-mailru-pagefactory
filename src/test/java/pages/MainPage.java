package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends Page {
    private final String URL = "http://mail.ru";

    @FindBy(id = "mailbox__login")
    private WebElement elementLogin;

    @FindBy(id = "mailbox__password")
    private WebElement elementPassorw;

    @FindBy(id = "mailbox__login__domain")
    private WebElement elementLoginDomain;

    @FindBy(id = "mailbox__auth__button")
    private WebElement elementAutButton;

    private final String login = "rebenokan";
    private final String password = "galina2010";
    private final String domen = "@inbox.ru";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(URL);
    }

    public void findMailboxLoginAndPassword() {
        PageFactory.initElements(driver, this);

    }

    public MessagesPage enterLoginAndPassword() {
        elementLogin.sendKeys(login);
        elementPassorw.sendKeys(password);
        new Select(elementLoginDomain).selectByVisibleText(domen);
        elementAutButton.click();
        return new MessagesPage(driver);

    }

}