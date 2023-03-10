import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class AllStudentsLis extends JFrame implements ActionListener {

    /**SQL's values**/
    private String url = "jdbc:mysql://localhost:0000/student_manager";
    private String username = "";
    private   String password = "";

    Connection sqlCon = null;
    ResultSet rs = null;
    /** END SQL's values**/

    private JPanel contentPane;

    private JLabel lblNewLabel;

    private JPanel panel;

    private JFrame frame;

    private JButton exitBtn;

    private JTable table;

    private DefaultTableModel model;

    private JScrollPane scrollPane;

    /**Class constructor**/
    AllStudentsLis(){

        /**JFrame**/
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        /**JPanel**/
        panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, -1, 692, 36);
        contentPane.add(panel);
        panel.setLayout(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        /**students JLable**/
        lblNewLabel = new JLabel("Students");
        lblNewLabel.setBounds(251, 0, 146, 38);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        /**Home JButton**/
        exitBtn = new JButton("");
        exitBtn.addActionListener(this::exitbtnActionPerformed);
        exitBtn.setBounds(0, 0, 48, 36);
        panel.add(exitBtn);
        exitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        exitBtn.setBackground(Color.GRAY);
        exitBtn.setOpaque(true);
        exitBtn.setIcon(new ImageIcon("/Users/nabil/eclipse-workspace/student_management/216242_home_icon_copy.png"));
        contentPane.add(exitBtn);


        /**JScrollPane**/
        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 100, 680, 185);
        contentPane.add(scrollPane);





        /**table  JTable **/
        table = new JTable();
        model = new DefaultTableModel();
        Object [] colum = {"matrNr","name","vorname","email","phone","strasse","hausenummer","plz","ort"};
        Object [] row = new Object[0];
        model.setColumnIdentifiers(colum);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    /**Exit button functionality**/
    public void exitbtnActionPerformed(ActionEvent e){
        frame = new JFrame("Exit");

        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Students List", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {

            dispose();
            MainPage mp = new MainPage();
            mp.show();

        }

    }

    /**showDateAction Table functionality. This function displays the content of the  table in (students)
     * and is used in the mainPage class to display the table whenever we press Add students on the main page.**/
    public void showDateAction(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlCon = DriverManager.getConnection(url, username,password);
            Statement st = sqlCon.createStatement();


            rs = st.executeQuery("select * from students ");

            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()){
                Vector columnData  = new Vector();



                String matNr = (rs.getString("matrNr"));
                String name = (rs.getString("name"));
                String vorname = (rs.getString("vorname"));
                String email =(rs.getString("email"));
                String phone =(rs.getString("phone"));
                String strasse =(rs.getString("strasse"));
                String hausnummer = (rs.getString("hausenummer"));
                String plz = (rs.getString("plz"));
                String ort = (rs.getString("ort"));


                columnData.add(matNr);columnData.add(name);
                columnData.add(vorname);columnData.add(email);columnData.add(phone);
                columnData.add(strasse);columnData.add(hausnummer);
                columnData.add(plz);columnData.add(ort);




                RecordTable.addRow(columnData);
            }



            sqlCon.close();

        }catch (Exception ex){

            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
