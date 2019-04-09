package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
    
    private Cell cell1;
    
    private Cell cell2;
    
    //TEST
    private Cell cell3;
    
    private Character character;
    
    private Item item;
    
    private static final int X_CELL = 12;
    
    private static final int Y_CELL = 8;
    
    private static final EGroundType TYPE_CELL = EGroundType.GROUND;

    
    @Before
    public void setUp() throws Exception{
        this.character = new Monkey();
        this.item = new Rhum();
        this.cell2 = new Cell(X_CELL,Y_CELL,TYPE_CELL);
        this.cell1 = new Cell();
        this.cell1.setCoordX(X_CELL);
        this.cell1.setCoordY(Y_CELL);
        this.cell1.setType(TYPE_CELL);
        this.cell1.setCharacter(character);
        this.cell1.setItem(item);
    }
    
    @Test
    public void testType() throws Exception {
        assertEquals(this.cell1.getType(), TYPE_CELL);
        assertEquals(this.cell2.getType(), TYPE_CELL);
    }
    
    @Test
    public void testCoordX() throws Exception {
        assertEquals(this.cell1.getCoordX(), X_CELL);
        assertEquals(this.cell2.getCoordX(), X_CELL);
    }
    
    @Test
    public void testCoordY() throws Exception {
        assertEquals(this.cell1.getCoordY(), Y_CELL);
        assertEquals(this.cell2.getCoordY(), Y_CELL);
    }
    
    @Test
    public void testCharacter() throws Exception {
        assertEquals(this.cell1.getCharacter(), this.character);
        assertEquals(this.cell2.getCharacter(), null);
    }
    
    @Test
    public void testItem() throws Exception {
        assertEquals(this.cell1.getItem(), this.item);
        assertEquals(this.cell2.getItem(), null);
    }

}
