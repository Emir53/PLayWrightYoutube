package Pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage {
    Page page;
    public CartPage(Page page){
        this.page=page;

    }

    private String addProductBtn="button[type='button']";
    private String viewCartBtn="//u[text()='View Cart']";
    private String removeProductFromCart="i.fa.fa-times";
    private String proceedToCheckOut="a.btn.btn-default.check_out";

    private String textAreaForProceed="textarea.form-control";
    private String placeOrderBtn="//a[contains(text(),'Place Order')]";

    private String paymentNameOnCart="input[name='name_on_card']";
    private String paymentCardNumber="input[name='card_number']";

    private String paymentBtn="button[data-qa='pay-button']";

    public void addProductOnCartAndViewCart(){
        page.click(addProductBtn);
        page.click(viewCartBtn);
    }

    public void proceedToCheckOut(){
        page.click(proceedToCheckOut);

        page.click(placeOrderBtn);
    }
    public void EnterCartİnfos(String nameOnCart,String cartNumber,String expireDate,String MM,String YY){

        page.fill(paymentNameOnCart,nameOnCart);
        page.fill(paymentCardNumber,cartNumber);
        page.getByPlaceholder("ex.").fill(expireDate);
        page.getByPlaceholder("MM").fill(MM);
        page.getByPlaceholder("YYYY").fill(YY);


    }

    public void completePaymentThenCheck(){
        page.click(paymentBtn);


    }

    public void assertİfOrderCreated(){
        page.waitForSelector("//b[text()='Order Placed!']");
        assertThat(page.locator("//b[text()='Order Placed!']")).isVisible();
    }

    public void removeProdcutFromCart(){
        page.click(removeProductFromCart);

    }
    public void assertİfProductRemoved(){
        assertThat(page.locator("span#empty_cart>p")).isVisible();
    }


}



/*
   page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Place Order")).click();
           page.locator("input[name=\"name_on_card\"]").click();
           page.locator("input[name=\"name_on_card\"]").fill("emir");
           page.locator("input[name=\"card_number\"]").click();
           page.locator("input[name=\"card_number\"]").fill("12345");
           page.getByPlaceholder("ex.").click();
           page.getByPlaceholder("ex.").fill("123");
           page.getByPlaceholder("MM").click();
           page.getByPlaceholder("MM").fill("12");
           page.getByPlaceholder("YYYY").click();
           page.getByPlaceholder("YYYY").fill("1999");
           page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay and Confirm Order")).click();

 */