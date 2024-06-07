import java.util.Objects;

public class Referee extends MainBase{

    static void setUnit(int x, int y,String typeIn,int hpIn,int sideIn, boolean activatedIn){
        tabla[x][y].type=typeIn;
        tabla[x][y].hp=hpIn;
        tabla[x][y].side=sideIn;
        tabla[x][y].activated=activatedIn;
    }

    static int[] identifyUnitProperties(String input) {

        int[] proprietati = new int[2];

        switch (input) {
            case Troop1.type1: {
                proprietati[0] = Troop1.hp;
                proprietati[1] = Troop1.cost;
                return proprietati;
            }
            case Troop2.type1: {
                proprietati[0] = Troop2.hp;
                proprietati[1] = Troop2.cost;
                return proprietati;
            }
            case Troop3.type1: {
                proprietati[0] = Troop3.hp;
                proprietati[1] = Troop3.cost;
                return proprietati;
            }
            case Heavy1.type1: {
                proprietati[0] = Heavy1.hp;
                proprietati[1] = Heavy1.cost;
                return proprietati;
            }
            case Heavy2.type1: {
                proprietati[0] = Heavy2.hp;
                proprietati[1] = Heavy2.cost;
                return proprietati;
            }
            case Sniper1.type1: {
                proprietati[0] = Sniper1.hp;
                proprietati[1] = Sniper1.cost;
                return proprietati;
            }
            case Sniper2.type1: {
                proprietati[0] = Sniper2.hp;
                proprietati[1] = Sniper2.cost;
                return proprietati;
            }
            case Bomber1.type1: {
                proprietati[0] = Bomber1.hp;
                proprietati[1] = Bomber1.cost;
                return proprietati;
            }
            case Bomber2.type1: {
                proprietati[0] = Bomber2.hp;
                proprietati[1] = Bomber2.cost;
                return proprietati;
            }
            case Looter1.type1: {
                proprietati[0] = Looter1.hp;
                proprietati[1] = Looter1.cost;
                return proprietati;
            }
            case Looter2.type1: {
                proprietati[0] = Looter2.hp;
                proprietati[1] = Looter2.cost;
                return proprietati;
            }
            case Medic1.type1: {
                proprietati[0] = Medic1.hp;
                proprietati[1] = Medic1.cost;
                return proprietati;
            }
            case Defender1.type1: {
                proprietati[0] = Defender1.hp;
                proprietati[1] = Defender1.cost;
                return proprietati;
            }
            default:return proprietati;
        }
    }

    static int checkWin(){

        int index;
        for(index=1;index<=coloane;index++){

                if(tabla[1][index].side==1){
                    gameEnd=true;
                    return 1;
                }
                if(tabla[linii][index].side==2){
                    gameEnd=true;
                    return 2;
                }
        }
        return 0;
    }

    static void killUnit(int x, int y){
        tabla[x][y].type="--";
        tabla[x][y].hp=0;
        tabla[x][y].side=0;
    }

    static void damageUnit(int x,int y, int damage){
        int[] properties;

        tabla[x][y].hp-=damage;

        if(tabla[x][y].hp<=0){
            tabla[x][y].hp=0;
            killUnit(x,y);
        }

        properties=identifyUnitProperties(tabla[x][y].type);
        if(tabla[x][y].hp>properties[0])tabla[x][y].hp=properties[0];
    }

    static boolean checkOkCoordinates(int x,int y){
        return x <= linii && y <= coloane && x >= 1 && y >= 1;
    }


    static void globalAction(){
        for(i=1;i<=linii;i++){
            for(j=1;j<=coloane;j++){

                switch (tabla[i][j].type){
                    case Troop1.type1:
                    case Troop1.type2:{
                        if(!Troop1.attack(i,j))Troop1.move(i,j);
                        break;
                    }


                    default: break;
                }

            }
        }
    }

    static void resetUnitActivity(){
        int i,j;
        for(i=1;i<=linii;i++)
            for(j=1;j<=coloane;j++){
                tabla[i][j].activated=false;
            }
    }

    static boolean checkSpaceOccupied(int x,int y){
        return tabla[x][y].side == 0;
    }

    static boolean checkImiPermit(int val){
        return val <= currentMoney;
    }

    static boolean checkIsUnit(String unit){
        int[] proprietati;

        proprietati=identifyUnitProperties(unit);
        return proprietati[0] != 0;
    }


    public static void main(String[] args) {

        Controller.selectLevel();

        presetChooser();

        Display.afisareTabla();

        while(!gameEnd) {

            Controller.placeUnits();

            globalAction();

            Display.afisareTabla();

            resetUnitActivity();

            changeTurn();

            receiveMoney();

            //obligatoriu
            Display.afisareCastigator();
        }

        Controller.scanner.close();
    }
}