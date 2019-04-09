package model;

/**
 * Une cellule, la Map est composée de différentes Cells.
 *
 */
public class Cell {

    /**
     * Type de terrain de la Cell.
     */
    private EGroundType type;

    /**
     * Coordonée x de la Cell.
     */
    private int coordX;

    /**
     * Coordonnée y de la Cell.
     */
    private int coordY;

    /**
     * TODO.
     */
    private Character character;

    /**
     * TODO.
     */
    private Item item;

    /**
     * Constructeur vide.
     */
    public Cell() {
    }

    /**
     * Constructeur.
     * 
     * @param x    la coordonnée x de la Cell
     * @param y    la coordonnée y de la Cell
     * @param type le type de terrain de la Cell
     */
    public Cell(int x, int y, EGroundType type) {
        this.coordX = x;
        this.coordY = y;
        this.type = type;
        this.character = null;
        this.item = null;
    }

    // Setters

    /**
     * 
     * @param x La coordonnée X
     */
    public void setCoordX(int x) {
        this.coordX = x;
    }

    /**
     * 
     * @param y La coordonnée Y.
     */
    public void setCoordY(int y) {
        this.coordY = y;
    }

    /**
     * 
     * @param type Le type de terrain
     */
    public void setType(EGroundType type) {
        this.type = type;
    }

    /**
     * TODO.
     *
     * @param character character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }
    
    /**
     * Setter item.
     * @param item item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    // Getters

    /**
     * 
     * @return La coordonnée X
     */
    public int getCoordX() {
        return this.coordX;
    }

    /**
     * 
     * @return La coordonnée Y.
     */
    public int getCoordY() {
        return this.coordY;
    }

    /**
     * 
     * @return Le type de terrain.
     */
    public EGroundType getType() {
        return this.type;
    }

    /**
     * 
     * @return l'information de la présence d'un Character sur la Cell.
     */
    public Character getCharacter() {
        return this.character;
    }

    /**
     * Getter item.
     * @return item
     */
    public Item getItem() {
        return this.item;
    }
}
