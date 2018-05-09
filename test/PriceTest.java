package pl.hachiwari.test;

import pl.hachiwari.model.Price;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {

    @Test
    public void twoPriceWithTheSameAmountAndCurrencyShouldBeEqual() {
        assertEquals(new Price(1.9, "PLN"), new Price(1.9, "PLN"));
    }

    @Test
    public void pricesWithDifferentAmountArentEqual() {
        assertNotEquals(new Price(1.1, "PLN"), new Price(1.9, "PLN"));
    }

    @Test
    public void pricesWithDifferentCurrencyArentEqual() {
        assertNotEquals(new Price(1.9, "PLN"), new Price(1.9, "USD"));
    }

    @Test
    public void pricesWithTheSameAmountShouldHaveSameHasCode() {
        assertEquals(new Price(1.9, "PLN").hashCode(), new Price(1.9, "PLN").hashCode());
    }

    @Test
    public void pricesWithDifferentAmountShouldHaveDifferentHasCode() {
        assertNotEquals(new Price(1.1, "PLN").hashCode(), new Price(1.9, "PLN").hashCode());
    }

    @Test
    public void pricesWithDifferentAmountAndTheSameCurrencyShouldBeOrdered() {
        assertEquals(-1, new Price(1.9, "PLN").compareTo(new Price(2.9, "PLN")));
    }
}