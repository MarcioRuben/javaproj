import java.util.HashSet;
import java.util.List;

public class Queen extends Pieces{
    private HashSet<Point> moves;

    public Queen(Point ponto, Board table, String lado){
        super(lado, ponto, table);
    }

    @Override
    public void move(Board board){

    }

    public HashSet<Point> getPossibleMoves(){
        return moves;
    }

    @Override
    public String toString(){
        return "Q";
    }
}
