import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    /*
    Тесты класса Burger:
    1. В бургере можно выбрать булочку
    2. Ингридиент можно добавить
    3. Ингридиент можно переместить
    4. Ингридиент можно удалить
    5. Можно получить стоимость бургера
    6. Можно получить чек с инфо о бургере
     */

    public String name;
    public float price;
    public IngredientType type;

    @Mock
    public Ingredient ingredient;
    @Mock
    public Ingredient secondIngredient;
    public Bun bun;

    @Before
    public void setData() {
        name = "chicken";
        price = 10;
        type = IngredientType.FILLING;
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        bun = new Bun(name+"bun", price);
        burger.setBuns(bun);
        Assert.assertEquals(name+"bun",burger.bun.getName());
        Assert.assertEquals(price,burger.bun.getPrice(),0);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient,burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient,burger.ingredients.get(0));
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient,burger.ingredients.get(0));
        burger.addIngredient(secondIngredient);
        Assert.assertEquals(secondIngredient,burger.ingredients.get(1));
        burger.moveIngredient(1,0);
        Assert.assertEquals(secondIngredient,burger.ingredients.get(0));
        Assert.assertEquals(ingredient,burger.ingredients.get(1));

    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Mockito.when(secondIngredient.getPrice()).thenReturn(price+10);
        burger.setBuns(new Bun(name, price));
        Assert.assertEquals(name,burger.bun.getName());
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient,burger.ingredients.get(0));
        burger.addIngredient(secondIngredient);
        Assert.assertEquals(secondIngredient,burger.ingredients.get(1));
        float expectedPrice = price*4+10;
        Assert.assertEquals(expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun(name, price));
        Mockito.when(ingredient.getName()).thenReturn(name);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Mockito.when(secondIngredient.getName()).thenReturn(name+"roll");
        Mockito.when(secondIngredient.getType()).thenReturn(type);
        Mockito.when(secondIngredient.getPrice()).thenReturn(price+10);
        Assert.assertEquals(name,burger.bun.getName());
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient,burger.ingredients.get(0));
        burger.addIngredient(secondIngredient);
        Assert.assertEquals(secondIngredient,burger.ingredients.get(1));
        String expectedReceipt =
                String.format("(==== %s ====)%n", name) +
                String.format("= %s %s =%n",ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("= %s %s =%n",secondIngredient.getType().toString().toLowerCase(), secondIngredient.getName()) +
                String.format("(==== %s ====)%n",name) +
                String.format("%n") +
                String.format("Price: %f%n",price*4+10);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
