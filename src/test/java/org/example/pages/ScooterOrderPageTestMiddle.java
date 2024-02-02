package org.example.pages;

import org.example.MainTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScooterOrderPageTestMiddle extends MainTest {
    @Test
    public void orderScooterTest() {
        ScooterOrderPage scooterOrderPage = new ScooterOrderPage(driver);

        scooterOrderPage.clickOrderButtonMiddle();
        scooterOrderPage.fillFieldsToOrder(
                "увувкрим",
                "Бари",
                "Ул. Абая 66",
                "Алатау",
                "87095786654",
                "04.04.2024",
                "",
                "",
                "Тесты"
        );
        String successText = scooterOrderPage.getSuccessText();
        System.out.println(successText);
        assertThat("Error", successText, containsString("оформлен"));
    }

}