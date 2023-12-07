package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locators {

    public Locators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;
    @FindBy(xpath = "//button[text()='Log in']")
    WebElement login;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;
    @FindBy(css = "ul[class='nav nav-pills nav-sidebar flex-column nav-legacy']>li>a")
    List<WebElement> leftNav;
    @FindBy(css = "ul[class='nav nav-pills nav-sidebar flex-column nav-legacy']>li>a+ul")
    List<WebElement> leftNavDisplayed;
    @FindBy(xpath = "//p[text()=' Customers']")
    WebElement customers;
    @FindBy(css = "a[class='btn btn-primary']")
    WebElement addNew;
    @FindBy(css = "input[name='FirstName']")
    WebElement firstname;
    @FindBy(css = "input[name='LastName']")
    WebElement lastname;
    @FindBy(css = "button[name='save']")
    WebElement saveButton;
    @FindBy(css = "div[class='alert alert-success alert-dismissable']")
    WebElement successMessage;
    @FindBy(css = "input[id='SearchFirstName']")
    WebElement searchFirstName;
    @FindBy(css = "input[id='SearchLastName']")
    WebElement searchLastName;
    @FindBy(css = "button[id='search-customers']")
    WebElement search;
    @FindBy(css = "tr[class='odd']>td:nth-child(3)")
    WebElement regisCheck;
    @FindBy(css = "a[class='btn btn-default']")
    WebElement edit;
    @FindBy(id = "customer-delete")
    WebElement delete;
    @FindBy(xpath = "//button[@class='btn btn-danger float-right']")
    WebElement delete2;
    @FindBy(xpath = "//p[text()=' Dashboard']")
    WebElement homepage;

}
