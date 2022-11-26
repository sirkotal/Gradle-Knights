import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.Item;
import pt.up.fe.ldts.gd.Shop;


import java.util.Arrays;

public class ShopTest {
    @Test
    public void shopTesting(){
        Shop shop = new Shop();
        Item item = new Item();
        for (int i = 0; i<2; i++){
            shop.addItem(item);}
        Assertions.assertEquals(2,shop.getItems().size());
        shop.removeItem(item);
        Assertions.assertEquals(1,shop.getItems().size());
    }
}
