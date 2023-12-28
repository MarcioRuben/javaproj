import java.util.HashSet;

public class Rook extends Pieces{
    private HashSet<Point> moves;

    public Rook(Point ponto, Board table, String lado){
        super(lado, ponto, table);
        moves = new HashSet<Point>();
    }

    public void move(Board table){

        Point point = this.gePoint();

        /*adiciona às jogadas possíveis se não houver peça no local
         * caso haja, se a peça no local não for da cor do bispo, adiciona-se a posição da peça ao set de movimentos possíveis e para-se o loop
         * se a peça presente for da mesma cor, não se adiciona a posição ao set e dá-se break ao loop
         */

        //vertical - para baixo
        for(int i = 1; i<7; i++){
            if(table.inBoard(point.getX() + i, point.getY())){
                if((table.getPiece(new Point(point.getX() + i, point.getY())) instanceof NoPiece)){
                    moves.add(new Point(point.getX() + i, point.getY()));
                }
                else{
                    if(table.getPiece(new Point(point.getX() + i, point.getY())).getSide() != this.getSide()){
                        moves.add(new Point(point.getX() + i, point.getY()));
                        break;
                    }
                }
            }
        }

        //vertical - para cima
        for(int j = 1; j<7; j++){
            if(table.inBoard(point.getX() - j, point.getY())){
                if(table.existentPiece(point.getX() - j, point.getY()) == false){
                    if(table.getPiece(new Point(point.getX() - j, point.getY())) instanceof NoPiece){
                        moves.add(new Point(point.getX() - j, point.getY()));
                    }
                }
                else break;
            }
        }

        //horizontal - para a esquerda
        for(int k = 1; k<7; k++){
            if(table.inBoard(point.getX(), point.getY() - k)){
                if(table.getPiece(new Point(point.getX(), point.getY() - k)) instanceof NoPiece){
                    moves.add(new Point(point.getX(), point.getY() - k));
                }
                else if(table.getPiece(new Point(point.getX(), point.getY() - k)).getSide() != this.getSide()){ //caso exista peça
                    moves.add(new Point(point.getX(), point.getY() - k));
                }
                else break;
            }
        }

        //horizontal - para a direita
        for(int l = 1; l<7; l++){
            if(table.inBoard(point.getX(), point.getY() + l)){
                if(///table.getPiece(new Point(point.getX(), point.getY() + l)).getSide().equals(this.getSide()) == false ||
                table.getPiece(new Point(point.getX(), point.getY() + l)) instanceof NoPiece){
                    moves.add(new Point(point.getX(), point.getY() + l));
                }
                else break;
            }
        }
    }

    public HashSet<Point> getPossibleMoves(){
        return moves;
    }
    
    public String toString(){
        return "R";
    }
}
