package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class ScooterOrderPage {
    Random randomGenerator = new Random();

    private WebDriver driver;
    private By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    private By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");

    private By nameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input");
    private By surnameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input");
    private By addressField = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input");
    private By metroStationFieldInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]//input");
    private By metroStationField = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]//div/ul/li/button");

    private By mobileNumberField = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input");
    //Input_Input__1iN_Z Input_Responsible__1jDKN
    private By nextButtonInOrderPage = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class ='Button_Button__ra12g Button_Middle__1CSJM']");

    private By deliverDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    private By deliverDateFieldSelect = By.xpath(".//div[@class='react-datepicker__input-container']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN react-datepicker-ignore-onclickoutside']");
    private By rentalPeriodField = By.xpath(".//div[@class='Dropdown-root']");
    private By rentElementsList = By.xpath(".//div[@class='Dropdown-menu']/div[@class='Dropdown-option']");

    private By scooterColorField = By.className("Checkbox_Input__14A2w");
    private By additionCommentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private By cookieButton = By.className("App_CookieButton__3cvqF");

    private By clickOrderButtonInOrderPage = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By buttonYesInOrderModalPage = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");


    private By successOrderText = By.xpath(".//div[@class='Order_Modal__YZ-d3']//div[contains(text(),'Заказ оформлен') and @class='Order_ModalHeader__3FDaJ']");
    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scroll() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /*public void checkButtonIsReady() {
        System.out.println(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement()));
    }*/

    public void clickOrderButtonHeader(){
       driver.findElement(orderButtonHeader).click();
    }
    public void clickOrderButtonMiddle(){
        scroll();
        //System.out.println(driver.findElement(orderButtonMiddle).getText());
       // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderButtonMiddle);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(orderButtonMiddle));
        driver.findElement(orderButtonMiddle).click();
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //метод заполненяет поля ввода пароля
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void setAddress(String adress) {
        driver.findElement(addressField).sendKeys(adress);
    }
    //метод заполненяет поля ввода пароля
    public void setMetroSt(String metroStation) {
        //driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(metroStationFieldInput).click();
        List<WebElement> metroElements = driver.findElements(metroStationField);
        int item = randomGenerator.nextInt(Math.abs(metroElements.size()));

        WebElement element = metroElements.get(item);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        metroElements.get(item).click();
    }
    public void setMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }
    public void clickNextButtonInOrderPage(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(nextButtonInOrderPage).click();
    }

    public void setDeliverDate(String deliverDate) {
        //driver.findElement(deliverDateField).sendKeys(deliverDate);
//        driver.findElement(deliverDateField).click();
//        List<WebElement> datePickerDays = driver.findElements(deliverDateField);
//        datePickerDays.stream().filter(e->e.getText().equals(deliverDate)).findFirst().get().click();
        driver.findElement(deliverDateField).sendKeys(deliverDate);
        driver.findElement(deliverDateField).sendKeys(Keys.ENTER);

    }
    //метод заполненяет поля ввода пароля
    public void setRentalPeriod(String rentPeriod) {
        driver.findElement(rentalPeriodField).click();

        List<WebElement> rentElements = driver.findElements(rentElementsList);
        int item = randomGenerator.nextInt(Math.abs(rentElements.size()));

        WebElement element = rentElements.get(item);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        rentElements.get(item).click();
        //driver.findElement(rentalPeriodField).sendKeys(rentPeriod)
    }
    public void setScooterColor(String color) {
        List<WebElement> colorElements = driver.findElements(scooterColorField);
        int randomInt = randomGenerator.nextInt(Math.abs(colorElements.size()));
        colorElements.get(randomInt).click();
    }
    //метод заполненяет поля ввода пароля
    public void setAdditionComment(String commentText) {
        driver.findElement(additionCommentField).sendKeys(commentText);
    }

    public void clickOrderButtonInOrderPage(){
        driver.findElement(clickOrderButtonInOrderPage).click();
    }
    public void clickYesButtonInOrderPage(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(buttonYesInOrderModalPage));
        driver.findElement(buttonYesInOrderModalPage).click();
        System.out.println("clicked su");
    }

    public void fillFieldsToOrder(String name,String surname, String address, String metroStation,String mobileNumber,
                                  String deliverDate,String rentPeriod,String color,String commentText){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroSt(metroStation);
        setMobileNumber(mobileNumber);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        clickNextButtonInOrderPage();

        setDeliverDate(deliverDate);
        setRentalPeriod(rentPeriod);
        setScooterColor(color);
        setAdditionComment(commentText);
        clickOrderButtonInOrderPage();
        clickYesButtonInOrderPage();
    }

    public String getSuccessText(){
        return driver.findElement(successOrderText).getText();
    }
}
