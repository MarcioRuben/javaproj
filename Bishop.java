import java.util.HashSet;

public class Bishop extends Pieces{
    private HashSet<Point> availableMoves;

    public Bishop(Point ponto, Board table, String lado){
        super(lado, ponto, table);
        availableMoves = new HashSet<Point>();
    }

    @Override
    public HashSet<Point> getPossibleMoves(){
        return availableMoves;
    }

    public void move(Board table){
        Point currentPoint = super.gePoint();

        for(int i = 1; i<7; i++){
            if(table.inBoard(currentPoint.getX() + i, currentPoint.getY() + i) == true){
                if(table.getPiece(new Point(currentPoint.getX() + i, currentPoint.getY() + i)).getSide().equals(this.getSide()) == false || 
                table.existentPiece(currentPoint.getX() + i, currentPoint.getY() + i) == false){
                    availableMoves.add(new Point(currentPoint.getX() + i, currentPoint.getY() + i));
                }
                else break;
            }
            else{
                break;
            }
        }

        for(int j = 1; j<7; j++){
            if(table.inBoard(currentPoint.getX() + j, currentPoint.getY() - j) == true){
                if(table.existentPiece(currentPoint.getX() + j, currentPoint.getY() - j) == false || 
                table.getPiece(new Point(currentPoint.getX() + j, currentPoint.getY() - j)).getSide().equals(this.getSide()) == false){
                    availableMoves.add(new Point(currentPoint.getX() + j, currentPoint.getY() - j));
                }
                else break;
            }
            else break;
        }

        for(int k = 1; k<7; k++){
            if(table.inBoard(currentPoint.getX() - k, currentPoint.getY() + k) == true){
                if(table.existentPiece(currentPoint.getX() - k, currentPoint.getY() + k) == false || 
                table.getPiece(new Point(currentPoint.getX() - k, currentPoint.getX() + k)).getSide().equals(this.getSide()) == false){
                    availableMoves.add(new Point(currentPoint.getX() - k, currentPoint.getX() + k));
                }
                else break;
            }
            else break;
        }

        for(int l = 0; l<7; l++){
            if(table.inBoard(currentPoint.getX() - l, currentPoint.getY() - l) == true){
                if(table.existentPiece(currentPoint.getX() + l, currentPoint.getY() - l) == false || 
                table.getPiece(new Point(currentPoint.getX() - l, currentPoint.getX() - l)).getSide().equals(this.getSide()) == false){
                    availableMoves.add(new Point(currentPoint.getX() - l, currentPoint.getX() - l));
                }
                else break;
            }
            else break;
        }
    }

    public String toString(){
        return "B";
    }

    
    
}
