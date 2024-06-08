//Diarmaid Hughes
//L00186245

//Any lines that have not been commented will be code that has been explained prior

import javafx.application.Application; // Import Application class for positioning of elements from JavaFX library
import javafx.geometry.Pos; // Import Pos class for positioning of elements from JavaFX library
import javafx.scene.Scene; // Import Scene class from JavaFX library
import javafx.scene.control.Button; // Import Button class from JavaFX library
import javafx.scene.control.Label; // Import Label class from JavaFX library
import javafx.scene.control.TextArea; // Import TextArea class from JavaFX library
import javafx.scene.control.TextField; // Import TextField class from JavaFX library
import javafx.scene.layout.HBox; // Import HBox class from JavaFX library
import javafx.scene.layout.VBox; // Import VBox class from JavaFX library
import javafx.stage.Stage; // Import Stage class from JavaFX library
import javafx.event.ActionEvent; // Import ActionEvent from JavaFX library
import java.util.ArrayList; // Import arraylist class from Java library
import java.util.Collections; // Import collections class from Java library
import java.util.Comparator; // Import comparator class from Java library

public class PropertyGUI extends Application  //PropertyGUI class that extends Application - PropertyGUI inherits from Application class
{
   //Create ArrayList for Properties
   ArrayList <Property> propertyList = new ArrayList<>();
   //Create ArrayLists for sorting search results or all properties results
   ArrayList <Property> viewAllLowList = new ArrayList<>();
   ArrayList <Property> viewAllHighList = new ArrayList<>();
   ArrayList <Property> searchResultsLowList = new ArrayList<>();
   ArrayList <Property> searchResultsHighList = new ArrayList<>();
   
   //Main Window
   //Declare Text Fields to get user input for property details
   //Second row
   TextField txtStreet;
   TextField txtTown;
   TextField txtCounty;
   //Third row
   TextField txtBeds;
   TextField txtReceptions;
   TextField txtBath;
   TextField txtType;
   TextField txtPrice;
   
   //Declare Buttons to perform action(s) for property(ies)
   //Fifth row
   Button btnAddProperty;
   Button btnViewProperties;
   Button btnRemovePropertyWindow; // Any that end with window will be handled to open a new scene
   Button btnUpdatePriceWindow;
   //Eighth row
   Button btnSearch;
   //Ninth row
   Button btnSortLowPrice;
   Button btnSortHighPrice;
   //Tenth row
   Button btnUpdateDetailsWindow;
   //Eleventh row
   Button btnHelp;
   Button btnClearFields;
   
   //Declare TextArea to show results or messages to user
   //Sixth row
   TextArea txtOutput;
   
   //Declare Controls in Second scene(Remove Property)
   Label lblPropNum;
   TextField txtPropNum;
   Button btnRemoveProperty;
   Button btnReturn;
   TextArea txtOutput2;
   
   //Declare Controls in Third Scene(Update Property Price)
   Label lblPropNum2;
   Label lblNewPrice;
   TextField txtPropNum2;
   TextField txtNewPrice;
   TextArea txtOutput3;
   Button btnUpdatePrice;
   Button btnReturn2;
   
   //Decare Controls in Fourth Scene(Update Property Details)
   Label lblInstructions;
   Label lblPropNumToUpdate;
   Label lblStreetUpdate;
   Label lblTownUpdate;
   Label lblCountyUpdate;
   Label lblBedsUpdate;
   Label lblReceptionstUpdate;
   Label lblBathUpdate;
   Label lblTypetUpdate;
   Label lblPriceUpdate;
   
   TextField txtPropNumToUpdate;
   TextField txtStreetUpdate;
   TextField txtTownUpdate;
   TextField txtCountyUpdate;
   TextField txtBedsUpdate;
   TextField txtReceptionsUpdate;
   TextField txtBathUpdate;
   TextField txtTypeUpdate;
   TextField txtPriceUpdate;
   
   TextArea txtOutput5;
   
   Button btnUpdateDetails;
   Button btnReturnToMain;
   
   //Declare Controls in Fifth Scene(Help)
   TextArea txtOutput4;
   Button btnReturn3;
      
