package model;

import java.util.ArrayList;
import java.util.Random;


/**
 * Stategy de délacement des singes.
 *
 */
public class StrategyErratic extends StrategyDeplacement {

    /**
     * Constructeur vide.
     * 
     * @param monkey monkey sur lequel s'applique la stratégie
     */
    public StrategyErratic(Monkey monkey) {
        super(monkey);
    }

    @Override
    public EDirection generateDirection() {
        Map map = GameMaster.getInstance().getIsland().getMap();
        Cell actualCell = this.monkey.getCell();
        ArrayList<EDirection> listDirection = new ArrayList<EDirection>();
        Cell newCell;
        Random rGen = new Random();
        for (int i = 0; i < EDirection.values().length; i++) {
            newCell = map.getCell(actualCell, EDirection.values()[i]);
            if (this.monkey.canAccess(newCell)) {
                listDirection.add(EDirection.values()[i]);
            }
        }
        if (listDirection.size() <= 0) {
            return null;
        } else {
            return listDirection.get(rGen.nextInt(listDirection.size()));
        }
    }

}
