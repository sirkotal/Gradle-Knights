import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.PotionItem;

public class PotionItemTest {
    @Test
    public void potionTest() {
        PotionItem potion = new PotionItem("Holy Orange Juice", 100, 10000);
        Assertions.assertEquals("Holy Orange Juice", potion.getName());
        Assertions.assertEquals(10000, potion.getPrice());
        Assertions.assertEquals(100, potion.getValue());
    }
}