import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;


@RunWith(MockitoJUnitRunner.class)
public class BunTests {
/*
  тесты класса булочка
  булочке можно назначить название и цену
  булочка имеет название и цену
  можно получить название булочки
  можно получить цену булочки
*/


    @Test
    public void getNameTest() {
        String name = "black";
        float price = 100;
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name,bun.getName());
    }

    @Test
    public void getPriceTest() {
        String name = "black";
        float price = 100;
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}
