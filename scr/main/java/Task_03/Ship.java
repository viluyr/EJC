package Task_03;

/**
 * v_01
 */
public class Ship {
    int leng;
    public int liveDeckQty;
    Cell upperLeftCell;
    boolean isHorizontal;
    Field field;

    /**
     * @param upperLeftCell The extreme left deck of the ship
     * @param leng          Length of deck
     * @param isHorizontal  Location
     * @param field         v_01
     */

    public Ship(Cell upperLeftCell, int leng, boolean isHorizontal, Field field) {
        this.upperLeftCell = upperLeftCell;
        this.leng = leng;
        liveDeckQty = leng;
        this.isHorizontal = isHorizontal;
        this.field = field;

        for (int i = 0; i < leng; i++) {
            if (isHorizontal) {
                field.cells[upperLeftCell.x + i][upperLeftCell.y].ship = this;
            } else {
                field.cells[upperLeftCell.x][upperLeftCell.y + i].ship = this;
            }
        }
    }
}
