package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    LoginPage loginPage;
    HomePage homePage;
    Playwright playwright=Playwright.create();
    Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));

    Page page= browser.newPage();
    @Given("I Opened The Browser")
    public void ı_opened_the_browser() {
        page.navigate("https://automationexercise.com/");
        homePage=new HomePage(page);
        loginPage=new LoginPage(page);

    }
    @And("CLicked On Login")
    public void c_licked_on_login() {
        homePage.goToLoginPage();
    }

    @Then("I checked İf I logged in")
    public void ı_checked_if_ı_logged_in() {
        loginPage.checkİfLoggedIn();
    }

    @When("I Log in correct e-mail {string} and password {string}")
    public void ıLogInCorrectEMailAndPassword(String usrname, String password) {
        loginPage.loginFunction(usrname, password);
    }

    @When("I Log in with invalid e mail {string} and password {string}")
    public void ıLogInWithInvalidEMailAndPassword(String usrname, String password) {
        loginPage.loginFunction(usrname, password);
    }

    @Then("I checked İf I get an error message")
    public void ıCheckedİfIGetAnErrorMessage() {
        loginPage.checkıfGetErrorMessage();

    }
}
