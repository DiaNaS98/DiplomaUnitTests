import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)

public class BurgerPriceParamsTest {
    private final float bunPrice;
    private final List<Float> ingredientPrices;
    private final float expectedPrice;

    public BurgerPriceParamsTest(float price, List<Float> ingredientPrices, float expectedPrice) {
        this.bunPrice = price;
        this.ingredientPrices = ingredientPrices;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] priceData() {
        return new Object[][]{
                {10f, List.of(4f, 6f), 30f},
                {10f, List.of(20f, 30f), 70f},
                {20f, List.of(), 40}}; }

    @Test
    public void getPriceSuccessfulTest() {
        Burger burger = new Burger();
        Bun mockBun = Mockito.mock(Bun.class);
        when(mockBun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(mockBun);
        for (float price : ingredientPrices) {
            Ingredient mockIngredient = Mockito.mock(Ingredient.class);
            when(mockIngredient.getPrice()).thenReturn(price);
            burger.addIngredient(mockIngredient);
        }

        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }
}