   public void start(Stage stage)//start main method, pass in stage to set the initial scene for program
   {
      //Create Labels for main window/scene, to be placed alongside corresponding text fields for each where appropriate
      //Top row
      Label lblEnterPropDetails = new Label("**** Enter Property Details ****");
      //Second row
      Label lblStreet = new Label("Street");
      Label lblTown = new Label("Town");
      Label lblCounty = new Label("County");
      //Third row
      Label lblBeds = new Label("Beds");
      Label lblReceptions = new Label("Receptions");
      Label lblBath = new Label("Bath");
      Label lblType = new Label("Type");
      Label lblPrice = new Label("Price €");
      //Fourth row
      Label lblPropFunctions = new Label("**** Property Functions ****");
      //Seventh row
      Label lblCreateFunctions = new Label("**** Create your own functions ****");
      //Eighth row - Label describes to user how to use the search
      Label lblSearch = new Label("Enter any search data in property details and press search");
      
      //Create all TextFields for user to input data
      //Assign values to each text field for the selected width of each
      txtStreet = new TextField();
      txtStreet.setMaxWidth(150);
      txtTown = new TextField();
      txtTown.setMaxWidth(150);
      txtCounty = new TextField();
      txtCounty.setMaxWidth(150);
      
      txtBeds = new TextField();
      txtBeds.setMaxWidth(50);
      txtReceptions = new TextField();
      txtReceptions.setMaxWidth(50);
      txtBath = new TextField();
      txtBath.setMaxWidth(50);
      txtType = new TextField();
      txtType.setMaxWidth(100);
      txtPrice = new TextField();
      txtPrice.setMaxWidth(100);
      
      
      //Create Buttons to add property, view properties, remove properties, update property price, sort by price, help, and clear fields. Also define what text will be in each button.
      btnAddProperty = new Button("Add Property");
      btnAddProperty.setOnAction(e -> addProperty()); //By using .setOnAction() method on the button, the lambda expression calls the addProperty() method in this case, when the add property button is clicked
      btnViewProperties = new Button("View All Properties");
      btnViewProperties.setOnAction(e -> viewProperties());
      btnRemovePropertyWindow = new Button("Remove Property"); //Button created which will be set to open the remove property scene further ahead in code
      btnUpdatePriceWindow = new Button("Update Property Price");
      
      btnSearch = new Button("Search for property");
      btnSearch.setOnAction(e -> searchProperty());
      btnSortLowPrice = new Button("Sort properties by lowest price");
      //When this button is clicked, the lambda expression will check if there are any properties in the propertyList first, if there are, the sortLowPrice() method is called. If not, a message will state there are no properties yet.
      btnSortLowPrice.setOnAction(e -> 
      {
         if(!propertyList.isEmpty())
         {
            sortLowPrice();
         }
         else
         {
            txtOutput.setText("No properties added yet");
         }
      });
      btnSortHighPrice = new Button("Sort properties by highest price");
      //Works the same as the above button, but it will call the sortHighPrice() method if there are properties in the propertyList
      btnSortHighPrice.setOnAction(e -> 
      {
         if(!propertyList.isEmpty())
         {
            sortHighPrice();
         }
         else
         {
            txtOutput.setText("No properties added yet");
         }
      });
      btnUpdateDetailsWindow = new Button("Update property details");
      btnHelp = new Button("Help");
      btnHelp.setMaxWidth(100); //Setting the max width for the help button to 100 pixels
      btnClearFields = new Button("Clear all fields");
      btnClearFields.setOnAction(e -> clearFields()); //When this button is clicked, it will call the clearFields() method
      
      //Create Text Area for main scene/window
      txtOutput = new TextArea();
      txtOutput.setMaxSize(800,500); //Set the width and height for the text area
      txtOutput.setEditable(false); //Do not allow user to edit what is in text area
      
      //Create HBox and add all elements to it
      //Adding Labels, Text Fields, Text Area, and Buttons across the screen
      HBox row1 = new HBox(8); //Create HBox titled row1, allow 8 pixels for space between this and any other HBoxes added.
      row1.getChildren().addAll(lblEnterPropDetails); //Add elements to this row, in this case the label for entering property details
      row1.setAlignment(Pos.CENTER); //Position the elements to the center horizontally
      
      HBox row2 = new HBox(8);
      row2.getChildren().addAll(lblStreet, txtStreet, lblTown, txtTown, lblCounty, txtCounty); // Here, we add in the labels and textfields in the order we want them displayed
      row2.setAlignment(Pos.CENTER);
      
      HBox row3 = new HBox(8);
      row3.getChildren().addAll(lblBeds, txtBeds, lblReceptions, txtReceptions, lblBath, txtBath, lblType, txtType, lblPrice, txtPrice);
      row3.setAlignment(Pos.CENTER);
      
      HBox row4 = new HBox(8);
      row4.getChildren().addAll(lblPropFunctions);
      row4.setAlignment(Pos.CENTER);
      
      HBox row5 = new HBox(8);
      row5.getChildren().addAll(btnAddProperty, btnViewProperties, btnRemovePropertyWindow, btnUpdatePriceWindow);
      row5.setAlignment(Pos.CENTER);
      
      HBox row7 = new HBox(8);
      row7.getChildren().addAll(lblCreateFunctions);
      row7.setAlignment(Pos.CENTER);
      
      HBox row8 = new HBox(8);
      row8.getChildren().addAll(lblSearch, btnSearch);
      row8.setAlignment(Pos.CENTER);
      
      HBox row9 = new HBox(8);
      row9.getChildren().addAll(btnSortLowPrice, btnSortHighPrice);
      row9.setAlignment(Pos.CENTER);
      
      HBox row10 = new HBox(8);
      row10.getChildren().addAll(btnUpdateDetailsWindow);
      row10.setAlignment(Pos.CENTER);
      
      HBox row11 = new HBox(8);
      row11.getChildren().addAll(btnHelp, btnClearFields);
      row11.setAlignment(Pos.CENTER);
      
      //Create VBox and add the HBoxes to it and also TextArea(txtOutput)
      VBox root = new VBox(10); // Create new VBox and leave 10 pixels between each row
      root.getChildren().addAll(row1, row2, row3, row4, row5, txtOutput, row7, row8, row9, row10, row11); //Assign the horizontal rows to our VBox, in the order we want them displayed. No need for a row6 as we are only adding txtOutput here.
      root.setAlignment(Pos.CENTER); // Position the VBox to the centre(vertical)
      //Create Scene and add VBox to scene
      Scene scene = new Scene(root, 900, 600); //Create scene, add VBox to it, and set width and height
      stage.setScene(scene); //Set the scene to the stage
      stage.setTitle("Property Program"); //Set the title for the stage
      stage.show(); //Display the stage
      
      //Controls for scene 2(Remove property scene)
      Label lblPropNum = new Label("Enter property number");
      txtPropNum = new TextField();
      txtPropNum.setMaxWidth(50);
      btnRemoveProperty = new Button("Remove this property");
      btnReturn = new Button("Return");
      btnReturn.setMaxWidth(100);
      txtOutput2 = new TextArea();
      txtOutput2.setMaxSize(300, 70);
      txtOutput2.setEditable(false);
      HBox input = new HBox(8); // Need to ensure the HBox name is different to any other HBoxes to prevent any issues
      input.getChildren().addAll(lblPropNum, txtPropNum, btnRemoveProperty);
      input.setAlignment(Pos.CENTER);
      VBox root2 = new VBox(10);
      root2.getChildren().addAll(input, txtOutput2, btnReturn);
      root2.setAlignment(Pos.CENTER);
      Scene scene2 = new Scene(root2, 500, 400);
      
      btnRemovePropertyWindow.setOnAction(e -> 
      {
         if(!propertyList.isEmpty())
         {
            stage.setScene(scene2); // If user clicks on button to remove property window and there are properties in the propertyList, scene2 will display.
         }
         else //If no properties in propertyList, display message below
         {
            txtOutput.setText("No properties added yet");
         }
      });
      
      btnRemoveProperty.setOnAction(e -> removeProperty()); // If user clicks remove property in scene2, call the removeProperty() method
      btnReturn.setOnAction(e -> 
      {
         txtOutput2.clear();
         stage.setScene(scene); // If user clicks on return in scene2, clear the text from the text area in scene2, and return to the main scene window.
      });
      
      //Controls for scene 3 (Update property price)
      Label lblPropNum2 = new Label("Enter property number");
      txtPropNum2 = new TextField();
      txtPropNum2.setMaxWidth(50);
      Label lblNewPrice = new Label("Enter new price");
      txtNewPrice = new TextField();
      txtNewPrice.setMaxWidth(70);
      txtOutput3 = new TextArea();
      txtOutput3.setMaxSize(400, 70);
      txtOutput3.setEditable(false);
      
      btnUpdatePrice = new Button("Update price");
      btnReturn2 = new Button("Return");
      btnReturn2.setMaxWidth(100);

      HBox input1 = new HBox(8);
      input1.getChildren().addAll(lblPropNum2, txtPropNum2);
      input1.setAlignment(Pos.CENTER);
      HBox input2 = new HBox(8);
      input2.getChildren().addAll(lblNewPrice, txtNewPrice);
      input2.setAlignment(Pos.CENTER);
      HBox buttons = new HBox(8);
      buttons.getChildren().addAll(btnUpdatePrice, btnReturn2);
      buttons.setAlignment(Pos.CENTER);
      
      VBox root3 = new VBox(10);
      root3.getChildren().addAll(input1, input2, txtOutput3, buttons);
      root3.setAlignment(Pos.CENTER);
      Scene scene3 = new Scene(root3, 500, 400);
      
      btnUpdatePriceWindow.setOnAction(e -> 
      {
         if(!propertyList.isEmpty())
         {
            stage.setScene(scene3);
         }
         else
         {
            txtOutput.setText("No properties added yet");
         }
      });
      
      btnUpdatePrice.setOnAction(e -> updatePrice());
      btnReturn2.setOnAction(e -> 
      {
         txtOutput3.clear();
         stage.setScene(scene);
      });
      
      //Controls for scene 4 (Update any property details)
      Label lblInstructions = new Label("Only enter changes in fields you want to update, leave the rest blank");
      Label lblPropNumToUpdate = new Label("Enter property number to update");
      Label lblStreetUpdate = new Label("Update street name here");
      Label lblTownUpdate = new Label("Update town name here");
      Label lblCountyUpdate = new Label("Update county name here");
      Label lblBedsUpdate = new Label("Update beds number here");
      Label lblReceptionsUpdate = new Label("Update receptions number here");
      Label lblBathUpdate = new Label("Update baths number here");
      Label lblTypeUpdate = new Label("Update property type here");
      Label lblPriceUpdate = new Label("Update price here");
      
      txtPropNumToUpdate = new TextField();
      txtPropNumToUpdate.setMaxWidth(150);
      txtStreetUpdate = new TextField();
      txtStreetUpdate.setMaxWidth(150);
      txtTownUpdate = new TextField();
      txtTownUpdate.setMaxWidth(150);
      txtCountyUpdate = new TextField();
      txtCountyUpdate.setMaxWidth(150);
      txtBedsUpdate = new TextField();
      txtBedsUpdate.setMaxWidth(150);
      txtReceptionsUpdate = new TextField();
      txtReceptionsUpdate.setMaxWidth(150);
      txtBathUpdate = new TextField();
      txtBathUpdate.setMaxWidth(150);
      txtTypeUpdate = new TextField();
      txtTypeUpdate.setMaxWidth(150);
      txtPriceUpdate = new TextField();
      txtPriceUpdate.setMaxWidth(150);
      
      txtOutput5 = new TextArea();
      txtOutput5.setMaxSize(400, 100);
      txtOutput5.setPrefSize(400, 100); //Had to use .setPrefSize to change to the correct text area dimensions
      txtOutput5.setEditable(false);
      
      btnUpdateDetails = new Button("Update Property Details");
      btnReturnToMain = new Button("Return");
      
      HBox updateRow1 = new HBox(8);
      updateRow1.getChildren().addAll(lblInstructions);
      updateRow1.setAlignment(Pos.CENTER);
      
      HBox updateRow2 = new HBox(8);
      updateRow2.getChildren().addAll(lblPropNumToUpdate, txtPropNumToUpdate);
      updateRow2.setAlignment(Pos.CENTER);
      
      HBox updateRow3 = new HBox(8);
      updateRow3.getChildren().addAll(lblStreetUpdate, txtStreetUpdate);
      updateRow3.setAlignment(Pos.CENTER);
      
      HBox updateRow4 = new HBox(8);
      updateRow4.getChildren().addAll(lblTownUpdate, txtTownUpdate);
      updateRow4.setAlignment(Pos.CENTER);
      
      HBox updateRow5 = new HBox(8);
      updateRow5.getChildren().addAll(lblCountyUpdate, txtCountyUpdate);
      updateRow5.setAlignment(Pos.CENTER);
      
      HBox updateRow6 = new HBox(8);
      updateRow6.getChildren().addAll(lblBedsUpdate, txtBedsUpdate);
      updateRow6.setAlignment(Pos.CENTER);
      
      HBox updateRow7 = new HBox(8);
      updateRow7.getChildren().addAll(lblReceptionsUpdate, txtReceptionsUpdate);
      updateRow7.setAlignment(Pos.CENTER);
      
      HBox updateRow8 = new HBox(8);
      updateRow8.getChildren().addAll(lblBathUpdate, txtBathUpdate);
      updateRow8.setAlignment(Pos.CENTER);
      
      HBox updateRow9 = new HBox(8);
      updateRow9.getChildren().addAll(lblTypeUpdate, txtTypeUpdate);
      updateRow9.setAlignment(Pos.CENTER);
      
      HBox updateRow10 = new HBox(8);
      updateRow10.getChildren().addAll(lblPriceUpdate, txtPriceUpdate);
      updateRow10.setAlignment(Pos.CENTER);
      
      HBox updateRow11 = new HBox(8);
      updateRow11.getChildren().addAll(txtOutput5);
      updateRow11.setAlignment(Pos.CENTER);
      
      HBox updateRow12 = new HBox(8);
      updateRow12.getChildren().addAll(btnReturnToMain, btnUpdateDetails);
      updateRow12.setAlignment(Pos.CENTER);

      
      VBox rootUpdate = new VBox(10);
      rootUpdate.getChildren().addAll(updateRow1, updateRow2, updateRow3, updateRow4, updateRow5, updateRow6, updateRow7, updateRow8, updateRow9, updateRow10, updateRow11, updateRow12);
      rootUpdate.setAlignment(Pos.CENTER);
      Scene sceneUpdate = new Scene(rootUpdate, 800, 700);
      
      btnUpdateDetailsWindow.setOnAction(e -> 
      {
         if(!propertyList.isEmpty())
         {
            stage.setScene(sceneUpdate);
         }
         else
         {
            txtOutput.setText("No properties added yet");
         }
      });
      
      btnUpdateDetails.setOnAction(e -> updateDetails());
      btnReturnToMain.setOnAction(e -> 
      {
         txtOutput5.clear();
         txtOutput.clear();
         txtPropNumToUpdate.clear();
         txtStreetUpdate.clear();
         txtTownUpdate.clear();
         txtCountyUpdate.clear();
         txtBedsUpdate.clear();
         txtReceptionsUpdate.clear();
         txtBathUpdate.clear();
         txtTypeUpdate.clear();
         txtPriceUpdate.clear();
         stage.setScene(scene);
      });
      
      //Controls for scene 5 (Help instructions guide)
      txtOutput4 = new TextArea();
      txtOutput4.setMaxSize(700, 500);
      txtOutput4.setPrefSize(700, 500);
      txtOutput4.setEditable(false);
      txtOutput4.setText( // The text area txtOutput4 will contain the text below which explains how to use the program
         "Welcome to property manager!\n" +
         "\n" +
         "Here is a simple guide on the instructions\n" +
         "\n" +
         "1. Add a property \n" +
         "   To add a property, ensure all fields are filled with valid entries and click add property.\n" +
         "   Beds, Receptions, Bath, and Price must have valid numbers entered.\n" +
         "   Street, Town, and County must contain valid names.\n" +
         "   Type must contain either 'Residential', 'Commercial', or 'Site'.\n" +
         "\n" +
         "2. View all properties \n" +
         "   At least one property must be added to view properties.\n" +
         "   To view all properties, simply click the button.\n" +
         "\n" +
         "3. Remove a property \n" +
         "   To remove a property, click the button to be brought to a new window. \n" +
         "   Enter a valid property number and click remove property to remove.\n" +
         "   To return to main window, click return.\n" +
         "\n" +
         "4. Update Property Price \n" +
         "   To update a property price, enter a valid property number, followed by a valid price number and click update price.\n" +
         "   To return to main window, click return.\n" +
         "\n" +
         "5. Search for a property/ properties \n" +
         "   To search for a property, you can add as many entries into the property fields at the top, and click search.\n" +
         "   If any results are found, they will be shown.\n" +
         "   You can begin by searching using one field entry, and then if you want to refine your results, add more entries.\n" +
         "   If no properties are found, a message will display stating this.\n" +
         "\n" +
         "6. Sort properties by high &/ low price \n" +
         "   To sort properties using either high or low price, you can either select view all properties, or search for properties.\n" +
         "   Whatever you select, provided there are properties found, you can select to sort by highest or lowest price.\n" +
         "   You may alternate between highest and lowest price if you please.\n" +
         "\n" +
         "7. Update Property Details \n" +
         "   By clicking update property details you can update as many fields as you want to for a valid property.\n" +
         "   Enter the property number at the top, and then fill in the fields you want to update.\n" +
         "   You can leave the fields you don't want to update blank and they will stay the same.\n" +
         "   Click update property details to update with the given changes.\n" +
         "\n" +
         "8. Help \n" +
         "   If you have selected help, all of the instructions for the controls are found here.\n" +
         "   To return to the main window, simply click return at the bottom of this page.\n" +
         "\n" +
         "9. Clear all fields \n" +
         "   By clicking clear all fields, you will remove any text in all of the property fields.\n" +
         "\n"
      );
         
      btnReturn3 = new Button("Return");
      btnReturn3.setMaxSize(150, 50);
      btnReturn3.setPrefSize(150, 50);

      HBox help = new HBox(8);
      help.getChildren().addAll(txtOutput4);
      help.setAlignment(Pos.CENTER);
      HBox return3 = new HBox(8);
      return3.getChildren().addAll(btnReturn3);
      return3.setAlignment(Pos.CENTER);
      
      VBox root4 = new VBox(10);
      root4.getChildren().addAll(help, btnReturn3);
      root4.setAlignment(Pos.CENTER);
      Scene scene4 = new Scene(root4, 900, 700);
      
      btnHelp.setOnAction(e -> stage.setScene(scene4));
      btnReturn3.setOnAction(e -> stage.setScene(scene));
      
   }
   
