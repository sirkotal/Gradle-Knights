import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.CombatItem;

public class CombatItemTest {
    @Test
    public void swordTest() {
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        Assertions.assertEquals("Excalibur", sword.getName());
        Assertions.assertEquals(5000, sword.getPrice());
        Assertions.assertEquals(100, sword.getValue());
        sword.setUsed();
        Assertions.assertEquals(true, sword.isEquipped());
    }
}

