package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * La carte ou se déroule la partie.
 *
 */
public class Map {

    /**
     * la taille de la carte en asbysse.
     */
    private int sizeX;

    /**
     * la taille de la carte en ordonnée.
     */
    private int sizeY;

    /**
     * L'ensemble des cellules composants la carte.
     */
    private ArrayList<Cell> cells;

    /**
     * constructeur vide.
     */
    public Map() {
        this.cells = new ArrayList<Cell>();
    }

    /**
     * constructeur basique.
     * 
     * @param x taille de la carte en absysse.
     * @param y taille de la carte en ordonnée.
     */
    public Map(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
        this.cells = new ArrayList<Cell>();
    }

    /**
     * Fonction permettant de récupérer un cellule selon une cellule dorigine et la direction dans
     * laquelle chercher le cellule cible.
     * 
     * @param cell : Cellule depuis laquelle on cherche la cellule adjacente.
     * @param dir  : Direction dans laquelle chercher la cellule adjacente.
     * @return : Cellule recherchée
     */
    public Cell getCell(Cell cell, EDirection dir) {
        int x = cell.getCoordX();
        int y = cell.getCoordY();
        Cell retCell = null;
        if (dir != null) {
            switch (dir) {
                case LEFT:
                    retCell = this.getCell(x - 1, y);
                    break;

                case RIGHT:
                    retCell = this.getCell(x + 1, y);
                    break;

                case UP:
                    retCell = this.getCell(x, y - 1);
                    break;

                case DOWN:
                    retCell = this.getCell(x, y + 1);
                    break;

                default:
                    retCell = null;
            }
        }
        return retCell;
    }

    /**
     * Fonction permettant de retrouver une cellule selon ses coordonées.
     * 
     * @param x : coordonnée x de la cellule.
     * @param y : coordonnée y de la cellule.
     * @return : Cellule recherchée.
     */
    public Cell getCell(int x, int y) {
        if (x < 0 || x > this.sizeX || y < 0 || y > this.sizeY) {
            return null;
        } else {
            return this.cells.get(x + y * (this.sizeX + 1));
        }
    }

    /**
     * Fonction créant ajoutant les Cells a une Map selon un String comprenant des 0(Mer) ou des
     * 1(Terre).
     * 
     * @param organisation La String représentnat le type de Cells de la Map
     */
    public void createMap(String organisation) {
        this.cells = new ArrayList<Cell>();

        if (organisation.length() != (this.sizeX + 1) * (this.sizeY + 1)) {
            System.out.println("Map.java => mauvaise taille de carte");
        } else {
            for (int i = 0; i <= this.sizeY; i++) {
                for (int j = 0; j <= this.sizeX; j++) {
                    if (organisation.charAt(j + i * (this.sizeX + 1)) == '0') {
                        this.cells.add(new Cell(j, i, EGroundType.WATER));
                    } else if (organisation.charAt(j + i * (this.sizeX + 1)) == '1') {
                        this.cells.add(new Cell(j, i, EGroundType.GROUND));
                    } else {
                        System.out.println(
                                "Map.java => Erreur lors de la lecture de la chaine de caractères");
                        this.cells = new ArrayList<Cell>();
                        return;
                    }
                }
            }
        }
    }

    /**
     * Méthode retournant une Cell de terre sans Item.
     * 
     * @return Cell
     */
    public Cell getRandomEmptyItemCell() {
        Random rand = new Random();
        ArrayList<Cell> emptyCells = new ArrayList<Cell>();
        for (Cell cell : this.cells) {
            if (cell.getType() == EGroundType.GROUND && cell.getItem() == null) {
                emptyCells.add(cell);
            }
        }
        return emptyCells.get(rand.nextInt(emptyCells.size()));
    }

    /**
     * Méthode retournant une Cell de terre sans Character.
     * 
     * @return Cell
     */
    public Cell getRandomEmptyCharCell() {
        Random rand = new Random();
        ArrayList<Cell> emptyCells = new ArrayList<Cell>();
        for (Cell cell : this.cells) {
            if (cell.getType() == EGroundType.GROUND && cell.getCharacter() == null) {
                emptyCells.add(cell);
            }
        }
        return emptyCells.get(rand.nextInt(emptyCells.size()));
    }

    // Setters

    /**
     * 
     * @param x la taille de la carte en x
     */
    public void setSizeX(int x) {
        this.sizeX = x;
    }

    /**
     * 
     * @param y la taille de la carte en y
     */
    public void setSizeY(int y) {
        this.sizeY = y;
    }

    /**
     * 
     * @param cells les cases de la carte
     */
    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    // Getters

    /**
     * 
     * @return taille de la Map en X
     */
    public int getSizeX() {
        return this.sizeX;
    }

    /**
     * 
     * @return taille de la Map en Y
     */
    public int getSizeY() {
        return this.sizeY;
    }

    /**
     * 
     * @return Les Cells de la Map
     */
    public ArrayList<Cell> getCells() {
        return this.cells;
    }

    /**
     * Fonction affichant la carte.
     */
    public void printMapXY() {
        int i = 0;
        for (Cell cell : cells) {
            System.out.print("x=" + cell.getCoordX() + " y=" + cell.getCoordY() + "     ");
            i++;
            if (i == this.getSizeX() + 1) {
                System.out.println();
                i = 0;
            }
        }
    }

    /**
     * Fonction affichant la carte.
     */
    public void printMapGround() {
        int i = 0;
        for (Cell cell : cells) {
            System.out.print(cell.getType() + " ");
            i++;
            if (i == this.getSizeX() + 1) {
                System.out.println();
                i = 0;
            }
        }
    }

    /**
     * Fonction affichant la carte.
     */
    public void printMapElements() {
        int i = 0;
        for (Cell cell : cells) {
            if (cell.getCharacter() != null) {
                if (cell.getCharacter().getClass() == Pirate.class) {
                    System.out.print("P ");
                } else if (cell.getCharacter().getClass() == Monkey.class) {
                    System.out.print("M ");
                } else {
                    System.out.print("E ");
                }

            } else {
                if (cell.getType() == EGroundType.GROUND) {
                    System.out.print("1 ");
                } else if (cell.getType() == EGroundType.WATER) {
                    System.out.print("0 ");
                } else {
                    System.out.print("T ");
                }
            }
            i++;
            if (i == this.getSizeX() + 1) {
                System.out.println();
                i = 0;
            }
        }
    }

    /**
     * Methode qui retourne la direction de la Cell 2 par rapport a la Cell 1. si les deux cases ne
     * sont pas a coté ou si c'est deux fois la même case, retourne null
     * 
     * @param cell1 Cell 1
     * @param cell2 Cell 2
     * @return EDirection
     */
    public EDirection getDirectionFromCells2(Cell cell1, Cell cell2) {
        if (cell1 == null || cell2 == null) {
            return null;
        } else {
            EDirection dir = null;
            if (cell1.getCoordX() - cell2.getCoordX() == 0) {
                if (cell1.getCoordY() - cell2.getCoordY() == 1) {
                    dir = EDirection.UP;
                } else if (cell1.getCoordY() - cell2.getCoordY() == -1) {
                    dir = EDirection.DOWN;
                }
            } else if (cell1.getCoordY() - cell2.getCoordY() == 0) {
                if (cell1.getCoordX() - cell2.getCoordX() == 1) {
                    dir = EDirection.LEFT;
                } else if (cell1.getCoordX() - cell2.getCoordX() == -1) {
                    dir = EDirection.RIGHT;
                }
            }
            return dir;
        }
    }

}
