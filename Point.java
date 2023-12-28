public class Point {
    private int _x;
    private int _y;

    public Point(int x, int y){
        _x = x;
        _y = y;
    }

    public int getX(){
        return _x;
    }

    public int getY(){
        return _y;
    }

    public boolean equalPoints(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return "("+Integer.toString(_x)+","+Integer.toString(_y)+")";
    }
}
