package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;
    public HomePage(Page page){
        this.page=page;
    }

    private String loginBtnOnHomePage="//a[contains(.,'Signup / Login')]";

    private String viewFirstProduct="(//i[@class='fa fa-plus-square'])[1]";

    public void goToLoginPage(){
        page.click(loginBtnOnHomePage);
    }

    public void viewFirstProduct(){
        page.click(viewFirstProduct);
    }




}
