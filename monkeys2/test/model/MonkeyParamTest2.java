package model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MonkeyParamTest2 {

    private GameMaster gameMaster;

    private Map map;

    private Monkey monkey;

    private Pirate pirate;

    private Monkey monkey2;

    private static String ISLAND_SHAPE = "010111010";

    private int monkeyXOrigin;
    private int monkeyYOrigin;
    private EMonkeyType monkeyTypeOrigin;
    private int monkeyKcOrigin;

    private int monkeyXOrigin2;
    private int monkeyYOrigin2;
    private EMonkeyType monkeyTypeOrigin2;
    private int monkeyKcOrigin2;

    private int pirateXOrigin;
    private int pirateYOrigin;
    private int pirateIdOrigin;
    private EPirateState pirateStateOrigin;

    private int targetX;
    private int targetY;

    private int monkeyXEnd;
    private int monkeyYEnd;
    private EMonkeyType monkeyTypeEnd;
    private int monkeyKcEnd;

    private EPirateState pirateStateEnd;

    @Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}")
    //
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {
                //DPLCMT SUR TERRE
                { 1, 1, EMonkeyType.ERRATIC, 0, 0, 1, EMonkeyType.ERRATIC, 0, 2, 1, 1,
                        EPirateState.ALIVE, 1, 0, 1, 0, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },
                { 1, 1, EMonkeyType.ERRATIC, 0, 0, 1, EMonkeyType.ERRATIC, 0, 2, 1, 1,
                        EPirateState.ALIVE, 1, 2, 1, 2, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },
                { 1, 1, EMonkeyType.ERRATIC, 0, 1, 0, EMonkeyType.ERRATIC, 0, 1, 2, 1,
                        EPirateState.ALIVE, 0, 1, 0, 1, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },
                { 1, 1, EMonkeyType.ERRATIC, 0, 1, 0, EMonkeyType.ERRATIC, 0, 1, 2, 1,
                        EPirateState.ALIVE, 2, 1, 2, 1, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },

                //DPLCMT VERS EAU
                { 0, 1, EMonkeyType.ERRATIC, 0, 1, 1, EMonkeyType.ERRATIC, 0, 1, 0, 1,
                        EPirateState.ALIVE, 0, 0, 0, 1, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },
                { 0, 1, EMonkeyType.ERRATIC, 0, 1, 1, EMonkeyType.ERRATIC, 0, 1, 0, 1,
                        EPirateState.ALIVE, 0, 2, 0, 1, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },
                { 1, 0, EMonkeyType.ERRATIC, 0, 1, 1, EMonkeyType.ERRATIC, 0, 0, 1, 1,
                        EPirateState.ALIVE, 0, 0, 1, 0, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },
                { 1, 0, EMonkeyType.ERRATIC, 0, 1, 1, EMonkeyType.ERRATIC, 0, 0, 1, 1,
                        EPirateState.ALIVE, 2, 2, 1, 0, EMonkeyType.ERRATIC, 0,
                        EPirateState.ALIVE },

                //DPLCMT HORS DE MAP
                { 0, 1, EMonkeyType.ERRATIC, 0, 1, 1, EMonkeyType.ERRATIC, 0, 1, 0, 1,
                            EPirateState.ALIVE, -1, -1, 0, 1, EMonkeyType.ERRATIC, 0,
                            EPirateState.ALIVE },
                
                
                //INTERACTION AUTRE PESONNAGES
                { 1, 1, EMonkeyType.ERRATIC, 0, 0, 1, EMonkeyType.ERRATIC, 0, 1, 0, 1,
                        EPirateState.ALIVE, 1, 0, 1, 0, EMonkeyType.ERRATIC, 1, EPirateState.DEAD },
                
                { 1, 1, EMonkeyType.ERRATIC, 2, 0, 1, EMonkeyType.ERRATIC, 0, 1, 0, 1,
                        EPirateState.ALIVE, 1, 0, 1, 0, EMonkeyType.HUNTER, 3, EPirateState.DEAD },
                
                { 1, 1, EMonkeyType.HUNTER, 3, 0, 1, EMonkeyType.ERRATIC, 0, 1, 0, 1,
                        EPirateState.ALIVE, 1, 0, 1, 0, EMonkeyType.HUNTER, 4, EPirateState.DEAD },
                
                { 1, 1, EMonkeyType.HUNTER, 4, 0, 1, EMonkeyType.ERRATIC, 0, 1, 0, 1,
                        EPirateState.ALIVE, 1, 0, 1, 0, EMonkeyType.ERRATIC, 0, EPirateState.DEAD }

        };
        return Arrays.asList(data);
    }


    public MonkeyParamTest2(int monkeyXOrigin, int monkeYOrigin, EMonkeyType monkeyTypeOrigin,
            int monkeyKcOrigin, int monkeyXOrigin2, int monkeyYOrigin2,
            EMonkeyType monkeyTypeOrigin2, int monkeyKcOrigin2, int pirateXOrigin,
            int pirateYOrigin, int pirateIdOrigin, EPirateState pirateStateOrigin, int targetX,
            int targetY, int monkeyXEnd, int monkeYEnd, EMonkeyType monkeyTypeEnd, int monkeyKcEnd,
            EPirateState pirateStateEnd) throws Exception {
//        super();
        this.monkeyXOrigin = monkeyXOrigin;
        this.monkeyYOrigin = monkeYOrigin;
        this.monkeyTypeOrigin = monkeyTypeOrigin;
        this.monkeyKcOrigin = monkeyKcOrigin;
        
        this.monkeyXOrigin2 = monkeyXOrigin2;
        this.monkeyYOrigin2 = monkeyYOrigin2;
        this.monkeyTypeOrigin2 = monkeyTypeOrigin2;
        this.monkeyKcOrigin2 = monkeyKcOrigin2;
        
        this.pirateXOrigin = pirateXOrigin;
        this.pirateYOrigin = pirateYOrigin;
        this.pirateIdOrigin = pirateIdOrigin;
        this.pirateStateOrigin = pirateStateOrigin;
        
        this.targetX = targetX;
        this.targetY = targetY;
        
        this.monkeyXEnd = monkeyXEnd;
        this.monkeyYEnd = monkeYEnd;
        this.monkeyTypeEnd = monkeyTypeEnd;
        this.monkeyKcEnd = monkeyKcEnd;
        this.pirateStateEnd = pirateStateEnd;
    }

    @Test
    public void testParametrized() throws Exception {
        this.gameMaster = GameMaster.getInstance();
        this.map = new Map();

        this.map.setSizeX(2);
        this.map.setSizeY(2);
        this.map.createMap(ISLAND_SHAPE);
        this.gameMaster.setConfig(new Config());
        this.gameMaster.setIsland(new Island());
        this.gameMaster.getIsland().setMap(map);
        

        this.monkey = new Monkey(this.monkeyXOrigin, this.monkeyYOrigin, this.monkeyTypeOrigin);
        this.monkey.setKillCount(this.monkeyKcOrigin);

        this.monkey.setKillToUpgrade(3);
        this.monkey.setKillToDownGrade(5);
        
        this.monkey2 = new Monkey(this.monkeyXOrigin2, this.monkeyYOrigin2, this.monkeyTypeOrigin2);
        this.monkey2.setKillCount(monkeyKcOrigin2);
        
        this.pirate = new Pirate(this.pirateXOrigin, this.pirateYOrigin, this.pirateIdOrigin,20);
        this.pirate.setState(pirateStateOrigin);
        
        this.monkey.notifyObservers(targetX, targetY);

        assertEquals(this.monkey.getPosX(), this.monkeyXEnd);
        assertEquals(this.monkey.getPosY(), this.monkeyYEnd);
        assertEquals(this.monkey.getCell(), this.map.getCell(this.monkeyXEnd, this.monkeyYEnd));
        assertEquals(this.monkey.getKillCount(),this.monkeyKcEnd);
        assertEquals(this.monkey.getType(),this.monkeyTypeEnd);
        
        assertEquals(this.pirate.getId(),this.pirateIdOrigin);
        assertEquals(this.pirate.getPosX(),this.pirateXOrigin);
        assertEquals(this.pirate.getPosY(),this.pirateYOrigin);
        assertEquals(this.pirate.getState(),this.pirateStateEnd);
        
        assertEquals(this.monkey2.getPosX(), this.monkeyXOrigin2);
        assertEquals(this.monkey2.getPosY(), this.monkeyYOrigin2);
        assertEquals(this.monkey2.getCell(), this.map.getCell(this.monkeyXOrigin2, this.monkeyYOrigin2));
        assertEquals(this.monkey2.getKillCount(),this.monkeyKcOrigin2);
        assertEquals(this.monkey2.getType(),this.monkeyTypeOrigin2);   
    }

    ///////////////////////////////////////////


}
