/*
 * Project: Advanced Contact Management System
 * Author: Nadeen smairy
 * University: University College of Applied Sciences (UCAS)
 * Department: Cybersecurity & Programming
 */
package smartcontactmanager;
import java.util.Scanner;

public class SmartContactManager {
    public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
        String[][] contacts = new String[10000][3];
        int count = 0;
        int choice;

        do{
            System.out.print("\nooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n"+
            "\t\t\tWELCOME TO CONTACTBOOK\n"+
            "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n"+
            "\t\t\tplease enter your choice\n"+
            "\t\t\t1-ADD NEW CONTACT  \n"+
            "\t\t\t2-SEARCH BY NAME   \n"+
            "\t\t\t3-SEARCH BY number \n"+
            "\t\t\t4-DELETE BY NAME   \n"+
            "\t\t\t5-DELETE BY NUMBER \n"+
            "\t\t\t6-SHOW ALL CONTACTS\n"+
            "\t\t\t7-\tEXIT        \n"+
            "please enter your choice : ");
            
            choice=in.nextInt();

            switch(choice){
                case 1 :
                    System.out.println("\t\t\t [add new contact]");
                    if(count>=1000){
                        System.out.println("ERORR:\n memory is full please delete one contact to add new one ");
                    }else{
                        System.out.print("Enter the number of new contact :");
                        String newNumber = in.next();
                        
                        boolean existsNum = false ;
                        for(int i=0; i<count; i++){
                            if(contacts[i][1].contains(newNumber)){
                                existsNum=true;
                                break;
                            }
                        }
                        
                        if(existsNum){
                            System.out.println("ERROR:this number already exists! ");
                        }else{
                            System.out.print("Enter the name of contact : ");
                            String newName = in.next();
                            
                            boolean existsName = false;
                            int existingIndex = -1;
                            
                            for(int i=0; i<count; i++){
                                if(contacts[i][0].equalsIgnoreCase(newName)){
                                    existsName = true;
                                    existingIndex = i;
                                    break;
                                }
                            }
                            
                            if(existsName){
                                System.out.println("\nNOTE : this name already has contact we add the number to its name");
                                contacts[existingIndex][1] = contacts[existingIndex][1] + " , " + newNumber;
                                System.out.println("Process success!");
                            }else{
                                System.out.print("Enter type [Family , Personal , Work ,Other] : ");
                                String newType = in.next();
                                
                                if(!newType.equalsIgnoreCase("Family") && !newType.equalsIgnoreCase("Personal") && !newType.equalsIgnoreCase("Work") && !newType.equalsIgnoreCase("Other")){
                                    System.out.println("Invalid type! we turned your type to be Other ");
                                    newType = "Other";
                                }
                                
                                contacts[count][0] = newName;
                                contacts[count][1] = newNumber;
                                contacts[count][2] = newType;
                                count++;
                                System.out.println("Process success!");
                            }
                        }
                    }
                    break;

        case 2 :
                    System.out.print("Enter the name to search : ");
                    String searchName = in.next().toLowerCase();
                    boolean foundName = false;
                    
                    String searchNoVowels = "";
                    for(int j = 0; j < searchName.length(); j++){
                        char c = searchName.charAt(j);
                        if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'){
                            searchNoVowels = searchNoVowels + c;
                        }
                    }

                    System.out.printf("\n%-20s %-30s %-15s\n", "NAME", "NUMBER(S)", "TYPE");
                    System.out.println("------------------------------------------------------------------");
                    
                    for(int i = 0; i < count; i++){
                        String currentName = contacts[i][0].toLowerCase();
                        
                        String nameNoVowels = "";
                        for(int j = 0; j < currentName.length(); j++){
                            char c = currentName.charAt(j);
                            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'){
                                nameNoVowels = nameNoVowels + c;
                            }
                        }
                        
                        if(currentName.contains(searchName) || nameNoVowels.contains(searchNoVowels)){
                            System.out.printf("%-20s %-30s %-15s\n", contacts[i][0], contacts[i][1], contacts[i][2]);
                            foundName = true;
                        }
                    }
                    if(!foundName){
                        System.out.println("Not found");
                    }
                    break;

                case 3 :
                    System.out.print("Enter the number to search : ");
                    String searchNum = in.next();
                    boolean foundNum = false;
                    System.out.printf("\n%-20s %-30s %-15s\n", "NAME", "NUMBER(S)", "TYPE");
                    System.out.println("------------------------------------------------------------------");
                    for(int i=0; i<count; i++){
                        if(contacts[i][1].contains(searchNum)){
                            System.out.printf("%-20s %-30s %-15s\n", contacts[i][0], contacts[i][1], contacts[i][2]);
                            foundNum = true;
                        }
                    }
                    if(!foundNum){
                        System.out.println("Not found");
                    }
                    break;

                case 4 :
                    System.out.print("Enter the name to delete : ");
                    String delName = in.next();
                    int deletedCount = 0; 
                    
                    for(int i=0; i<count; i++){
                        if(contacts[i][0].equalsIgnoreCase(delName)){
                            for(int j=i; j<count-1; j++){
                                contacts[j][0] = contacts[j+1][0];
                                contacts[j][1] = contacts[j+1][1];
                                contacts[j][2] = contacts[j+1][2];
                            }
                            count--;
                            i--;
                            deletedCount++; 
                        }
                    }
                    if(deletedCount > 0){
                        System.out.println("Process success! Deleted contacts: " + deletedCount);
                    }else{
                        System.out.println("Not found");
                    }
                    break;
                case 5 :
                    System.out.print("Enter the number to delete : ");
                    String delNum = in.next();
                    boolean deletedNum = false;
                    for(int i=0; i<count; i++){
                        if(contacts[i][1].contains(delNum)){
                            for(int j=i; j<count-1; j++){
                                contacts[j][0] = contacts[j+1][0];
                                contacts[j][1] = contacts[j+1][1];
                                contacts[j][2] = contacts[j+1][2];
                            }
                            count--;
                            i--;
                            deletedNum = true;
                            System.out.println("Process success!");
                            break;
                        }
                    }
                    if(!deletedNum){
                        System.out.println("Not found");
                    }
                    break;

                case 6 :
                    System.out.println("\n\t\t\t [ALL CONTACTS]");
                    System.out.printf("%-20s %-30s %-15s\n", "NAME", "NUMBER(S)", "TYPE");
                    System.out.println("------------------------------------------------------------------");
                    for(int i=0; i<count; i++){
                        System.out.printf("%-20s %-30s %-15s\n", contacts[i][0], contacts[i][1], contacts[i][2]);
                    }
                    break;

                case 7 :
                    System.out.println("Good bey ^_^");
                    break;

                default :
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);    }
    
}
