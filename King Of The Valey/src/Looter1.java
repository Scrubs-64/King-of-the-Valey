public class Looter1 extends MainBase{
    static final short hp=100;
    static final short atk=25;
    static final short cost=30;
    static final String type1="L1";
    static final String type2="l1";

    //movement 1
    //range 1

    static boolean attack(int x, int y){

        if(tabla[x][y].side==1 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x-1,y) && tabla[x-1][y].side==2){
                if(atk>=tabla[x][y].hp)currentMoney+=10;
                Referee.damageUnit(x-1,y,atk);
                tabla[x][y].activated=true;
            }
        }

        else if(tabla[x][y].side==2 && !tabla[x][y].activated){
            if(Referee.checkOkCoordinates(x+1,y) && tabla[x+1][y].side==1){
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
