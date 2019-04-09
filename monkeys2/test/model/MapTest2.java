package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MapTest2 {
    private Map map;

    private Cell cell0;
    private Cell cell1;
    private Cell cell2;
    private Cell cell3;

    private static final int X_CELL0 = 0;
    private static final int Y_CELL0 = 0;
    private static final EGroundType TYPE_CELL0 = EGroundType.GROUND;

    private static final int X_CELL1 = 1;
    private static final int Y_CELL1 = 0;
    private static final EGroundType TYPE_CELL1 = EGroundType.GROUND;

    private static final int X_CELL2 = 0;
    private static final int Y_CELL2 = 1;
    private static final EGroundType TYPE_CELL2 = EGroundType.GROUND;

    private static final int X_CELL3 = 1;
    private static final int Y_CELL3 = 1;
    private static final EGroundType TYPE_CELL3 = EGroundType.GROUND;

    private static final int sizeX = 1;
    private static final int sizeY = 1;

    private static final int sizeX2 = 10;
    private static final int sizeY2 = 9;

    private ArrayList<Cell> listCell;

    private String map2 = "000010010000";
    private int X_MAP2 = 2;
    private int Y_MAP2 = 3;

    private String map3 = "0000001110011100111000000";
    private int X_MAP3 = 4;
    private int Y_MAP3 = 4;

    private String map4 = "0000z01110011100111000000";
    private int X_MAP4 = 4;
    private int Y_MAP4 = 4;

    @Before
    public void setUp() {
        this.map = new Map(sizeX, sizeY);

        cell0 = new Cell(X_CELL0, Y_CELL0, TYPE_CELL0);
        cell1 = new Cell(X_CELL1, Y_CELL1, TYPE_CELL1);
        cell2 = new Cell(X_CELL2, Y_CELL2, TYPE_CELL2);
        cell3 = new Cell(X_CELL3, Y_CELL3, TYPE_CELL3);

        this.listCell = new ArrayList<Cell>();
        listCell.add(cell0);
        listCell.add(cell1);
        listCell.add(cell2);
        listCell.add(cell3);
        this.map.setCells(listCell);

        /**
         * Carte : cell0 | cell1
         *         cell2 | cell3
         */
    }

    @Test
    public void testSizeX() {

        assertEquals("Echec test construteur map(int,int)", this.map.getSizeX(), sizeX);
        this.map.setSizeX(sizeX2);
        assertEquals("Echec test setterX Map", this.map.getSizeX(), sizeX2);
    }

    @Test
    public void testSizeY() {

        assertEquals("Echec test construteur map(int,int)", this.map.getSizeY(), sizeY);
        this.map.setSizeY(sizeY2);
        assertEquals("Echec test setterY Map", this.map.getSizeY(), sizeY2);
    }

    @Test
    public void testCells() throws Exception {
        assertEquals(this.map.getCells(), this.listCell);
    }

    @Test
    public void testGetCell_IntInt() throws Exception {
        // test des limites
        assertEquals(map.getCell(2, 0), null);
        assertEquals(map.getCell(0, 2), null);
        assertEquals(map.getCell(-3, 0), null);
        assertEquals(map.getCell(0, -1), null);

        // test valeur normales
        assertEquals(map.getCell(0, 0), cell0);
        assertEquals(map.getCell(0, 0).getCoordX(), X_CELL0);
        assertEquals(map.getCell(0, 0).getCoordY(), Y_CELL0);

        assertEquals(map.getCell(1, 0), cell1);
        assertEquals(map.getCell(1, 0).getCoordX(), X_CELL1);
        assertEquals(map.getCell(1, 0).getCoordY(), Y_CELL1);

        assertEquals(map.getCell(0, 1), cell2);
        assertEquals(map.getCell(0, 1).getCoordX(), X_CELL2);
        assertEquals(map.getCell(0, 1).getCoordY(), Y_CELL2);

        assertEquals(map.getCell(1, 1), cell3);
        assertEquals(map.getCell(1, 1).getCoordX(), X_CELL3);
        assertEquals(map.getCell(1, 1).getCoordY(), Y_CELL3);
    }

    @Test
    public void testGetCell_CellDir() throws Exception {

        // Test limites
        assertEquals(map.getCell(cell0, EDirection.LEFT), null);
        assertEquals(map.getCell(cell0, EDirection.UP), null);

        assertEquals(map.getCell(cell3, EDirection.RIGHT), null);
        assertEquals(map.getCell(cell3, EDirection.DOWN), null);

        // Test valeurs normales

        assertEquals(map.getCell(cell0, EDirection.RIGHT), cell1);
        assertEquals(map.getCell(cell0, EDirection.DOWN), cell2);

        assertEquals(map.getCell(cell3, EDirection.LEFT), cell2);
        assertEquals(map.getCell(cell3, EDirection.UP), cell1);

    }

    @Test
    public void testCreateMap_String() throws Exception {

        // Test string ne correspondant pas a la taille de la carte
        this.map.createMap(map2);
        assertEquals(this.map.getCells().isEmpty(), true);

        // test string correspondant a la taille de la carte
        // map2
        this.map.setSizeX(X_MAP2);
        this.map.setSizeY(Y_MAP2);
        this.map.createMap(map2);

        assertEquals(this.map.getCell(0, 0).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 0).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(2, 0).getType(), EGroundType.WATER);

        assertEquals(this.map.getCell(0, 1).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 1).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(2, 1).getType(), EGroundType.WATER);

        assertEquals(this.map.getCell(0, 2).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 2).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(2, 2).getType(), EGroundType.WATER);

        assertEquals(this.map.getCell(0, 3).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 3).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(2, 3).getType(), EGroundType.WATER);

        // test string correspondant a la taille de la carte
        // map3
        this.map.setSizeX(X_MAP3);
        this.map.setSizeY(Y_MAP3);
        this.map.createMap(map3);

        assertEquals(this.map.getCell(0, 0).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 0).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(2, 0).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(3, 0).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(4, 0).getType(), EGroundType.WATER);

        assertEquals(this.map.getCell(0, 1).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 1).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(2, 1).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(3, 1).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(4, 1).getType(), EGroundType.WATER);

        assertEquals(this.map.getCell(0, 2).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 2).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(2, 2).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(3, 2).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(4, 2).getType(), EGroundType.WATER);

        assertEquals(this.map.getCell(0, 3).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 3).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(2, 3).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(3, 3).getType(), EGroundType.GROUND);
        assertEquals(this.map.getCell(4, 3).getType(), EGroundType.WATER);

        assertEquals(this.map.getCell(0, 4).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(1, 4).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(2, 4).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(3, 4).getType(), EGroundType.WATER);
        assertEquals(this.map.getCell(4, 4).getType(), EGroundType.WATER);

        // test string correspondant a la taille mais avec un caractère non égale a 0 ou 1
        this.map.setSizeX(X_MAP4);
        this.map.setSizeY(Y_MAP4);
        this.map.createMap(map4);
        assertEquals(this.map.getCells().isEmpty(), true);
    }
    
    @Test
    public void testRandomCharacter() {
        this.map.setSizeX(2);
        this.map.setSizeY(0);
        Character chara = new Pirate();
        Item item = new Item();
        this.map.createMap("011");
        this.map.getCell(1, 0).setCharacter(chara);
        this.map.getCell(2, 0).setItem(item);
        assertEquals(this.map.getRandomEmptyItemCell(),this.map.getCell(1, 0));
        assertEquals(this.map.getRandomEmptyItemCell(),this.map.getCell(1, 0));
        assertEquals(this.map.getRandomEmptyItemCell(),this.map.getCell(1, 0));
        assertEquals(this.map.getRandomEmptyItemCell(),this.map.getCell(1, 0));
        
        assertEquals(this.map.getRandomEmptyCharCell(),this.map.getCell(2, 0));
        assertEquals(this.map.getRandomEmptyCharCell(),this.map.getCell(2, 0));
        assertEquals(this.map.getRandomEmptyCharCell(),this.map.getCell(2, 0));
        assertEquals(this.map.getRandomEmptyCharCell(),this.map.getCell(2, 0));
        assertEquals(this.map.getRandomEmptyCharCell(),this.map.getCell(2, 0));

        map.printMapXY();
    }
    
    @Test
    public void testGetDirectionCell_CellCell() {
        assertEquals(this.map.getDirectionFromCells2(this.cell0, this.cell1),EDirection.RIGHT);
        assertEquals(this.map.getDirectionFromCells2(this.cell1, this.cell0),EDirection.LEFT);
        assertEquals(this.map.getDirectionFromCells2(this.cell0, this.cell2),EDirection.DOWN);
        assertEquals(this.map.getDirectionFromCells2(this.cell2, this.cell0),EDirection.UP);
        
        assertEquals(this.map.getDirectionFromCells2(this.cell0, this.cell0),null);
        assertEquals(this.map.getDirectionFromCells2(this.cell0, this.cell3),null);
        assertEquals(this.map.getDirectionFromCells2(this.cell1, this.cell2),null);
        assertEquals(this.map.getDirectionFromCells2(this.cell0, null),null);
        assertEquals(this.map.getDirectionFromCells2(null, this.cell3),null);
    }

}
