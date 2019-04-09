package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MonkeyTest3 {

    private GameMaster gameMaster;

    private Map map;

    private Monkey monkey;

    private Pirate pirate1;

    private static String ISLAND_SHAPE = "010111010";

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
        this.monkey = new Monkey(1, 1, EMonkeyType.ERRATIC);
        Monkey monkey2 = new Monkey(0, 1, EMonkeyType.ERRATIC);

        this.monkey.notifyObservers(1, 2);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 2));
        assertEquals(this.map.getCell(1, 1).getCharacter(), null);
        assertEquals(this.map.getCell(1, 2).getCharacter(), this.monkey);

        this.monkey.notifyObservers(2, 2);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 2));
        assertEquals(this.map.getCell(1, 2).getCharacter(), this.monkey);
        assertEquals(this.map.getCell(2, 2).getCharacter(), null);

        this.monkey.notifyObservers(1, 1);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 1));

        this.monkey.notifyObservers(0, 1);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 1));
        assertEquals(monkey2.getCell(), this.map.getCell(0, 1));
        assertEquals(this.monkey, this.map.getCell(1, 1).getCharacter());
        assertEquals(monkey2, this.map.getCell(0, 1).getCharacter());

        this.monkey.notifyObservers(1, 1);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 1));
        this.monkey.notifyObservers(2, 1);
        assertEquals(this.monkey.getCell(), this.map.getCell(2, 1));
        this.monkey.notifyObservers(1, 1);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 1));
        this.monkey.notifyObservers(1, 0);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 0));
    }

    @Test
    public void testMouvementWater_UPnDOWN() {
        this.monkey = new Monkey(0, 1, EMonkeyType.ERRATIC);

        // test HAUT BAS
        this.monkey.notifyObservers(0, 0);
        assertEquals(this.monkey.getCell(), this.map.getCell(0, 1));
        assertEquals(this.map.getCell(0, 0).getCharacter(), null);
        assertEquals(this.map.getCell(0, 1).getCharacter(), this.monkey);

        this.monkey.notifyObservers(0, 2);
        assertEquals(this.monkey.getCell(), this.map.getCell(0, 1));
        assertEquals(this.map.getCell(0, 2).getCharacter(), null);
        assertEquals(this.map.getCell(0, 1).getCharacter(), this.monkey);

    }

    @Test
    public void testMouvementWater_LEFTnRIGHT() {
        this.monkey = new Monkey(1, 0, EMonkeyType.ERRATIC);

        // test HAUT BAS
        this.monkey.notifyObservers(0, 0);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 0));
        assertEquals(this.map.getCell(0, 0).getCharacter(), null);
        assertEquals(this.map.getCell(1, 0).getCharacter(), this.monkey);

        this.monkey.notifyObservers(2, 0);
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 0));
        assertEquals(this.map.getCell(2, 0).getCharacter(), null);
        assertEquals(this.map.getCell(1, 0).getCharacter(), this.monkey);

    }

    @Test
    public void testMouvementVersSinge() {

        this.monkey = new Monkey(1, 1, EMonkeyType.ERRATIC);
        Monkey monkey2 = new Monkey(0, 1, EMonkeyType.ERRATIC);

        this.monkey.notifyObservers(0, 1);
        System.out.println();
        assertEquals(this.monkey.getCell(), this.map.getCell(1, 1));
        assertEquals(monkey2.getCell(), this.map.getCell(0, 1));
    }

    @Test
    public void testMouvementVersPirate() {
        this.monkey = new Monkey(1, 1, EMonkeyType.ERRATIC);
        this.monkey.setKillToUpgrade(2);
        this.monkey.setKillToDownGrade(3);
        Pirate pirate = new Pirate(0, 1, 1,20);
        this.map.printMapElements();
        this.monkey.notifyObservers(0, 1);
        

        this.map.printMapElements();
        assertEquals(this.monkey.getCell(), this.map.getCell(0, 1));
        assertEquals(this.map.getCell(0, 1).getCharacter(), this.monkey);
        assertEquals(pirate.getState(), EPirateState.DEAD);
        assertEquals(this.monkey.getType(),EMonkeyType.ERRATIC);
        assertEquals(this.monkey.getKillCount(), 1);
    }
}
