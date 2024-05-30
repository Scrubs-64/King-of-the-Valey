import java.util.Objects;

public class Referee extends MainBase{

    static void setUnit(int x, int y,String typeIn,int hpIn, int atkIn, int rangeIn,int moveIn,int sideIn){
        tabla[x][y].type=typeIn;
        tabla[x][y].hp=hpIn;
        tabla[x][y].atk=atkIn;
        tabla[x][y].range=rangeIn;
        tabla[x][y].move=moveIn;
        tabla[x][y].side=sideIn;
    }

    static int[] identifyUnitProperties(String input) {

        int[] proprietati = new int[5];

        switch (input) {
            case Troop1.type1: {
                proprietati[0] = Troop1.hp;
                proprietati[1] = Troop1.atk;
                proprietati[2] = Troop1.range;
                proprietati[3] = Troop1.move;
                proprietati[4] = Troop1.cost;
                return proprietati;
            }
            case Troop2.type1: {
                proprietati[0] = Troop2.hp;
                proprietati[1] = Troop2.atk;
                proprietati[2] = Troop2.range;
                proprietati[3] = Troop2.move;
                proprietati[4] = Troop2.cost;
                return proprietati;
            }
            case Troop3.type1: {
                proprietati[0] = Troop3.hp;
                proprietati[1] = Troop3.atk;
                proprietati[2] = Troop3.range;
                proprietati[3] = Troop3.move;
                proprietati[4] = Troop3.cost;
                return proprietati;
            }
            case Heavy1.type1: {
                proprietati[0] = Heavy1.hp;
                proprietati[1] = Heavy1.atk;
                proprietati[2] = Heavy1.range;
                proprietati[3] = Heavy1.move;
                proprietati[4] = Heavy1.cost;
                return proprietati;
            }
            case Heavy2.type1: {
                proprietati[0] = Heavy2.hp;
                proprietati[1] = Heavy2.atk;
                proprietati[2] = Heavy2.range;
                proprietati[3] = Heavy2.move;
                proprietati[4] = Heavy2.cost;
                return proprietati;
            }
            case Sniper1.type1: {
                proprietati[0] = Sniper1.hp;
                proprietati[1] = Sniper1.atk;
                proprietati[2] = Sniper1.range;
                proprietati[3] = Sniper1.move1;
                proprietati[4] = Sniper1.cost;
                return proprietati;
            }
            case Sniper2.type1: {
                proprietati[0] = Sniper2.hp;
                proprietati[1] = Sniper2.atk;
                proprietati[2] = Sniper2.range;
                proprietati[3] = Sniper2.move1;
                proprietati[4] = Sniper2.cost;
                return proprietati;
            }
            case Bomber1.type1: {
                proprietati[0] = Bomber1.hp;
                proprietati[1] = Bomber1.atk1;
                proprietati[2] = Bomber1.range;
                proprietati[3] = Bomber1.move;
                proprietati[4] = Bomber1.cost;
                return proprietati;
            }
            case Bomber2.type1: {
                proprietati[0] = Bomber2.hp;
                proprietati[1] = Bomber2.atk1;
                proprietati[2] = Bomber2.range;
                proprietati[3] = Bomber2.move;
                proprietati[4] = Bomber2.cost;
                return proprietati;
            }
            case Looter1.type1: {
                proprietati[0] = Looter1.hp;
                proprietati[1] = Looter1.atk;
                proprietati[2] = Looter1.range;
                proprietati[3] = Looter1.move;
                proprietati[4] = Looter1.cost;
                return proprietati;
            }
            case Looter2.type1: {
                proprietati[0] = Looter2.hp;
                proprietati[1] = Looter2.atk;
                proprietati[2] = Looter2.range;
                proprietati[3] = Looter2.move;
                proprietati[4] = Looter2.cost;
                return proprietati;
            }
            case Medic1.type1: {
                proprietati[0] = Medic1.hp;
                proprietati[1] = Medic1.atk;
                proprietati[2] = Medic1.range;
                proprietati[3] = Medic1.move;
                proprietati[4] = Medic1.cost;
                return proprietati;
            }
            case Defender1.type1: {
                proprietati[0] = Defender1.hp;
                proprietati[1] = Defender1.atk;
                proprietati[2] = Defender1.range;
                proprietati[3] = Defender1.move;
                proprietati[4] = Defender1.cost;
                return proprietati;
            }
            default:return proprietati;
        }
    }

    static int checkWin(){

        int index,jdex;
        for(index=1;index<=coloane;index++){
            for(jdex=0;jdex<unitNumber;jdex++){
                if(tabla[1][index].type.equals(allUnits1[jdex])){
                    gameEnd=true;
                    return 1;
                }
                if(tabla[linii][index].type.equals(allUnits2[jdex])){
                    gameEnd=true;
                    return 2;
                }
            }
        }
        return 0;
    }

    static void presetChooser(){

        switch (level){
            case 1: {
                preset1();
                break;
            }
            case 2: {
                preset2();
                break;
            }
            case 3: {
                preset3();
                break;
            }
            case 4: {
                preset4();
                break;
            }
            case 5: {
                preset5();
                break;
            }

        }

    }

