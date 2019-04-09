package model;

/**
 * La classe Treasure est l'objet que doivent chercher les Pirates afin de remporter la partie.
 *
 */
public class Treasure extends Item {
    
    /**
     * instance unique.
     */
    private static Treasure INSTANCE = null;
    
    /**
     * Définit si le Treasure est visible ou non.
     */
    
    /**
     * Contructeur vide, l'emplacement est généré aléatoirement.
     */
    private Treasure() {
        Cell cell = GameMaster.getInstance().getIsland().getMap().getRandomEmptyItemCell();
        this.posX = cell.getCoordX();
        this.posY = cell.getCoordY();
        this.cell = cell;
        cell.setItem(this);
        this.setVisible(false);
    }

    /**
     * Constructeur.
     * @param x x
     * @param y y
     */
    private Treasure(int x, int y) {
        this.posX = x;
        this.posY = y;
        this.cell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
        cell.setItem(this);
        this.visible = false;
        
        System.out.println("Treasure.java => contructeur(x,y) : x = " + x);
        System.out.println("Treasure.java => contructeur(x,y) : y = " + y);
    }
    // setters



    

    /**
     * Point d'accès pour l'instance unique du singleton.
     * 
     * @return Le singleton Treasure.
     */
    public static synchronized Treasure getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Treasure();
        }
        return INSTANCE;
    }
    
    /**
     * Point d'accès pour l'instance unique du singleton.
     * 
     * @param x x
     * @param y y
     * 
     * @return instance 
     */
    public static synchronized Treasure getInstance(int x,int y) {
        if(INSTANCE == null) {
            INSTANCE = new Treasure(x,y);
        }
        return INSTANCE;
    }

}
