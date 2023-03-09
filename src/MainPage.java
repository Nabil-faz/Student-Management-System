import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame implements ActionListener {


      private JPanel contentPane;


      private JButton tableBtn,studentsBtn,stuLisBtn,exitBtn;

      private JFrame frame;




    /**Class constructor**/
    MainPage(){
        /**JFrame**/
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 498, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        /**Modul Button**/
        tableBtn = new JButton("Modul");
        tableBtn.addActionListener(this);
        tableBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        tableBtn.setBounds(89, 39, 156, 117);
        contentPane.add(tableBtn);

        /**Add Students Button**/
        studentsBtn = new JButton("Add Students");
        studentsBtn.addActionListener(this);
        studentsBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        studentsBtn.setBounds(246, 39, 156, 117);
        contentPane.add(studentsBtn);

        /**Studetns List Button**/
        stuLisBtn = new JButton("Students List");
        stuLisBtn.addActionListener(this);
        stuLisBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        stuLisBtn.setBounds(89, 154, 156, 117);
        contentPane.add(stuLisBtn);

        /**Exit Button**/
        exitBtn = new JButton("Exit\n");
        exitBtn.addActionListener(this);
        exitBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        exitBtn.setBounds(246, 154, 156, 117);
        contentPane.add(exitBtn);


    }

    /**Button functionality for table, students, students List and Exit**/
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tableBtn){

            ModulenList ml = new ModulenList();
            ml.show();
            ml.showSem1();
            dispose();

        }else if (e.getSource() == studentsBtn){
            studentsPage sp = new studentsPage();
            sp.setVisible(true);
            sp.showDateAction();
            dispose();
        } else if (e.getSource() == stuLisBtn) {
            AllStudentsLis allSL = new AllStudentsLis();
            allSL.setVisible(true);
            allSL.showDateAction();
            dispose();

        } else if (e.getSource() == exitBtn) {
            frame = new JFrame("Exit");

            if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Student Management Software", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                System.exit(0);

            }


        }


    }
}