    static void preset1(){

        linii=7;
        coloane=5;

        MainBase.init();

        setUnit(2,2,Troop1.type2,Troop1.hp,Troop1.atk,Troop1.range,Troop1.move,2);

        setUnit(2,4,Troop1.type2,Troop1.hp,Troop1.atk,Troop1.range,Troop1.move,2);

        setUnit(1,3,Heavy1.type2,Heavy1.hp,Heavy1.atk,Heavy1.range,Heavy1.move,2);

    }
    static void preset2(){

        linii=9;
        coloane=5;

        MainBase.init();
    }
    static void preset3(){
        linii=9;
        coloane=5;

        MainBase.init();
    }
    static void preset4(){
        linii=9;
        coloane=5;

        MainBase.init();
    }
    static void preset5(){
        linii=9;
        coloane=5;

        MainBase.init();
    }

    static void killUnit(int x, int y){
        tabla[x][y].type="--";
        tabla[x][y].hp=0;
        tabla[x][y].atk=0;
        tabla[x][y].range=0;
        tabla[x][y].move=0;
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

    static void move1(int x,int y){

    }

    static void move2(int x,int y){

    }

    static void globalAction(){
        for(i=1;i<=linii;i++){
            for(j=1;j<=coloane;j++){
                if(!attack2(i, j))move2(i,j);
                if(!attack1(i, j))move1(i,j);
            }
        }
    }

    static boolean attack1(int x,int y){
        int i,j;
        boolean attacked=false;

        if(tabla[x][y].side==2){

            for(i=y;checkOkCoordinates(i,1) && i<=y+tabla[x][y].range && !attacked;i++){

                if(tabla[i][y].side==2 && Objects.equals(tabla[x][y].type, "m1")){
                    damageUnit(i,y,tabla[x][y].atk);
                    attacked=true;
                }

                else if(tabla[i][y].side==1){

                    switch(tabla[x][y].type){
                        case "b1":{
                            for(j=0;j<=3;j++) {
                                if (checkOkCoordinates(i+blastRadiusX[j], y+blastRadiusY[j]) && !Objects.equals(tabla[i+blastRadiusX[j]][y +blastRadiusY[j]].type, "--"))
                                    damageUnit(i+blastRadiusX[j], y +blastRadiusY[j], Bomber1.atk2);
                            }
                            attacked = true;
                            break;
                        }
                        case "b2":{
                            for(j=0;j<=3;j++) {
                                if (checkOkCoordinates(i+blastRadiusX[j], y+blastRadiusY[j]) && !Objects.equals(tabla[i+blastRadiusX[j]][y +blastRadiusY[j]].type, "--"))
                                    damageUnit(i+blastRadiusX[j], y +blastRadiusY[j], Bomber2.atk2);
                            }
                            attacked=true;
                            break;
                        }

                    }

                    switch (tabla[i][y].type){
                        case "D1":{
                            attacked=true;
                            break;
                        }
                        default:{
                            damageUnit(i, y, tabla[x][y].atk);
                            attacked=true;
                        }
                    }

                }

            }

        }


        return attacked;
    }

    static boolean attack2(int x,int y){
        int i,j;
        boolean attacked=false;

        if(tabla[x][y].side==2){

            for(i=y;checkOkCoordinates(i,1) && i<=y+tabla[x][y].range && !attacked;i++){

                if(tabla[i][y].side==2 && Objects.equals(tabla[x][y].type, "m1")){
                    damageUnit(i,y,tabla[x][y].atk);
                    attacked=true;
                }

                else if(tabla[i][y].side==1){

                    switch(tabla[x][y].type){
                        case "b1":{
                            for(j=0;j<=3;j++) {
                                if (checkOkCoordinates(i+blastRadiusX[j], y+blastRadiusY[j]) && !Objects.equals(tabla[i+blastRadiusX[j]][y +blastRadiusY[j]].type, "--"))
                                    damageUnit(i+blastRadiusX[j], y +blastRadiusY[j], Bomber1.atk2);
                            }
                            attacked = true;
                            break;
                        }
                        case "b2":{
                            for(j=0;j<=3;j++) {
                                if (checkOkCoordinates(i+blastRadiusX[j], y+blastRadiusY[j]) && !Objects.equals(tabla[i+blastRadiusX[j]][y +blastRadiusY[j]].type, "--"))
                                    damageUnit(i+blastRadiusX[j], y +blastRadiusY[j], Bomber2.atk2);
                            }
                            attacked=true;
                            break;
                        }

                    }

                    switch (tabla[i][y].type){
                        case "D1":{
                            attacked=true;
                            break;
                        }
                        default:{
                            damageUnit(i, y, tabla[x][y].atk);
                            attacked=true;
                        }
                    }

                }

            }

        }

        return attacked;
    }

    public static void main(String[] args) {

        Controller.selectLevel();

        presetChooser();

        while(!gameEnd) {

            Display.afisareTabla();

            Controller.placeUnits();

            globalAction();

            //obligatoriu
            Display.afisareCastigator();
        }

        Controller.scanner.close();
    }
}