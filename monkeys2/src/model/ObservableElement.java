package model;

/**
 * TODO.
 * 
 * @author bij
 *
 */
public abstract interface ObservableElement {

    /**
     * méthode ajoutant un observer.
     * 
     * @param o observer a ajouter
     */
    public abstract void addObserver(Observer o);

    /**
     * méthode enlevant un observer.
     * 
     * @param o observer a enlever
     */
    public abstract void removeObserver(Observer o);

    /**
     * Méthode qui notifit les observers.
     */
    public abstract void notifyObservers();

    /**
     * TODO. Méthode qui notifit les observers.
     * 
     * @param x x
     * @param y y
     */
    public abstract void  notifyObservers(int x, int y);

}
