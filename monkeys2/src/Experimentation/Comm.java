package Experimentation;

import model.GameMaster;

/**
 * Classe assurant la gestion de la communication entre le client et le serveur.
 * @author bij
 *
 */
public class Comm {

    private GameMaster gameMaster;
    
    public Comm(GameMaster gm) {
        this.gameMaster = gm;
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
}
