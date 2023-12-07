package Test;

import Utlity.BrowserParameters;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Tests extends BrowserParameters {


    @Test(priority = 1)
    void Login() {
        Locators lct = new Locators(driver);

        driver.get("https://admin-demo.nopcommerce.com/login");
        lct.email.clear();
        lct.email.sendKeys("admin@yourstore.com");
        lct.password.clear();
        lct.password.sendKeys("admin");
        lct.login.click();

        Assert.assertTrue(lct.logout.getText().toLowerCase().contains("logout"));
    }

    Faker faker=new Faker();
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String name2 = faker.name().fullName();


    @Test(dependsOnMethods = "Login", priority = 2)
    @Parameters("mail")
    void CreateCustomer(String mail) {
        Locators lct = new Locators(driver);

        wait.until(ExpectedConditions.titleContains("Dashboard"));
        wait.until(ExpectedConditions.elementToBeClickable(lct.leftNav.get(3)));
        lct.leftNav.get(3).click();
        wait.until(ExpectedConditions.attributeToBe(lct.leftNavDisplayed.get(2), "style", "display: block;"));
        lct.customers.click();
        lct.addNew.click();
        lct.email.sendKeys(mail);
        lct.firstname.sendKeys(name);
        lct.lastname.sendKeys(lastName);
        lct.saveButton.click();

        Assert.assertTrue(lct.successMessage.getText().contains("success"));
    }


    @Test(dependsOnMethods = "CreateCustomer", priority = 3)
    @Parameters("mail")
    void EditCustomer(String mail) {
        Locators lct = new Locators(driver);

        wait.until(ExpectedConditions.elementToBeClickable(lct.email));
        lct.email.sendKeys(mail);
        lct.searchFirstName.sendKeys(name);
        lct.searchLastName.sendKeys(lastName);
        lct.search.click();

        Assert.assertEquals(lct.regisCheck.getText(),(name+" "+lastName));
        lct.edit.click();
        lct.firstname.clear();
        lct.firstname.sendKeys(name2);
        lct.saveButton.click();

        Assert.assertTrue(lct.successMessage.getText().contains("success"));
    }


    @Test(dependsOnMethods = "CreateCustomer", priority = 4)
    @Parameters("mail")
    void DeleteCustomer(String mail) {
        Locators lct = new Locators(driver);

        lct.leftNav.get(3).click();
        wait.until(ExpectedConditions.elementToBeClickable(lct.email));
        lct.email.sendKeys(mail);
        lct.searchFirstName.sendKeys(name2);
        lct.searchLastName.sendKeys(lastName);
        lct.search.click();

        lct.edit.click();
        lct.delete.click();
        lct.delete2.click();

        Assert.assertTrue(lct.successMessage.getText().contains("success"));

        lct.homepage.click();
    }

}
