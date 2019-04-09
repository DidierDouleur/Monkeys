package model;

/**
 * Classe Oserveur du pirate qui permet de faire l'ensemble des action requise lors du déplacement
 * du Pirate.
 * 
 * @author bij
 *
 */
public class ObserverPirate extends Observer {

    /**
     * Pirate a observer.
     */
    private Pirate pirate;

    /**
     * Constructeur.
     * 
     * @param pirate le Pirate a obeserver
     */
    public ObserverPirate(Pirate pirate) {
        this.pirate = pirate;
    }

    @Override
    public void update(int x, int y) {
        Cell targetCell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
        this.update(targetCell);
    }

    @Override
    public void update() {
        if (this.pirate.getEnergy() <= 0) {
            this.pirate.killPirate();
        }
    }

    @Override
    public void update(Cell cell) {
        if (cell != null
                && GameMaster.getInstance().getIsland().getMap().getDirectionFromCells2(cell,
                        this.pirate.getCell()) != null
                && this.pirate.getState() == EPirateState.ALIVE) {
            if (this.pirate.canAccess(cell)) {
                if (cell.getItem() != null) {
                    if (cell.getItem() == Treasure.getInstance()) {
                        Treasure.getInstance().setVisible(true);
                        GameMaster.getInstance().gameEnd();
                    } else if (cell.getItem().getClass() == Rhum.class
                            && cell.getItem().getVisible()) {
                        Rhum rhum = (Rhum) cell.getItem();
                        this.pirate.drinkRhum(rhum.getEnergy());
                        rhum.drinkRhum();
                    }
                }

                if (cell.getCharacter() == null) {
                    this.pirate.getCell().setCharacter(null);
                    this.pirate.move(cell.getCoordX(), cell.getCoordY());
                    this.pirate.setEnergy(this.pirate.getEnergy() - 1);
                    cell.setCharacter(this.pirate);
                } else if (cell.getCharacter().getClass() == Monkey.class) {
                    this.pirate.getCell().setCharacter(null);
                    this.pirate.move(cell.getCoordX(), cell.getCoordY());
                    this.pirate.setEnergy(this.pirate.getEnergy() - 1);
                    Monkey monkey = (Monkey) cell.getCharacter();
                    this.pirate.killPirate();
                    monkey.setKillCount(monkey.getKillCount() + 1);
                    monkey.notifyObservers();
                }
            }
            this.update();
        }
    }

}