   //Method to clear all text from textFields
   public void clearTextFields(){
      txtStreet.clear(); //Will clear text from the text field txtStreet
      txtTown.clear();
      txtCounty.clear();
      txtBeds.clear();
      txtReceptions.clear();
      txtBath.clear();
      txtType.clear();
      txtPrice.clear();
   }
   
   //Method to add property
   public void addProperty(){
      //Create variables that correspond to the input fields for property details in main scene
      String street;
      String town;
      String county;
      int numBeds;
      int numReceptions;
      int numBaths;
      String propType;
      double propPrice;
      
      //Get the text from all fields that expect Strings and assign to corresponding variables
      street = txtStreet.getText();
      town = txtTown.getText();
      county = txtCounty.getText();
      propType = txtType.getText();
      
      //If any field is empty, tell user all must be filled to add a property
      if(street.isEmpty() || town.isEmpty() || county.isEmpty() || propType.isEmpty() || txtBeds.getText().isEmpty() || txtReceptions.getText().isEmpty() || txtBath.getText().isEmpty() || txtPrice.getText().isEmpty())
      {
         txtOutput.setText("All fields must have an entry to add a property");
      }
      else //If all fields entered
      {
         //Check that property type is either residential, commercial, or site. And to ignore the case.
         if(propType.equalsIgnoreCase("Residential") || propType.equalsIgnoreCase("Commercial") || propType.equalsIgnoreCase("Site")) 
         { 
            
            try //Begin try catch method where we attempt to assign the values for beds, receptions, baths and price to their variables
            { 
               numBeds = Integer.parseInt(txtBeds.getText()); //Assign the Integer parsed text to the numBeds variable
               if(numBeds < 0 || numBeds > 100)
               {
                  txtOutput.setText("The number of beds must be greater than or equal to zero, and not exceed 100");
                  return; // Exit the method and print the above statement
               }
               numReceptions = Integer.parseInt(txtReceptions.getText());
               if(numReceptions < 0 || numReceptions > 100)
               {
                  txtOutput.setText("The number of receptions must be greater than or equal to zero, and not exceed 100");
                  return;
               }
               numBaths = Integer.parseInt(txtBath.getText());
               if(numBaths < 0 || numBaths > 100)
               {
                  txtOutput.setText("The number of baths must be greater than or equal to zero, and not exceed 100");
                  return;
               }
               propPrice = Double.parseDouble(txtPrice.getText()); // Similar here but to parse Double instead of Integer
               if(propPrice >= 0.0 && propPrice <= 100000000) // Check that the property price is 0.0 or greater, and less than or equal to 100 million
               {
                  //Create a new Property object by calling the third constructor from the Property class, passing all the variables assigned from the input fields data, and add it to the propertyList array list.
                  propertyList.add(new Property(street, town, county, numBeds, numReceptions, numBaths, propType, propPrice));
                  clearTextFields(); //Call the clearTextFields() method to clear all text fields
                  txtOutput.setText("Property added"); //Inform user property has been added
               }
               else //If price is less than 0, or greater than 100 million, print message below
               {
                  txtOutput.setText("Property price must be greater than or equal to 0, and less than or equal to 100 Million");
                  return;
               }
            }
            catch(NumberFormatException e) //If any exceptions caught(values not of the format of the variables that expect either integers or doubles), tell user the fields that need a valid number
            {
               txtOutput.setText("Beds, Receptions, Bath, and Price must have a valid number");
            }
         }
         else //If type is not entered as residential, commercial, or site, tell user it must be one of those three.
         {
            txtOutput.setText("Type must be either 'Residential', 'Commercial', or 'Site'.");
         }
      }
   }
   
