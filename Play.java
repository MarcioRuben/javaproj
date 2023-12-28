import java.util.Scanner;

public class Play {
    private String White = "White";
    private String Black = "Black";
    private Board tabuleiro;

    public Play(Board table){
        tabuleiro = table;
    }

    /* Comando
     * -play | posição da peça a ser movida(a1) | posição desejada
     * 
     * Fazer temporizador
     */
    
    
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Board b = new Board();
        b.drawBoard();

        System.out.println("Insira o comando que pretende: ");

        String command = scanner.nextLine();
        Parser parser = new Parser();
        if(parser.parseFirstWord(command).equals("show")){
            parser.parseShow(command, null);//falta meter o tabuleiro associado
        }
        else if(parser.parseFirstWord(command).equals("play")){
            Point piecePoint = parser.parsePiecePoint(command);
            Point desiredPoint = parser.parseDesiredPoint(command);
            Pieces peca = b.getPiece(piecePoint);
            System.out.println(b.inBoard(desiredPoint.getX(), desiredPoint.getY()));
            System.out.println(peca.getSide()); 
            System.out.println(parser.parseFirstWord(command));
            //b.drawBoard();
            scanner.close();
        }
        //scanner.close();

        //Board b = new Board();
        //b.drawBoard();
        /*Pieces piece = b.getPiece(new Point(8,7));
        piece.move(b);//retira todos os movimentos possíveis
        b.movePiece(new Point(6,6), piece);// vai efetivamente mover a peça no tabuleiro
        System.out.println(piece.getPossibleMoves());*/
        

        /*while(true){
            break;
        }*/
        //scanner.nextLine();
    }
}