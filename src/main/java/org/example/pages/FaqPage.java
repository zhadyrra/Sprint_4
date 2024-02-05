package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FaqPage {
    private WebDriver driver;
    private List<WebElement> questions;
    private List<WebElement> answers;

    public FaqPage(WebDriver driver){
        this.driver = driver;

        this.questions = driver.findElements(By.xpath(".//div[starts-with(@id,'accordion__heading-')]"));
        this.answers = driver.findElements(By.xpath(".//div[starts-with(@id,'accordion__panel-')]"));
    }

    public void scrollPageToFaq() {
        //
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clickFaqList(int index) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(questions.get(index)));

        questions.get(index).click();
    }

    public String getFaqAnswer(int index) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(answers.get(index)));
        return answers.get(index).getText();
    }
}
