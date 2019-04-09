package model;

/**
 * Classe Oserveur du Monkey qui permet de faire l'ensemble des action requise lors du déplacement
 * du Monkey.
 * 
 * @author bij
 *
 */
public class ObserverMonkey extends Observer {

    /**
     * Monkey a observer.
     */
    private Monkey monkey;

    /**
     * Constructeur.
     * 
     * @param monkey monkey que l'on souhaite observer.
     */
    public ObserverMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

    @Override
    public void update() {
        if (this.monkey.getKillCount() >= this.monkey.getKillToUpgrade()) {
            this.monkey.setMonkeyType(EMonkeyType.HUNTER);
        }
        if (this.monkey.getKillCount() >= this.monkey.getKillToDownGrade()) {
            this.monkey.setMonkeyType(EMonkeyType.ERRATIC);
            this.monkey.setKillCount(0);
        }

    }

    @Override
    public void update(int x, int y) {
        Cell targetCell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
        this.update(targetCell);
    }

    @Override
    public void update(Cell cell) {
        if (cell != null && this.monkey.canAccess(cell)) {
            if (cell.getCharacter() != null && cell.getCharacter().getClass() == Pirate.class) {
                Pirate pirate = (Pirate) cell.getCharacter();
                pirate.killPirate();
                this.monkey.setKillCount(this.monkey.getKillCount() + 1);
                this.update();
            }
            this.monkey.getCell().setCharacter(null);
            this.monkey.move(cell.getCoordX(), cell.getCoordY());
            cell.setCharacter(this.monkey);
        }

    }

    /**
     * Getter Monkey.
     * 
     * @return monkey
     */
    public Monkey getMonkey() {
        return this.monkey;
    }

    /**
     * Setter Monkey.
     * 
     * @param monkey monkey
     */
    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
}
