package Steps;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    ProductsPage productsPage;
    Playwright playwright=Playwright.create();
    Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));

    Page page= browser.newPage();
    @Given("I Opened The Browser")
    public void ı_opened_the_browser() {
        page.navigate("https://automationexercise.com/");
        homePage=new HomePage(page);
        loginPage=new LoginPage(page);
        cartPage=new CartPage(page);
        productsPage=new ProductsPage(page);

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
/////////////////////////
    @Given("I Clicked View product")
    public void viewFirstProduct(){
        homePage.viewFirstProduct();
    }

    @And("I proceed to Checkout")
    public void proceed(){
        cartPage.proceedToCheckOut();
    }


    @And("I added product on my cart")
    public void ıAddedProductOnMyCart() {
        cartPage.addProductOnCartAndViewCart();
    }

    @When("I Enter The Cart İnformations {string} {string}  {string}  {string} {string}")
    public void ıEnterTheCartİnformations(String arg0, String arg1, String arg2, String arg3, String arg4) {

        cartPage.EnterCartİnfos(arg0, arg1, arg2, arg3, arg4);
    }

    @Then("I complete Order Then check if order created")
    public void completeOrderAndCheck(){
        cartPage.completePaymentThenCheck();
        cartPage.assertİfOrderCreated();

    }
    @When("I remove order from cart")
    public void removeOrderFromCart(){
        cartPage.removeProdcutFromCart();
    }
    @Then("I should see if product removed")
    public void assertİfProductRemoved(){
        cartPage.assertİfProductRemoved();
    }

    ///////////////////////////
    @Given("I clicked on Products button")
    public void clickedOnProductsBtn(){
        homePage.goToProductsPage();

    }



    @And("I searched for product {string}")
    public void ıSearchedForProduct(String arg0) {
        productsPage.typeİnSearchBox(arg0);
    }

    @When("I click on Search Button")
    public void ıClickOnSearchButton() {
        productsPage.clickOnSearchBoxButton();
    }

    @Then("I check İf Expected visible {string}")
    public void ıCheckIfExpectedVisible(String arg0) {
        productsPage.assertİfProductVisible(arg0);
    }
}
