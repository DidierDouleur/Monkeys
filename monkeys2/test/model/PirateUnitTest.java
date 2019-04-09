package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ GameMaster.class })
public class PirateUnitTest {

    private Monkey monkeyMock;

    private Pirate pirateTest;

    private Pirate pirateTest2;

    private GameMaster gameMasterMock;

    private Island islandMock;

    private Map mapMock;

    private Cell cellHereMock;

    private Cell cellTargetMock;

    private static final int PIRATE_X = 2;

    private static final int PIRATE_Y = 3;

    private static final int PIRATE_ID = 10;

    private static final int PIRATE_ENERGY = 35;

    private static final int TARGET_X = 1;

    private static final int TARGET_Y = 3;
    
    private static final int RHUM_ENERGY = 10;

    private static final EGroundType CELLHERE_TYPE = EGroundType.GROUND;

    @Before
    public void setUp() throws Exception {
        this.gameMasterMock = Mockito.mock(GameMaster.class);
        this.islandMock = Mockito.mock(Island.class);
        this.mapMock = Mockito.mock(Map.class);
        this.cellHereMock = Mockito.mock(Cell.class);
        this.monkeyMock = Mockito.mock(Monkey.class);
        this.cellTargetMock = Mockito.mock(Cell.class);

        PowerMockito.mockStatic(GameMaster.class);
        PowerMockito.when(GameMaster.getInstance()).thenReturn(this.gameMasterMock);
        Mockito.when(this.gameMasterMock.getIsland()).thenReturn(this.islandMock);

        Mockito.when(this.islandMock.getMap()).thenReturn(this.mapMock);

        Mockito.when(this.mapMock.getCell(PIRATE_X, PIRATE_Y)).thenReturn(this.cellHereMock);
        Mockito.when(this.mapMock.getCell(TARGET_X, TARGET_Y)).thenReturn(this.cellTargetMock);

        Mockito.when(this.cellHereMock.getType()).thenReturn(CELLHERE_TYPE);
        Mockito.when(this.cellHereMock.getCharacter()).thenReturn(null);

    }

    @Test
    public void testConstructuer() {
        this.pirateTest = new Pirate();

        this.pirateTest.setPosX(PIRATE_X);
        assertEquals(this.pirateTest.getPosX(), PIRATE_X);
        this.pirateTest.setPosY(PIRATE_Y);
        assertEquals(this.pirateTest.getPosY(), PIRATE_Y);

        this.pirateTest.setCell(cellHereMock);
        assertEquals(this.pirateTest.getCell(), cellHereMock);

        this.pirateTest.setId(PIRATE_ID);
        assertEquals(this.pirateTest.getId(), PIRATE_ID);

        this.pirateTest.setState(EPirateState.DEAD);
        assertEquals(this.pirateTest.getState(), EPirateState.DEAD);

        this.pirateTest.setEnergy(PIRATE_ENERGY);
        assertEquals(this.pirateTest.getEnergy(), PIRATE_ENERGY);

    }

    @Test
    public void testConstructuer_IntIntId() {
        this.pirateTest = new Pirate(PIRATE_X, PIRATE_Y, PIRATE_ID,PIRATE_ENERGY);

        assertEquals(this.pirateTest.getPosX(), PIRATE_X);
        assertEquals(this.pirateTest.getPosY(), PIRATE_Y);
        assertEquals(this.pirateTest.getId(), PIRATE_ID);
        assertEquals(this.pirateTest.getEnergy(), PIRATE_ENERGY);
    }

    @Test
    public void testCanAccess() {
        this.pirateTest = new Pirate();
        this.pirateTest2 = new Pirate();

        // Case Vide (char)
        Mockito.when(this.cellTargetMock.getCharacter()).thenReturn(null);

        // Terre
        Mockito.when(this.cellTargetMock.getType()).thenReturn(EGroundType.GROUND);

        assertEquals(this.pirateTest.canAccess(cellTargetMock), true);
        assertEquals(this.pirateTest.canAccess(TARGET_X, TARGET_Y), true);

        // Mer
        Mockito.when(this.cellTargetMock.getType()).thenReturn(EGroundType.WATER);

        assertEquals(this.pirateTest.canAccess(cellTargetMock), false);
        assertEquals(this.pirateTest.canAccess(TARGET_X, TARGET_Y), false);

    }

    @Test
    public void testKillPirate() {
        this.pirateTest = new Pirate(PIRATE_X, PIRATE_Y, PIRATE_ID,PIRATE_ENERGY);
        this.pirateTest.killPirate();
        
        assertEquals(this.pirateTest.getState(),EPirateState.DEAD);
    }
    
    @Test
    public void testDrinkRhum() {
        this.pirateTest = new Pirate();
        this.pirateTest.setEnergy(PIRATE_ENERGY);
        this.pirateTest.drinkRhum(RHUM_ENERGY);
        
        assertEquals(this.pirateTest.getEnergy(),PIRATE_ENERGY + RHUM_ENERGY);
    }
    
}
