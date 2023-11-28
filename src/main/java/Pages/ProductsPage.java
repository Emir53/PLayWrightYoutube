package Pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsPage {
    Page page;
    public ProductsPage(Page page){
        this.page=page;
    }

    private String searchBoxİnput="input[name='search']";
    private String searchButton="i.fa.fa-search";


    public void typeİnSearchBox(String text){
        page.fill(searchBoxİnput,text);
    }

    public void clickOnSearchBoxButton(){
        page.click(searchButton);
    }

    public void assertİfProductVisible(String expText){
        assertThat(page.locator("//div[@class='productinfo text-center']//p[1]")).hasText(expText);
    }
}
