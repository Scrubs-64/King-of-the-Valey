public class Bomber1 extends MainBase{
    static final short hp=100;
    static final short atk1=50;
    static final short atk2=25;
    static final short cost=50;
    static final String type1="B1";
    static final String type2="b1";

    //movement 1
    //range 2

    static boolean attack(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x-2,y) && tabla[x-2][y].side==2){
                Referee.damageUnit(x-2,y,atk1);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x-2,y-1) && tabla[x-2][y-1].side==2){
                Referee.damageUnit(x-2,y-1,atk2);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x-2,y+1) && tabla[x-2][y+1].side==2){
                Referee.damageUnit(x-2,y+1,atk2);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==2){
                Referee.damageUnit(x-1,y,atk2);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x-3,y) && tabla[x-3][y].side==2){
                Referee.damageUnit(x-3,y,atk2);
                tabla[x][y].activated=true;
            }
        }

        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+2,y) && tabla[x+2][y].side==2){
                Referee.damageUnit(x+2,y,atk1);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x+2,y-1) && tabla[x+2][y-1].side==2){
                Referee.damageUnit(x+2,y-1,atk2);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x+2,y+1) && tabla[x+2][y+1].side==2){
                Referee.damageUnit(x-2,y+1,atk2);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x+1,y) && tabla[x+1][y].side==2){
                Referee.damageUnit(x+1,y,atk2);
                tabla[x][y].activated=true;
            }
            if(Referee.checkOkCoordinates(x+3,y) && tabla[x+3][y].side==2){
                Referee.damageUnit(x+3,y,atk2);
                tabla[x][y].activated=true;
            }
        }

        return tabla[x][y].activated;
    }

    static void move(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){

            if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==0){
                Referee.setUnit(x-1,y,type1,hp,1,true);
                Referee.killUnit(x,y);
            }
        }
        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+1,y) && tabla[x+1][y].side==0){
                Referee.setUnit(x+1,y,type2,hp,2,true);
                Referee.killUnit(x,y);
            }
        }
    }
}
