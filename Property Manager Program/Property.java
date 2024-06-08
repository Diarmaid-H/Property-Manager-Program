//Diarmaid Hughes
//L00186245

public class Property
{
   //Declare instance variables
   private int propertyNo;
   private String propertyStreet;
   private String propertyTown;
   private String propertyCounty;
   private String propertyType;
   private int noBeds;
   private int noBaths;
   private int noReception;
   private double price;
   private static int propNum=100;
   
   //Set values for the default constructor
   public Property ()
   {
      propertyNo = propNum++; //Creates different property numbers
      propertyStreet = " ";
      propertyTown = " ";
      propertyCounty = " ";
      propertyType = " ";
      noBeds = 0;
      noBaths = 0;
      noReception = 0;
      price = 0.00;
   }
   
   //Set values for constructor no 2 to hold the property address only
   public Property (String street, String town, String county)
   {
      propertyNo = propNum++; 
      propertyStreet = propertyStreet;
      propertyTown = propertyTown;
      propertyCounty = propertyCounty;
      propertyType = " ";
      noBeds = 0;
      noBaths = 0;
      noReception = 0;
      price = 0.00;
   }
   
   //Set Values for constructor no 3 to hold all details of property
   public Property (String street, String town, String county, int numBeds, int numReception, int numBaths, String type, double propPrice)
   {
         propertyNo = propNum++;
         propertyStreet = street;
         propertyTown = town;
         propertyCounty = county;
         propertyType = type;
         noBeds = numBeds;
         noBaths = numBaths;
         noReception = numReception;
         price = propPrice;
      
   }
   //Set value for constructor no 4 to make a copy of the Property object, this is to be used to add properties to my arraylists for sorting properties by price
   public Property (Property copy)
   {
         this.propertyNo = copy.propertyNo;
         this.propertyStreet = copy.propertyStreet;
         this.propertyTown = copy.propertyTown;
         this.propertyCounty = copy.propertyCounty;
         this.propertyType = copy.propertyType;
         this.noBeds = copy.noBeds;
         this.noBaths = copy.noBaths;
         this.noReception = copy.noReception;
         this.price = copy.price;
   }
      
   
   //Method to view details of a property
   public String toString()
   {
      return "\nProperty number:" +propertyNo+ "\t Street: " +propertyStreet.toUpperCase() + "\t Town: " +propertyTown.toUpperCase() +"\t County: " +propertyCounty.toUpperCase() +"\t Number beds: " +noBeds+ "\t Number baths: " +noBaths+ "\t Number reception rooms: " +noReception+ "\nPrice €" +price+"\t Type: " +propertyType.toUpperCase() +"\n";
   }
   
   //Accessor Methods - View each detail of property individually
   public int viewPropNo()
   {
      return propertyNo;
   }
   public String viewStreet()
   {
      return propertyStreet;
   }
   public String viewTown()
   {
      return propertyTown;
   } 
   public String viewCounty()
   {
      return propertyCounty;
   }   
   public int viewBeds()
   {
      return noBeds;
   }
   public int viewBaths()
   {
      return noBaths;
   }
   public int viewReceptions()
   {
      return noReception;
   }
   public double viewPrice()
   {
      return price;
   }
   public String viewPropertyType()
   {
      return propertyType;
   }
      
   //Mutator methods - Allows us to change any details of property
   public void setStreet(String street)
   {
      propertyStreet = street;
   }
   public void setTown(String town)
   {
      propertyTown = town;
   }
   public void setCounty(String county)
   {
      propertyCounty = county;
   }
   public void setNoBeds(int numBeds)
   {
      noBeds = numBeds;
   }
   public void setNoBaths(int numBaths)
   {
      noBaths = numBaths;
   }  
   public void setNoReceptions(int numReceptions)
   { 
      noReception = numReceptions; 
   }
   public void setPrice(double propPrice)
   {
      price = propPrice;   
   }
   public void setType(String type)
   {
      propertyType = type;
   }
   

}//Closes Class