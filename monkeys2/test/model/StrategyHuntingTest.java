package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StrategyHuntingTest {

    
    
 private GameMaster gameMaster;
    
    private Map map;
    
    private Monkey monkey;
    
    private Island island;
    
    private static final int monkeyX = 2;
    
    private static final int monkeyY = 5;
    
    private Pirate pirate1;
    
    private Pirate pirate2;
    
    private static final int pirate1X = 6;

    private static final int pirate1Y = 5;
    
    private static final int pirate1Energy = 20;
    
    private static final int pirate2X = 2;
    
    private static final int pirate2Y = 2;
    
    private static final int pirate2Energy = 20;

    private static String ISLAND_SHAPE = ""
            + "0000000000"  //0
            + "0111111110"
            + "0111111110"
            + "0111011110"//
            + "0111011110" //4
            + "0111011110"
            + "0111011110"
            + "0111111110"
            + "0111111110"
            + "0000000000";
    
    
//    + "0 0 0 0 0 0 0 0 0 0"  
//    + "0 1 1 1 1 1 1 1 1 0"
//    + "0 1 P 1 1 1 1 1 1 0"   //Pirate 2 lorsqu'il est la (1,2)
//    + "0 1 1 1 0 1 1 1 1 0"
//    + "0 1 1 1 0 1 1 1 1 0"
//    + "0 1 M 1 0 1 P 1 1 0"   //Pirate 1 lorsqu'il est la (6,5)
//    + "0 1 1 1 0 1 1 1 1 0"
//    + "0 1 1 1 0 1 1 1 1 0"
//    + "0 1 1 1 1 1 1 1 1 0"
//    + "0 1 1 1 1 1 1 1 1 0";
    
    private static int WIDTH = 9;

    private static int HEIGHT = 9;

    @Before
    public void setUp() {
        this.gameMaster = GameMaster.getInstance();
        this.map = new Map();
        
        this.map.setSizeX(WIDTH);
        this.map.setSizeY(HEIGHT);
        this.map.createMap(ISLAND_SHAPE);
        this.island = new Island();
        this.gameMaster.setConfig(new Config());
        this.gameMaster.setIsland(this.island);
        this.island.setMap(map);
    }

    
    @Test
    public void testMapSansPirate() {
        this.monkey = new Monkey(monkeyX,monkeyY,EMonkeyType.HUNTER);
        StrategyHunting strat = (StrategyHunting)this.monkey.getStrategyDeplacement();
        assertEquals(strat.generateDirection(),null);
    }
    
    
    @Test
    public void test1Pirate() {
        this.monkey = new Monkey(monkeyX,monkeyY,EMonkeyType.HUNTER);
        this.pirate2 = new Pirate(pirate2X,pirate2Y,2,pirate2Energy);
        ArrayList<Pirate> listPirate = new ArrayList<Pirate>();
        listPirate.add(pirate2);
        this.island.setListPirate(listPirate);
        StrategyHunting strat = (StrategyHunting)this.monkey.getStrategyDeplacement();
        
        assertEquals(strat.generateDirection(),EDirection.UP);
    }
    
    @Test
    public void test1PirateDEAD() {
        this.monkey = new Monkey(monkeyX,monkeyY,EMonkeyType.HUNTER);
        this.pirate2 = new Pirate(pirate2X,pirate2Y,2,pirate2Energy);
        this.pirate2.setState(EPirateState.DEAD);
        ArrayList<Pirate> listPirate = new ArrayList<Pirate>();
        listPirate.add(pirate2);
        this.island.setListPirate(listPirate);
        StrategyHunting strat = (StrategyHunting)this.monkey.getStrategyDeplacement();
        
        assertEquals(strat.generateDirection(),null);
    }
    
    
    @Test
    public void test1Pirate2() {
        this.monkey = new Monkey(monkeyX,monkeyY,EMonkeyType.HUNTER);
        this.pirate1 = new Pirate(pirate1X,pirate1Y,1,pirate1Energy);
        ArrayList<Pirate> listPirate = new ArrayList<Pirate>();
        listPirate.add(pirate1);
        this.island.setListPirate(listPirate);
        StrategyHunting strat = (StrategyHunting)this.monkey.getStrategyDeplacement();
        assertEquals(strat.generateDirection(),EDirection.RIGHT);
    }
    
    @Test
    public void test2Pirate() {
        this.monkey = new Monkey(monkeyX,monkeyY,EMonkeyType.HUNTER);
        this.pirate1 = new Pirate(pirate1X,pirate1Y,1,pirate1Energy);
        this.pirate2 = new Pirate(pirate2X,pirate2Y,2,pirate2Energy);
        ArrayList<Pirate> listPirate = new ArrayList<Pirate>();
        listPirate.add(pirate1);
        listPirate.add(pirate2);
        this.island.setListPirate(listPirate);
        StrategyHunting strat = (StrategyHunting)this.monkey.getStrategyDeplacement();
        assertEquals(strat.generateDirection(),EDirection.UP);
    }

}
