package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class IslandTest {
    
    private Island island;
    
    private Pirate pirateTest1;
    
    private Pirate pirateTest2;
    
    private ArrayList<Pirate> listPirate;

    @Before
    public void setUp() throws Exception {
        this.island = new Island();
        pirateTest1 = new Pirate();
        pirateTest1.setId(1);
        pirateTest2 = new Pirate();
        pirateTest2.setId(2);       
        listPirate = new ArrayList<Pirate>();
        listPirate.add(pirateTest2);
        listPirate.add(pirateTest1);
    }

    @Test
    public void testMap() throws Exception {
        Map map = new Map();
        this.island.setMap(map);
        assertEquals(this.island.getMap(), map);
    }

    @Test
    public void testListPirate() throws Exception {
        ArrayList<Pirate> listPirate = new ArrayList<Pirate>();
        this.island.setListPirate(listPirate);
        assertEquals(this.island.getListPirate(), listPirate);
    }

    @Test
    public void testMonkeyGroup() throws Exception {
        MonkeyGroup monkeyGroup = new MonkeyGroup();
        this.island.setMonkeyGroup(monkeyGroup);
        assertEquals(this.island.getMonkeyGroup(),monkeyGroup);
    }
    
    
    @Test
    public void testGetPirateByID_found() {
       this.island.setListPirate(listPirate);
       assertEquals(this.island.getPirateByID(2),pirateTest2);
       assertEquals(this.island.getPirateByID(1),pirateTest1);
       assertEquals(this.island.getPirateByID(12),null);
    }

}
