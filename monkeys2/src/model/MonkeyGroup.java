package model;

import java.util.ArrayList;

/**
 * Groupe des singes a gérer.
 *
 */
public class MonkeyGroup extends Thread {

    /**
     * Liste des singes à gérer.
     */
    private ArrayList<Monkey> listMonkeys;

    /**
     * Nombre de pirate a manger avant qu'un Monkey passe du type ERRATIC au type HUNTER.
     */
    private int killToUpgrade;

    /**
     * Nombre de pirate a manger avant qu'un Monkey passe du type HUNTER au type ERRATIC.
     */
    private int killToDownGrade;

    /**
     * Vitesse des singes.
     */
    private int speed;

    /**
     * Contructeur.
     * 
     */
    public MonkeyGroup() {
        this.listMonkeys = new ArrayList<Monkey>();
    }

    /**
     * Getter speed.
     * 
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setter speed.
     * 
     * @param speed speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Setters

    /**
     * 
     * @param monkeys liste des singes à gérer.
     */
    public void setMonkeys(ArrayList<Monkey> monkeys) {
        this.listMonkeys = monkeys;
    }

    // Getters

    /**
     * Getter listMonkeys.
     * 
     * @return listMonkeys
     */
    public ArrayList<Monkey> getListMonkeys() {
        return listMonkeys;
    }

    /**
     * Setter listMonkeys.
     * 
     * @param listMonkeys listMonkeys
     */
    public void setListMonkeys(ArrayList<Monkey> listMonkeys) {
        this.listMonkeys = listMonkeys;
    }

    /**
     * Getter KillToUpgrade.
     * 
     * @return KillToUpgrade
     */
    public int getKillToUpgrade() {
        return killToUpgrade;
    }

    /**
     * Setter KillToUpgrade.
     * 
     * @param killToUpgrade killToUpgrade
     */
    public void setKillToUpgrade(int killToUpgrade) {
        this.killToUpgrade = killToUpgrade;
    }

    /**
     * Getter KillToDownGrade.
     * 
     * @return killToDownGrade
     */
    public int getKillToDownGrade() {
        return killToDownGrade;
    }

    /**
     * setter KillToDownGrade.
     * 
     * @param killToDownGrade killToDownGrade
     */
    public void setKillToDownGrade(int killToDownGrade) {
        this.killToDownGrade = killToDownGrade;
    }

    /**
     * 
     * @return liste des singes à gérer.
     */
    public ArrayList<Monkey> getMonkeyList() {
        return this.listMonkeys;
    }

    /**
     * Fonction créant un nombre définit de Erratic Monkey.
     * 
     * TODO vvv créer les Monkeys sur les cases désignées dans le fichier de config
     * 
     * @param nbr le nombre d'erratic qu'on souhaite créer
     */
    public void createErraticMonkeys(int nbr) {
        Map map = GameMaster.getInstance().getIsland().getMap();
        Cell cell;
        Monkey monkey;
        for (int i = 0; i < nbr; i++) {
            cell = map.getRandomEmptyCharCell();
            monkey = new Monkey(cell.getCoordX(), cell.getCoordY(), EMonkeyType.ERRATIC);
            monkey.setKillToUpgrade(this.killToUpgrade);
            monkey.setKillToDownGrade(this.killToDownGrade);
            this.listMonkeys.add(monkey);
        }
    }

    /**
     * Fonction créant un nombre définit de Hunter Monkey.
     * 
     * TODO vvv créer les Monkeys sur les cases désignées dans le fichier de config
     * 
     * @param nbr le nombre d'erratic qu'on souhaite créer
     */
    public void createHunterMonkeys(int nbr) {
        Map map = GameMaster.getInstance().getIsland().getMap();
        Cell cell;
        Monkey monkey;
        for (int i = 0; i < nbr; i++) {
            cell = map.getRandomEmptyCharCell();
            monkey = new Monkey(cell.getCoordX(), cell.getCoordY(), EMonkeyType.HUNTER);
            monkey.setKillToUpgrade(this.killToUpgrade);
            monkey.setKillToDownGrade(this.killToDownGrade);
            this.listMonkeys.add(monkey);
        }
    }

    @Override
    public void run() {
        while (GameMaster.getInstance().isRunning()) {
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Monkey monkey : this.listMonkeys) {
                monkey.askMove();
            }
            GameMaster.getInstance().getIsland().getMap().printMapElements();
        }
    }
}