   //Method to view all properties in propertyList
   public void viewProperties()
   {
      txtOutput.clear(); //Clear any text from textArea in main scene
      if(propertyList.isEmpty()) //Check if there are no properties in propertyList yet, if so, print message saying none found
      {
         txtOutput.setText("No properties found");
      }
      else //If properties in propertyList
      {
         //Clear all entries from arraylists below. This relates to the sort functions. Anytime the viewProperties method is called we want to start with empty arraylists which hold the search results, or results for viewing all properties. The properties in the system will then be added to the relevant arraylists in case the sort methods are called
         viewAllLowList.clear();
         viewAllHighList.clear();
         searchResultsLowList.clear();
         searchResultsHighList.clear();
         
         //Run a for each loop to iterate over all properties 'p' in propertyList
         for(Property p : propertyList)
         {
            //For each property found, print out the property details. Use appendText to ensure multiple details will display if multiple properties found.
            txtOutput.appendText(p + "\n--------------------------------------------------------------------------------------------------------------------------------------------");
            //Add the property 'p' to both the viewAllLowList and viewAllHighList, so that regardless of which sort by method the user may choose, it will contain the property
            viewAllLowList.add(new Property(p));
            viewAllHighList.add(new Property(p));
         }
      }
   }
   
   //Method to remove property
   public void removeProperty()
   {
      boolean propertyFound = false; //boolean to be used if property is found
      int propertyNum; //variable for property number
      int propertyNumFound; //variable for the property number found
      //Check if the user has entered a number for property number, if not, display the message
      if(txtPropNum.getText().isEmpty())
      {
         txtOutput2.setText("Property Number is empty");
      }
      else // If user enters data into property number text field
      {
         try // Try to parse the text from txtPropNum to an Integer
         {
            propertyNum = Integer.parseInt(txtPropNum.getText()); // Assign value from parse method to variable propertyNum
            
            if(propertyNum >= 0) //Check if the value for property number is greater than or equal to 0
            {
            Property toDelete = null; //Declare a Property object 'toDelete' and set it to null, to be used later outside of the foreach loop, so as to prevent any issues from attempting to delete the object within the foreach loop.
            
               for(Property p : propertyList) //Iterate through properties 'p' in property list
               {
                  if(propertyNum == p.viewPropNo()) //If the propertyNum entered matches with a property number from the property list
                  {
                     toDelete = p; //assing the property found to toDelete object
                     propertyFound = true; //set propertyFound to true
                     txtOutput2.setText("Property Removed!"); //Display message that property has been removed
                  }
               }
               
               if(propertyFound) //If propertyFound has been set to true
               {
                  propertyList.remove(toDelete); //Delete the property. I had to use this instead of just deleting 'p' within the foreach loop as there was an error occuring when doing that
               }
               else //If propertyNum has not found a match in the propertyList, print message below
               {
                  txtOutput2.setText("No property with that number found");
               }
            }
            else // If propertyNum entered is less than 0, print message below
            {
               txtOutput2.setText("Number must be greater than or equal to 0");
            }
         }
         catch(NumberFormatException e) // If a user has entered something other than a number for property number, print message below
         {
            txtOutput2.setText("A valid number must be entered");
         }   
      }
      txtOutput.clear();   // Clear the text in txtOutput  
   }
   
