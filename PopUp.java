import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PopUp extends JFrame{

    //path
    public PopUp(){
        super();
        //ImageIcon image= new ImageIcon("green fade.png");
        //this.setIconImage(image.getImage());
        //this.setResizable(false);
        this.setSize(500,300);
        this.setTitle("shortest path");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        int arr[]= new int[2];

        JTextField num1=new JTextField(1);
        String text1=num1.getText();
        text1.split(",");
        this.add(num1);




        this.setVisible(true);
    }


    public static void main(String[] args) {
    PopUp p=new PopUp();
    }
}
