package model;

import Experimentation.Comm;

/**
 * Class gérant le fonctionnement de la partie.
 *
 */
public class GameMaster {

    /**
     * instance unique de GameMaster.
     */
    private static GameMaster INSTANCE = null;

    /**
     * la classe permettant la configuration de la partie.
     */
    private Config config;

    /**
     * l'ile sur laquelle se déroule la partie.
     */
    private Island island;

    /**
     * Class communication assurant les échanges entre le client et le serveur.
     */
    private Comm communication;

    /**
     * boolean qui nous indique si la partie est en cours.
     */
    private boolean isRunning;

    /**
     * Constructeur.
     */
    public GameMaster() {
        this.isRunning = false;
    }

    /**
     * Point d'accès à l'instance du singleton.
     * 
     * @return GameMaster
     */
    public static synchronized GameMaster getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameMaster();
        }
        return INSTANCE;
    }

    /**
     * Fonction d'initialisation de la partie. TODO : implémenter totalement afin de gérer un partie
     * complète
     */
    public void initGame() {
        this.config = new Config();
        this.island = new Island();
        this.communication = new Comm(this);
        this.config.readConfigFile();
        System.out.println("------------------------");
        this.island.getMap().printMapElements();

        this.isRunning = true;
        this.island.getMonkeyGroup().start();
    }

    /**
     * Fonction de mise a jour de la partie.
     */
    public void updateGame() {

    }

    // Setters

    /**
     * 
     * @param isle l'island
     */
    public void setIsland(Island isle) {
        this.island = isle;
    }

    /**
     * 
     * @param conf la classe de configuration
     */
    public void setConfig(Config conf) {
        this.config = conf;
    }

    // Getters

    /**
     * 
     * @return l'ile u se déroule la partie
     */
    public Island getIsland() {
        return this.island;
    }

    /**
     * 
     * @return la classe de configuration de la partie
     */
    public Config getConfig() {
        return this.config;
    }

    /**
     * Methode mettant fin a la partie.
     */
    public void gameEnd() {
        this.isRunning = false;
        System.out.println("FIN DE PARTIE");
    }

    /**
     * @return the isRunning
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * @param isRunning the isRunning to set
     */
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
