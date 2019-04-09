package model;

/**
 * La classe Pirate est la classe de personnage controlée par les joueurs. Leurs but est de trouver
 * le Treasure en évitant les singes.
 * 
 */
public class Pirate extends Character {

    /**
     * Identifiant unique du pirate.
     */
    private int id;

    /**
     * Etat du pirate.
     */
    private EPirateState state;

    /**
     * l'Energy du Pirate.
     */
    private int energy;

    /**
     * Constrcteur vide.
     */
    public Pirate() {
        super();
    }

    /**
     * Constrcteur basique.
     * 
     * @param x  : position du Pirate en x
     * @param y  : position du Pirate en Y
     * @param id : identifiant du Pirate
     * @param energy : energy du pirate
     */
    public Pirate(int x, int y, int id, int energy) {
        super();
        Cell newCell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
        if (this.canAccess(x, y)) {
            this.posX = x;
            this.posY = y;
            this.id = id;
            this.energy = energy;
            this.setCell(newCell);
            this.state = EPirateState.ALIVE;
            this.addObserver(new ObserverPirate(this));
            newCell.setCharacter(this);
        } else {
            newCell = GameMaster.getInstance().getIsland().getMap().getRandomEmptyCharCell();
            if (newCell != null) {
                this.posX = newCell.getCoordX();
                this.posY = newCell.getCoordY();
                this.id = id;
                this.energy = energy;
                this.setCell(newCell);
                this.state = EPirateState.ALIVE;
                this.addObserver(new ObserverPirate(this));
                newCell.setCharacter(this);
            }
        }

    }

    @Override
    public boolean canAccess(int x, int y) {
        Cell cell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
        return this.canAccess(cell);
    }

    @Override
    public boolean canAccess(Cell cell) {
        boolean ret = false;
        if (cell != null && cell.getType() == EGroundType.GROUND) {
            if (cell.getCharacter() == null || cell.getCharacter().getClass() == Monkey.class) {
                ret = true;
            }
        }
        return ret;
    }

    // setters

    /**
     * 
     * @param id L'identifiant unique du Pirate.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @param state L'état du Pirate.
     */
    public void setState(EPirateState state) {
        this.state = state;
    }

    // Getters

    /**
     * 
     * @return lIdentifiant unique du Pirate.
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @return L'état du Pirate.
     */
    public EPirateState getState() {
        return this.state;
    }

    /**
     * Méthode tuant le pirate.
     */
    public void killPirate() {
        this.setState(EPirateState.DEAD);
        this.cell.setCharacter(null);
    }

    /**
     * Méthode faisant boire le pirate.
     * 
     * @param energy energy fournit par le Rhum
     */
    public void drinkRhum(int energy) {
        this.energy += energy;
        this.notifyObservers();
    }

    /**
     * Getter Energy.
     * 
     * @return energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Setter Energy.
     * 
     * @param energy ernergy
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
