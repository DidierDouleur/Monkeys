package model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StartegyErraticParamTest {

    private StrategyDeplacement strategyDeplacement;

    private Monkey monkeyMock;

    private Monkey monkey2;

    private Map mapMock;

    private GameMaster gameMasterMock;

    private Island islandMock;

    public StartegyErraticParamTest(int mapX, int mapY, String mapOrganisation, int monkeyX,
            int monkeyY, double resNull, double resUp, double resDown, double resLeft,
            double resRight, double delta, int monkey2x, int monkey2y, int testNbr) {
//        super();
//        this.strategyDeplacement = strategyDeplacement;
//        this.monkeyMock = monkeyMock;
//        this.monkey2 = monkey2;
//        this.mapMock = mapMock;
//        this.gameMasterMock = gameMasterMock;
//        this.islandMock = islandMock;
        this.mapX = mapX;
        this.mapY = mapY;
        this.mapOrganisation = mapOrganisation;
        this.monkeyX = monkeyX;
        this.monkeyY = monkeyY;
        this.resNull = resNull;
        this.resUp = resUp;
        this.resDown = resDown;
        this.resLeft = resLeft;
        this.resRight = resRight;
        this.delta = delta;
        monkey2X = monkey2x;
        monkey2Y = monkey2y;
        this.testNbr = testNbr;
    }

    private int mapX;
    private int mapY;
    private String mapOrganisation;
    private int monkeyX;
    private int monkeyY;
    private double resNull;
    private double resUp;
    private double resDown;
    private double resLeft;
    private double resRight;

    private double delta;
    private int monkey2X;
    private int monkey2Y;
    private double testNbr;

    @Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}")
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {

                { 2, 2, "110010000", 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1000 },
                { 2, 2, "100110000", 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1000 },
                { 2, 2, "100011000", 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1000 },
                { 2, 2, "100010010", 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1000 },

                { 2, 2, "110110000", 1, 1, 0, 0.5, 0, 0.5, 0, 0.2, 0, 0, 1000 },
                { 2, 2, "100011010", 1, 1, 0, 0, 0.5, 0, 0.5, 0.2, 0, 0, 1000 },
                { 2, 2, "110010010", 1, 1, 0, 0.5, 0.5, 0, 0, 0.2, 0, 0, 1000 },
                { 2, 2, "100111000", 1, 1, 0, 0, 0, 0.5, 0.5, 0.2, 0, 0, 1000 },

                { 2, 2, "010110000", 1, 1, 0, 0, 0, 1, 0, 0.2, 1, 0, 1000 },
                { 2, 2, "000011010", 1, 1, 0, 0, 1, 0, 0, 0.2, 2, 1, 1000 },
                { 2, 2, "010010010", 1, 1, 0, 0, 1, 0, 0, 0.2, 1, 0, 1000 },
                { 2, 2, "000111000", 1, 1, 0, 0, 0, 1, 0, 0.2, 2, 1, 1000 },
                { 2, 2, "110111010", 1, 1, 0, 0.25, 0.25, 0.25, 0.25, 0.5, 0, 0, 10000 },
                { 0, 0, "1", 0, 0, 1, 0, 0, 0, 0, 0, 12, 12, 10000 },

        };
        return Arrays.asList(data);
    }

    @Test
    public void testParametrized() throws Exception {

        this.gameMasterMock = GameMaster.getInstance();
        this.islandMock = new Island();
        this.mapMock = new Map(this.mapX, mapY);
        this.mapMock.createMap(this.mapOrganisation);

        this.gameMasterMock.setIsland(this.islandMock);
        this.islandMock.setMap(this.mapMock);
        this.monkeyMock = new Monkey(this.monkeyX, this.monkeyY, EMonkeyType.ERRATIC);
        this.monkey2 = new Monkey(this.monkey2X, this.monkey2Y, EMonkeyType.ERRATIC);

        this.strategyDeplacement = this.monkeyMock.getStrategyDeplacement();
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        int nullI = 0;
        EDirection dir = null;
        for (int i = 0; i < testNbr; i++) {

            dir = this.strategyDeplacement.generateDirection();
            if (dir == null) {
                nullI++;
            } else {
                switch (dir) {
                    case LEFT:
                        left++;
                        break;
                    case RIGHT:
                        right++;
                        break;
                    case UP:
                        up++;
                        break;
                    case DOWN:
                        down++;
                        break;
                    default:
                        fail("Direction inconnue lors de l'incrément i=" + i);
                        break;
                }
            }
        }
        assertEquals(down / this.testNbr, this.resDown, this.testNbr * this.delta);
        assertEquals(up / this.testNbr, this.resUp, this.delta);
        assertEquals(left / this.testNbr, this.resLeft, this.delta);
        assertEquals(right / this.testNbr, this.resRight, this.delta);
        assertEquals(nullI / this.testNbr, this.resNull, this.delta);
    }

}
