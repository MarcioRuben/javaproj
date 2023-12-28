public class Parser {
    private String pedido;

    public Parser(){
        
    }

    public void parseShow(String s, Board table){
        String[] comando = s.split(" ", -2);

        if(comando[0] == "show"){
            System.out.println(table.getAllMovements());
        }
    }

    public String parseFirstWord(String d){
        String[] c = d.split(" ");
        return c[0];
    }

    //retira o segundo ponto introduzido no comando
    public Point parseDesiredPoint(String g){
        String[] comando = g.split(" ");
        char character = comando[2].charAt(0);
        int x = (int)character;
        x -= 96; //coluna
        int y = (int)comando[2].charAt(1);
        y -= 48; //linha
        return new Point(y, x);
    }

    //retira o primeiro ponto introduzido no comando
    public Point parsePiecePoint(String f){
        String[] com = f.split(" ");

        char character = com[1].charAt(0);
        int x = (int)character;
        x -= 96; //coluna
        int y = (int)com[1].charAt(1);
        y -= 48; //linha
        return new Point(y, x);
    }
}
