package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PirateTest3 {

    private GameMaster gameMaster;

    private Map map;

    private Monkey monkey;

    private Pirate pirate;

    private static String ISLAND_SHAPE = "010111010";
    
    private static int ENERGY_PIRATE = 50;

    @Before
    public void setUp() {
        this.gameMaster = GameMaster.getInstance();
        this.map = new Map();

        this.map.setSizeX(2);
        this.map.setSizeY(2);
        this.map.createMap(ISLAND_SHAPE);
        this.gameMaster.setConfig(new Config());
        this.gameMaster.setIsland(new Island());
        this.gameMaster.getIsland().setMap(map);
    }

    @Test
    public void testMouvement4Directon() {
        this.pirate = new Pirate(1, 1, 1,ENERGY_PIRATE);
        assertEquals(this.pirate.getCell(), this.map.getCell(1, 1));
        
        this.pirate.notifyObservers(0, 1);
        assertEquals(this.pirate.getCell(), this.map.getCell(0, 1));
        assertEquals(this.map.getCell(1,1).getCharacter(),null);
        assertEquals(this.pirate.getEnergy(),ENERGY_PIRATE-1);
        assertEquals(this.pirate.getState(),EPirateState.ALIVE);
        
        this.pirate.notifyObservers(1, 1);
        assertEquals(this.pirate.getCell(), this.map.getCell(1, 1));
        assertEquals(this.map.getCell(1,1).getCharacter(),this.pirate);
        assertEquals(this.map.getCell(0,1).getCharacter(),null);
        assertEquals(this.pirate.getState(),EPirateState.ALIVE);
        assertEquals(this.pirate.getEnergy(),ENERGY_PIRATE-2);
    }
}
