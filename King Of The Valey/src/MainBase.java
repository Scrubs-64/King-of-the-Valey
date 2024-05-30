abstract class MainBase{

    final static short maxLinii=25,maxColoane=25;
    static int linii=7,coloane=5;
    static int i=0,j=0;

    static int level=1;
    final static int numberLevels=5;

    static int turn=1;
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
                tabla[i][j]=new SpatiuTabla("--",0,0,0,0,0);
            }
        }

    }





}
