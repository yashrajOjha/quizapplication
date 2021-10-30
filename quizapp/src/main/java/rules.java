import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class rules extends JFrame implements ActionListener{
    JButton start,back;
    String username;
    //defining a  constructor
    rules(String username){ //the username is passed from the main quiz file
        this.username = username;
        setBounds(200, 100, 1000, 500);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#FDE0E0"));
        setLayout(null);
        //adding heading for the rules
        JLabel heading = new JLabel("Hello "+username+", welcome to The Quiz App");
        //we get the user name from the main quiz file
        heading.setFont(new Font("Century Gothic",Font.BOLD,27));
        heading.setBounds(275,25,600,40);
        add(heading);
        
        //adding Rules for the rules
        JLabel rules = new JLabel("Here are the rules:");
        rules.setFont(new Font("Century Gothic",Font.BOLD,17));
        rules.setBounds(450,70,600,20);
        add(rules);
        
        //adding rules point by point
        //here we are using html tags like br to give the points a line-break 
        JLabel rule = new JLabel("");
        rule.setFont(new Font("Century Gothic",Font.BOLD,15));
        rule.setBounds(145,50,800,400);
        rule.setText("<html>"+ 
                "1. You will not be allowed to leave the quiz app during the exam." + "<br><br>" +
                "2. You may be asked by the invigilator to sit in a room with better lighting for visuals." + "<br><br>" +
                "3. An exam is a race against time, try to be quick as you have 15 seconds per question." + "<br><br>" +
                "4. After the time limit is execeded, the page will switch to next question." + "<br><br>" +
                "5. Only one hint is allowed throughout the exam." + "<br><br>" +
            "<html>");
        add(rule);
        
        //adding atb
        JLabel atb = new JLabel("All the best !");
        atb.setFont(new Font("Century Gothic",Font.BOLD,17));
        atb.setBounds(450,375,120,20);
        add(atb);
        
        //adding button to navigate to previous page
        back = new JButton("Back");
        back.setBounds(120,375,100,40);
        back.setFont(new Font("Century Gothic",Font.BOLD,17));
        back.setBackground(Color.decode("#FF5757"));
        back.setForeground(Color.decode("#FFE865"));
        back.addActionListener(this);
        add(back);
        
        //adding a button to start the exam
        start = new JButton("Start");
        start.setBounds(770,375,100,40);
        start.setFont(new Font("Century Gothic",Font.BOLD,17));
        start.setBackground(Color.decode("#FF5757"));
        start.setForeground(Color.decode("#FFE865"));
        start.addActionListener(this);
        add(start);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            this.setVisible(false);
            new quizapp().setVisible(true);
        }
        if(ae.getSource() == start) {
            this.setVisible(false);
            new quizes(username).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new rules("");
    }
}
