package model;

/**
 * Représente les objet présent sur le terrain de jeu. Ces Elements peuvent être le Tresure ou de
 * bouteille de Rhum
 *
 */
public class Item extends Element {
    
    /**
     * Visibilité de l'objet.
     */
    protected boolean visible;

    /**
     * TODO .
     * @param x TODO
     * @param y TODO
     */
    public Item(int x,int y ) {
        super(x,y);
    }
    
    /**
     * TODO .
     */
    public Item() {
        super();
    }
    
    /**
     * Setter visible.
     * 
     * @param state Etat a affecter a l'Item.
     */
    public void setVisible(boolean state) {
        this.visible = state;
    }

    // getters

    /**
     * Getter visible.
     * 
     * @return La visibilité de l'item.
     */
    public boolean getVisible() {
        return this.visible;
    }
    
    
}
