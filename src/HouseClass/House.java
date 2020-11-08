package HouseClass;

import java.util.ArrayList;
import java.text.ParseException;

public class House {
    int id,roomNumber,floor,apartmentNumber;
    double square;
    String street;

    public House(){

    }

    public House(String street,int id,int roomNumber,int floor,int apartmentNumber,double square){
        this.street=street;
        this.id=id;
        this.roomNumber=roomNumber;
        this.floor=floor;
        this.apartmentNumber=apartmentNumber;
        this.square=square;
    }

    public void SetStreet(String street){
        this.street=street;
    };
    public void SetId(int Id){
        this.id=id;
    };
    public void SetRoom_number(int RoomNumber){
        this.roomNumber=roomNumber;
    };
    public void SetFloor(int floor){
        this.floor=floor;
    };
    public void SetApartment_number(int ApartmentNumber){
        this.apartmentNumber=apartmentNumber;
    };
    public void SetSquare(double square){ this.square=square; };


    public int GetId(){
        return  id;
    };
    public int GetRoom_number(){
        return roomNumber;
    };
    public int GetFloor(){
        return floor;
    };
    public int GetApartment_number(){
        return apartmentNumber;
    };
    public double GetSquare(){
        return square;
    };
    public String GetStreet(){
        return street;
    };


    public static void printElements1(ArrayList<House> houses, int roomNumber) {
        System.out.println("|--------------------------------------------------------------------- |");
        System.out.println("|  Street      | House Id   | Floor | Apartment,  | Room     | Square  |");
        System.out.println("|              |            |       | number      | number   |         |");
        System.out.println("|----------------------------------------------------------------------|");

        for (House temporaryObj : houses) {
            if (temporaryObj.roomNumber==roomNumber) {
                System.out.printf("| %-12s | %-10d | %-5d | %-11d | %-8d | %-7.2f |\n", temporaryObj.street,
                        temporaryObj.id,
                        temporaryObj.floor,
                        temporaryObj.apartmentNumber,
                        temporaryObj.roomNumber,
                        temporaryObj.square);
            }
        }

        System.out.println("------------------------------------------------------------------------");
    }

    public static void printElements2(ArrayList<House> houses, int roomNumber,int start,int end) {
        System.out.println("|--------------------------------------------------------------------- |");
        System.out.println("|  Street      | House Id   | Floor | Apartment,  | Room     | Square  |");
        System.out.println("|              |            |       | number      | number   |         |");
        System.out.println("|----------------------------------------------------------------------|");

        for (House temporaryObj : houses) {
            if ((temporaryObj.roomNumber==roomNumber)&&(temporaryObj.floor>=start&&temporaryObj.floor<=end)) {
                System.out.printf("| %-12s | %-10d | %-5d | %-11d | %-8d | %-7.2f |\n", temporaryObj.street,
                        temporaryObj.id,
                        temporaryObj.floor,
                        temporaryObj.apartmentNumber,
                        temporaryObj.roomNumber,
                        temporaryObj.square);
            }
        }

        System.out.println("------------------------------------------------------------------------");
    }


    public static void printElements3(ArrayList<House> houses, double square) {
        System.out.println("|--------------------------------------------------------------------- |");
        System.out.println("|  Street      | House Id   | Floor | Apartment,  | Room     | Square  |");
        System.out.println("|              |            |       | number      | number   |         |");
        System.out.println("|----------------------------------------------------------------------|");

        for (House temporaryObj : houses) {
            if (temporaryObj.square>square) {
                System.out.printf("| %-12s | %-10d | %-5d | %-11d | %-8d | %-7.2f |\n", temporaryObj.street,
                        temporaryObj.id,
                        temporaryObj.floor,
                        temporaryObj.apartmentNumber,
                        temporaryObj.roomNumber,
                        temporaryObj.square);
            }
        }

        System.out.println("------------------------------------------------------------------------");
    }
}