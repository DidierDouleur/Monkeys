package model;

/**
 * Character Monkey controler par le programme. Si il se trou if (this.monkey.canAccess(cell)) { if
 * (cell.getCharacter() == null) {ve au même endroit qu'un Pirate, le tue.
 *
 */
public class Monkey extends Character {

    /**
     * type du singe, erratique ou chasseur.
     */
    private EMonkeyType type;

    /**
     * TODO.
     */
    private StrategyDeplacement strategyDeplacement;

    /**
     * Nombre de pirate tué.
     */
    private int killCount;

    /**
     * nombre de pirate a tuer pour passer en chasseur.
     */
    private int killToUpgrade;

    /**
     * nombre de pirate a tuer pour passer en Erratic.
     */
    private int killToDownGrade;

   

    /**
     * constructeur vide.
     */
    public Monkey() {
        super();
    }

    /**
     * constructeur.
     * 
     * @param x    la coordonnée x du Monkey.
     * @param y    la coordonnée y du Monkey.
     * @param type le type du Monkey.
     */
    public Monkey(int x, int y, EMonkeyType type) {
        Cell newCell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
        if (this.canAccess(x, y)) {
            this.setPosX(x);
            this.setPosY(y);
            this.setCell(newCell);
            this.addObserver(new ObserverMonkey(this));
            newCell.setCharacter(this);
            this.setMonkeyType(type);
            this.killCount = 0;
        } else {
            System.out.println("Monkey.java : erreur lors de l'invocation du constructeur");
        }
        // TODO => ELSE SI CASE PAS DISPO
    }

    @Override
    public boolean canAccess(int x, int y) {
        Cell cell = GameMaster.getInstance().getIsland().getMap().getCell(x, y);
        return this.canAccess(cell);
    }

    /**
     * Methode générant ue direction en fonction de la stratefie des singes puis déplace le singe
     * vers la direction générée si elle existe.
     */
    public void askMove() {
        Map map = GameMaster.getInstance().getIsland().getMap();
        Cell targetCell = map.getCell(this.cell, this.strategyDeplacement.generateDirection());
        if (targetCell != null) {
            System.out.println("Monkey.java => askMove() tragetX=" + targetCell.getCoordX()
                    + "targetY = " + targetCell.getCoordY());
            this.notifyObservers(targetCell.getCoordX(), targetCell.getCoordY());
        } else {
            System.out.println("Monkey.java => askMove() : NOMOVE");
        }

    }

    /**
     * TODO.
     * 
     * @param cell Cell dont on veut tester l'accès
     * @return true si le Monkey peut aller sur cette case, false si il ne peut pas
     */
    public boolean canAccess(Cell cell) {
        boolean ret = false;
        if (cell != null && cell.getType() == EGroundType.GROUND) {
            if (cell.getCharacter() == null || cell.getCharacter().getClass() == Pirate.class) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * TODO.
     * 
     * @param strat TODO.
     */
    private void setStrategyDeplacement(StrategyDeplacement strat) {
        this.strategyDeplacement = strat;
    }

    /**
     * TODO.
     * 
     * @return TODO
     */
    public StrategyDeplacement getStrategyDeplacement() {
        return this.strategyDeplacement;
    }

    /**
     * TODO.
     * 
     * @param kc TODO.
     */
    public void setKillCount(int kc) {
        this.killCount = kc;
    }

    /**
     * TODO.
     * 
     * @return TODO.
     */
    public int getKillCount() {
        return this.killCount;
    }

    
    /**
     * @return the killToDownGrade
     */
    public int getKillToDownGrade() {
        return killToDownGrade;
    }

    /**
     * @param killToDownGrade the killToDownGrade to set
     */
    public void setKillToDownGrade(int killToDownGrade) {
        this.killToDownGrade = killToDownGrade;
    }

    /**
     * @return the killToUpgrade
     */
    public int getKillToUpgrade() {
        return killToUpgrade;
    }

    /**
     * @param killToUpgrade the killToUpgrade to set
     */
    public void setKillToUpgrade(int killToUpgrade) {
        this.killToUpgrade = killToUpgrade;
    }
    
    /**
     * 
     * @return le type du singe
     */
    public EMonkeyType getType() {
        return this.type;
    }
    
    // Setters

    /**
     * 
     * @param type le Type du singe
     */
    public void setMonkeyType(EMonkeyType type) {
        this.type = type;
        if (type == EMonkeyType.ERRATIC) {
            this.setStrategyDeplacement(new StrategyErratic(this));
        } else if (type == EMonkeyType.HUNTER) {
            this.setStrategyDeplacement(new StrategyHunting(this));
        }
    }
    
}