   //Method to update price
   public void updatePrice()
   { 
      boolean propertyFound = false;  // Create boolean value 'propertyFound' and set it to false
      try // Try to parse the data from txtNewPrice into a double, and assign to price variable. Do the same with txtPropNum2 to an Int and assign to propNum
      {
         double price = Double.parseDouble(txtNewPrice.getText());      
         int propNum = Integer.parseInt(txtPropNum2.getText());
         
         if(price >= 0.0 && price <= 100000000 && propNum >= 0) //Check that price is greater than or equal to 0, that price is less than or equal to 100 Million, and that propNum is greater than or equal to 0.
         {
            Property toUpdate = null; // Declare Property object 'toUpdate' and set it to null
         
            for(Property p: propertyList) //Iterate over properties in propertyList
            {
               if(propNum == p.viewPropNo()) //If the propNum entered matches with a property Number in the propertyList
               {
                  toUpdate = p; //assign the property 'p' found to toUpdate object
                  propertyFound = true; // set propertyFound to true
                  txtOutput3.setText("Price updated"); //Display message
               }
            }
            if(propertyFound) //If propertyFound has been set to true
            {
               toUpdate.setPrice(price); // Had to call the setPrice method, passing the price the user entered on the toUpdate object. This was again done as there were issues when trying to update on the 'p' property in the foreach loop.
            }
            else //If propertyNum has not found a match in propertyList, display message below
            {
               txtOutput3.setText("No property with that property number found");
            }
         }
         else //If property number and price are not greater than or equal to 0, and property Price is greater than 100 Million, print message below
         {
            txtOutput3.setText("Property number and Price must be greater than or equal to 0, and Price must be less than or equal to 100 Million"); 
         }
      }
      catch(NumberFormatException e) // If text entered for propertyNum and price are not numbers, print message below
      {
         txtOutput3.setText("Valid numbers must be entered for Price and Property Number");
      }
         
      txtOutput.clear(); //Clear text from txtOutput

   }
   
