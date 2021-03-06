package comp1110.ass2;
/* Authors:
    1)Joel Chua, U6708832
    2)Gengliang Li, U6799959
    3)Peng Chen, U6460012
 */
public class Spot {

    char col; // or char col;
    char row;

    public char upEdge;
    public char downEdge;
    public char leftEdge;
    public char rightEdge;

    public Spot(String SpotString) {
        // in this constructor, get the information of col and row by
        // this.col = SpotString.chatAt(0)...sth like this
        this.row = SpotString.charAt(0);
        this.col = SpotString.charAt(1);

    }

    // 'h' is highway, 'r' is railway, 'b' is blank.
    public Spot(String SpotString, char upEdge, char rightEdge, char downEdge, char leftEdge) {
        // in this constructor, get the information of col and row by
        // this.col = SpotString.chatAt(0)...sth like this
        this.row = SpotString.charAt(0);
        this.col = SpotString.charAt(1);

        this.upEdge = upEdge;
        this.rightEdge = rightEdge;
        this.downEdge = downEdge;
        this.leftEdge = leftEdge;


    }


    public boolean isExit() {
        // this method checks whether a spot is a neighboring an exit
        // by writing some if condition
        // and if this spot is neighboring exit, then return true
        if (row == 'B' && col == '0') {
            return true;
        }
        if (row == 'D' && col == '0') {
            return true;
        }
        if (row == 'F' && col == '0') {
            return true;
        }
        if (row == 'A' && col == '1') {
            return true;
        }
        if (row == 'A' && col == '3') {
            return true;
        }
        if (row == 'A' && col == '5') {
            return true;
        }
        if (row == 'B' && col == '6') {
            return true;
        }
        if (row == 'D' && col == '6') {
            return true;
        }
        if (row == 'F' && col == '6') {
            return true;
        }
        if (row == 'G' && col == '1') {
            return true;
        }
        if (row == 'G' && col == '3') {
            return true;
        }
        if (row == 'G' && col == '5') {
            return true;
        } else {
            return false;
        }


    }

    public boolean isNeighboring(Spot testspot) {
        // this method checks whether the testspot is neighboring current spot
        // you may want to split the two character of a spot, like split"B6" into "B" and "6"
        // and "A6" into "A" and "6" to check if they are neighboring
        char testcol = testspot.col;
        char testrow = testspot.row;
        int coldefi = col - testcol;
        int rowdefi = row - testrow;
        if (Math.abs(coldefi) + Math.abs(rowdefi) < 2) {
            return true;
        } else {
            return false;
        }
    }

    public String connectionside(Spot testspot) {
        // for this method, we need to figure out if to spot is connected, what is their connection side
        char testcol = testspot.col;
        char testrow = testspot.row;
        if (col - testcol == 1 && row - testrow == 0) {
            return "left"; // the test spot is on the left of tested spot
        }
        if (testcol - col == 1 && row - testrow == 0) {
            return "right"; // the test spot is on the right of tested spot
        }
        if (row - testrow == 1 && col - testcol == 0) {
            return "upside"; // the test spot is on the upside of tested spot
        }
        if (testrow - row == 1 && col - testcol == 0) {
            return "downside"; // the test spot is on the downside of tested spot
        } else {
            return "something wrong";
        }

    }


    public boolean isCenter() {
        // this method check is a given spot in the center of the board
        if (row == 'C' && col == '2') {
            return true;
        }
        if (row == 'C' && col == '3') {
            return true;
        }
        if (row == 'C' && col == '4') {
            return true;
        }
        if (row == 'D' && col == '2') {
            return true;
        }
        if (row == 'D' && col == '3') {
            return true;
        }
        if (row == 'D' && col == '4') {
            return true;
        }
        if (row == 'E' && col == '2') {
            return true;
        }
        if (row == 'E' && col == '3') {
            return true;
        }
        if (row == 'E' && col == '4') {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return String.valueOf(this.row) + this.col;
    }

}
