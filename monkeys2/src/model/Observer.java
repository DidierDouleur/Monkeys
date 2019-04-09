package model;

/**
 * Observeur, observe les objets auxquel il est lié et agi selon les changements que cet observer
 * subit.
 * 
 * @author bij
 *
 */
public abstract class Observer {

    /**
     * Mise a jour de l'état de l'observé et des objet sur lesquels il agit.
     */
    public abstract void update();

    /**
     * Mise a jour de l'état de l'observé vers la position x,y.
     * 
     * @param x positionx
     * @param y positiony
     */
    public abstract void update(int x, int y);

    /**
     * Mise a jour de l'état de l'observé vers la position cellule.
     * 
     * @param cell cellule
     */
    public abstract void update(Cell cell);
}
