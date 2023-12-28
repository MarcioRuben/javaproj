import java.util.HashSet;

public class King extends Pieces{
    private HashSet<Point> possibleMoves;

    public King(Point ponto, Board table, String lado){
        super(lado, ponto, table);
        possibleMoves = new HashSet<Point>();
    }

    @Override
    public void move(Board base){
        Point pontoAtual = super.gePoint();

        for(int i = -1; i <= 1; i++){
            if(base.inBoard(pontoAtual.getX() + 1, pontoAtual.getY() + i) && base.existentPiece(pontoAtual.getX() + 1, pontoAtual.getY() + i) == false){
                possibleMoves.add(new Point(pontoAtual.getX() + 1, pontoAtual.getY() + i));
            }else if(base.existentPiece(pontoAtual.getX() + 1, pontoAtual.getY() + i)){
                if(base.getPiece(new Point(pontoAtual.getX() + 1, pontoAtual.getY() + i)).getSide() != this.getSide()){
                    possibleMoves.add(new Point(pontoAtual.getX() + 1, pontoAtual.getY() + i));
                }
            }
        }

        for(int j = -1; j<=1; j++){
            if(base.inBoard(pontoAtual.getX() - 1, pontoAtual.getY() + j) && base.existentPiece(pontoAtual.getX() - 1, pontoAtual.getY() + j) == false){
                possibleMoves.add(new Point(pontoAtual.getX() - 1, pontoAtual.getY() + j));
            }else if(base.existentPiece(pontoAtual.getX() - 1, pontoAtual.getY() + j)){
                if(base.getPiece(new Point(pontoAtual.getX() - 1, pontoAtual.getY() + j)).getSide() != this.getSide()){
                    possibleMoves.add(new Point(pontoAtual.getX() - 1, pontoAtual.getY() + j));
                }
            }
        }

        if(base.inBoard(pontoAtual.getX() + 1, pontoAtual.getY()) && base.existentPiece(pontoAtual.getX() + 1, pontoAtual.getY()) == false){
            possibleMoves.add(new Point(pontoAtual.getX() + 1, pontoAtual.getY()));
        }else if(base.existentPiece(pontoAtual.getX() + 1, pontoAtual.getY())){
            if(base.getPiece(new Point(pontoAtual.getX() + 1, pontoAtual.getY())).getSide() != this.getSide()){
                possibleMoves.add(new Point(pontoAtual.getX() + 1, pontoAtual.getY()));
            }
        }

        if(base.inBoard(pontoAtual.getX() - 1, pontoAtual.getY()) && base.existentPiece(pontoAtual.getX() - 1, pontoAtual.getY()) == false){
            possibleMoves.add(new Point(pontoAtual.getX() - 1, pontoAtual.getY()));
        }else if(base.existentPiece(pontoAtual.getX() - 1, pontoAtual.getY())){
            if(base.getPiece(new Point(pontoAtual.getX() - 1, pontoAtual.getY())).getSide() != this.getSide()){
                possibleMoves.add(new Point(pontoAtual.getX() - 1, pontoAtual.getY()));
            }
        }
    }

    public HashSet<Point> getPossibleMoves(){
        return possibleMoves;
    }

    public String toString(){
        return "K";
    }

    
}
