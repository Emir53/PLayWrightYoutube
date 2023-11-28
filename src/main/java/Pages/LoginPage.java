package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    private Page page;

    public LoginPage(Page page){
        this.page=page;
    }

    private String usrname="input[data-qa='login-email']";
    private String pasword="input[data-qa='login-password']";

    private String loginbtn="button[data-qa='login-button']";






    public void loginFunction(String username,String password){
        page.fill(usrname,username);
        page.fill(pasword,password);
        page.click(loginbtn);

    }

    public void checkİfLoggedIn(){
        assertThat(page.locator("i.fa.fa-user")).isVisible();
    }

    public void checkıfGetErrorMessage(){
        assertThat(page.locator("//p[text()='Your email or password is incorrect!']")).isVisible();
    }

}
