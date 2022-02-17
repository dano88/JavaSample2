//====================================================================
//
// Application: Object Serialization
// Author:      Dan Ouellette
// Description:
//      This Java application demonstrates writing and reading objects
// using Java object serialization.
//
//====================================================================
package biz.ssc.ObjectSerialization;

//Import classes
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//====================================================================
//class ObjectSerialization
//====================================================================
public class ObjectSerialization
{
    
    //================================================================
    // Fields
    //================================================================
	private static final String COLFMT = "%-14s";
	private static final String FILE_NAME = "CarObjects.obj";

	//----------------------------------------------------------------
	// printObjectInfo
	//----------------------------------------------------------------
	public static void printObjectInfo(Car car1, Car car2, Car car3)
	{
		System.out.printf(COLFMT + COLFMT + COLFMT + "%n", "Object", 
	 		"Make", "Model");
	    System.out.printf(COLFMT + COLFMT + COLFMT + "%n", "car1",
    		car1.getMake(), car1.getModel());
	    System.out.printf(COLFMT + COLFMT + COLFMT + "%n", "car2", 
    		car2.getMake(), car2.getModel());
	    System.out.printf(COLFMT + COLFMT + COLFMT + "%n", "car3", 
    		car3.getMake(), car3.getModel());
	 }

	//----------------------------------------------------------------
	// main
	//----------------------------------------------------------------
	public static void main(String[] args)
	{
 	
		// Declare variables
		ObjectInputStream objIn = null;
		ObjectOutputStream objOut = null;

	    // Show application header
	    System.out.println("Welcome to Object Serialization");
	    System.out.println("-------------------------------\n");
	    
	    // Create car objects
	    Car car1 = new Car ("Ford", "Mustang");
	    Car car2 = new Car ("Dodge", "Challenger");
	    Car car3 = new Car ("Chevy", "Camaro");
	    
	    // Print object info before serialization
	    System.out.println("\nCar object info before serialization");
	    printObjectInfo(car1, car2, car3);
	    
	    // Write objects to file
	    try
	    {
	    	objOut = new ObjectOutputStream(
    			new FileOutputStream(FILE_NAME));
	     	objOut.writeObject(car1);
	     	objOut.writeObject(car2);
	     	objOut.writeObject(car3);
	     	objOut.close();
	    }
	    catch (IOException e)
	    {
	    	System.out.println("Error: file '" + FILE_NAME +
    			"' cannot be created, opened, or written to.");
	    	System.out.println("Error message: " + e.getMessage());
	    }
	    
	    // Read objects from file
	    try
	    {
	    	objIn = new ObjectInputStream(new FileInputStream(FILE_NAME));
	    	car1 = (Car) objIn.readObject();
	    	car2 = (Car) objIn.readObject();
	    	car3 = (Car) objIn.readObject();
	    	objIn.close();
	    } 
	    catch (IOException e1) 
	    {
	    	System.out.println("Error: file '" + FILE_NAME +
    			"' not found.");
	    	System.out.println("Error message:" + e1.getMessage());
	    }
	    catch (ClassNotFoundException e2) 
	    {
	    	System.out.println("Error: class Car not found in file '" +
    			FILE_NAME + "'.");
	    	System.out.println("Error message:" + e2.getMessage());
	    }
	    
	    // Print object info after serialization
	    System.out.println("\nCar object info after serialization");
	    printObjectInfo(car1, car2, car3);

	    // Show application close
	    System.out.println("\nEnd of Object Serialization");

 }

}