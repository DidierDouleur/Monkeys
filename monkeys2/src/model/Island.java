package model;

import java.util.ArrayList;

/**
 * 
 * @author bij
 *
 */
public class Island {

    /**
     * Carte sur laquelle se déroule la partie.
     */
    private Map map;

    /**
     * Liste des Pirate présent sur le plateau de jeu.
     */
    private ArrayList<Pirate> listPirate;

    /**
     * MonkeyGroup présent sur la carte.
     */
    private MonkeyGroup monkeyGroup;

    /**
     * RhumGroup présent sur la carte.
     */
    private RhumGroup rhumGroup;
    
    /**
     * Le gameMaster qui gére la partie.
     */
    private GameMaster gameMaster;

    /**
     * Constructeur privé.
     */
    public Island() {
        this.listPirate = new ArrayList<Pirate>();
        this.map = new Map();
        this.monkeyGroup = new MonkeyGroup();
        this.rhumGroup = new RhumGroup();
        this.gameMaster = GameMaster.getInstance();
    }

    /**
     * @return the gameMaster
     */
    public GameMaster getGameMaster() {
        return gameMaster;
    }

    /**
     * @param gameMaster the gameMaster to set
     */
    public void setGameMaster(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }

    /**
     * Getter RhumGroup.
     * 
     * @return rhumGroup
     */
    public RhumGroup getRhumGroup() {
        return rhumGroup;
    }

    /**
     * Setter RhumGroup.
     * 
     * @param rhumGroup rhumGroup
     */
    public void setRhumGroup(RhumGroup rhumGroup) {
        this.rhumGroup = rhumGroup;
    }

    // Setters

    /**
     * Setter map.
     * @param map Carte.
     */
    public void setMap(Map map) {
        this.map = map;
    }

    // Getters

    /**
     * 
     * @return Carte.
     */
    public Map getMap() {
        return this.map;
    }

    /**
     * Getter listPirate.
     * 
     * @return listPirate
     */
    public ArrayList<Pirate> getListPirate() {
        return this.listPirate;
    }

    /**
     * Setter listPirate.
     * 
     * @param listPirate listPirate
     */
    public void setListPirate(ArrayList<Pirate> listPirate) {
        this.listPirate = listPirate;
    }

    /**
     * Getter monkeyGroup.
     * 
     * @return monkeyGroup
     */
    public MonkeyGroup getMonkeyGroup() {
        return monkeyGroup;
    }

    /**
     * Setter monkeyGroup.
     * 
     * @param monkeyGroup monkeyGroup
     */
    public void setMonkeyGroup(MonkeyGroup monkeyGroup) {
        this.monkeyGroup = monkeyGroup;
    }

    /**
     * Methode récupérant un pirate selon son ID.
     * 
     * @param id id
     * @return Pirate
     */
    public Pirate getPirateByID(int id) {
        for (Pirate pirate : listPirate) {
            if (pirate.getId() == id) {
                return pirate;
            }
        }
        return null;
    }

}
