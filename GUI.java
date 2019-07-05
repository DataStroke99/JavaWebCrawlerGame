package webcrawler;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Screen;




public class GUI extends Application{
    
   
    
    // Initializing variables
    
    Stage window;
    Scene scene;
    HBox hbox1, hbox2, hc3;
    VBox vbox1;
    GridPane gp;
    BorderPane bp;
    
    //UI variables
    Button btn1, btn2;
    TextField topic1, topic2;
    Label l1,l2,l3;
    String ret, ans;
    
    String wiki = "https://en.wikipedia.org/wiki/", Origin_uri="",Target_uri="" ;
    
    
    Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
   
  
    @Override
    public void start(Stage primaryStage)throws IOException{
        
        //Assign proper value to the variable
        window = primaryStage;

        //Creating the title for the window
        window.setTitle("6 Links of Seperation");
        
         window.setOnCloseRequest(e->{
            e.consume();
            closePrograme();
            
        });
    
        
        
        //UI components
        l1 = new Label("Enter Topic 1:  ");
        l2 = new Label("Enter Topic 2:  ");
        l3 = new Label();
        
  
        topic1 = new TextField();
        //topic1.setMaxWidth(300);
        topic2 = new TextField();
       
        btn1 = new Button("GO");
        btn1.setOnAction(e ->l3.setText( "The links of seperation between topics are :===> "+getUrl(topic1.getText(),topic2.getText()) )  );
        
        
        
        //Creating a layout
        hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.setMargin(topic1,new Insets(20,20,20,20));

        hbox1.setMargin(l1,new Insets(20,20,20,20));
        hbox1.setAlignment(Pos.TOP_CENTER);
        hbox1.getChildren().addAll(l1,topic1);
        
        hbox2 = new HBox();
        hbox2.setSpacing(10);
        hbox2.setMargin(topic2,new Insets(20,20,20,20));
       
        hbox2.setMargin(l2,new Insets(20,20,20,20));
        hbox2.setAlignment(Pos.TOP_CENTER);
        hbox2.getChildren().addAll(l2,topic2,btn1);
        
        hc3 = new HBox();
        hc3.setAlignment(Pos.CENTER);
        hc3.getChildren().add(l3);
        
        vbox1 = new VBox();
        vbox1.getChildren().addAll(hbox1,hbox2,hc3);

        
        bp = new BorderPane();
        bp.setTop(vbox1);
     
        
        
        
        
        
        
      
   
        //Creating scene with a HBox layout, height and width
        scene = new Scene(bp); 
        
        //Adding Scene to Stage
        window.setScene(scene);
        
        //Window half the size of the screen
        window.setWidth(bounds.getWidth()/2);
	window.setHeight(bounds.getHeight()/2);
        
        
        
        //Display Stage
        window.show();
        
  
    }
    
    
    
    private void closePrograme(){
        boolean answer = ConfirmationBox.display("Exit Confirm", "Do you want to exit? ");
        if(answer) 
            window.close();
        
    }
    
    private String getUrl(String t1,String t2){
        String start = check(t1);
        String destination = check(t2);
        
        String star_url = wiki+start;
        String dest_url = wiki+destination;
        
        
        System.err.println(star_url);
        System.err.println(dest_url);
        
        ret = Crawl2.BFS(star_url,dest_url);
        
        
        
        
        
        return ret;
    
    
    }
    
    private String check(String t1 ){
        
        
        
        String str = t1.toLowerCase();
      
        String s ,uri="";
       
        String[] arr = str.split(" ");
        
      
        String[] word ; 
        int num=0, count=0;

        
        for(String aa :arr){ num ++;  }
 
        
        word = new String[num];
      
        
        
        for(String aa :arr){         
            s = aa.substring(0, 1).toUpperCase() + aa.substring(1);
            word[count] = s;     
            count++;   
        }
     
        
        count=1;
        
        
        for(int i = 0; i< num; i++){
         
            if(count == num){
              uri = uri+word[i];
              break;
        }
        uri = uri+word[i] + "_";
        count++;

        }
        
       return uri;
  
    
    }
 
    
    public static void main(String[] args){
        launch(args);
        
        
    }
    
    
   
        
    }
