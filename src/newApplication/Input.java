package newApplication;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(){
        return scanner.nextLine();
    }

    public String getString(String prompt){
        if(prompt.isEmpty()){
            System.out.println("Type something: ");
        } else {
            System.out.println(prompt);
        }
        return getString();
    }

    public String getString(int num2, int num1){
        String userInput = scanner.nextLine();
        if (userInput.length() == num2 || userInput.length() == num1){
            return userInput;
        }else {
            System.out.println("Invalid number, must be 7 or 10 digits");
            return getString(num2, num1);
        }



    }


    public boolean yesNo(){
        String yesorno = scanner.nextLine();
        return yesorno.equalsIgnoreCase("y") || yesorno.equalsIgnoreCase("yes");
    }

    public int getInt(int min, int max){
        System.out.format("Choose number between %s and %s: \n", min, max);

        try{
           int userNum = Integer.valueOf( scanner.nextLine() );;

            if ( userNum >= min && userNum  <= max){
                return userNum;
            }else {
                System.out.format("invalid number, choose number between %s and %s: \n", min, max);
                return getInt(min, max);
            }
        }catch (Exception e){
            System.out.println("Not valid integer");
            return getInt(min, max);
        }
    }

    public int getInt(){
        try{
           int userNum = Integer.valueOf( scanner.nextLine() );
            return userNum;

        }catch (Exception e){
            System.out.println("Not valid integer");
            return getInt();
        }
    }

    public double getDouble(double min, double max){

        System.out.format("Choose number between %s and %s: \n", min, max);
        try{
           double userDbl = Double.valueOf(scanner.nextLine());
            if ( userDbl >= min && userDbl <= max){
                return userDbl;
            }else {
                System.out.format("invalid number, choose number between %s and %s: \n", min, max);
                return getDouble(min, max);
            }
        }catch (Exception e){
            System.out.println("Not Valid Double");
            return getDouble(min,max);
        }
    }

    public double getDouble(){
        try{
            return Integer.valueOf(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Not valid double");
            return getDouble();
        }
    }

    public int getBinary(){
        try {
            return Integer.valueOf(scanner.nextLine(),2);
        }catch (Exception e){
            System.out.println("Invalid Binary");
            return getBinary();
        }
    }

    public int getHex(){
        try {
            return Integer.valueOf(scanner.nextLine(),16);
        }catch (Exception e){
            System.out.println("Invalid Hex");
            return getHex();
        }
    }

}
