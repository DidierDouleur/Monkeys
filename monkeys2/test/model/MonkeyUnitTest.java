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
public class MonkeyUnitTest {

    private Monkey monkeyTest;

    private Monkey monkey2;

    private Pirate pirateMock;

    private GameMaster gameMasterMock;

    private Island islandMock;

    private Map mapMock;

    private Cell cellHereMock;

    private Cell cellTargetMock;

    private static final int MONKEY_X = 2;

    private static final int MONKEY_Y = 3;

    private static final int MONKEY_KC = 1;

    private static final int TARGET_X = 1;

    private static final int TARGET_Y = 3;

    private static final EGroundType CELLHERE_TYPE = EGroundType.GROUND;

    @Before
    public void setUp() throws Exception {
        this.gameMasterMock = Mockito.mock(GameMaster.class);
        this.islandMock = Mockito.mock(Island.class);
        this.mapMock = Mockito.mock(Map.class);
        this.cellHereMock = Mockito.mock(Cell.class);
        this.pirateMock = PowerMockito.mock(Pirate.class);
        this.cellTargetMock = Mockito.mock(Cell.class);

        PowerMockito.mockStatic(GameMaster.class);
        PowerMockito.when(GameMaster.getInstance()).thenReturn(this.gameMasterMock);
        Mockito.when(this.gameMasterMock.getIsland()).thenReturn(this.islandMock);

        Mockito.when(this.islandMock.getMap()).thenReturn(this.mapMock);

        Mockito.when(this.mapMock.getCell(MONKEY_X, MONKEY_Y)).thenReturn(this.cellHereMock);
        Mockito.when(this.mapMock.getCell(TARGET_X, TARGET_Y)).thenReturn(this.cellTargetMock);

        Mockito.when(this.cellHereMock.getType()).thenReturn(CELLHERE_TYPE);
        Mockito.when(this.cellHereMock.getCharacter()).thenReturn(null);

    }

    @Test
    public void testConstructeur() {
        this.monkeyTest = new Monkey();

        this.monkeyTest.setPosX(MONKEY_X);
        assertEquals(this.monkeyTest.getPosX(), MONKEY_X);
        this.monkeyTest.setPosY(MONKEY_Y);
        assertEquals(this.monkeyTest.getPosY(), MONKEY_Y);
        this.monkeyTest.setKillCount(MONKEY_KC);
        assertEquals(this.monkeyTest.getKillCount(), MONKEY_KC);
        this.monkeyTest.setCell(cellHereMock);
        assertEquals(this.monkeyTest.getCell(), cellHereMock);

        this.monkeyTest.setMonkeyType(EMonkeyType.ERRATIC);
        assertEquals(this.monkeyTest.getType(), EMonkeyType.ERRATIC);
        assertEquals(this.monkeyTest.getStrategyDeplacement().getClass(), StrategyErratic.class);

    }

    @Test
    public void testConstructeur_Int_Int_EMonkeyType() {
        this.monkeyTest = new Monkey(this.MONKEY_X, this.MONKEY_Y, EMonkeyType.ERRATIC);
        assertEquals(this.monkeyTest.getPosX(), MONKEY_X);
        assertEquals(this.monkeyTest.getPosY(), MONKEY_Y);
        assertEquals(this.monkeyTest.getType(), EMonkeyType.ERRATIC);
        assertEquals(this.monkeyTest.getKillCount(), 0);
        assertEquals(this.monkeyTest.getStrategyDeplacement().getClass(), StrategyErratic.class);
    }

    @Test
    public void testCanAccess() throws Exception {
        this.monkeyTest = new Monkey();
        this.monkey2 = new Monkey();

        // Case Vide (char)
        Mockito.when(this.cellTargetMock.getCharacter()).thenReturn(null);

        // Terre
        Mockito.when(this.cellTargetMock.getType()).thenReturn(EGroundType.GROUND);

        assertEquals(this.monkeyTest.canAccess(cellTargetMock), true);
        assertEquals(this.monkeyTest.canAccess(TARGET_X, TARGET_Y), true);

        // Mer
        Mockito.when(this.cellTargetMock.getType()).thenReturn(EGroundType.WATER);

        assertEquals(this.monkeyTest.canAccess(cellTargetMock), false);
        assertEquals(this.monkeyTest.canAccess(TARGET_X, TARGET_Y), false);

        // Case avec singe
        Mockito.when(this.cellTargetMock.getCharacter()).thenReturn(this.monkey2);
        Mockito.when(this.cellTargetMock.getType()).thenReturn(EGroundType.GROUND);

        assertEquals(this.monkeyTest.canAccess(cellTargetMock), false);
        assertEquals(this.monkeyTest.canAccess(TARGET_X, TARGET_Y), false);


    }

}
