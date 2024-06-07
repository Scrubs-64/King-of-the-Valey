abstract class MainBase{

    final static short maxLinii=25,maxColoane=25;
    static int linii=7,coloane=5;
    static int i=0,j=0;

    static int level=1;
    final static int numberLevels=5;

    static short turn=1;
    static int currentMoney=150;
    final static int moneyPeTurn=30;
    static boolean gameEnd=false;

    final static String[] allUnits1=new String[]{"T1","T2","T3","H1","H2","L1","L2","S1","S2","M1","D1","B1","B2"};
    final static String[] allUnits2=new String[]{"t1","t2","t3","h1","h2","l1","l2","s1","s2","m1","d1","b1","b2"};
    final static int unitNumber=allUnits1.length;

    final static short blastRadiusX[]={1,-1,0,0};
    final static short blastRadiusY[]={0,0,1,-1};

    ///
    static SpatiuTabla[][] tabla = new SpatiuTabla[maxLinii][maxColoane];
    ///

    static void init(){
        for(i=1;i<=linii;i++){
            for(j=1;j<=coloane;j++){
                tabla[i][j]=new SpatiuTabla("--",0,0,false);
            }
        }

    }

    static void receiveMoney(){
        currentMoney+=moneyPeTurn;
    }

    static void changeTurn(){
        if(turn==1)turn=2;
        else if(turn==2)turn=1;
    }

    static void preset1(){

        linii=7;
        coloane=5;

        MainBase.init();

        Referee.setUnit(2,2,Troop1.type2,Troop1.hp,2,false);

        Referee.setUnit(2,4,Troop1.type2,Troop1.hp,2,false);

        Referee.setUnit(1,3,Heavy1.type2,Heavy1.hp,2,false);

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


}
