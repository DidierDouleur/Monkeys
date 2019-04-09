package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PirateTest2 {
    
    private Pirate pirate1;
        
    private Monkey monkey;
    
    private Map map;
    
    private Cell cell0;
    
    private Cell cell1;
    
    private Cell cell2;
    
    private Cell cell3;
    
    private Island island;
    
//    private Treasure
    
    //Pirate1
    private static final int ID_PIRATE1 = 1;
    
    private static final int X_PIRATE1 = 1;
    
    private static final int Y_PIRATE1 = 1;
    
    //Monkey  
    private static final int X_MONKEY = 0;
    
    private static final int Y_MONKEY = 1;
    
    private static final EMonkeyType TYPE_MONKEY = EMonkeyType.ERRATIC;
    
    //Map
    
    private static final int MAP_WIDTH = 1;
    
    private static final int MAP_HEIGHT = 1;
    
    //Cell 0
    private static final int X_CELL0 = 0;
    
    private static final int Y_CELL0 = 0;
    
    private static final EGroundType TYPE_CELL0 = EGroundType.WATER;
    
    //Cell 1
    private static final int X_CELL1 = 1;
    
    private static final int Y_CELL1 = 0;
    
    private static final EGroundType TYPE_CELL1 = EGroundType.GROUND;
    
    //Cell 2
    private static final int X_CELL2 = 0;
    
    private static final int Y_CELL2 = 1;
    
    private static final EGroundType TYPE_CELL2 = EGroundType.GROUND;
    
    //Cell3
    private static final int X_CELL3 = 1;
    
    private static final int Y_CELL3 = 1;
    
    private static final EGroundType TYPE_CELL3 = EGroundType.GROUND;
    
    @Before
    public void setUp() throws Exception{
        this.map = new Map(MAP_WIDTH,MAP_HEIGHT);
        this.cell0 = new Cell(X_CELL0,Y_CELL0,TYPE_CELL0);
        this.cell1 = new Cell(X_CELL1,Y_CELL1,TYPE_CELL1);
        this.cell2 = new Cell(X_CELL2,Y_CELL2,TYPE_CELL2);
        this.cell3 = new Cell(X_CELL3,Y_CELL3,TYPE_CELL3);
        ArrayList<Cell> listCell = new ArrayList<Cell>();
        listCell.add(cell0);
        listCell.add(cell1);
        listCell.add(cell2);
        listCell.add(cell3);
        this.island = new Island();
        this.island.setMap(map);
        this.map.setCells(listCell);
        GameMaster.getInstance().setIsland(island);
        this.pirate1 = new Pirate(X_PIRATE1,Y_PIRATE1,ID_PIRATE1,20);
        this.monkey = new Monkey(X_MONKEY,Y_MONKEY,TYPE_MONKEY);
    }
    
    @Test 
    public void testEmptyFailed() {
        this.pirate1 = new Pirate(-1,-1,1,10);
    }

    @Test
    public void testID() throws Exception {
        assertEquals(this.pirate1.getId(),ID_PIRATE1);
    }
    
    @Test
    public void testPosX() throws Exception {
        assertEquals(this.pirate1.getPosX(),X_PIRATE1);
    }
    
    @Test
    public void testPosY() throws Exception {
        assertEquals(this.pirate1.getPosY(),Y_PIRATE1);
    }
    
    @Test
    public void testCanAccess_EmptyGround() throws Exception {
        assertEquals(this.pirate1.canAccess(X_CELL2, Y_CELL2),true);
    }
    
    @Test
    public void testCanAccess_GroundMonkey() throws Exception {
        assertEquals(this.pirate1.canAccess(X_CELL1, Y_CELL1),true);
    }
    
    @Test
    public void testCanAccess_GroundPirate() throws Exception {
        assertEquals(this.pirate1.canAccess(X_CELL1, Y_CELL1),true);
    }
    
    @Test
    public void testCanAccess_EmptyWater() throws Exception {
        assertEquals(this.pirate1.canAccess(X_CELL0, Y_CELL0),false);
    }
    
    @Test
    public void testCanAccess_OutOfMap()throws Exception {
        assertEquals(this.pirate1.canAccess(-1, -1),false);
    }

}
