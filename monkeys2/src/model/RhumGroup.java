package model;

import java.util.ArrayList;

/**
 * Classe servant a gérer le group de rhum durant la partie.
 * 
 * @author bij
 *
 */
public class RhumGroup {

    /**
     * La liste des rhum a géree durant la partie.
     */
    private ArrayList<Rhum> listRhum;

    /**
     * Constructur vide.
     */
    public RhumGroup() {
        listRhum = new ArrayList<Rhum>();
    }

    /**
     * Fonction créant les bouteilles de rhum pour la partie.
     * 
     * @param nbr       nombre de bouteille de rhum a créer
     * @param energy    energy
     * @param spawnTime  spanwTime
     */
    public void createRhums(int nbr, int energy, int spawnTime) {
        Map map = GameMaster.getInstance().getIsland().getMap();
        Cell cell;
        Rhum rhum;
        for (int i = 0; i < nbr; i++) {
            cell = map.getRandomEmptyItemCell();
            rhum = new Rhum(cell.getCoordX(), cell.getCoordY(), energy, spawnTime);
            cell.setItem(rhum);
            this.listRhum.add(rhum);
        }
    }
}
