import java.util.HashSet;

public class Knight extends Pieces{
    private HashSet<Point> possibleMoves;

    public Knight(Point point, Board table, String lado){
        super(lado, point, table);
        possibleMoves = new HashSet<Point>();
    }

    public void move(Board table){
        Point currentPoint = super.gePoint();

        if(table.inBoard(currentPoint.getX() + 2, currentPoint.getY() + 1)){
            if(table.existentPiece(currentPoint.getX() + 2, currentPoint.getY() + 1) == false ||
            table.getPiece(currentPoint).getSide() != this.getSide()){
                possibleMoves.add(new Point(currentPoint.getX() + 2, currentPoint.getY() + 1));
            }
        }
        
        if(table.inBoard(currentPoint.getX() + 2, currentPoint.getY() - 1)){
            if(table.existentPiece(currentPoint.getX() + 2, currentPoint.getY() - 1) == false ||
            table.getPiece(currentPoint).getSide() != this.getSide()){
                possibleMoves.add(new Point(currentPoint.getX() + 2, currentPoint.getY() - 1));
            }
        }

        if(table.inBoard(currentPoint.getX() - 2, currentPoint.getY() + 1) && (table.existentPiece(currentPoint.getX() - 2, currentPoint.getY() + 1) == false ||
        table.getPiece(currentPoint).getSide() != this.getSide())){
            possibleMoves.add(new Point(currentPoint.getX() - 2, currentPoint.getY() + 1));
        }

        if(table.inBoard(currentPoint.getX() - 2, currentPoint.getY() - 1) && (table.existentPiece(currentPoint.getX() - 2, currentPoint.getY() - 1) == false ||
        table.getPiece(currentPoint).getSide() != this.getSide())){
            possibleMoves.add(new Point(currentPoint.getX() - 2, currentPoint.getY() - 1));
        }

        if(table.inBoard(currentPoint.getX() + 1, currentPoint.getY() - 2) && (table.existentPiece(currentPoint.getX() + 1, currentPoint.getY() - 2) == false ||
        table.getPiece(currentPoint).getSide() != this.getSide())){
            possibleMoves.add(new Point(currentPoint.getX() + 1, currentPoint.getY() - 2));
        }

        if(table.inBoard(currentPoint.getX() + 1, currentPoint.getY() + 2) && (table.existentPiece(currentPoint.getX() + 1, currentPoint.getY() + 2) == false ||
        table.getPiece(currentPoint).getSide() != this.getSide())){
            possibleMoves.add(new Point(currentPoint.getX() + 1, currentPoint.getY() + 2));
        }

        if(table.inBoard(currentPoint.getX() - 1, currentPoint.getY() - 2) && (table.existentPiece(currentPoint.getX() - 1, currentPoint.getY() - 2) == false ||
        table.getPiece(currentPoint).getSide() != this.getSide())){
            possibleMoves.add(new Point(currentPoint.getX() - 1, currentPoint.getY() - 2));
        }

        if(table.inBoard(currentPoint.getX() - 1, currentPoint.getY() + 2) && (table.existentPiece(currentPoint.getX() - 1, currentPoint.getY() + 2) == false ||
        table.getPiece(currentPoint).getSide() != this.getSide())){
            possibleMoves.add(new Point(currentPoint.getX() - 1, currentPoint.getY() + 2));
        }
    }



    @Override
    public HashSet<Point> getPossibleMoves(){
        return possibleMoves;
    }

    @Override
    public String toString(){
        return "N";
    }

}    
