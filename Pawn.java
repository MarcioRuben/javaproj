import java.util.HashSet;

public class Pawn extends Pieces{
    //private ArrayList<String> moves;
    private HashSet<Point> pontosDisponiveis;

    public Pawn(String side, Point local, Board board){
        super(side, local, board);
        pontosDisponiveis = new HashSet<Point>();
    }

    @Override
    public void move(Board table){//recebe o tabuleiro associado. O segundo argumento não é necessário
        //ArrayList<Point> pontosDisponiveis = new ArrayList<Point>();
        //Pieces[][] t = table.getPieces();
        Point pontoAtual = super.gePoint();
        //pontosDisponiveis = super.getMovementsAvailable();
        /* começa por verificar se a primeira posição à frente do peão está disponível. Se estiver, caso não haja uma peça na dada posição, então adiciona a mesma ao array de jogadas possíveis
         * de seguida verifica-se se a segunda posição à frente está disponível. Se estiver, repete-se o processo 
         * faz-se a mesma coisa mas para as primeiras posições na diagonal, mas no caso de haver peça numa dada posição, verifica-se a cor da peça presente e
         * caso a peça tenha cor diferente, então adiciona-se a posição ao array de movimentos possíveis
         * Depois vê-se se o ponto destino corresponde a algum ponto presente na lista. Caso 
        */
        if(super.getSide().equals("Black")){

            if(table.inBoard(pontoAtual.getX() + 1, pontoAtual.getY()) && table.existentPiece(pontoAtual.getX() + 1, pontoAtual.getY()) == false){ //movimentos verticais
                pontosDisponiveis.add(new Point(pontoAtual.getX() + 1, pontoAtual.getY()));
                if(table.inBoard(pontoAtual.getX() + 2, pontoAtual.getY()) || table.existentPiece(pontoAtual.getX() + 2, pontoAtual.getY()) == false){ //incomplete, ver se as posições seguinte estão em campo também
                    pontosDisponiveis.add(new Point(pontoAtual.getX() + 2, pontoAtual.getY()));
                }
            }

            else if(table.inBoard(pontoAtual.getX() + 1, pontoAtual.getY() + 1) || table.inBoard(pontoAtual.getX() + 1, pontoAtual.getY() - 1)){//movimentos diagonais
                if(table.existentPiece(pontoAtual.getX() + 1, pontoAtual.getY() + 1) && table.getPiece(new Point(pontoAtual.getX() + 1, pontoAtual.getY() + 1)).getSide().equals("White")){
                    pontosDisponiveis.add(new Point(pontoAtual.getX() + 1, pontoAtual.getY() + 1));
                }
                else if(table.existentPiece(pontoAtual.getX() + 1, pontoAtual.getY() - 1) && table.getPiece(new Point(pontoAtual.getX() + 1, pontoAtual.getY() - 1)).getSide().equals("White")){
                    pontosDisponiveis.add(new Point(pontoAtual.getX() + 1, pontoAtual.getY() - 1));
                }
            }

            //caso o peão chegue ao final do tabuleiro, torna-se numa rainha
            /*else if(pontoAtual.getX() == 8){
                this = new Queen(pontoAtual, table, "Black");
            }*/
        }

        else if(super.getSide().equals("White")){

            if(table.inBoard(pontoAtual.getX() - 1, pontoAtual.getY()) && table.existentPiece(pontoAtual.getX() - 1, pontoAtual.getY()) == false){ //movimentos verticais
                pontosDisponiveis.add(new Point(pontoAtual.getX() - 1, pontoAtual.getY()));
                if(table.inBoard(pontoAtual.getX() - 2, pontoAtual.getY()) || table.existentPiece(pontoAtual.getX() - 2, pontoAtual.getY()) == false){ //incomplete, ver se as posições seguinte estão em campo também
                    pontosDisponiveis.add(new Point(pontoAtual.getX() - 2, pontoAtual.getY()));
                }
            }

            else if(table.inBoard(pontoAtual.getX() - 1, pontoAtual.getY() + 1) || table.inBoard(pontoAtual.getX() - 1, pontoAtual.getY() - 1)){//movimentos diagonais
                if(table.existentPiece(pontoAtual.getX() - 1, pontoAtual.getY() + 1) && table.getPiece(new Point(pontoAtual.getX() - 1, pontoAtual.getY() + 1)).getSide().equals("Black")){
                    pontosDisponiveis.add(new Point(pontoAtual.getX() - 1, pontoAtual.getY() + 1));
                }
                else if(table.existentPiece(pontoAtual.getX() - 1, pontoAtual.getY() - 1) && table.getPiece(new Point(pontoAtual.getX() - 1, pontoAtual.getY() - 1)).getSide().equals("Black")){
                    pontosDisponiveis.add(new Point(pontoAtual.getX() - 1, pontoAtual.getY() - 1));
                }
            }
        }
    }

    @Override
    public HashSet<Point> getPossibleMoves(){
        return pontosDisponiveis;
    }

    //moves.add(pontoDestino.toString());
    //fazer função para o peão trocar para rainha quando chega ao fim do tabuleiro

    @Override
    public String toString(){
        return "P";
    }
}
