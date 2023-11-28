package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;
    public HomePage(Page page){
        this.page=page;
    }

    private String loginBtnOnHomePage="//a[contains(.,'Signup / Login')]";

    public void goToLoginPage(){
        page.click(loginBtnOnHomePage);
    }




}
