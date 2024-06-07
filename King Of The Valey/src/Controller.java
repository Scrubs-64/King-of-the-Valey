import java.util.Objects;
import java.util.Scanner;

public class Controller extends MainBase{

    static Scanner scanner=new Scanner(System.in);
    static String rawInput;
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

        int y,i;
        int[] properties;
        boolean okPlacement=false,isUnit=false,hasMoney=false;

        System.out.println("Place units on columns: ");

        while(!okPlacement || !isUnit || !hasMoney){

            okPlacement=true;
            isUnit=true;
            hasMoney=true;

            try {
                y=scanner.nextInt();
            }
            catch(Exception E){
                System.out.println("Something went wrong. Try entering again.");
                okPlacement=false;
                scanner.nextLine();
                continue;
            }

            try{
                rawInput=scanner.next();
            }
            catch(Exception E){
                System.out.println("Something went wrong. Try entering again.");
                isUnit=false;
                scanner.nextLine();
                continue;
            }

            if(y==0)break;

            rawInput=rawInput.trim();
            properties=Referee.identifyUnitProperties(rawInput);


            if(okPlacement)okPlacement=Referee.checkOkCoordinates(linii, y);

            if(okPlacement)okPlacement=Referee.checkSpaceOccupied(linii,y);

            isUnit=Referee.checkIsUnit(rawInput);

            if(isUnit)hasMoney=Referee.checkImiPermit(properties[1]);


            if(!isUnit)System.out.println("There is no unit with that name.");
            if(!okPlacement)System.out.println("You can't place it there.");
            if(!hasMoney)System.out.println("You don't have enough money");

            if(okPlacement && isUnit && hasMoney){
                Referee.setUnit(linii, y, rawInput, properties[0],1,false);
                currentMoney-=properties[1];

                for(i=1;i<=coloane;i++){
                    tabla[linii][i].activated=true;
                }
            }

        }

    }



}
