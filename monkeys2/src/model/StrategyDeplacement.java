package model;

/**
 * Stratégie de déplacement des singes.
 * @author bij
 *
 */
public abstract class StrategyDeplacement {
    
    /**
     * Monkey auquel la stratégie est appliquée.
     */
    protected Monkey monkey;
    
    /**
     * Constructeur.
     * @param monkey monkey
     */
    public StrategyDeplacement(Monkey monkey){
        this.monkey = monkey;
    }
    
    /**
     * Retourne la direction dans laquelle le singe doit aller.
     * @return direction.
     */
    public abstract EDirection generateDirection();
    
    /**
     * Getter Monkey.
     * @return monkey
     */
    public Monkey getMonkey() {
        return this.monkey;
    }
    
    /**
     * Setter monkey.
     * @param monkey monkey
     */
    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

}