   //Method to search for a property
   public void searchProperty()
   {
   
   txtOutput.clear(); //Clear text from txtOutput
   if(propertyList.isEmpty()) //Check if propertyList has no properties, if so, print message below
   {
      txtOutput.setText("No properties added yet");
   }
   else // If propertyList contains property/ies
   {
         searchResultsLowList.clear(); //Clear results from searchResultsLowList arraylist, so that if any matches are found, they will be added to an empty arraylist. This is done to update the properties in the arrayLists each time a sort method is called.
         searchResultsHighList.clear(); //Clear results from searchResultHighList arraylist, so that if any matches are found, they will be added to an empty arraylist
         
         //String variables for each corresponding text field for property details. All of which have been assigned the value from the textField
         String street = txtStreet.getText();
         String town = txtTown.getText();
         String county = txtCounty.getText();
         String numBeds = txtBeds.getText();
         String numReceptions = txtReceptions.getText();
         String numBaths = txtBath.getText();
         String type = txtType.getText();
         String price = txtPrice.getText();
         
         //Check if no fields have data entered, if so, print message below
         if(street.isEmpty() && town.isEmpty() && county.isEmpty() && numBeds.isEmpty() && numReceptions.isEmpty() && numBaths.isEmpty() && type.isEmpty() && price.isEmpty())
         {
            txtOutput.setText("No fields entered for search");
         }
         else // If there is data entered in at least one or more fields
         {
            boolean oneFound = false; // Boolean value to use to determine whether at least one matching property has been found, initialised to false
            for(Property p : propertyList) // Iterate over properties in propertyList
            {
               // Initialise boolean 'found' to true, even though match techinically has not been found yet. Assume all properties are part of search results and we need to find reasons to eliminate them. If it steps through the following code and a non empty field returns false on found, it will then be set to false, indicating that property in the iteration is not a match.
               boolean found = true; 
               if(!street.isEmpty()) // Check if data from street is not empty
               {
                  if(!(street.equalsIgnoreCase(p.viewStreet()))) //If the data for street does not match the street from the property in this iteration, set found to false
                  {
                     found = false;
                  }
               }
               if(!town.isEmpty())
               {
                  if(!(town.equalsIgnoreCase(p.viewTown())))
                  {
                     found = false;
                  }
               }
               if(!county.isEmpty())
               {
                  if(!(county.equalsIgnoreCase(p.viewCounty())))
                  {
                     found = false;
                  }
               }
               if(!numBeds.isEmpty())
               {
                  try // Need to use try here to parse the String variable numBeds and assign it to numBedsInt
                  {
                     int numBedsInt = Integer.parseInt(numBeds);
                     if(numBedsInt > 100 || numBedsInt < 0) // Check the numBeds is not greater than 100, or less than 0, if so, print message
                     {
                        txtOutput.appendText("Number of beds must be greater than or equal to 0, and less than 100 \n");
                     }
                        
                     if(numBedsInt != p.viewBeds()) // If the number of beds does not match the number of beds in the property for this iteration, set found to false
                     {
                        found = false;
                     }
                  }
                  catch(NumberFormatException e) // If the value entered for number of Beds is not a number
                  {
                     txtOutput.appendText("Beds must contain a valid number \n");
                     found = false; // Set found to false, excluding the property from this iteration, from the results
                  }
               }
               if(!numReceptions.isEmpty()) // This if statement works the same as the one above, and the one below
               {
                  try
                  {
                     int numReceptionsInt = Integer.parseInt(numReceptions);
                     if(numReceptionsInt > 100 || numReceptionsInt < 0)
                     {
                        txtOutput.appendText("Number of receptions must be greater than or equal to 0, and less than 100 \n");
                     }
                     if(numReceptionsInt != p.viewReceptions())
                     {
                        found = false;
                     }
                  }
                  catch(NumberFormatException e)
                  {
                     txtOutput.appendText("Receptions must contain a valid number \n");
                     found = false;
                  }
               }
               if(!numBaths.isEmpty())
               {
                  try
                  {
                     int numBathsInt = Integer.parseInt(numBaths);
                     if(numBathsInt > 100 || numBathsInt < 0)
                     {
                        txtOutput.appendText("Number of baths must be greater than or equal to 0, and less than 100 \n");
                     }
                     if(numBathsInt != p.viewBaths())
                     {
                        found = false;
                     }
                  }
                  catch(NumberFormatException e)
                  {
                     txtOutput.appendText("Baths must contain a valid number \n");
                     found = false;
                  }
               }
      
               if(!type.isEmpty()) // This if statement works the same as the one for street, town, and county above
               {
                  if(!(type.equalsIgnoreCase(p.viewPropertyType())))
                  {
                     found = false;
                  }
               }
               if(!price.isEmpty()) // This if statement works the same as numBeds, numReceptions, and numBath only we are parsing a Double instead of an int. Also we check the price is greater than or equal to 0 and no more than 100 million
               {
                  try
                  {
                     double priceDouble = Double.parseDouble(price);
                     if(priceDouble > 100000000 || priceDouble < 0)
                     {
                        txtOutput.appendText("Price must be greater than or equal to 0, and less than 100,000,000 \n");
                     }
                     if(priceDouble != p.viewPrice())
                     {
                        found = false;
                     }
                  }
                  catch(NumberFormatException e)
                  {
                     txtOutput.appendText("Baths must contain a valid number \n");
                     found = false;
                  }
               }
               
               if(found) // If the property in the iteration has stepped through the above code and has not been switched to false, we can conclude it is part of the results
               {
                  txtOutput.appendText(p.toString() + "\n--------------------------------------------------------"); // Print out the property details
                  searchResultsLowList.add(new Property(p)); // Add this property to the searchResultsLowList arrayList in case the user wants to sort the properties by lowest price
                  searchResultsHighList.add(new Property(p)); // Add this property to the searchResultsHighList arrayList in case the user wants to sort the properties by highest price
                  oneFound = true; // set oneFound to true to indicate we have found at least one property for the search results from the iteration
               }
            }
            if(!oneFound) // If one found has not been set to true, we can conclude no matches are found, so print statement below
            {
               txtOutput.setText("No properties found");
            }
         }
      }
   }
   
