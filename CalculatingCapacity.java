import java.util.Scanner;

/*itcs 1212-005-von Briesen
@author Buelow, Shawn
@since 11/10/2021
Calculating Capacity version 1.0
*/

public class CalculatingCapacity 
{
    
   public static void main(String[] args)
   {
       Scanner aScanner = new Scanner(System.in);
       System.out.println("Hello! please enter your state authorized capacity percentage in decimal form (i.e 80% = 0.8): ");
       double statePercent = aScanner.nextDouble();
       
      while(statePercent < 0.0 || 1.0 < statePercent)
       {
            System.out.println("Please enter a valid percentage: ");
            statePercent = aScanner.nextDouble();
       }

       System.out.println("Your state authorized capacity percentage is: " + statePercent + "."); 
          
          int floorCapacity = 0;
          int buildingCapacity = 0;
          int allowedFloorCapacity = 0;
          int allowedBuildingCapacity = 0;
       System.out.println("Please enter the number of floors in the building: ");
       int floors = aScanner.nextInt();
       while(floors < 1)
       {
            System.out.println("Please enter a valid number of floors");
            floors = aScanner.nextInt();
       }
     
       System.out.println("The number of floors you entered is: " + floors + ".");
       
       for(int counter = 1; counter <= floors; counter++)
       {
          System.out.println("Enter the number of classrooms for floor # " + counter + ": ");
          int classrooms = aScanner.nextInt();
          while(classrooms < 2)
          {
               System.out.println("Please enter a valid number of classrooms (More than 2)");
               classrooms = aScanner.nextInt();
          }
          floorCapacity = 0;  
          allowedFloorCapacity = 0;   
          for(int aCounter = 1; aCounter <= classrooms; aCounter++)
          {
               System.out.println("Enter capacity for classroom # " + aCounter +  ": ");
               int classroomCapacity = aScanner.nextInt();
               
               System.out.println("The normal capacity for this room is: " + classroomCapacity);
               floorCapacity = floorCapacity + classroomCapacity;

               int allowedCapacity =(int) (classroomCapacity * statePercent);
               System.out.println("The state authorized percent is: " + allowedCapacity);
               allowedFloorCapacity = allowedFloorCapacity + allowedCapacity;
               
               System.out.println("");
          } //end classrooms loop

          System.out.println("The total capacity for floor # " + counter + " is:" + floorCapacity);
          System.out.println("The total authorized capacity for this floor is: " + allowedFloorCapacity);
          System.out.println("");
          
          buildingCapacity = buildingCapacity + floorCapacity;
          allowedBuildingCapacity = allowedBuildingCapacity + allowedFloorCapacity;          

       } //end floors loop

      System.out.println("The normal capacity for the building is: " + buildingCapacity);
      System.out.println("The state authorized capacity is: " + allowedBuildingCapacity); 

   } //end Main
} // end Class
