package persistence;

import gui.Player;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersistenceServiceTest {
    static ArrayList<Player> namen = new ArrayList<>();
    static PersistenceService ps = new PersistenceService();
    @BeforeEach
    void setUp() {
        namen.add(new Player("Hans"));
        namen.add(new Player("sophie"));
    }

    @Test
    @Order(1)
    void playerSave()  {
        try {
            ps.playerSave(namen);
            assert(true);
        }catch(Exception e){
            assert(false);
        }
    }

    @Test
    @Order(2)
    void loadData() {
        try {
            ArrayList<Player> vergleiche = ps.loadData();
            assertTrue(vergleiche.get(0).equals(namen.get(0)));
            assertTrue(vergleiche.get(1).equals(namen.get(1)));
            //assertEquals(vergleiche, namen);
        }catch(Exception e){
            assert(false);
        }
    }
}