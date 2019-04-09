package pathFinder;

/**
 * Node Class
 *
 * @author Marcelo Surriabre
 * @version 2.0, 2018-02-23
 */
public class Node {

    private int g;
    private int f;
    private int h;
    private int row;
    private int col;
    private boolean isBlock;
    private Node parent;

    /**
     * Constructeur.
     * @param row largeur
     * @param col hauteur
     */
    public Node(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    /**
     * Fonction qui calcule la valeur heuristic.
     * @param finalNode Le Node de fin vers lequel calculer la valeur.
     */
    public void calculateHeuristic(Node finalNode) {
        this.h = Math.abs(finalNode.getRow() - getRow()) + Math.abs(finalNode.getCol() - getCol());
    }

    /**
     * TODO.
     * @param currentNode
     * @param cost
     */
    public void setNodeData(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
        setParent(currentNode);
        setG(gCost);
        calculateFinalCost();
    }

    /**
     * Méthode qui vérifie si un meilleur chemin existe
     * @param currentNode
     * @param cost
     * @return
     */
    public boolean checkBetterPath(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
        if (gCost < getG()) {
            setNodeData(currentNode, cost);
            return true;
        }
        return false;
    }

    /**
     * Méthode qui calcule le cout final.
     */
    private void calculateFinalCost() {
        int finalCost = getG() + getH();
        setF(finalCost);
    }

    @Override
    public boolean equals(Object arg0) {
        Node other = (Node) arg0;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }

    @Override
    public String toString() {
        return "Node [row=" + row + ", col=" + col + "]";
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}



















//public class Node {
//
//    /**
//     * Coordonées.
//     */
//    private int x, y;
//
//    /**
//     * Node parent.
//     */
//    private Node parent;
//
//    /**
//     * Cout final, G+H avec : G(n) the cout du chemin du Node de départ à n et H (n) l'heuritic qui
//     * estime le cout du chemin le plus court de n au but. *
//     */
//    private int finalCost; // G+H with
//
//    /**
//     * Constructeur basique.
//     * 
//     * @param x x
//     * @param y y
//     */
//    public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public String toString() {
//        return "[" + this.x + ";" + this.y + "]";
//    }
//
//    /**
//     * @return the x
//     */
//    public int getX() {
//        return x;
//    }
//
//    /**
//     * @param x the x to set
//     */
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    /**
//     * @return the y
//     */
//    public int getY() {
//        return y;
//    }
//
//    /**
//     * @param y the y to set
//     */
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    /**
//     * @return the parent
//     */
//    public Node getParent() {
//        return parent;
//    }
//
//    /**
//     * @param parent the parent to set
//     */
//    public void setParent(Node parent) {
//        this.parent = parent;
//    }
//
//    /**
//     * @return the finalCast
//     */
//    public int getFinalCost() {
//        return finalCost;
//    }
//
//    /**
//     * @param finalCast the finalCast to set
//     */
//    public void setFinalCost(int finalCast) {
//        this.finalCost = finalCast;
//    }
//}
