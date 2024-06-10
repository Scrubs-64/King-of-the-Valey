
import java.util.Scanner;

public class Controller extends MainBase{

    static Scanner scanner=new Scanner(System.in);
    static boolean okInput=false;

    static void selectLevel(){

        okInput=false;

        while(!okInput) {

            System.out.println("Enter level(1-5): ");

            okInput=true;
            try {
                level = scanner.nextInt();
            }
            catch(Exception E){
                System.out.println("Something went wrong. Retry.");
                scanner.nextLine();
                okInput=false;
            }

            if(level>numberLevels || level<1){
                System.out.println("This level doesn't exist. Retry.");
                scanner.nextLine();
                okInput=false;
            }

        }

    }


    static void placeUnits(){

        int i,coordHand,coordTabla;
        int[] properties;
        boolean okPlacement=false,hasMoney=false;

        System.out.println("Place units on columns: ");

        while(!okPlacement || !hasMoney){

            okPlacement=true;
            hasMoney=true;

            try {
                coordHand=scanner.nextInt();
            }
            catch(Exception E){
                System.out.println("Something went wrong. Try entering again.");
                okPlacement=false;
                scanner.nextLine();
                continue;
            }

            try{
                coordTabla=scanner.nextInt();
            }
            catch(Exception E){
                System.out.println("Something went wrong. Try entering again.");
                okPlacement=false;
                scanner.nextLine();
                continue;
            }

            if(coordHand==0)break;

            coordHand--;

            //verificarile

            okPlacement= okPlacement && 0 <= coordHand && coordHand <= 4;

            if(okPlacement)okPlacement=Referee.checkOkCoordinates(linii,coordTabla);

            if(okPlacement)okPlacement=Referee.checkSpaceOccupied(linii, coordTabla);

            if(!okPlacement){
                System.out.println("You can't place it there.");
                continue;
            }

            properties=Referee.identifyUnitProperties(hand[coordHand]);

            hasMoney=Referee.checkImiPermit(properties[1]);

            if(!hasMoney)System.out.println("You don't have enough money");

            if(okPlacement && hasMoney){
                Referee.setUnit(linii, coordTabla, hand[coordHand], properties[0],1,false);
                currentMoney-=properties[1];

                hand[coordHand]=null;

                for(i=1;i<=coloane;i++){
                    tabla[linii][i].activated=true;
                }
            }

        }

    }



}