   //Method to sort properties by lowest price
   public void sortLowPrice()
   {
      txtOutput.clear(); // Clear text from txtOutput
      
      if(!searchResultsLowList.isEmpty()) // Check if there are entries in the searchResultsLowList arrayList
      {
         // Perform sort operation on the searchResultsLowLost arrayList. Pass in two properties p1, and p2 from the arrayList. Then complete the following using a lambda expression.
         searchResultsLowList.sort((Property p1, Property p2) -> 
         {
            if (p1.viewPrice() > p2.viewPrice()) // Check to see if the price for p1 is greater than the price for p2
              return 1; // If so, return 1, which in terms of sort, means that p1 should be placed after p2 in the arrayList
            if (p1.viewPrice() < p2.viewPrice()) //If the price of p1 is not greater than the price of p2, check if the opposite is true
              return -1; // If so return -1, which indicates that p1 should come before p2
            return 0; // If neither of the above if statements are true, it means the prices are the same in p1 and p2 so neither property needs to move its position
         }); 
         
         for(Property s: searchResultsLowList) // Iterate over the properties in searchResultsLowList Arraylist
         {
            //Append the properties to txtOutput, which will now be in order of lowest price
            txtOutput.appendText(s.toString() + "\n---------------------------------------------------------------------------------------------------------------------------------");
         } 
      }
      else if(!viewAllLowList.isEmpty()) // If searchResultsLowList is empty, check if there are entries in the viewAllLowList arrayList
      {    
         viewAllLowList.sort((Property p1, Property p2) -> //The rest works the same as explained above
         {
            if (p1.viewPrice() > p2.viewPrice())
              return 1;
            if (p1.viewPrice() < p2.viewPrice())
              return -1;
            return 0;
         }); 
         
         for(Property v: viewAllLowList)
         {
            txtOutput.appendText(v.toString() + "\n---------------------------------------------------------------------------------------------------------------------------------");
         } 
      }
      else // If searchResultsLowList and viewAllLowList are both empty it means there are no properties in the txtOutput as neither a search or view all properties has been performed, then display message below
      {
         txtOutput.setText("Perform a search or view all properties first before sorting by price");
      }
      
   }

   //Method to sort properties by highest price
   //This works almost exactly the same as the sortLowPrice() method above, except when comparing the prices p1 returns 1 if it is less than p2. Also searchResultsHighList and viewAllHighList array lists are used. This will print the properties by order of highest price.
   public void sortHighPrice()
   {
      txtOutput.clear();
      
      if(!searchResultsHighList.isEmpty())
      {
         searchResultsHighList.sort((Property p1, Property p2) -> 
         {
            if (p1.viewPrice() < p2.viewPrice())
              return 1;
            if (p1.viewPrice() > p2.viewPrice())
              return -1;
            return 0;
         }); 
         
         for(Property s: searchResultsHighList)
         {
            txtOutput.appendText(s.toString() + "\n---------------------------------------------------------------------------------------------------------------------------------");
         } 
      }
      else if(!viewAllHighList.isEmpty())
      {    
         viewAllHighList.sort((Property p1, Property p2) -> 
         {
            if (p1.viewPrice() < p2.viewPrice())
              return 1;
            if (p1.viewPrice() > p2.viewPrice())
              return -1;
            return 0;
         }); 
         
         for(Property v: viewAllHighList)
         {
            txtOutput.appendText(v.toString() + "\n--------------------------------------------------------------------------------------------------------------------------------");
         } 
      }
      else
      {
         txtOutput.setText("Perform a search or view all properties first before sorting by price");
      }
   }
   
