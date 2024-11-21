import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTests {
    /*
    проверка на существование ингридиента
     */
    @Test
    public void enumTest() {
        Assert.assertEquals("FILLING", IngredientType.FILLING.toString());
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

}
