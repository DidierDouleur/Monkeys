package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonkeyTest2 {
    
    private Monkey monkey;

    @Test
    public void testConstructeurVide() {
        this.monkey = new Monkey();
    }
    
    @Test
    public void testType() throws Exception{
        this.monkey = new Monkey();
        this.monkey.setMonkeyType(EMonkeyType.ERRATIC);
        assertEquals(this.monkey.getType(),EMonkeyType.ERRATIC);
        assertEquals(this.monkey.getStrategyDeplacement().getClass(), StrategyErratic.class);
        
        this.monkey.setMonkeyType(EMonkeyType.HUNTER);
        assertEquals(this.monkey.getType(),EMonkeyType.HUNTER);
        assertEquals(this.monkey.getStrategyDeplacement().getClass(), StrategyHunting.class);
    }
    
    @Test
    public void testCanAccess_Cell() throws Exception{
        this.monkey = new Monkey();
        
        Pirate pirate = new Pirate();
        
        //Case de terre vide
        Cell cell = new Cell(0,0,EGroundType.GROUND);
        assertEquals(this.monkey.canAccess(cell), true);
        
        //Case de terre avec un pirate
        cell.setCharacter(pirate);
        assertEquals(this.monkey.canAccess(cell), true);
        
        //Case de terre avec un singe
        cell.setCharacter(this.monkey);
        assertEquals(this.monkey.canAccess(cell), false);
        
        //Case de Mer
        cell = new Cell(0,0,EGroundType.WATER);
        assertEquals(this.monkey.canAccess(cell), false);
    }
    

}
