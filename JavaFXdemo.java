 package Projekt3;
 import javafx.application.Application;
import javafx.geometry.Insets;
 import javafx.geometry.Pos;
 import javafx.stage.Stage;
 import javafx.scene.layout.GridPane;
 import javafx.scene.Scene;
  import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
  import javafx.scene.layout.HBox;
 import javafx.stage.StageStyle;
 
 public class Projekt3 extends Application
 {        
     @Override
     public void start(Stage stage) 
     { TextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
        Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
        t1=new TextField();
        t2=new TextField();
        t3=new TextField();
        t4=new TextField();
        t5=new TextField();
        t6=new TextField();
        t7=new TextField();
        t8=new TextField();
        t9=new TextField();
        l1=new Label("");
        l2=new Label("");
        l3=new Label("");
        l4=new Label("");
        l5=new Label("");
        l6=new Label("");
        l7=new Label("");
        l8=new Label("");
        l9=new Label("");
         
         stage.initStyle(StageStyle.UNDECORATED); 
        
         
         Button zamknij=new Button("Zamknij");    
         zamknij.setOnAction(zamknij1->
         {            
             stage.close();
         });        
         
         Button minimum=new Button("Zwiń do paska");
         minimum.setOnAction(minimum1->
         {            
             stage.setIconified(true);
         });    
         
         Button wprowadz=new Button("Wprowadź dane");
         Button wyswietl=new Button("Wyświetl dane");
         Label lb1=new Label("Podaj elementy tablicy: ");
         Label liczba=new Label("");
         Label minmax=new Label("");
         GridPane okno = new GridPane();
         
         okno.setHgap(5);
         okno.setVgap(2);
         
        
         Scene scena = new Scene(okno, 800, 600); 
         stage.setScene(scena); 
         stage.show(); 
         
         HBox przyciski = new HBox();
         przyciski.setMinWidth(800);  
         przyciski.setAlignment(Pos.TOP_RIGHT);
         przyciski.setSpacing(10);        
         przyciski.getChildren().addAll(minimum,zamknij);   
         okno.add(przyciski, 0, 0, 3, 1); 
         okno.add(wprowadz,0,0,3,1);
         HBox row1 = new HBox();
            HBox row2 = new HBox();
            HBox row3 = new HBox();
            HBox row4 = new HBox();
            HBox row5 = new HBox();
            HBox row6 = new HBox();
         
         wprowadz.setOnAction(wprowadz1->
         {
         if(okno.getChildren().contains(row1))
         {
          t1.setText("");
          t2.setText("");
          t3.setText("");
          t4.setText("");
          t5.setText("");
          t6.setText("");
          t7.setText("");
          t8.setText("");
          t9.setText("");
         }
         else
         {
         lb1.setAlignment(Pos.TOP_RIGHT);
         lb1.setPadding(new Insets(10));
                  
         okno.add(lb1,0,1,3,1);  
         okno.add(liczba,2,3,3,4);
         okno.add(minmax,2,6,3,4);
         row1.setMaxWidth(200);
         row1.setPadding(new Insets(10));
         
         row1.setSpacing(10);
         row1.getChildren().addAll(t1,t2,t3);
         okno.add(row1, 0, 3 );
         
         
         row2.setMaxWidth(200);
         row2.setPadding(new Insets(10));
         
         row2.setSpacing(10);
         row2.getChildren().addAll(t4,t5,t6);
         okno.add(row2, 0, 4);
         
          
         row3.setMaxWidth(200);
         row3.setPadding(new Insets(10));
         
         row3.setSpacing(10);
         row3.getChildren().addAll(t7,t8,t9);
         okno.add(row3, 0, 5);
         okno.add(wyswietl,0,6,3,1);
         }  
         }
         );
         row4.setMaxWidth(200);
         row4.setPadding(new Insets(10));
        
         row4.setSpacing(40);
        
         row4.getChildren().addAll(l1,l2,l3);
         okno.add(row4, 2, 3,3,4);
         
         row5.setMaxWidth(200);
         
         row5.setPadding(new Insets(10));
         
         
         row5.setSpacing(40);
         row5.getChildren().addAll(l4,l5,l6);
         okno.add(row5, 2, 4,3,4);
         
         row6.setMaxWidth(200);
         row6.setPadding(new Insets(10));
         
         row6.setSpacing(40);
         row6.getChildren().addAll(l7,l8,l9);
         okno.add(row6, 2, 5,3,4);
         
        wyswietl.setOnAction(wyswietl1->
        {
            String tab[] = new String[9];
            tab[0]=t1.getText();
            tab[1]=t2.getText();
            tab[2]=t3.getText();
            tab[3]=t4.getText();
            tab[4]=t5.getText();
            tab[5]=t6.getText();
            tab[6]=t7.getText();
            tab[7]=t8.getText();
            tab[8]=t9.getText();
            
         for(int i=0;i<tab.length;i++)
         {
             if(! isInteger(tab[i]))
            {  
            l1.setText("");
            l2.setText("");
            l3.setText("");
            l4.setText("");
            l5.setText("");
            l6.setText("");
            l7.setText("");
            l8.setText("");
            l9.setText("");
            liczba.setText("Jeden lub kilka\n elementów\n nie jest liczbą");
            minmax.setText("");
           
             break;                   
             }
             else
             {
             int tab2[] =new int[9];
              for(int j=0;j<tab2.length;j++)
              { if(isInteger(tab[j]))
                  tab2[j]=Integer.parseInt(tab[j]);
              else break;
              }
            l1.setText(t1.getText());
            l2.setText(t2.getText());
            l3.setText(t3.getText());
            l4.setText(t4.getText());
            l5.setText(t5.getText());
            l6.setText(t6.getText());
            l7.setText(t7.getText());
            l8.setText(t8.getText());
            l9.setText(t9.getText());
            liczba.setText("");
            int max = getMaxValue(tab2);
            int min = getMinValue(tab2);
            minmax.setText("Minimum: " + min +"\nMaksimum: " + max);
            
             }
         }
             
             
            
            
        }        );
                 

     }
     public static Integer TryParseInt(String someText) {
   try {
      return Integer.parseInt(someText);
   } catch (NumberFormatException ex) {
      return null;
   }
}
     public static int getMaxValue(int[] numbers){
  int maxValue = numbers[0];
  for(int i=1;i < numbers.length;i++){
    if(numbers[i] > maxValue){
	  maxValue = numbers[i];
	}
  }
  return maxValue;
}
public static int getMinValue(int[] numbers){
  int minValue = numbers[0];
  for(int i=1;i<numbers.length;i++){
    if(numbers[i] < minValue){
	  minValue = numbers[i];
	}
  }
  return minValue;
}
public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    
    return true;
}     //--------------------------------------
     public static void main(String[] args) 
     {
         launch(args);
     }
 }
