package model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PirateParamTest {

    private GameMaster gameMaster;

    private Map map;

    private Monkey monkey;

    private Pirate pirate;

    private Pirate pirate2;

    private Treasure treasure;

    private Rhum rhum;

    private int mapX;

    private int mapY;;
    private String mapOrganisation;

    private int pirateOriginX;
    private int pirateOriginY;
    private int pirateOriginID;
    private EPirateState pirateOriginState;
    private int pirateOriginEnergy;

    private int pirate2OriginX;
    private int pirate2OriginY;
    private int pirate2OriginID;
    private EPirateState pirate2OriginState;
    private int pirate2OriginEnergy;

    private int rhumX;
    private int rhumY;
    private int rhumEnergy;
    private boolean rhumOriginVisible;

    private int monkeyOriginX;
    private int monkeyOriginY;
    private EMonkeyType monkeyOriginType;
    private int monkeyOriginKillCount;
    private int monkeyKillToUpgrade;
    private int monkeyKillToDowngrade;

    private int treasureX;
    private int treasureY;
    private boolean treasureVisible;

    private int targetX;
    private int targetY;

    private int pirateEndX;
    private int pirateEndY;
    private EPirateState pirateEndState;
    private int pirateEndEnergy;

    private boolean rhumEndVisible;

    private EMonkeyType monkeyEndType;
    private int monkeyEndKillCount;

    private boolean treasureEndVisible;
    private boolean gameEndState;

    public PirateParamTest(int mapX, int mapY, String mapOrganisation, int pirateOriginX,
            int pirateOriginY, int pirateOriginID, EPirateState pirateOriginState,
            int pirateOriginEnergy, int pirate2OriginX, int pirate2OriginY, int pirate2OriginID,
            EPirateState pirate2OriginState, int pirate2OriginEnergy, int rhumX, int rhumY,
            int rhumEnergy, boolean rhumOriginVisible, int monkeyOriginX, int monkeyOriginY,
            EMonkeyType monkeyOriginType, int monkeyOriginKillCount, int monkeyKillToUpgrade,
            int monkeyKillToDowngrade, int treasureX, int treasureY, boolean treasureVisible,
            int targetX, int targetY, int pirateEndX, int pirateEndY, EPirateState pirateEndState,
            int pirateEndEnergy, boolean rhumEndVisible, EMonkeyType monkeyEndType,
            int monkeyEndKillCount, boolean treasureEndVisible, boolean gameEndState) {
        this.mapX = mapX;
        this.mapY = mapY;
        this.mapOrganisation = mapOrganisation;
        this.pirateOriginX = pirateOriginX;
        this.pirateOriginY = pirateOriginY;
        this.pirateOriginID = pirateOriginID;
        this.pirateOriginState = pirateOriginState;
        this.pirateOriginEnergy = pirateOriginEnergy;
        this.pirate2OriginX = pirate2OriginX;
        this.pirate2OriginY = pirate2OriginY;
        this.pirate2OriginID = pirate2OriginID;
        this.pirate2OriginState = pirate2OriginState;
        this.pirate2OriginEnergy = pirate2OriginEnergy;
        this.rhumX = rhumX;
        this.rhumY = rhumY;
        this.rhumEnergy = rhumEnergy;
        this.rhumOriginVisible = rhumOriginVisible;
        this.monkeyOriginX = monkeyOriginX;
        this.monkeyOriginY = monkeyOriginY;
        this.monkeyOriginType = monkeyOriginType;
        this.monkeyOriginKillCount = monkeyOriginKillCount;
        this.monkeyKillToUpgrade = monkeyKillToUpgrade;
        this.monkeyKillToDowngrade = monkeyKillToDowngrade;
        this.treasureX = treasureX;
        this.treasureY = treasureY;
        this.treasureVisible = treasureVisible;
        this.targetX = targetX;
        this.targetY = targetY;
        this.pirateEndX = pirateEndX;
        this.pirateEndY = pirateEndY;
        this.pirateEndState = pirateEndState;
        this.pirateEndEnergy = pirateEndEnergy;
        this.rhumEndVisible = rhumEndVisible;
        this.monkeyEndType = monkeyEndType;
        this.monkeyEndKillCount = monkeyEndKillCount;
        this.treasureEndVisible = treasureEndVisible;
        this.gameEndState = gameEndState;
    }

    @Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}, {19}, {20}, {21}, {22}, {23}, {24}, {25}, {26}, {27}, {28}, {29}, {30}, {31}, {32}, {33},{34}, {35}")
    //
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {

                { 2, 2, "101010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0,
                        1, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 2,
                        1, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 0, 1,
                        1, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 2, 1,
                        1, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0,
                        1, 0, EPirateState.ALIVE, 9, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101010010", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 2,
                        1, 2, EPirateState.ALIVE, 9, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101110000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 0, 1,
                        0, 1, EPirateState.ALIVE, 9, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101011000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 2, 1,
                        2, 1, EPirateState.ALIVE, 9, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101010001", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 2, 2,
                        1, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111000000", 1, 0, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, -1,
                        1, 0, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101100000", 0, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, -1, 1,
                        0, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101001000", 2, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 3, 1,
                        2, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101000010", 1, 2, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 3,
                        1, 2, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111100000", 0, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 1, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 0, 0,
                        0, 0, EPirateState.ALIVE, 9, false, EMonkeyType.ERRATIC, 0, true, false },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.DEAD, 10, 2, 0, 2, EPirateState.DEAD, 10,
                        2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0, 1,
                        1, EPirateState.DEAD, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 1, 0, 10, true, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0,
                        1, 0, EPirateState.ALIVE, 19, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 1, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0,
                        1, 0, EPirateState.ALIVE, 9, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 1, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0,
                        1, 0, EPirateState.DEAD, 9, false, EMonkeyType.ERRATIC, 1, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 1, 0, EMonkeyType.ERRATIC, 1, 2, 4, 0, 0, false, 1, 0,
                        1, 0, EPirateState.DEAD, 9, false, EMonkeyType.HUNTER, 2, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 1, 0, EMonkeyType.HUNTER, 2, 2, 4, 0, 0, false, 1, 0,
                        1, 0, EPirateState.DEAD, 9, false, EMonkeyType.HUNTER, 3, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 1, 0, EMonkeyType.HUNTER, 3, 2, 4, 0, 0, false, 1, 0,
                        1, 0, EPirateState.DEAD, 9, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "101100000", 0, 1, 1, EPirateState.ALIVE, 10, 2, 0, 2, EPirateState.DEAD,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 0, 0,
                        0, 0, EPirateState.DEAD, 9, false, EMonkeyType.ERRATIC, 1, true, false },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 1, 2, 0, 2, EPirateState.DEAD, 10,
                        2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0, 1,
                        0, EPirateState.DEAD, 0, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 1, 2, 0, 2, EPirateState.DEAD, 10,
                        1, 0, 10, true, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0, 1, 0,
                        EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },
                { 2, 2, "111010000", 1, 1, 1, EPirateState.ALIVE, 10, 1, 0, 2, EPirateState.ALIVE,
                        10, 2, 0, 10, false, 0, 0, EMonkeyType.ERRATIC, 0, 2, 4, 0, 0, false, 1, 0,
                        1, 1, EPirateState.ALIVE, 10, false, EMonkeyType.ERRATIC, 0, false, true },

        };
        return Arrays.asList(data);
    }

    @Test
    public void testParametrized() {
        this.gameMaster = GameMaster.getInstance();
        this.gameMaster.setRunning(true);
        Island island = new Island();
        this.gameMaster.setIsland(island);
        this.gameMaster.setRunning(true);
        this.map = new Map(this.mapX, this.mapY);
        this.map.createMap(this.mapOrganisation);
        island.setMap(map);

        this.treasure = Treasure.getInstance(treasureX, treasureY);
        this.treasure.setVisible(treasureVisible);
        this.map.getCell(treasureX, treasureY).setItem(treasure);

        this.pirate = new Pirate(this.pirateOriginX, this.pirateOriginY, this.pirateOriginID,
                this.pirateOriginEnergy);
        this.pirate.setState(this.pirateOriginState);

        this.pirate2 = new Pirate(this.pirate2OriginX, this.pirate2OriginY, this.pirate2OriginID,
                this.pirate2OriginEnergy);
        this.pirate2.setState(this.pirate2OriginState);

        this.rhum = new Rhum(this.rhumX, this.rhumY, this.rhumEnergy, 20);
        this.rhum.setVisible(this.rhumOriginVisible);

        this.monkey = new Monkey(this.monkeyOriginX, this.monkeyOriginY, this.monkeyOriginType);
        this.monkey.setKillToDownGrade(this.monkeyKillToDowngrade);
        this.monkey.setKillToUpgrade(this.monkeyKillToUpgrade);
        this.monkey.setKillCount(this.monkeyOriginKillCount);

        this.pirate.notifyObservers(this.targetX, this.targetY);

        assertEquals(this.pirate.getPosX(), this.pirateEndX);
        assertEquals(this.pirate.getPosY(), this.pirateEndY);
        assertEquals(this.pirate.getEnergy(), this.pirateEndEnergy);
        assertEquals(this.pirate.getState(), this.pirateEndState);
        assertEquals(this.pirate.getId(), this.pirateOriginID);

        assertEquals(this.pirate2.getPosX(), this.pirate2OriginX);
        assertEquals(this.pirate2.getPosY(), this.pirate2OriginY);
        assertEquals(this.pirate2.getEnergy(), this.pirate2OriginEnergy);
        assertEquals(this.pirate2.getState(), this.pirate2OriginState);
        assertEquals(this.pirate2.getId(), this.pirate2OriginID);

        assertEquals(this.monkey.getPosX(), this.monkeyOriginX);
        assertEquals(this.monkey.getPosY(), this.monkeyOriginY);
        assertEquals(this.monkey.getKillCount(), this.monkeyEndKillCount);
        assertEquals(this.monkey.getType(), this.monkeyEndType);

        assertEquals(this.rhum.getPosX(), this.rhumX);
        assertEquals(this.rhum.getPosY(), this.rhumY);
        assertEquals(this.rhum.getEnergy(), this.rhumEnergy);
        assertEquals(this.rhum.getVisible(), this.rhumEndVisible);

        assertEquals(this.treasure.getPosX(), this.treasureX);
        assertEquals(this.treasure.getPosY(), this.treasureY);
        assertEquals(this.treasure.getVisible(), this.treasureEndVisible);

        assertEquals(this.gameMaster.isRunning(), this.gameEndState);
    }
}
