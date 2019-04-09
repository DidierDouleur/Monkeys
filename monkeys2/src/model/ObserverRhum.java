package model;

/**
 * Observer du rhum.
 * @author bij
 *
 */
public class ObserverRhum extends Observer {
    
    /**
     * rhum que l'on observe.
     */
    private Rhum rhum;
    
    /**
     * Constructeur.
     * @param rhum rhum
     */
    public ObserverRhum(Rhum rhum) {
        this.rhum  =rhum;
    }

    @Override
    public void update() {
        Cell cell = this.rhum.getCell();
        if(cell.getCharacter() != null) {
            if(cell.getCharacter().getClass() == Pirate.class) {
                Pirate pirate = (Pirate) cell.getCharacter();
                pirate.drinkRhum(this.rhum.getEnergy());
                pirate.notifyObservers();
                this.rhum.drinkRhum();
                //TODO : AJOUTER TIMER DE RESPAWN DU RHUM
            }
        }

    }

    @Override
    public void update(int x, int y) {
    }

    @Override
    public void update(Cell cell) {
    }

}
