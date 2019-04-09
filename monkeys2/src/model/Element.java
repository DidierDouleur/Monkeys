package model;

import java.util.ArrayList;

/**
 * Element représente les Items et Characters présents sur le plateau de jeu.
 *
 */
public class Element implements ObservableElement {

    /**
     * La coordonnée en X de l'Element.
     */
    protected int posX;

    /**
     * La coordonnée en Y de l'Element.
     */
    protected int posY;

    /**
     * Cell dans laquelle l'élement se trouve.
     */
    protected Cell cell;


    /**
     * Liste des observer obervant l'objet.
     */
    protected ArrayList<Observer> observers;

    /**
     * Constructeur vide de l'Element.
     */
    public Element() {
        this.observers = new ArrayList<Observer>();
    }

    /**
     * Constructeur.
     * 
     * @param x coordonnée souhaitée en X.
     * @param y coordonnée souhaitée en Y.
     */
    public Element(int x, int y) {
        this.posX = x;
        this.posY = y;
        this.observers = new ArrayList<Observer>();
    }

    // Setters

    /**
     * 
     * @param x La coordonnée X.
     */
    public void setPosX(int x) {
        this.posX = x;
    }

    /**
     * 
     * @param y La coordonnée Y.
     */
    public void setPosY(int y) {
        this.posY = y;
    }

    /**
     * 
     * @param cell La cellule qu'occupera par l'Element
     */
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    // Getters

    /**
     * 
     * @return la coordonnée X.
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * 
     * @return La coordonnée Y.
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * 
     * @return La cellule occupé par l'Element
     */
    public Cell getCell() {
        return this.cell;
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
    
    @Override
    public void notifyObservers(int x,int y) {
        for (Observer o : observers) {
            o.update(x,y);
        }    
    }

}