   //Method to update any property details
   public void updateDetails()
   {
      //Create String variables for each corresponding textfield and assign the values from the textfields to the variables
      String propNumToUpdate = txtPropNumToUpdate.getText();
      String newStreet = txtStreetUpdate.getText();
      String newTown = txtTownUpdate.getText();
      String newCounty = txtCountyUpdate.getText();
      String newBeds = txtBedsUpdate.getText();
      String newReceptions = txtReceptionsUpdate.getText();
      String newBath = txtBathUpdate.getText();
      String newType = txtTypeUpdate.getText();
      String newPrice = txtPriceUpdate.getText();
      
      //Declare int variables and a double variable for the property number, number of beds, receptions, baths, and price
      int propNum;
      int newBedsNum;
      int newReceptionsNum;
      int newBathNum;
      double newPriceNum;
      
      boolean propFound = false; // Declare and initialise boolean variable propFound to false
   
      //Check if all text fields except for property number are empty, if so, print message below
      if(newStreet.isEmpty() && newTown.isEmpty() && newCounty.isEmpty() && newBeds.isEmpty() && newReceptions.isEmpty() && newBath.isEmpty() && newType.isEmpty() && newPrice.isEmpty())
      {
         txtOutput5.setText("No details to update entered");
      }
      else // If at least one text field to update is not empty
      {
         if(propNumToUpdate.isEmpty()) // Check if property number is empty, if so, print message below
         {
            txtOutput5.setText("You must enter a property Number");
         }
         else // If property number is not empty
         {
            try // Try to parse the text from propNumToUpdate and assign to int variable propNum
            {
               propNum = Integer.parseInt(propNumToUpdate);
               for(Property p : propertyList) // Iterate over properties in propertyList
               {
                  if(propNum == p.viewPropNo()) // If the property number entered finds a match in the propertyList
                  {
                     propFound = true; // set propFound to true
                     
                     //This set of if statements will check to see which fields have been entered. If any are empty, the corresponding value will not change. If the field has data, it will use the set method for that particular value and pass in the relevant value to update it to.
                     if(!newStreet.isEmpty())
                     {
                        p.setStreet(newStreet);
                     }
                     if(!newTown.isEmpty())
                     {
                        p.setTown(newTown);
                     }
                     if(!newCounty.isEmpty())
                     {
                        p.setCounty(newCounty);
                     }
                     if(!newBeds.isEmpty())
                     {
                     //Within any methods that expect an Integer or Double value, we need to use a try catch to see if the value can be parsed correctly
                        try
                        {
                           newBedsNum = Integer.parseInt(newBeds);
                           if(newBedsNum < 0 || newBedsNum > 100) // Check that the number of beds is not less than 0 or greater than 100
                           {
                              txtOutput5.setText("Please enter a valid number for beds, 0 up to 100 accepted.");
                              return;
                           }
                           else // If not, set the new value for beds using the setNoBeds on the property p, by passing the newBedsNum the user entered.
                           {
                              p.setNoBeds(newBedsNum);
                           }
                        }
                        catch(NumberFormatException e) // If the value entered for number of beds is not a number, print the error message below
                        {
                           txtOutput5.setText("Please enter a valid number for beds");
                           return; // exit the method and print the error message above
                        }
                     }
                     if(!newReceptions.isEmpty())
                     {
                        try
                        {
                           newReceptionsNum = Integer.parseInt(newReceptions);
                           if(newReceptionsNum < 0 || newReceptionsNum > 100)
                           {
                              txtOutput5.setText("Please enter a valid number for receptions, 0 up to 100 accepted");
                              return;
                           }
                           else
                           {
                              p.setNoReceptions(newReceptionsNum);
                           }
                        }
                        catch(NumberFormatException e)
                        {
                           txtOutput5.setText("Please enter a valid number for receptions");
                           return;
                        }
                     }
                     if(!newBath.isEmpty())
                     {
                        try
                        {
                           newBathNum = Integer.parseInt(newBath);
                           if(newBathNum < 0 || newBathNum > 100)
                           {
                              txtOutput5.setText("Please enter a valid number for baths, 0 up to 100 accepted");
                              return;
                           }
                           else
                           {
                              p.setNoBaths(newBathNum);
                           }
                        }
                        catch(NumberFormatException e)
                        {
                           txtOutput5.setText("Please enter a valid number for baths");
                           return;
                        }
                        
                     }
                     if(!newType.isEmpty())
                     {
                        //We need to check that the type is being updated to one of the three acceptable values below, if so, set the new type. Also this will ignore the case the user has typed in.
                        if(newType.equalsIgnoreCase("Residential") || newType.equalsIgnoreCase("Commercial") || newType.equalsIgnoreCase("Site")) 
                        {
                           p.setType(newType);
                        }
                        else // If not, print the message below
                        {
                           txtOutput5.setText("Type must be either 'Residential', 'Commercial', or 'Site'");
                           return; 
                        }
                     }
                     if(!newPrice.isEmpty())
                     {
                        try
                        {
                           newPriceNum = Double.parseDouble(newPrice);
                           if(newPriceNum < 0.0 || newPriceNum > 100000000.0)
                           {
                              txtOutput5.setText("Please enter a valid number for price, 0 up to 100000000 accepted");
                              return;
                           }
                           else
                           {
                              p.setPrice(newPriceNum);
                           }
                        }
                        catch(NumberFormatException e)
                        {
                           txtOutput5.setText("Please enter a valid number for price");
                           return;
                        }
                     }
                  
                  }
               }
               if(propFound == true) // If the property number has found a matching property
               {
                  txtOutput5.setText("Property details updated"); // If this point is reached, it is assumed that at least one field has been entered with valid data to update which has been done successfully
               }
                  
               if(propFound == false) // If the property number has not found a matching property, display message below
               {
                  txtOutput5.setText("No property found matching that property number");
               }
            }
            catch(NumberFormatException e) // If the property number entered is not a number, display the message below
            {
               txtOutput5.setText("You must enter a valid property number");
            }
            
         }
      
      }
   
   }
  
   //Method to clear all fields including the textArea 
   public void clearFields()
   {
      clearTextFields(); // This calls the method defined above which clears all the text fields
      txtOutput.clear();  // This will clear the text Area txtOutput
   }
}
