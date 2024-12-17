import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTests {
    String ingredientTypeStr;
    IngredientType ingredientType;

    public IngredientTypeTests(String ingredientTypeStr, IngredientType ingredientType) {
        this.ingredientTypeStr = ingredientTypeStr;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {"FILLING", IngredientType.FILLING},
                {"SAUCE", IngredientType.SAUCE}
        };
    }

    /*
    проверка на существование ингридиента
     */
    @Test
    public void enumTest() {
        Assert.assertEquals(ingredientTypeStr, ingredientType.toString());
    }

}
