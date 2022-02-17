//====================================================================
//
// Class: Car
// Description:
//   This class represents a car.
//
//====================================================================
package biz.ssc.ObjectSerialization;

//Import classes
import java.io.Serializable;

//======================================================================
// class Car
//======================================================================
@SuppressWarnings("serial")
public class Car implements Serializable
{
    
	//==================================================================
    // Fields
    //==================================================================
	private String make;
	private String model;
    
    //==================================================================
    // Constructors
    //==================================================================
	
	public Car()
	{
        System.out.println("This is the Car with no values constructor.");
        make = "(not set)";
        model = "(not set)";
	}
	
	public Car(String make, String model)
	{
        System.out.println("This is the Car with values constructor.");
        this.make = make;
        this.model = model;
	}
    
    //==================================================================
    // Methods
    //==================================================================
    
    //------------------------------------------------------------------
    // get methods
    //------------------------------------------------------------------

	public String getMake() 
    {
		return make;
	}

	public String getModel()
	{
		return model;
	}
    
    //------------------------------------------------------------------
    // set methods
    //------------------------------------------------------------------

	public void setMake(String make) 
	{
		this.make = make;
	}

	public void setModel(String model)
	{
		this.model = model;
	}
    
    //------------------------------------------------------------------
    // equals and toString methods
    //------------------------------------------------------------------

	public boolean equals(Car b)
	{
		if (this.make.equalsIgnoreCase(b.make) && 
			this.model.equalsIgnoreCase(b.model))
			return true;
		else
			return false;
	}

	public String toString()
	{
		return "Make: " + make + "\nModel: " + model;        
	}
    
} 
