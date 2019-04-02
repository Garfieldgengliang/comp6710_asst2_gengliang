package comp1110.ass2;

public class Spot {

        char col; // or char col;
        char row;
        boolean exitproperty;

        public Spot(String SpotString){
            // in this constructor, get the information of col and row by
            // this.col = SpotString.chatAt(0)...sth like this
            this.row = SpotString.charAt(0);
            this.col = SpotString.charAt(1);

        }



        public void isExit(){
            // this method checks whether a spot is a neighboring an exit
            // by writing some if condition
            // and if this spot is neighboring exit, then this.exitproperty = true

        }

        public boolean isNeighboring(Spot testspot){
            // this method checks whether the testspot is neighboring current spot
            // you may want to split the two charactor of a spot, like split"B6" into "B" and "6"
            // and "A6" into "A" and "6" to check if they are neighboring
            char testcol = testspot.col;
            char testrow = testspot.row;
            int coldefi = col - testcol;
            int rowdefi = row - testrow;
            if(Math.abs(coldefi)+Math.abs(rowdefi)<2){
                return true;
            }
            else{
                return false;
            }
        }

        public String connectionside(Spot testspot){
            char testcol = testspot.col;
            char testrow = testspot.row;
            if(col - testcol == 1){
                return "left"; // the test spot is on the left of tested spot
            }
            if(testcol - col == 1){
                return "right"; // the test spot is on the right of tested spot
            }
            if(row - testrow == 1){
                return "upside"; // the test spot is on the upside of tested spot
            }
            if(testrow - row == 1){
                return "downside"; // the test spot is on the downside of tested spot
            }else{
                return "something wrong";
            }

        }


        public boolean isCenter(){
            // this method check is a given spot in the center of the board
            return false;
        }

        public boolean isOccupied(){
            // for this method, we haven't think about its parameter and usage yet
            return  false;

        }



}