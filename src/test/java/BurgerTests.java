import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    @Test
    public void successfulSetBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientSuccessfulTest() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientSuccessfulTest() {
        Burger burger = new Burger();
        Ingredient differentIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(differentIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(differentIngredient, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientSuccessfulTest() {
        Burger burger = new Burger();
        Ingredient differenIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(differenIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(differenIngredient, burger.ingredients.get(0));
    }

}
