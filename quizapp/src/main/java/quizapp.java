import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//colors #FDE0E0
/*The prefix used for a package of Java standard extensions. 
For example, javax. servlet contains the classes and interfaces for running servlets*/
public class quizapp extends JFrame implements ActionListener{
    
    //declaring Buttons, and Text Field globally so every function can access it
    JButton rules,exit;
    JTextField tf;
    quizapp(){
        //making a constructor
        setBounds(200, 100, 1000, 500); //creates a frame
        //take 4 arguments, first 2 arguments are of distances from sides (left,up)
        //last 2 arguments are of size of the frames created
        setVisible(true);
        //by default set visible is false
        getContentPane().setBackground(Color.decode("#FDE0E0"));
        //making a image icon class to display the opening image on the screen
        ImageIcon openimage = new ImageIcon("C:\\Users\\YASHRAJ\\Documents\\DSU Study Material\\5th Sem\\OODJ\\Mini Project\\quizapp\\src\\main\\java\\images\\openingimage.png");
        //creating a JLabel object to add content(content can be image/text) inside the frame
        JLabel imagelayout = new JLabel(openimage);
        //to place the image we use layouts but to use ownlayout we can use a function below
        setLayout(null);
        imagelayout.setBounds(0,0,500,500); //the setting of image is according the frame, and so we use 0,0
        //after positioning the image we add it to the frame using add
        add(imagelayout);
        //adding a heading to the frame
        JLabel heading = new JLabel("The Quiz App");
        heading.setFont(new Font("Century Gothic",Font.BOLD,35));
        heading.setBounds(650,50,400,40);
        add(heading);
        //adding a name label
        JLabel namelabel = new JLabel("Enter Your Name");
        namelabel.setFont(new Font("Century Gothic",Font.BOLD,20));
        namelabel.setBounds(600,150,300,20);
        add(namelabel);
        //adding a text field
        tf= new JTextField();
        tf.setBounds(600,180,300,25);
        tf.setFont(new Font("Century Gothic",Font.BOLD,17));
        add(tf);
        //adding buttons for starting game and viewing rules
        rules = new JButton("Rules");
        rules.setBounds(600,350,100,40);
        rules.setFont(new Font("Century Gothic",Font.BOLD,15));
        rules.setBackground(Color.decode("#FF5757"));
        rules.setForeground(Color.decode("#FFE865"));
        rules.addActionListener(this);//on button click make an event
        //what happens after the button click will be defined in the action performed function
        add(rules);
        //adding buttons for exiting
        exit = new JButton("Exit");
        exit.setBounds(800,350,100,40);
        exit.setFont(new Font("Century Gothic",Font.BOLD,15));
        exit.setBackground(Color.decode("#FF5757"));
        exit.setForeground(Color.decode("#FFE865"));
        exit.addActionListener(this);
        //this is used to reference to this "exit" option
        add(exit);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        //we must first check what kind of event is being performed, that can be done using if loop
        //the event variable is ae, that has properties of the event triggered
        if(ae.getSource()== rules)
        {
            String username = tf.getText();
            //get text function wll return a string value
            //value from the getText function will be stored in variable username and sent to the rules window
            //after rules window opens, we must hide the main window, for that we make the set visible value false
            this.setVisible(false);
            new rules(username);
        }
        else
        {
         System.exit(0);    
        }
    }
    public static void main(String[] args)
    {
        new quizapp();
        
    }
    
}
