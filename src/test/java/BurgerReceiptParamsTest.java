import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)

public class BurgerReceiptParamsTest {

    private Bun bun = Mockito.mock(Bun.class);
    private Burger burger = new Burger();
    private Ingredient ingredient = Mockito.mock(Ingredient.class);
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private final float expectedPrice;

    public BurgerReceiptParamsTest(IngredientType ingredientType, String ingredientName, float ingredientPrice, float expectedPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] receiptData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 15f, 35f},
                {IngredientType.FILLING, "Плоды Фалленианского дерева", 2f, 22f}
        };
    }

    @Test
    public void receiptSuccessfulTest() {
        when(bun.getName()).thenReturn("Флюоресцентная булка");
        when(bun.getPrice()).thenReturn(10f);
        when(ingredient.getType()).thenReturn(ingredientType);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);
        when(ingredient.getName()).thenReturn(ingredientName);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String receipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "Флюоресцентная булка", ingredientType.toString().toLowerCase(), ingredientName, "Флюоресцентная булка", expectedPrice);

        assertEquals(expectedReceipt, receipt);
    }
}
