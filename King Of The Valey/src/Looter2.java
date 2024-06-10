import java.util.Objects;

public class Looter2 extends MainBase{
    static final short hp=125;
    static final short atk=50;
    static final short cost=30;
    static final String type1="L2";
    static final String type2="l2";

    //movement 1
    //range 2

    static boolean attack(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x-2,y) && tabla[x-1][y].side==0 && tabla[x-2][y].side==2 && !Objects.equals(tabla[x - 2][y].type, "d1")){
                if(atk>=tabla[x][y].hp)currentMoney+=10;
                Referee.damageUnit(x-2,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==2){
                Referee.damageUnit(x-1,y,atk);
                tabla[x][y].activated=true;
            }
        }

        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+2,y) && tabla[x+1][y].side==0 && tabla[x+2][y].side==1  && !Objects.equals(tabla[x + 2][y].type, "D1")){
                Referee.damageUnit(x+2,y,atk);
                tabla[x][y].activated=true;
            }
            else if(Referee.checkOkCoordinates(x+1,y) && tabla[x+1][y].side==1){
                Referee.damageUnit(x+1,y,atk);
                tabla[x][y].activated=true;
            }
        }

        return tabla[x][y].activated;
    }

    static void move(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){

            if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==0){
                Referee.setUnit(x-1,y,type1,tabla[x][y].hp,1,true);
                Referee.killUnit(x,y);
            }
        }
        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+1,y) && tabla[x+1][y].side==0){
                Referee.setUnit(x+1,y,type2,tabla[x][y].hp,2,true);
                Referee.killUnit(x,y);
            }
        }
    }
}
