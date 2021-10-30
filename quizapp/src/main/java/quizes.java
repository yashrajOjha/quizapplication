import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quizes extends JFrame implements ActionListener{
    
    JButton next, submit, ff,hint;
    public static int count = 0; // count variable to save the question number
    public static int timer = 15; //timer for 15 seconds
    public static int answer_given = 0;
    public static int score = 0;
    public static int hintdisplayed=0;
    public static int correct=0;
    JLabel quesno, ques, dishint;
    String q[][] = new String[10][5];
    String ans[][] = new String[10][1];
    String qa[][] = new String[10][2];
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    
    String username;
    quizes(String username){
        this.username = username;
        setBounds(200, 50, 1000, 700);//increasing the size of the quiz window
        getContentPane().setBackground(Color.decode("#FDE0E0"));
        ImageIcon banner = new ImageIcon("C:\\Users\\YASHRAJ\\Documents\\DSU Study Material\\5th Sem\\OODJ\\Mini Project\\quizapp\\src\\main\\java\\images\\appbanner.png");
        JLabel bannerlayout = new JLabel(banner);
        setLayout(null);
        bannerlayout.setBounds(0,10,1000,150);
        add(bannerlayout);
        
        quesno= new JLabel("");
        quesno.setBounds(125, 200, 70,25);
        quesno.setFont(new Font("Century Gothic",Font.BOLD,19));
        add(quesno);
        
        //label for displaying the question
        ques= new JLabel("");
        ques.setBounds(150, 200, 750,25);
        ques.setFont(new Font("Century Gothic",Font.BOLD,19));
        add(ques);
        
        q[0][0] = "Which is used to find and fix bugs in the Java programs?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";
        
        qa[0][1] = "JDB";
        qa[1][1] = "int";
        qa[2][1] = "java.util package";
        qa[3][1] = "Marker Interface";
        qa[4][1] = "Heap memory";
        qa[5][1] = "Remote interface";
        qa[6][1] = "import";
        qa[7][1] = "Java Archive";
        qa[8][1] = "java.lang.StringBuilder";
        qa[9][1] = "Bytecode is executed by JVM";
        
        
        opt1 = new JRadioButton("");
        opt1.setBounds(125, 250, 700,20);
        opt1.setFont(new Font("Century Gothic",Font.BOLD,17));
        opt1.setBackground(Color.decode("#FDE0E0"));
        add(opt1);
        
        opt2 = new JRadioButton("");
        opt2.setBounds(125, 280, 700,20);
        opt2.setFont(new Font("Century Gothic",Font.BOLD,17));
        opt2.setBackground(Color.decode("#FDE0E0"));
        add(opt2);
        
        opt3 = new JRadioButton("");
        opt3.setBounds(125, 310, 700,20);
        opt3.setFont(new Font("Century Gothic",Font.BOLD,17));
        opt3.setBackground(Color.decode("#FDE0E0"));
        add(opt3);
        
        opt4 = new JRadioButton("");
        opt4.setBounds(125, 340, 700,20);
        opt4.setFont(new Font("Century Gothic",Font.BOLD,17));
        opt4.setBackground(Color.decode("#FDE0E0"));
        add(opt4);
        
        //We can click on all the options available to click just on one option, we create a class called button group
        //this is used to group the buttons together
        //if one option is already selected, then we try to click another option then previously clicked option is unselected
        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        
        dishint= new JLabel("Hint: click on the button!");
        dishint.setBounds(125, 425, 700,25);
        dishint.setFont(new Font("Century Gothic",Font.BOLD,19));
        add(dishint);
        
        next = new JButton("Next");
        next.setBounds(115, 500, 175, 40);
        next.setFont(new Font("Century Gothic",Font.BOLD,17));
        next.setBackground(Color.decode("#FF5757"));
        next.setForeground(Color.decode("#FFE865"));
//        next.setIcon(new ImageIcon("C:\\Users\\YASHRAJ\\Documents\\DSU Study Material\\5th Sem\\OODJ\\Mini Project\\quizapp\\src\\main\\java\\nexticon.png"));
        next.addActionListener(this);
        add(next);
        
        hint = new JButton("Hint");
        hint.setBounds(315, 500, 175, 40);
        hint.setFont(new Font("Century Gothic",Font.BOLD,17));
        hint.setBackground(Color.decode("#FF5757"));
        hint.setForeground(Color.decode("#FFE865"));
        hint.addActionListener(this);
        add(hint);
        
        ff = new JButton("50-50");
        ff.setBounds(515, 500, 175, 40);
        ff.setFont(new Font("Century Gothic",Font.BOLD,17));
        ff.setBackground(Color.decode("#FF5757"));
        ff.setForeground(Color.decode("#FFE865"));
        ff.addActionListener(this);
        add(ff);
        
        submit = new JButton("Submit");
        submit.setEnabled(false); //enable it only after penultimate question
        submit.setBounds(715, 500, 175, 40);
        submit.setFont(new Font("Century Gothic",Font.BOLD,17));
        submit.setBackground(Color.decode("#FF5757"));
        submit.setForeground(Color.decode("#FFE865"));
        submit.addActionListener(this);
        add(submit);
        
        start(0);//start the question count from zero
        
    }
    
    public void actionPerformed(ActionEvent ae){
        //overriding the function actionPerformed inside the interface Action Listener
        //inside Action Listener only actionPerformed is abstract method which must be overriden
        //after clicking on the button the trigger is catched by ActionEvent object ae
        if(ae.getSource() == next){
            //after we click on next the whole window must be repainted and the next question must be visible
            //this functionality can be obtained from java applets
            repaint(); //repaint internally calls paint function
            //while repainting we need to check if the answer has been selected or not
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            //we are enabling these options because of the fifty fifty life line function, because if
            // we dont do it then the options will be remained disabled regardless of the question
            
            answer_given = 1; //the user has given the answer
            if(options.getSelection() == null){
                ans[count][0] = "";
            }else {
                ans[count][0] = options.getSelection().getActionCommand();
            }
            
            //accessing the submit button through a series of next button clicks
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++; //moving to the next count, and therefore the next question
            start(count);
        }else if(ae.getSource() == submit){
            //checking if the user has answered or not
            answer_given = 1;
            if(options.getSelection() == null){
                ans[count][0] = "";
            }else {
                ans[count][0] = options.getSelection().getActionCommand();
            }
            //then we calculate the score
            for(int i =0 ; i < ans.length ; i++){
                if(ans[i][0].equals(qa[i][1])){
                    score+=10;
                    correct++;
                }else{
                    score+=0;
                }
            }
            this.setVisible(false);
            new finalscore(username, score, correct).setVisible(true);
        }else if(ae.getSource() == ff){
            //we are assuming that this is the pattern of answers question 3, 5, 7, 9, 10 have option 2 and 3 as wrong options and so we disable it
            if(count == 2 || count == 4 || count == 6 || count == 8 || count == 9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            ff.setEnabled(false);
        }
        else if(ae.getSource() == hint){
            //we are displaying hint only once, after displaying hint it disables the option
            /*we are using a hint displayed check, as we need to display that hint only for one question,
            as soon as the hint is displayed, the next questions must show that hint is used up.*/
            dishint.setText("Hint: "+qa[count][1]);
            hint.setEnabled(false);
            hintdisplayed =1;
        }
    }
    
    public void paint(Graphics g){
        super.paint(g);
        String tl = "Time Left :"+timer+ " seconds";
        g.setColor(Color.decode("#FF5757"));
        g.setFont(new Font("Century Gothic",Font.BOLD,17));
        
        if(timer > 0) { //time should start decrementing negatively
           g.drawString(tl, 700, 475);
        }else {
            g.drawString("Time's Up!", 700, 475);
        }
        
        timer--; // 14
        
        try{
            Thread.sleep(1000); //reduce after every 1 second
            repaint();
        }catch(Exception e){
            e.printStackTrace(); //printing the exception
        }
        
        if(answer_given == 1){
            answer_given = 0; //reseting the answer given
            timer = 15; //if the answer has given the user, the time will be reset to 15
        }
        else if(timer < 0){ //this case is when the time is over
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            //similar to next question case, we need to enable these options again,
            //or else these will be remained disabled if timer moves to next question
            
            if(count == 8){
                //on the penultimate question, next should be disabled and submit should be enabled
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
            //when we are on submit question and times up, the test must be automatically submitted
            //apart from that there are two possibilites, we have answered the question, we have not answered the question
                if(options.getSelection() == null){
                    ans[count][0] = ""; //the user has not answered anything and so the answer recorded is null
                }else {
                    ans[count][0] = options.getSelection().getActionCommand();
                    //we now need to store his/her answers in an array to calculate the score;
                    //getting value of the option selected
                }
                
                for(int i =0 ; i < ans.length ; i++){
                    if(ans[i][0].equals(qa[i][1])){
                        score+=10;
                        correct++;
                    }else{
                        score+=0;
                    }
                }
                this.setVisible(false);
                new finalscore(username, score,correct).setVisible(true);
            }
             //count isn't 09 or 08, it must automatically move forward
            else{
                if(options.getSelection() == null){
                    ans[count][0] = "";
                }else {
                    ans[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }
    
    public void start(int count){
        //used to set initial values, calling it from constructor
        /*button's action command is it's label. But in 
        some cases, labels are too long and is not appropriate to use
        it as an action command. In such situation you would want to 
        define custom short action command for a button.*/
        quesno.setText("" + (count + 1) + ". "); //converting count (integer value to a string
        ques.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
        
        if(hintdisplayed==1){
            dishint.setText("Hint used up! Check for 50-50");
        }
        else{
            dishint.setText("Hint: Click on the button!");
        }
    }
    
    public static void main(String[] args){
        new quizes("").setVisible(true);
    }
}