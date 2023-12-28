import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Board{
    
    private Pieces[][] _pieces;
    private ArrayList<String> allMovements;
    private ArrayList<Pieces> removedPieces;
    private HashMap<Pieces,HashSet<Point>> plays;
    private boolean state; //Ver de quem é a vez

    public Board(){//falta definir os os lados de cada peça que não seja peão
        _pieces = new Pieces[8][8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(i == 1){
                    _pieces[i][j] = new Pawn("Black", new Point(i + 1, j + 1), this);
                }
                else if(i == 6){
                    _pieces[i][j] = new Pawn("White", new Point(i + 1, j + 1), this);
                }
                else if(i == 0){
                    if(j == 0 || j == 7){
                        _pieces[i][j] = new Rook(new Point(i + 1, j + 1), this, "Black");
                    }
                    else if(j == 1 || j == 6){
                        _pieces[i][j] = new Knight(new Point(i + 1, j + 1), this, "Black");
                    }
                    else if(j == 2 || j == 5){
                        _pieces[i][j] = new Bishop(new Point(i + 1, j + 1), this, "Black");
                    }
                    else if(j == 3){
                        _pieces[i][j] = new Queen(new Point(i + 1, j + 1), this, "Black");
                    }
                    else if(j == 4){
                        _pieces[i][j] = new King(new Point(i + 1, j + 1), this, "Black");
                    }
                }
                else if(i == 7){
                    if(j == 0 || j == 7){
                        _pieces[i][j] = new Rook(new Point(i + 1, j + 1), this, "White");
                    }
                    else if(j == 1 || j == 6){
                        _pieces[i][j] = new Knight(new Point(i + 1, j + 1), this, "White");
                    }
                    else if(j == 2 || j == 5){
                        _pieces[i][j] = new Bishop(new Point(i + 1, j + 1), this, "White");
                    }
                    else if(j == 3){
                        _pieces[i][j] = new Queen(new Point(i + 1, j + 1), this, "White");
                    }
                    else if(j == 4){
                        _pieces[i][j] = new King(new Point(i + 1, j + 1), this, "White");
                    }
                }
                else{
                    _pieces[i][j] = new NoPiece(new Point(i + 1, j + 1), this);
                }
            }
        }
        plays = new HashMap<Pieces,HashSet<Point>>(); 
    }

    //Devolve a peça de uma determinada posição, caso tenha
    public Pieces getPiece(Point p){
        return _pieces[p.getX() - 1][p.getY() - 1];
    }

    //Guarda todos os movimentos efetuados
    public void registerMovements(Point p, Pieces f){
        allMovements.add("("+f.toString()+""+p.toString()+")");
    }

    //Verifica se uma dada posição está ocupada
    public boolean existentPiece(int r,int c){
        if(_pieces[r - 1][c - 1] instanceof NoPiece){
            return false;
        }
        return true;
    }

    public void changeState(){
        if(state == true){
            state = false;
        }
        else{
            state = true;
        }
    }

    
    
    public void drawBoard(){
        System.out.print("  abcdefgh\n");
        //System.out.print("  --------\n");
        for(int i = 0; i < 8; i++){
            System.out.print(+i + 1+"|");
            for(int j = 0; j < _pieces[i].length; j++){
                if(_pieces[i][j] instanceof Pieces){
                    System.out.print(_pieces[i][j].toString());
                }
            }
            System.out.print("\n");
        }
    }

    public Pieces[][] getPieces(){
        return _pieces;
    }

    public void movePiece(Point p, Pieces piece){
        Point pontoSemPeca = piece.gePoint();
        //_pieces[p.getX() - 1][p.getY() - 1] = piece;
        //_pieces[pontoSemPeca.getX() - 1][pontoSemPeca.getY() - 1] = new NoPiece(piece.gePoint(), this);
        for(Point f: piece.getPossibleMoves()){
            if(f.getX() == p.getX() && f.getY() == p.getY()){
                _pieces[p.getX() - 1][p.getY() - 1] = piece;
                _pieces[pontoSemPeca.getX() - 1][pontoSemPeca.getY() - 1] = new NoPiece(piece.gePoint(), this);;
            }
        }
    }

    public void movePeca(Point p, Pieces piece){
        _pieces[p.getX() - 1][p.getY() - 1] = piece;
        _pieces[piece.gePoint().getX() - 1][piece.gePoint().getY() - 1] = new NoPiece(piece.gePoint(), this);
    }


    public void removePiece(Pieces p){
        Point ponto = p.gePoint();
        _pieces[ponto.getX()][ponto.getY()] = new NoPiece(ponto, this);
        removedPieces.add(p);
    }

    public boolean inBoard(int p, int c){
        if(p <= 8 && c <= 8 && p >= 1 && c >= 1){
            return true;
        }else{
            return false;
        }
    }
 

    //devolve um array com todas as jogadas possíveis de todas as peças em campo
    public HashMap<Pieces,HashSet<Point>> saveAllPossiblePlays(){
        for(int i = 0; i<8; i++){
            for(int j = 0; i<8; j++){
                if(_pieces[i][j].toString() != "-"){
                    plays.put(_pieces[i][j], _pieces[i][j].getPossibleMoves());
                }
            }
        }
        return plays;
    }

    public void clearPossibleMoves(){
        plays.clear();
    }

    public ArrayList<String> getAllMovements(){
        return allMovements;
    }

}