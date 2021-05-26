package apparel;

import homePage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ApparelTest extends TopMenuTest {

    @Test

    public void verifyUserShouldNavigateToAccessoriesPageSuccessfully() throws InterruptedException {

        // 1.1 Mouse Hover on “Apparel” Tab

        Thread.sleep(1000);
        mouseHover(By.linkText("Apparel"));
        Thread.sleep(1000);

        //  1.2 Mouse Hover on “Accessories” and click
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        Thread.sleep(1000);

        //1.3 Verify the text “Accessories”
        String expectedText = "Accessories";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Accessories')]"));
        Assert.assertEquals("User not  Navigated to Accessories page ", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //1.4 Click on “REGISTER” tab

         Thread.sleep(1000);
         mouseHover(By.xpath("//a[contains(text(),'Register')]"));
         Thread.sleep(1000);
         clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //1.5 Verify the text “Register”

        String expectedverificationMessage = "Register";
        Thread.sleep(1000);
        String actualVerificationMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals(" User not registered successfully", expectedverificationMessage, actualVerificationMessage);

        //1.6 Fill the mandatory fields
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Shivani");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='LastName']"), "vyas");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "Shivani.vyas12"+randomInt+"@yahoo.com");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "Jaisai2401");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Jaisai2401");

        //1.7 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(1000);

        //1.8 Verify the message “Your registration completed”
        String expectedregistrationMessage = "Your registration completed";
        Thread.sleep(2000);
        String actualregistrationMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Registered successfully", expectedregistrationMessage, actualregistrationMessage);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        /**
         *
         *1.1 Mouse Hover on “Apparel” Tab
         * 1.2 Mouse Hover on “Accessories” and click
         * 1.3 Verify the text “Accessories”
         */

         this.verifyUserShouldNavigateToAccessoriesPageSuccessfully();// method call by current object keyword

        //1.9 Click on List View Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //1.10 Click on product name “Obay Propaganda Hat” link
        Thread.sleep(1000);
        clickOnElement(By.linkText("Obey Propaganda Hat"));

        //1.11 Verify the text “Obay Propaganda Hat”
        Thread.sleep(1000);
        String expectedresult = "Obey Propaganda Hat";
        Thread.sleep(2000);
        String actualresult = getTextFromElement(By.xpath("//h1[contains(text(),'Obey Propaganda Hat')]"));
        Assert.assertEquals("User not  Navigated to Obey Propaganda Hat page ", expectedresult, actualresult);

        //1.12 select the size
        Thread.sleep(1000);
        selectByIndexFromDropDown(By.cssSelector("#product_attribute_13"), 3);

        // 1.13 Click on ADD TO CART
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-31' and @class='button-1 add-to-cart-button']"));

        //1.14 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("User not successfully purchases the product ", expectedMessage, actualMessage);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //1.15 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //1.16 Verify the message "Shopping cart"
        Thread.sleep(1000);
        String expectedMessageCart = "Shopping cart";
        String actualMessageCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User not successfully navigate to Shopping cart page", expectedMessageCart, actualMessageCart);

        //1.17 Change the quantity to 5 and update the shopping cart
        Thread.sleep(1000);
        clear(By.xpath("//tbody/tr[1]/td[5]/input[1]"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//tbody/tr[1]/td[5]/input[1]"), "5");
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));

        //1.18 Verify the Total $150.00
        Thread.sleep(2000);
        String expectedPrice1 = "$150.00";
        String actualPrice1 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]"));
        Assert.assertEquals("Total not verified", expectedPrice1, actualPrice1);

        //1.19 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //1.20Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //1.21 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        String expectedWelcomeMessage = "Welcome, Please Sign In!";
        Thread.sleep(2000);
        String actualwelcomeMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome message not displayed", expectedWelcomeMessage, actualwelcomeMessage);

         //1.22 enter detail for existing user

        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "shivani.vyas12"+randomInt+"@yahoo.com");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "Jaisai2401");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        Thread.sleep(1000);

        //1.23 Click on “CHECKOUT”/ and accept terms and condition

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //1.24 Fill the Mandatory fields/for billing address

        Thread.sleep(1000);
        clear(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Shivani");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "vyas");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='BillingNewAddress_Email']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "shivani.vyas" + randomInt + "@gmail.com");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.Address1']"), "Flat 10,634 Kingsbury road");
        Thread.sleep(1000);
        sendTextToElement(By.xpath(" //input[@id='BillingNewAddress_ZipPostalCode']"), "NW9 9HN");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07722405000");
        Thread.sleep(1000);

        //1.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));

        //1.26 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //1.27 Click on “CONTINUE”
       // clickOnElement(By.xpath("//input[@id='shippingoption_2' and @name='shippingoption']"));

        //1.28 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
            Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));

        // 1.29 Select “AMEX” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 3);

        //1.30 Fill all the details/ Payment card details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Mrs.Samira brown");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "344501208672842");
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "3");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "417");

        //1.31 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //1.32 Verify “Payment Method” is “Amex Card”
        Thread.sleep(1000);
        String expectedpaymentMessage = "Credit Card";
        Thread.sleep(2000);
        String actualpaymentMessage = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment method is not verified", expectedpaymentMessage, actualpaymentMessage);

        //1.33 Verify “Shipping Method” is “2nd Day Air”

        Thread.sleep(1000);
        String expectedshippingMessage = "2nd Day Air";
        Thread.sleep(2000);
        String actualshippingMessage = getTextFromElement(By.xpath("//span[contains(text(),'2nd Day Air') and @class='value']"));
        Assert.assertEquals("Shipping method is not correct", expectedshippingMessage, actualshippingMessage);

        //1.34 Verify Total is “$150.00”
        Thread.sleep(1000);
        String expectedtotalMessage = "$150.00";
        Thread.sleep(1000);
        String actualtotalMessage = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Total amount is not verified", expectedtotalMessage, actualtotalMessage);

        Thread.sleep(1000);
        //1.35 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //1.36 Verify the Text “Thank You”

        String expectedMessage9 = "Thank you";
        Thread.sleep(2000);
        String actualMessage9 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank you message is not displayed", expectedMessage9, actualMessage9);


        //1.37 Verify the message “Your order has been successfully processed!”

        String expectedMessage10 = "Your order has been successfully processed!";
        Thread.sleep(2000);
        String actualMessage10 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Order not placed successfully", expectedMessage10, actualMessage10);
        System.out.println("pass Total6");
        Thread.sleep(1000);

        //1.38 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //1.39 Verify the text “Welcome to our store”
        String expectedMessage11 = "Welcome to our store";
        Thread.sleep(2000);
        String actualMessage11 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Successfully Not purchased product", expectedMessage11, actualMessage11);

        //1.40 Click on “Logout” link
        Thread.sleep(1000);
        clickOnElement(By.linkText("Log out"));

        //1.41 Verify the URL is “https://demo.nopcommerce.com/”

        String expectedUrl = "https://demo.nopcommerce.com/";
        Thread.sleep(1000);
        String actualUrl = getUrl();
        Assert.assertEquals("Url is NotMatch", expectedUrl, actualUrl);

    }

}
