package org.example.pages;

import org.example.MainTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScooterOrderPageTest extends MainTest {
    @Test
    public void orderScooterTest() {
        ScooterOrderPage scooterOrderPage = new ScooterOrderPage(driver);
        scooterOrderPage.clickOrderButtonHeader();
        scooterOrderPage.fillFieldsToOrder(
                "Кари",
                "Бари",
                "Ул. Абая 100",
                "Черкизовская",
                "87095786654",
                "01.04.2024",
                "",
                "",
                "Тесты"
        );
        String successText = scooterOrderPage.getSuccessText();
        System.out.println(successText);

        assertThat("Error", successText, containsString("оформлен"));


    }

}