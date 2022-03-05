import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CarGUI1208 extends Application
{
   //Create ArrayList
   ArrayList<Car> carList = new ArrayList<>();
   
   //Create Alert
   //AlertType type = AlertType.INFORMATION;
   Alert alert = new Alert(AlertType.NONE);
   
   //TextField and Buttons for adding Car Details
   TextField txtRegNo;
   TextField txtRegNo1;
   TextField txtMake;
   TextField txtModel;
   TextField txtEmissions;
   TextField txtEngineSize;
   TextField txtYear;
   TextField txtValue;
   TextField txtRegNoEd;
   TextField txtMakeEd;
   TextField txtModelEd;
   TextField txtEmissionsEd;
   TextField txtEngineSizeEd;
   TextField txtYearEd;
   TextField txtValueEd;
   TextField txtNoOfMonths;
   Button btnAddCar;
   Button btnViewAll;
   Button btnEditCar;
   Button btnCarSold;
   Button btnSearchMake;
   Button btnSearchPrice;
   Button btnCalLoan;
   Button btnSearchReg;
   Button btnCarDetails;
   Button btnReturn;
   Button btnEnterTerm;
   Button btnUpdateCar;
   Button btnCancel;
   Button btnEnterReg;
   Button btnUpdateCar1;
   TextArea txtOutput;
   TextArea txtOutput1;
   TextArea txtOutputEdit;
   
  
   
   //private Car testCar = new Car();
   public void start(Stage stage)
   {  
   
      //Create Scenes and add VBox to scene
      
       //Labels for Text Fields
      Label lblTitle = new Label("*********************** Car Details ***************************");
      Label lblBreak = new Label("******************************************************");
      Label lblRegNo = new Label("Reg No");
      Label lblRegNo1 = new Label("Reg No");
      Label lblMake = new Label("Make");
      Label lblModel = new Label("Model");
      Label lblEmissions = new Label("Emissions");
      Label lblEngineSize = new Label("Engine Size");
      Label lblYear = new Label("Year");
      Label lblValue = new Label("Price");
      Label lblRegNoEd = new Label("Reg No");
      Label lblMakeEd = new Label("Make");
      Label lblModelEd = new Label("Model");
      Label lblEmissionsEd = new Label("Emissions");
      Label lblEngineSizeEd = new Label("Engine Size");
      Label lblYearEd = new Label("Year");
      Label lblValueEd = new Label("Price");
      
      //Create all TextFields
      txtRegNo = new TextField();
      txtRegNo1 = new TextField();
      txtMake = new TextField();
      txtMake.setMaxWidth(150);
      txtModel = new TextField();
      txtModel.setMaxWidth(150);
      txtEmissions = new TextField();
      txtEmissions.setMaxWidth(50);
      txtEngineSize = new TextField();
      txtEngineSize.setMaxWidth(50);
      txtYear = new TextField();
      txtYear.setMaxWidth(50);
      txtValue = new TextField();
      txtValue.setMaxWidth(50);
      txtOutput = new TextArea();
      txtOutput1 = new TextArea();
      txtOutputEdit = new TextArea();
      
      //Create Buttons 
      btnAddCar = new Button("Add Car");
      btnAddCar.setOnAction(e -> addCar(e));
      btnViewAll = new Button("View All Cars");
      btnViewAll.setOnAction(e -> viewAll(e));
      btnEditCar = new Button("Edit Car Details");
      btnCarSold = new Button("Car Sold");
      btnCarSold.setOnAction(e -> carSold(e));
      btnSearchReg = new Button("Search by Reg No");
      btnSearchReg.setOnAction(e -> searchReg(e));
      btnSearchMake = new Button("Search by Make");
      btnSearchMake.setOnAction(e -> searchMake(e));
      btnSearchPrice = new Button("Search by Price");
      btnSearchPrice.setOnAction(e -> searchPrice(e));
      btnCalLoan = new Button("Calculate Loan Repayments");
      btnCarDetails = new Button("Enter Csr Details");
      
      
      
      //Create TextArea for output
      txtOutput = new TextArea();
      txtOutput.setMaxSize(500,400);
      txtOutput.setEditable(false);
      
      
      //HBox input
      //Adding Labels and TextBoxes across the screen
      HBox input1 = new HBox(10);
      input1.getChildren().addAll(lblRegNo, txtRegNo, lblMake, txtMake, lblModel, txtModel);
      input1.setAlignment(Pos.CENTER);
      
      //HBox input2
      //Adding Labels and TextBoxes across the screen
      HBox input2 = new HBox(10);
      input2.getChildren().addAll(lblEmissions, txtEmissions, lblEngineSize, txtEngineSize, lblYear, txtYear, lblValue, txtValue);
      input2.setAlignment(Pos.CENTER);
      
      //HBox buttons1
      HBox buttons1 = new HBox(10);
      buttons1.getChildren().addAll(btnAddCar,btnViewAll,btnEditCar, btnCarSold);
      buttons1.setAlignment(Pos.CENTER);
      
      //HBox buttons2   
      HBox buttons2 = new HBox(10);
      buttons2.getChildren().addAll(btnSearchReg, btnSearchMake, btnSearchPrice, btnCalLoan);
      buttons2.setAlignment(Pos.CENTER);
            
      //Create VBox and add 2 HBoxes to it and also TextArea, labels & buttons
      VBox root = new VBox(25);
      root.getChildren().addAll(lblTitle, input1, input2,lblBreak, buttons1, buttons2, txtOutput);
      root.setAlignment(Pos.CENTER);
      Scene scene = new Scene(root, 1000, 750);
      stage.setScene(scene);
      stage.setTitle("CarGUI");
      stage.show();
      
      //New window for Calculate loan repayments
      lblRegNo1 = new Label("Reg No");
      Label lblNoOfMonths = new Label("Term of loan");
      txtRegNo1 = new TextField();
      txtRegNo1.setMaxWidth(100);
      txtNoOfMonths = new TextField();
      txtNoOfMonths.setMaxWidth(50);
      txtOutput1.setMaxSize(700,600);
      txtOutput1.setEditable(false);
      btnCarDetails = new Button("Enter Car Details");
      btnCarDetails.setOnAction(e -> enterDetails(e));
      btnReturn = new Button("Return");
      HBox input3 = new HBox(10);
      input3.getChildren().addAll(lblRegNo1, txtRegNo1, lblNoOfMonths, txtNoOfMonths);
      input3.setAlignment(Pos.CENTER);
      VBox root1 = new VBox(10);
      root1.getChildren().addAll(input3, btnCarDetails, btnReturn, txtOutput1);
      root1.setAlignment(Pos.CENTER);
      Scene scene1 = new Scene(root1, 1000, 750);
      //Buttons to enter and exit scene1
      btnCalLoan.setOnAction(e -> stage.setScene(scene1));
      btnReturn.setOnAction(e -> stage.setScene(scene));
       
      
      //New window for edit car details
      lblRegNoEd =new Label("RegNo");
      txtRegNoEd = new TextField();
      btnEnterReg = new Button("Search Reg");
      txtRegNoEd.setMaxWidth(100);
      lblMakeEd =new Label("Make");
      txtMakeEd = new TextField();
      txtMakeEd.setMaxWidth(100);
      lblModelEd =new Label("Model");
      txtModelEd = new TextField();
      txtModelEd.setMaxWidth(100);
      lblEmissionsEd =new Label("Emissions");
      txtEmissionsEd = new TextField();
      txtEmissionsEd.setMaxWidth(100);
      lblEngineSizeEd =new Label("Engine Size");
      txtEngineSizeEd = new TextField();
      txtEngineSizeEd.setMaxWidth(100);
      lblYearEd =new Label("Year");
      txtYearEd = new TextField();
      txtYearEd.setMaxWidth(100);
      lblValueEd =new Label("Price");
      txtValueEd = new TextField();
      txtValueEd.setMaxWidth(100);
      txtOutputEdit.setMaxSize(700,600);
      txtOutputEdit.setEditable(false);
      btnUpdateCar1 = new Button("Update Details");
      btnCancel = new Button("Cancel");
      HBox inputEdit = new HBox(10);
      inputEdit.getChildren().addAll(lblMakeEd, txtMakeEd, lblModelEd, txtModelEd);
      inputEdit.setAlignment(Pos.CENTER);
      HBox inputEditReg = new HBox(10);
      inputEditReg.getChildren().addAll(lblRegNoEd, txtRegNoEd, btnEnterReg);
      inputEditReg.setAlignment(Pos.CENTER);
      HBox inputEdit1 = new HBox(10);
      inputEdit1.getChildren().addAll(lblEmissionsEd, txtEmissionsEd, lblEngineSizeEd, txtEngineSizeEd, lblYearEd, txtYearEd, lblValueEd, txtValueEd);
      inputEdit1.setAlignment(Pos.CENTER);
      HBox inputEdit2 = new HBox(10);
      inputEdit2.getChildren().addAll(btnUpdateCar1, btnCancel);
      inputEdit2.setAlignment(Pos.CENTER);
      VBox rootEdit = new VBox(10);
      rootEdit.getChildren().addAll(inputEditReg, inputEdit, inputEdit1, inputEdit2, txtOutputEdit);
      rootEdit.setAlignment(Pos.CENTER);
      Scene sceneEdit = new Scene(rootEdit, 1000, 750);
      btnEditCar.setOnAction(e -> stage.setScene(sceneEdit));
      btnEnterReg.setOnAction(e -> updateCar(e));
      btnCancel.setOnAction(e -> stage.setScene(scene));
      btnUpdateCar1.setOnAction(e -> updateCar1(e));
      //btnUpdateCar1.setOnAction(e -> stage.setScene(scene));

      
     //btnReturn.setOnAction(e - > stage.setScene(scene));
 
       
   }//Close start Method
   
   //Method to add Car Details
   public void addCar(ActionEvent e)
   {
      try
      {
         //Check if TextFields are empty
         if(txtRegNo.getText().isEmpty() || txtMake.getText().isEmpty() || txtModel.getText().isEmpty() || txtEmissions.getText().isEmpty() || txtEngineSize.getText().isEmpty()  || txtYear.getText().isEmpty() || txtValue.getText().isEmpty())
         {
            txtOutput.setText("You must enter values for all 7 fields");
         }
         else
         { 
            String regNo = txtRegNo.getText();
            String make = txtMake.getText();
            String model = txtModel.getText();
            int emissions = Integer.parseInt(txtEmissions.getText());
            int engineSize = Integer.parseInt(txtEngineSize.getText());
            int year = Integer.parseInt(txtYear.getText());
            double value = Double.parseDouble(txtValue.getText());
         
            //Create object and add it to ArrayList carList
            carList.add(new Car(regNo, make, model, emissions, engineSize, year, value));
            alert.setAlertType(AlertType.INFORMATION);
            alert.setContentText("Car successfully added");
            alert.show();
            
            //Clear TextFields
            txtRegNo.clear();
            txtMake.clear();
            txtModel.clear();
            txtEmissions.clear();
            txtEngineSize.clear(); 
            txtYear.clear();   
            txtValue.clear();    
         }//Close else

       }//Close try block
         catch(NumberFormatException ex)
         {
            txtOutput.setText("Check the values entered for the Engine Size, Emissions, Year & Value");
         }
         catch(IllegalArgumentException ex)
         {
            txtOutput.setText("Check Engine Size, Emissions, Year or Value are not negative values");
         }
   }//Close method
    
    //Method to view all car details
    public void viewAll(ActionEvent e)
   {
      //Clear txtOutput
      txtOutput.clear();
      //Check if TextFields are empty
         for(Car car: carList)
         {
            txtOutput.appendText(car +"\n"); // \n to put car on separate line
         }    
    }//Close method
    
    //Mehtod to search by car reg
     public void searchReg(ActionEvent e)
    {
      //Clear txtOutput
      txtOutput.clear();
      
      //Check text field txtregNo are not empty use if statement
      if(txtRegNo.getText().isEmpty())
      {
         txtOutput.setText("You must enter a value for Reg No");
      }
      else
      { 
      //Get car reg from user
         String regNo = txtRegNo.getText();
         //Search entire arraylist
         boolean isFound = false;
         for(int i = 0; i < carList.size(); i++)
         {
            if(regNo.equalsIgnoreCase(carList.get(i).getRegNo()))
            {
            txtOutput.appendText(carList.get(i).getMake()+"\n"+ carList.get(i).getModel()+"\n"+carList.get(i).getEngineSize()+"\n"+carList.get(i).getEmissions()+"\n"+carList.get(i).getYear()+"\n"+carList.get(i).getValue()+"\n");
            isFound = true;
            }//Close if
         } //Close for
               if(isFound == false)
               {
               txtOutput.setText("No car found matching this Reg No");
               }
       }//CLose else
 
      //Clear TextFields
      txtRegNo.clear();
      txtMake.clear();
      txtModel.clear();
      txtEmissions.clear();
      txtEngineSize.clear(); 
      txtYear.clear();   
      txtValue.clear();    
    }//Close method
    
    //Car Sold Method
    public void carSold(ActionEvent e)
    {
      //Clear TxtArea
      txtOutput.clear();
      
      if(txtRegNo.getText().isEmpty())
      {
         txtOutput.setText("You must enter a value for Reg No");
      }
      else
      { 
         //Get car reg from user
         String regNo = txtRegNo.getText();
         //Search entire arraylist
         boolean isFound = false;
         for(int i = 0; i < carList.size(); i++)
         {
            if(carList.get(i).getRegNo().equals(regNo));
            {
               carList.remove(i);
               txtOutput.setText("Car has been successfully removed");
               isFound = true;
            }//Close if
         }//Close for
            if(isFound == false)
               {
               txtOutput.setText("No car found matching this Reg No");
               }
       }//Close Method
       
      //Clear TextFields
      txtRegNo.clear();
      txtMake.clear();
      txtModel.clear();
      txtEmissions.clear();
      txtEngineSize.clear(); 
      txtYear.clear();   
      txtValue.clear(); 
     }//Close method
 
     public void searchMake(ActionEvent e)
     {   
         //Clear TxtArea
         txtOutput.clear();
         String mk = txtMake.getText();
         //Check if TextFields are empty
         if(txtMake.getText().isEmpty()) 
         { 
           txtOutput.setText("You must enter the make of the car");
         }
         else
         {
            boolean isFound = false;
            for(int i = 0; i < carList.size(); i++)
            {
        
            if(carList.get(i).getMake().equals(mk))
            {
               txtOutput.appendText(carList.get(i).getRegNo()+"\n");
               isFound = true;
            }//Close if
            }//Close for
            if(isFound == false)
            {
               txtOutput.setText("No car found matching that make");
            }//Close if
         }//Close else
         //Clear TextFields
      txtMake.clear();
      }//Close method
      
      //Method for search by price range ***NOT WORKING***
      public void searchPrice(ActionEvent e)
     { 
      try
      {  
         //Clear TxtArea
         txtOutput.clear();
         //Check if TextFields are empty
         if(txtValue.getText().isEmpty())
         { 
           txtOutput.setText("You must enter a maxium price range ");
         }
         else
         {
            double value = Double.parseDouble(txtValue.getText());
            boolean isFound = false;
            for(int i = 0; i < carList.size(); i++)
            {
               if(carList.get(i).getValue() <= value) 
               {
                  
                  txtOutput.appendText(carList.get(i).getRegNo()+"\n");
                  isFound = true;
               }//Close if
            }//Close for
            if(isFound == false)
            {
               txtOutput.setText("No cars found within this price range");
            }//Close if
         }//Close else
      }//Close try block
         catch(NumberFormatException ex)
         {
            txtOutput.setText("Value enter must be a number");
         }
         catch(IllegalArgumentException ex)
         {
            txtOutput.setText(" Value enter must not be a negative number");
         }
         //Clear TextFields
      txtValue.clear();
      }//Close method
      
      //Method for Loan Calculations ***NOT WORKING returning 0.00***
      public void enterDetails(ActionEvent e)
     {   
         //Clear TxtArea
         txtOutput1.clear();
         //Check if TextFields are empty
         if(txtRegNo1.getText().isEmpty() || txtNoOfMonths.getText().isEmpty()) 
         { 
           txtOutput1.setText("You must enter Reg No & Loan Term ");
         }  
         else
         {
           //Get car reg from user
            String regNo1 = txtRegNo1.getText();
            int noMonths = Integer.parseInt(txtNoOfMonths.getText());
            
            double repayment = 0;
            //Car new car1 = new Car();
            //Search entire arraylist
            boolean isFound = false;
            for(int i = 0; i < carList.size(); i++)
             {
               if(regNo1.equalsIgnoreCase(carList.get(i).getRegNo()))
               {
                   //Declaring local variables
                   //double loanPayments = 0;
                   double x = 0; 
                   double value = carList.get(i).getValue();
                   //Calculating loan monthly repayments
                   x = Math.pow(1 + 0.003333333333, noMonths);//Sourced from https://stackoverflow.com/questions/33094636/display-monthly-payment-in-powa-b-method.
                   repayment = (value*x*0.003333333333)/(x-1); 
                   txtOutput1.setText("The monthly repayment is: "+(repayment));
               }
               //}
                  //double loanRepayments = car1.loanRepayments(noMonths);
                  //txtOutput1.setText("The monthly repayment is: "+ loanRepayments);
                  
                //car.loanRepayments(noMonths);
               //}//Close if
            }//Close for
               if(isFound == false)
                {
                  txtOutput1.setText("No car found matching this Reg No");
                }
         }//Close else
         
         //Clear TextFields
      txtValue.clear();
      }//Close method 
 
      //Method to edit details
      
      /*public void enterReg(ActionEvent e)
     {   
            //Clear TxtArea
            txtOutput.clear();
            String searchReg = txtRegNoEd.getText();
         if(txtRegNoEd.getText().isEmpty()) 
         {  
            txtOutputEdit.setText("You must enter the car Reg number");
         }
         else
         {
            boolean isFound = false;
            for(int i = 0; i < carList.size(); i++)
            {
        
               if(searchReg.equalsIgnoreCase(carList.get(i).getRegNo()))
               {
                  txtMakeEd.setText(carList.get(i).getMake()+ "\n");
                  
                  txtModelEd.setText(carList.get(i).getModel()+ "\n");
                  txtEngineSizeEd.setText(carList.get(i).getEngineSize()+ "\n");
                  txtEmissionsEd.setText(carList.get(i).getEmissions()+ "\n");
                  txtYearEd.setText(carList.get(i).getYear()+ "\n");
                  txtValueEd.setText(carList.get(i).getValue()+ "\n");
                  
               }//Close if
            }//Close for
            if(isFound == false)
            {
               txtOutput.setText("No car found matching that make");
            }//Close if
         }//Close else
         
         
      }//Close method*/
      
   public void updateCar(ActionEvent e)
   {
      try
      {
         //Check if TextFields are empty
         if(txtRegNoEd.getText().isEmpty()) //|| txtMakeEd.getText().isEmpty() || txtModelEd.getText().isEmpty() || txtEmissionsEd.getText().isEmpty() || txtEngineSizeEd.getText().isEmpty()  || txtYearEd.getText().isEmpty() || txtValueEd.getText().isEmpty())
         {
            txtOutputEdit.setText("You must enter a car Reg No");
         }
         
         else
         { 
            String searchReg = txtRegNoEd.getText();
            boolean isFound = false;
            for(int i = 0; i < carList.size(); i++)
            {
        
               if(searchReg.equalsIgnoreCase(carList.get(i).getRegNo()))
               {
                  String mk = carList.get(i).getMake();
                  txtMakeEd.setText(mk);
                  String model = carList.get(i).getModel();
                  txtModelEd.setText(model);
                  int emissions = carList.get(i).getEmissions();
                  txtEmissionsEd.setText(String.valueOf(emissions));
                  int engineSize = carList.get(i).getEngineSize();
                  txtEngineSizeEd.setText(String.valueOf(engineSize));
                  int year = carList.get(i).getYear();
                  txtYearEd.setText(String.valueOf(year));
                  double value = carList.get(i).getValue();
                  txtValueEd.setText(String.valueOf(value));
                  
                  isFound = true;
                }
                if(isFound == false)
                {
                   txtOutputEdit.setText("No cars found matching this Reg No");
                }//Close if
            }
         }
            
            //txtMakeEd.setText(String.valueOf(carList.get(1)));
            //carList.set(1, make);
            /*String model = txtModel.getText();
            int emissions = Integer.parseInt(txtEmissions.getText());
            int engineSize = Integer.parseInt(txtEngineSize.getText());
            int year = Integer.parseInt(txtYear.getText());
            double value = Double.parseDouble(txtValue.getText());
         
 
            txtMakeEd.getText()carList.set(1);
            txtModelEd.setText(carList.get(i).setModel()+ "\n");
            txtEngineSizeEd.setText(carList.get(i).setEngineSize()+ "\n");
            txtEmissionsEd.setText(carList.get(i).setEmissions()+ "\n");
            txtYearEd.setText(carList.get(i).setYear()+ "\n");
            txtValueEd.setText(carList.get(i).setValue()+ "\n"); */
            
            //Clear TextFields
            /*txtRegNoEd.clear();
            txtMakeEd.clear();
            txtModelEd.clear();
            txtEmissionsEd.clear();
            txtEngineSizeEd.clear(); 
            txtYearEd.clear();   
            txtValueEd.clear(); */   

     }//Close try block
         catch(NumberFormatException ex)
         {
            txtOutput.setText("Check the values entered for the Engine Size, Emissions, Year & Value");
         }
         catch(IllegalArgumentException ex)
         {
            txtOutput.setText("Check Engine Size, Emissions, Year or Value are not negative values");
         }
   }//Close method  *****NOT WORKING****
   public void updateCar1(ActionEvent e)
   {
      if(txtRegNoEd.getText().isEmpty() || txtMakeEd.getText().isEmpty() || txtModelEd.getText().isEmpty() || txtEmissionsEd.getText().isEmpty() || txtEngineSizeEd.getText().isEmpty()  || txtYearEd.getText().isEmpty() || txtValueEd.getText().isEmpty())
         {
            txtOutput.setText("You must enter values for all 7 fields");
         } 
         else
         { 
            String regNoEd = txtRegNoEd.getText();
            boolean isFound = false;
            for(int i = 0; i < carList.size(); i++)
            {
               if(regNoEd.equalsIgnoreCase(carList.get(i).getRegNo()))
               {
                  //String reg = txtRegNoEd.getText();
                  //carList.get(i).setRegNo(reg);
                  String mk = txtMakeEd.getText();
                  carList.get(i).setMake(mk);
                  String mod = txtModelEd.getText();
                  carList.get(i).setModel(mod);
                  int size = Integer.parseInt(txtEngineSizeEd.getText());
                  carList.get(i).setEngineSize(size);
                  int em = Integer.parseInt(txtEmissionsEd.getText());
                  carList.get(i).setEmissions(em);
                  int yr = Integer.parseInt(txtYearEd.getText());
                  carList.get(i).setYear(yr);
                  double val = Double.parseDouble(txtValueEd.getText());
                  carList.get(i).setValue(val);
                  isFound = true;
                }//Close if
                   if(isFound == false)
                   {
                     txtOutput.setText("No car found matching this Reg No");
                   }
             }
         }//Close else
   
   
      //Clear TextFields
      txtRegNoEd.clear();
      txtMakeEd.clear();
      txtModelEd.clear();
      txtEmissionsEd.clear();
      txtEngineSizeEd.clear(); 
      txtYearEd.clear();   
      txtValueEd.clear();
     
    }//Close method 
   public static void main(String []args)
   {
      launch(args);
   }
}//Close Class