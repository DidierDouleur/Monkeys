package model;

import java.util.ArrayList;
import java.util.List;

import pathFinder.AStar;
import pathFinder.Node;

/**
 * Startégie de chasse.
 * 
 * @author bij
 *
 */
public class StrategyHunting extends StrategyDeplacement {

    /**
     * 
     */
    AStar aStar;

    /**
     * Island de la partie.
     */
    Island island;

    /**
     * Map de la partie.
     */
    Map map;

    /**
     * Constructeur.
     * 
     * @param monkey Le Monkey qui applique la strtégie
     */
    public StrategyHunting(Monkey monkey) {
        super(monkey);
        this.island = GameMaster.getInstance().getIsland();
        this.map = this.island.getMap();
    }

    @Override
    public EDirection generateDirection() {
        return map.getDirectionFromCells2(this.monkey.getCell(),
                this.findTargetCellToClosestPirate());
    }

    /**
     * Léthode qui génére le block.
     */
    public void generateBlock() {
        ArrayList<Cell> aux = new ArrayList<Cell>();
        for (Cell cell : map.getCells()) {
            if (!this.monkey.canAccess(cell)) {
                aux.add(cell);
            }
        }
        int[][] ret = new int[aux.size()][2];
        int i = 0;
        for (Cell cell : aux) {
            ret[i][0] = cell.getCoordX();
            ret[i][1] = cell.getCoordY();
            i++;
        }
        this.aStar.setBlocks(ret);
    }

    /**
     * Méthode trouvant le chemin le plus court vers des coordonnées données.
     * 
     * @param x x de destination
     * @param y y de destination
     * @return le chemin a parcourir sours forme de liste de Node dont le premier est la position de
     *         départ.
     */
    public List<Node> findPath(int x, int y) {
        this.aStar = new AStar(map.getSizeX() + 1, map.getSizeY() + 1,
                new Node(this.monkey.getPosY(), this.monkey.getPosX()), new Node(y, x));
        this.generateBlock();
        return aStar.findPath();
    }

    /**
     * Methode qui trouve le chemin le plus cours entre la lsit de Cell cibles.
     * 
     * @param cells liste des Cell que l'on souhaite atteindre.
     * @return list
     */
    public List<Node> findBestPathToCells(ArrayList<Cell> cells) {
        List<Node> best = new ArrayList<Node>();
        List<Node> aux;
        for (Cell cell : cells) {
            aux = this.findPath(cell.getCoordX(), cell.getCoordY());
            if (best.isEmpty() || best.size() > aux.size()) {
                best = aux;
            }
        }
        return best;
    }

    /**
     * Méthode retournant la Cellule adjacente a atteindre si on souhaite chasser des pirate.
     * 
     * @return cell
     */
    public Cell findTargetCellToClosestPirate() {
        Cell ret = null;
        ArrayList<Pirate> listPirate = this.island.getListPirate();
        if (listPirate != null && !listPirate.isEmpty()) {
            ArrayList<Cell> listCell = new ArrayList<Cell>();
            for (Pirate pirate : this.island.getListPirate()) {
                if (pirate.getState() == EPirateState.ALIVE) {
                    listCell.add(pirate.getCell());
                    List<Node> aux = this.findBestPathToCells(listCell);
                    ret = map.getCell(aux.get(1).getCol(), aux.get(1).getRow());
                }
            }

        }
        return ret;
    }

}
