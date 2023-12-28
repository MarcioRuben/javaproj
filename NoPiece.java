import java.util.HashSet;

public class NoPiece extends Pieces{

    private HashSet<Point> possibleMoves;

    public NoPiece(Point ponto, Board table){
        super(ponto, table);
    }

    public String toString(){
        return "-";
    }

    //trocar espaçco vazio com peça
    public void move(Board table){
        Pieces[][] tabuleiro = table.getPieces();

    }

    public HashSet<Point> getPossibleMoves(){
        return possibleMoves;
    }
    
}
