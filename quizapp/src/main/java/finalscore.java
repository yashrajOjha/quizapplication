import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class finalscore extends JFrame implements ActionListener{
    JButton sa, exit;
    finalscore(String username, int points, int right){
        setBounds(200, 100, 1000, 500);
        getContentPane().setBackground(Color.decode("#FDE0E0"));
        ImageIcon scoreimage = new ImageIcon("C:\\Users\\YASHRAJ\\Documents\\DSU Study Material\\5th Sem\\OODJ\\Mini Project\\quizapp\\src\\main\\java\\images\\scoreimage.png");
        JLabel imagelayout = new JLabel(scoreimage);
        setLayout(null);
        imagelayout.setBounds(0,0,500,500);
        add(imagelayout);
        
        JLabel scoredisplay = new JLabel("<html>"+ "Hey "+username+" !"+"<br>"+"Here's your score for the quiz!"+"</html>", SwingConstants.CENTER);
        scoredisplay.setFont(new Font("Century Gothic",Font.BOLD,20));
        scoredisplay.setBounds(560,100,400,60);
        add(scoredisplay);
        
        //displaying scores
        JLabel score = new JLabel("Points Scored: "+ points);
        score.setFont(new Font("Century Gothic",Font.BOLD,20));
        score.setBounds(680,225,400,40);
        add(score);
        
        JLabel correct = new JLabel("Correct Answers: "+ right+ " / 10");
        correct.setFont(new Font("Century Gothic",Font.BOLD,20));
        correct.setBounds(650,275,400,40);
        add(correct);
        
        //start again
        sa = new JButton("Go Again");
        sa.setBounds(600,350,125,40);
        sa.setFont(new Font("Century Gothic",Font.BOLD,15));
        sa.setBackground(Color.decode("#FF5757"));
        sa.setForeground(Color.decode("#FFE865"));
        sa.addActionListener(this);//on button click make an event
        //what happens after the button click will be defined in the action performed function
        add(sa);
        //adding buttons for exiting
        exit = new JButton("Exit");
        exit.setBounds(800,350,125,40);
        exit.setFont(new Font("Century Gothic",Font.BOLD,15));
        exit.setBackground(Color.decode("#FF5757"));
        exit.setForeground(Color.decode("#FFE865"));
        exit.addActionListener(this);
        //this is used to reference to this "exit" option
        add(exit);
    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == exit)
        {
            System.exit(0);
        }
        else {
            this.setVisible(false);
            new quizapp().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new finalscore("",0,0).setVisible(true);
    }
}
