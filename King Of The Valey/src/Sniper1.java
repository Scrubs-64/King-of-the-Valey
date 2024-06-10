import java.util.Objects;

public class Sniper1 extends MainBase{
    static final short hp=75;
    static final short atk=100;
    static final short cost=30;
    static final String type1="S1";
    static final String type2="s1";

    //movement 1/2
    //range 3

    static boolean attack(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x-3,y) && tabla[x-1][y].side==0 && tabla[x-2][y].side==0 && tabla[x-3][y].side==2 && !Objects.equals(tabla[x - 3][y].type, "d1")){
                Referee.damageUnit(x-3,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x-2,y) && tabla[x-1][y].side==0 && tabla[x-2][y].side==2 && !Objects.equals(tabla[x - 2][y].type, "d1")){
                Referee.damageUnit(x-2,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==2){
                Referee.damageUnit(x-1,y,atk);
                tabla[x][y].activated=true;
            }
        }

        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+3,y) && tabla[x+1][y].side==0 && tabla[x+2][y].side==0 && tabla[x+3][y].side==1 && !Objects.equals(tabla[x + 3][y].type, "D1")){
                Referee.damageUnit(x+3,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x+2,y) && tabla[x+1][y].side==0 && tabla[x+2][y].side==1 && !Objects.equals(tabla[x + 2][y].type, "D1")){
                Referee.damageUnit(x+2,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==1){
                Referee.damageUnit(x+1,y,atk);
                tabla[x][y].activated=true;
            }
        }

        return tabla[x][y].activated;
    }

    static void move(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){

            if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==0 && turn==1){
                Referee.setUnit(x-1,y,type1,hp,1,true);
                Referee.killUnit(x,y);
            }
        }
        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+1,y) && tabla[x+1][y].side==0 && turn==2){
                Referee.setUnit(x+1,y,type2,hp,2,true);
                Referee.killUnit(x,y);
            }
        }
    }
}
