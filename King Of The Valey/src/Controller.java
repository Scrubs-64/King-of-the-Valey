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

        int y;
        int[]properties;
        boolean okPlacement=false,isUnit=false,hasMoney=true;

        System.out.println("Place units on columns: ");

        while(!okPlacement && !isUnit){

            isUnit=false;
            okPlacement=true;

            try {
                y=scanner.nextInt();
                rawInput=scanner.next();
            }
            catch(Exception E){
                System.out.println("Something went wrong. Try entering again.");
                okPlacement=false;
                scanner.nextLine();
                continue;
            }

            if(y==0)break;

            rawInput=rawInput.trim();

            if(y>coloane || y<0){
                System.out.println("This position does not exist.");
                okPlacement=false;
                scanner.nextLine();
                continue;
            }

            if(!Objects.equals(tabla[linii][y].type,"--")){
                System.out.println("Space already occupied. Try entering again.");
                okPlacement=false;
                scanner.nextLine();
                continue;
            }

            properties=Referee.identifyUnitProperties(rawInput);
            if(properties[0]!=0)isUnit=true;
            else System.out.println("There is no unit with that name.");

            if(currentMoney<properties[4]){
                System.out.println("You don't have enough money.");
                hasMoney=false;
            }

            if(okPlacement && isUnit && hasMoney){
                Referee.setUnit(linii, y, rawInput, properties[0],properties[1],properties[2],properties[3],1);
                currentMoney-=properties[4];
            }

        }

    }



}
