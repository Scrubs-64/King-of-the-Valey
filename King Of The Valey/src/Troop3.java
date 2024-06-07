public class Troop3 extends MainBase{
    static final short hp=150;
    static final short atk=75;
    static final short cost=60;
    static final String type1="T3";
    static final String type2="t3";

    //movement 2
    //range 2

    static boolean attack(int x, int y){

        boolean attacked=false;

        if(tabla[x][y].side==1 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x-2,y) && tabla[x-1][y].side==0 && tabla[x-2][y].side==2){
                Referee.damageUnit(x-2,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==2){
                Referee.damageUnit(x-1,y,atk);
                tabla[x][y].activated=true;
            }
        }

        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+2,y) && tabla[x+1][y].side==0 && tabla[x+2][y].side==1){
                Referee.damageUnit(x+2,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x+1,y) && tabla[x+1][y].side==1){
                Referee.damageUnit(x+1,y,atk);
                tabla[x][y].activated=true;
            }
        }

        return attacked;
    }

    static void move(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){


            if(Referee.checkOkCoordinates(x-2,y) && tabla[x-1][y].side==0 && tabla[x-2][y].side==0){
                Referee.setUnit(x-2,y,type1,hp,1,true);
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
