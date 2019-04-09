package model;

/**
 * TODO.
 * 
 * @author bij
 *
 */
public class Rhum extends Item {

    /**
     * TODO .
     */
    private int energy;

    /**
     * TODO .
     */
    private int spawnTime;

    /**
     * Constructeur vide.
     */
    public Rhum() {
        super();
    }

    /**
     * TODO .
     * 
     * @param x         TODO
     * @param y         TODO
     * @param energy    TODO
     * @param spawnTime TODO
     */
    public Rhum(int x, int y, int energy, int spawnTime) {
        super(x, y);
        if (GameMaster.getInstance().getIsland().getMap().getCell(x, y).getItem() == null) {
            this.cell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
            this.energy = energy;
            this.spawnTime = spawnTime;
            this.cell.setItem(this);  
            this.addObserver(new ObserverRhum(this));
        }
    }

    /**
     * TODO.
     * 
     * @return return
     */
    public int getEnergy() {
        return this.energy;
    }

    /**
     * TODO.
     * 
     * @return return
     */
    public int getSPawnTime() {
        return this.spawnTime;
    }

    /**
     * Consomme le rhum.
     * 
     * TODO : ajouter lancement timer suite a la consomation du Rhum.
     */
    public void drinkRhum() {
        this.visible = false;
    }

    /**
     * Fais réaparaitre le rhum.
     */
    public void spawnRhum() {
        this.visible = false;
        this.notifyObservers();
    }

}
