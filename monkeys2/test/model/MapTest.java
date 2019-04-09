package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MapTest {

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

    @Before
    public void setUp() {
        this.map = new Map(sizeX, sizeY);

        cell0 = Mockito.mock(Cell.class);
        cell1 = Mockito.mock(Cell.class);
        cell2 = Mockito.mock(Cell.class);
        cell3 = Mockito.mock(Cell.class);

        Mockito.when(cell0.getCoordX()).thenReturn(X_CELL0);
        Mockito.when(cell0.getCoordY()).thenReturn(Y_CELL0);

        Mockito.when(cell1.getCoordX()).thenReturn(X_CELL1);
        Mockito.when(cell1.getCoordY()).thenReturn(Y_CELL1);

        Mockito.when(cell2.getCoordX()).thenReturn(X_CELL2);
        Mockito.when(cell2.getCoordY()).thenReturn(Y_CELL2);

        Mockito.when(cell3.getCoordX()).thenReturn(X_CELL3);
        Mockito.when(cell3.getCoordY()).thenReturn(Y_CELL3);

        this.listCell = new ArrayList<Cell>();
        listCell.add(cell0);
        listCell.add(cell1);
        listCell.add(cell2);
        listCell.add(cell3);
        this.map.setCells(listCell);

        /**
         * Carte : cell0 | cell1 cell2 | cell3
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
    public void testGetDirection_CellCell() throws Exception {

        assertEquals(map.getDirectionFromCells2(cell0, cell1),EDirection.RIGHT);
        assertEquals(map.getDirectionFromCells2(cell1, cell0),EDirection.LEFT);
        
        assertEquals(map.getDirectionFromCells2(cell0, cell2),EDirection.DOWN);
        assertEquals(map.getDirectionFromCells2(cell2, cell0),EDirection.UP);
        
        assertEquals(map.getDirectionFromCells2(cell0, cell0),null);
        assertEquals(map.getDirectionFromCells2(cell0, cell3),null);
        assertEquals(map.getDirectionFromCells2(cell0, null),null);
        assertEquals(map.getDirectionFromCells2(null, cell0),null);

    }

}
