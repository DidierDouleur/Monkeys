package model;

/**
 * Les différentes personnage présents lors de la partie. Ces personnages seront controllés par les
 * joueurs si ce sont de Pirates, sinon ce sont des singes qui seront gérés par le programme.
 *
 */
public abstract class Character extends Element {

    /**
     * Constructeur vide.
     */
    public Character() {
    }

    /**
     * Contructeur basique.
     * 
     * @param x la coordonnée en x du personnage.
     * @param y la coordonnée en y du personnage.
     */
    public Character(int x, int y) {
        super(x, y);
    }

    /**
     * Fonction permettant de déplacer un personnage.
     * 
     * @param x x cilbe
     * @param y y cible
     */
    public void move(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.cell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
    }

    /**
     * Fonction déplaçant le Character.
     * 
     * @param direction direction du déplacement
     */
    public void move(EDirection direction) {
        Map map = GameMaster.getInstance().getIsland().getMap();
        Cell actualCell = map.getCell(this.posX, this.posY);
        Cell nextCell = map.getCell(actualCell, direction);
        // Test du le cellule visée
        this.posX = nextCell.getCoordX();
        this.posY = nextCell.getCoordY();
    }

    /**
     * Methode indiuqant si le personnage peut accéder a une Cell.
     * 
     * @param x coordX de la Cell
     * @param y coordY de la Cell
     * @return boolean
     */
    public abstract boolean canAccess(int x, int y);

    /**
     * Méthode qui indique si un pirate peut acceder a une Cell.
     * 
     * @param cell Cell dont on veut tester l'accès
     * @return true si le Pirate peut aller sur cette case, false si il ne peut pas
     */
    public abstract boolean canAccess(Cell cell);

}
