
public class Display extends MainBase{

    static int i=0,j=0;

    static void afisareCastigator(){

        int winner=Referee.checkWin();

        if(winner!=0){
            afisareTabla();
            System.out.println("Player "+winner+" won! Battle over.");
        }
    }

    static void afisareTabla(){

        for(i=1;i<=linii;i++){
            for(j=1;j<=coloane;j++){
                System.out.print(tabla[i][j].type+' ');
            }
            System.out.println();
        }
        System.out.println("Money: "+currentMoney);

    }

}
