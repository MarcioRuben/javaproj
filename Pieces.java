import java.util.HashSet;

public abstract class Pieces {

    private Point _coordenate;
    private String _side; //preta ou branca
    private Board _table;
    protected  HashSet<Point> movementsAvailable;

    public Pieces(String tipo, Point ponto, Board table){
        _side = tipo;
        _coordenate = ponto;
        _table = table;
        movementsAvailable = new HashSet<Point>();
    }

    //Construtor apenas para espaços sem peça
    public Pieces(Point p, Board b){
        _coordenate = p;
        _table = b;
    }

    public abstract void move(Board table);//tem como argumentos o tabuleiro em jogo 
    public abstract String toString();
    public abstract HashSet<Point> getPossibleMoves();


    public Board getBoard(){
        return _table;
    }

    

    public Point gePoint(){
        return _coordenate;
    }

    public String getSide(){
        return _side;
    }

    public void setNewCoordenate(Point novo){
        _coordenate = new Point(novo.getX(), novo.getY());
    }


    public void addMove(Point coordenada){
        movementsAvailable.add(coordenada);
    }

    //usar sempre depois de uma jogada, pois vai sempre haver novos pontos disponíveis sempre que há movimento
    public void clearMovimentosPossiveis(){
        movementsAvailable.clear();
    }

    public void makeMove(Point pontoDestino, Board table, HashSet<Point> jogadasPossiveis) {

            if(jogadasPossiveis.contains(pontoDestino)){
                table.movePiece(pontoDestino, this);
            }
            //this._coordenate = pontoDestino;
            //moves.add(pontoDestino.toString());
        
    }
    
}
