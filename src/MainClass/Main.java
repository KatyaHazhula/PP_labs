package MainClass;

import HouseClass.House;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;

public class Main {
    private static ArrayList<House> houses = new ArrayList<House>();

    public static void main(String[] args) {

        Create_Array();
        House.printElements1(houses, 3);
        House.printElements2(houses, 3,4,9);
        House.printElements3(houses, 99);
    }
    public static void Create_Array(){
        Scanner in=new Scanner(System.in);
        String line;

        System.out.println("** Enter houses ** ");
        int choice = 1;

        while (choice == 1){
            House obj = new House();

            System.out.println("-----------------------");
            System.out.print("Enter house id: ");

            obj.SetId(Integer.parseInt(in.nextLine()));
            System.out.print("Enter street: ");
            obj.SetStreet(in.nextLine());

            System.out.print("Enter floor:");
            obj.SetFloor(Integer.parseInt(in.nextLine()));

            System.out.print("Enter Apartment number:");
            obj.SetApartment_number(Integer.parseInt(in.nextLine()));

            System.out.print("Enter room  number:");
            obj.SetRoom_number(Integer.parseInt(in.nextLine()));

            System.out.print("Enter square:");
            obj.SetSquare(Double.parseDouble(in.nextLine()));
            houses.add(obj);

            System.out.print("Do you want to continue? yes-1/no-0 => ");
            choice = Integer.parseInt(in.nextLine()) == 1 ? 1:0;
        }
    }
}