import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.PotionItem;

public class PotionItemTest {
    @Test
    public void setUsed() {
        PotionItem potion = new PotionItem("Holy Orange Juice", 100, 10000);
        Assertions.assertEquals("potion", potion.getType());
        Assertions.assertEquals(10000, potion.getPrice());
        Assertions.assertEquals(100, potion.getValue());
        potion.setUsed();
        Assertions.assertEquals(true, potion.isEquipped());
    }
}