package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        // find username field
        WebElement emailField = driver.findElement(By.id("username"));
        // Type the Email address to email field element
        emailField.sendKeys("tomsmith");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Find the Login btn Element and click
        WebElement loginButton = driver.findElement(By.xpath("//i[text()=' Login']"));
        loginButton.click();
        String expectedMessage = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        // find username field
        WebElement emailField = driver.findElement(By.id("username"));
        // Type the Email address to email field element
        emailField.sendKeys("tomsmith1");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.xpath("//i[text()=' Login']"));
        loginbutton.click();
        //Verify the error message “Your username  is invalid!”
        String expectedMessage = "Your username is invalid!\n" +
                "×" ;
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        // find username
        WebElement emailField = driver.findElement(By.id("username"));
        // Type the Email address to email field element
        emailField.sendKeys("tomsmith");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.xpath("//i[text()=' Login']"));
        loginbutton.click();
        //Verify the error message “Your username  is invalid!”
        String expectedMessage = "Your password is invalid!\n" +
                "×" ;
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

