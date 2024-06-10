import java.util.Objects;
import java.util.Random;

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
            case Troop1.type1:
            case Troop1.type2:{
                proprietati[0] = Troop1.hp;
                proprietati[1] = Troop1.cost;
                return proprietati;
            }
            case Troop2.type1:
            case Troop2.type2:{
                proprietati[0] = Troop2.hp;
                proprietati[1] = Troop2.cost;
                return proprietati;
            }
            case Troop3.type1:
            case Troop3.type2:{
                proprietati[0] = Troop3.hp;
                proprietati[1] = Troop3.cost;
                return proprietati;
            }
            case Heavy1.type1:
            case Heavy1.type2:{
                proprietati[0] = Heavy1.hp;
                proprietati[1] = Heavy1.cost;
                return proprietati;
            }
            case Heavy2.type1:
            case Heavy2.type2:{
                proprietati[0] = Heavy2.hp;
                proprietati[1] = Heavy2.cost;
                return proprietati;
            }
            case Sniper1.type1:
            case Sniper1.type2:{
                proprietati[0] = Sniper1.hp;
                proprietati[1] = Sniper1.cost;
                return proprietati;
            }
            case Sniper2.type1:
            case Sniper2.type2:{
                proprietati[0] = Sniper2.hp;
                proprietati[1] = Sniper2.cost;
                return proprietati;
            }
            case Bomber1.type1:
            case Bomber1.type2:{
                proprietati[0] = Bomber1.hp;
                proprietati[1] = Bomber1.cost;
                return proprietati;
            }
            case Bomber2.type1:
            case Bomber2.type2:{
                proprietati[0] = Bomber2.hp;
                proprietati[1] = Bomber2.cost;
                return proprietati;
            }
            case Looter1.type1:
            case Looter1.type2:{
                proprietati[0] = Looter1.hp;
                proprietati[1] = Looter1.cost;
                return proprietati;
            }
            case Looter2.type1:
            case Looter2.type2:{
                proprietati[0] = Looter2.hp;
                proprietati[1] = Looter2.cost;
                return proprietati;
            }
            case Looter3.type1:
            case Looter3.type2:{
                proprietati[0] = Looter3.hp;
                proprietati[1] = Looter3.cost;
                return proprietati;
            }
            case Medic1.type1:
            case Medic1.type2:{
                proprietati[0] = Medic1.hp;
                proprietati[1] = Medic1.cost;
                return proprietati;
            }
            case Defender1.type1:
            case Defender1.type2:{
                proprietati[0] = Defender1.hp;
                proprietati[1] = Defender1.cost;
                return proprietati;
            }
            default:return proprietati;
        }
    }

    static int checkWin(){

        boolean won1=false, won2=false;

        int index;
        for(index=1;index<=coloane;index++){

                if(tabla[1][index].side==1){
                    gameEnd=true;
                    won1=true;
                }
                if(tabla[linii][index].side==2){
                    gameEnd=true;
                    won2=true;
                }
        }

        if(won1 && won2)return 3;
        else if(won1)return 1;
        else if(won2)return 2;
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
                    case Troop2.type1:
                    case Troop2.type2:{
                        if(!Troop2.attack(i,j))Troop2.move(i,j);
                        break;
                    }
                    case Troop3.type1:
                    case Troop3.type2:{
                        if(!Troop3.attack(i,j))Troop3.move(i,j);
                        break;
                    }
                    case Heavy1.type1:
                    case Heavy1.type2:{
                        if(!Heavy1.attack(i,j))Heavy1.move(i,j);
                        break;
                    }
                    case Heavy2.type1:
                    case Heavy2.type2:{
                        if(!Heavy2.attack(i,j))Heavy2.move(i,j);
                        break;
                    }
                    case Bomber1.type1:
                    case Bomber1.type2:{
                        if(!Bomber1.attack(i,j))Bomber1.move(i,j);
                        break;
                    }
                    case Bomber2.type1:
                    case Bomber2.type2:{
                        if(!Bomber2.attack(i,j))Bomber2.move(i,j);
                        break;
                    }
                    case Sniper1.type1:
                    case Sniper1.type2:{
                        if(!Sniper1.attack(i,j))Sniper1.move(i,j);
                        break;
                    }
                    case Sniper2.type1:
                    case Sniper2.type2:{
                        if(!Sniper2.attack(i,j))Sniper2.move(i,j);
                        break;
                    }
                    case Medic1.type1:
                    case Medic1.type2:{
                        if(!Medic1.attack(i,j))Medic1.move(i,j);
                        break;
                    }
                    case Defender1.type1:
                    case Defender1.type2:{
                        if(!Defender1.attack(i,j))Defender1.move(i,j);
                        break;
                    }
                    case Looter1.type1:
                    case Looter1.type2:{
                        if(!Looter1.attack(i,j))Looter1.move(i,j);
                        break;
                    }
                    case Looter2.type1:
                    case Looter2.type2:{
                        if(!Looter2.attack(i,j))Looter2.move(i,j);
                        break;
                    }
                    case Looter3.type1:
                    case Looter3.type2:{
                        if(!Looter3.attack(i,j))Looter3.move(i,j);
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

    static void handGenerator(){
        int i, percentage;

        for(i=0;i<5;i++){
            if(hand[i]==null){
                percentage=RNGchance.nextInt(100);

                if(percentage<=50){
                    hand[i]=commonUnits[RNGleveled.nextInt(commonUnitsNumber)];
                }
                else if(percentage<=80){
                    hand[i]=rareUnits[RNGleveled.nextInt(rareUnitsNumber)];
                }
                else {
                    hand[i]=epicUnits[RNGleveled.nextInt(epicUnitsNumber)];
                }

            }
        }
    }


    public static void main(String[] args) {

        Controller.selectLevel();

        presetChooser();

        handGenerator();

        Display.afisareTabla();

        while(!gameEnd) {

            Controller.placeUnits();

            handGenerator();

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