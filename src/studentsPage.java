import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;

public class studentsPage extends JFrame implements ActionListener, MouseListener {

    /**SQL's values**/
    private String url = "jdbc:mysql://localhost:3306/student_manager";
    private String username = "root";
    private   String password = "";

    Connection sqlCon = null;
    PreparedStatement  pst = null;
    ResultSet rs = null;

    int q,i,id,deletItem;
    /** END SQL's values**/

    private JPanel contentPane;
    private JTextField textField_matrNr, textField_name, textField_vorname, textField_email , textField_phone, textField_strasse, textField_hausenummer, textField_plz, textField_ort;
    private JTable table;

    private JComboBox comboBox;
    private JLabel lblNewLabel, matrNrLab, nameLab, vornameLab, emailLab, phoneLab, strasseLab, hausenummerLab, plzLab, ortLab;

    private JButton addDataBtn, exitBtn, restbtn, deletbtn,printbtn,updatebtn;

    private JScrollPane scrollPane;

    private DefaultTableModel model;

    private JFrame frame;

    private JPanel panel,panel_1;



    /**Class constructor**/
    studentsPage(){

        /**JFrame**/
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 535);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        /**JPanel**/
        panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, -1, 692, 36);
        contentPane.add(panel);
        panel.setLayout(null);


        /**Student List JLable**/
        lblNewLabel = new JLabel("Students List");
        lblNewLabel.setBounds(251, 0, 146, 38);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        /**MatrNr JLable**/
        matrNrLab = new JLabel("MatrNr");
        matrNrLab.setBounds(91, 62, 78, 16);
        contentPane.add(matrNrLab);

        /**Matr JTextField**/
        textField_matrNr = new JTextField();
        textField_matrNr.setBounds(88, 78, 130, 26);
        contentPane.add(textField_matrNr);
        textField_matrNr.setColumns(10);

        /**Name JLable**/
        nameLab = new JLabel("Name");
        nameLab.setBounds(273, 62, 78, 16);
        contentPane.add(nameLab);

        /**name JTextField**/
        textField_name = new JTextField();
        textField_name.setBounds(270, 78, 130, 26);
        contentPane.add(textField_name);
        textField_name.setColumns(10);

        /**Vorname JLabel**/
        vornameLab = new JLabel("Vorname");
        vornameLab.setBounds(471, 62, 61, 16);
        contentPane.add(vornameLab);

        /**Vorname JTextField**/
        textField_vorname = new JTextField();
        textField_vorname.setBounds(468, 78, 130, 26);
        contentPane.add(textField_vorname);
        textField_vorname.setColumns(10);

        /**Email JLable**/
        emailLab = new JLabel("Email");
        emailLab.setBounds(471, 170, 61, 16);
        contentPane.add(emailLab);

        /**Email JTextField**/
        textField_email = new JTextField();
        textField_email.setBounds(468, 184, 130, 26);
        contentPane.add(textField_email);
        textField_email.setColumns(10);

        /**Phone JLable**/
        phoneLab = new JLabel("Phone");
        phoneLab.setBounds(273, 170, 63, 16);
        contentPane.add(phoneLab);

        /**Phone JTextField**/
        textField_phone = new JTextField();
        textField_phone.setBounds(270, 184, 130, 26);
        contentPane.add(textField_phone);
        textField_phone.setColumns(10);

        /**strasse JLable**/
        strasseLab = new JLabel("Strasse");
        strasseLab.setBounds(91, 116, 55, 16);
        contentPane.add(strasseLab);

        /**strasse JTextField**/
        textField_strasse = new JTextField();
        textField_strasse.setBounds(88, 132, 130, 26);
        contentPane.add(textField_strasse);
        textField_strasse.setColumns(10);

        /**hausenummer JLable**/
        hausenummerLab = new JLabel("Hausnum");
        hausenummerLab.setBounds(273, 116, 61, 16);
        contentPane.add(hausenummerLab);

        /**hausenummer JTextField**/
        textField_hausenummer = new JTextField();
        textField_hausenummer.setBounds(270, 132, 130, 26);
        contentPane.add(textField_hausenummer);
        textField_hausenummer.setColumns(10);

        /**plz JLable**/
        plzLab = new JLabel("PLZ");
        plzLab.setBounds(471, 116, 61, 16);
        contentPane.add(plzLab);

        /**plz JTextField**/
        textField_plz = new JTextField();
        textField_plz.setBounds(468, 132, 130, 26);
        contentPane.add(textField_plz);
        textField_plz.setColumns(10);

        /**ort JLable**/
        ortLab = new JLabel("Ort");
        ortLab.setBounds(91, 170, 61, 16);
        contentPane.add(ortLab);

        /**ort JTextField**/
        textField_ort = new JTextField();
        textField_ort.setBounds(88, 184, 130, 26);
        contentPane.add(textField_ort);
        textField_ort.setColumns(10);

        /**ADD data JButton**/
        addDataBtn = new JButton("ADD DATA");
        addDataBtn.addActionListener(this);
        addDataBtn.setBounds(200, 233, 101, 29);
        contentPane.add(addDataBtn);

        /**home JButton**/
        exitBtn = new JButton("");
        exitBtn.addActionListener(this::exitbtnActionPerformed);
        exitBtn.setBounds(0, 0, 48, 36);
        panel.add(exitBtn);
        exitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        exitBtn.setBackground(Color.GRAY);
        exitBtn.setOpaque(true);
        exitBtn.setIcon(new ImageIcon("/Users/nabil/eclipse-workspace/student_management/216242_home_icon_copy.png"));
        contentPane.add(exitBtn); // from the first dis

        /**Rest JButton**/
        restbtn = new JButton("Rest");
        restbtn.addActionListener(this::restbtnActionPerformed);
        restbtn.setBounds(381, 263, 101, 29);
        contentPane.add(restbtn);

        /**Delete JButton**/
        deletbtn = new JButton("Delete");
        deletbtn.addActionListener(this::deletbtnActionPerformed);
        deletbtn.setBounds(200, 263, 101, 29);
        contentPane.add(deletbtn);

        /**Print JButton**/
        printbtn = new JButton("Print");
        printbtn.addActionListener(this::printbtnActionPerformed);
        printbtn.setBounds(629, 33, 69, 29);
        contentPane.add(printbtn);

        /**Updata JButton**/
        updatebtn = new JButton("Update");
        updatebtn.addActionListener(this::updatebtnActionPerformed);
        updatebtn.setBounds(381, 233, 101, 29);
        contentPane.add(updatebtn);



        /**JScrollPane**/
        scrollPane = new JScrollPane();
        scrollPane.addMouseListener(this);
        scrollPane.setBounds(6, 300, 680, 185);
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

    /**This method is invoked immediately when the user clicks the listened-to component.**/
    public void mouseClicked(MouseEvent e) {

                DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
                int selectedRows = table.getSelectedRow();

                textField_matrNr.setText(RecordTable.getValueAt(selectedRows,1).toString());
                textField_name.setText(RecordTable.getValueAt(selectedRows,2).toString());
                textField_vorname.setText(RecordTable.getValueAt(selectedRows,3).toString());
                textField_email.setText(RecordTable.getValueAt(selectedRows,4).toString());
                textField_phone.setText(RecordTable.getValueAt(selectedRows,5).toString());
                textField_strasse.setText(RecordTable.getValueAt(selectedRows,6).toString());
                textField_hausenummer.setText(RecordTable.getValueAt(selectedRows,7).toString());
                textField_plz.setText(RecordTable.getValueAt(selectedRows,8).toString());
                textField_ort.setText(RecordTable.getValueAt(selectedRows,9).toString());

            }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    /**ADD Date button functionality**/
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlCon = DriverManager.getConnection(url, username, password);
            pst = sqlCon.prepareStatement("insert into students(matrNr,name,vorname,email,phone,strasse,hausenummer,plz,ort) value (?,?,?,?,?,?,?,?,?) ");

            pst.setString(1,textField_matrNr.getText());
            pst.setString(2,textField_name.getText());
            pst.setString(3,textField_vorname.getText());
            pst.setString(4,textField_email.getText());
            pst.setString(5,textField_phone.getText());
            pst.setString(6,textField_strasse.getText());
            pst.setString(7,textField_hausenummer.getText());
            pst.setString(8,textField_plz.getText());
            pst.setString(9,textField_ort.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Records Added");
            upDateDB();

        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(studentsPage.class.getName()).log(Level.SEVERE,null,ex);
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(studentsPage.class.getName()).log(Level.SEVERE,null,ex);
        }


    }

    /**Exit button functionality**/
    public void exitbtnActionPerformed(ActionEvent e){
        frame = new JFrame("Exit");

        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","MYSQL connecter", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
//            System.exit(0);
            dispose();
            MainPage mp = new MainPage();
            mp.show();

        }

    }

    /**Print button functionality**/
    public void printbtnActionPerformed(ActionEvent e){
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("Page {0,number, integer}");

        try {
            table.print(JTable.PrintMode.NORMAL,header,footer);
        }
        catch (PrinterException ex){
            System.err.format("No Printer found", ex.getMessage());
        }


    }

    /**Delete button functionality**/
    public void deletbtnActionPerformed(ActionEvent e){
        DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
        int selectedRows = table.getSelectedRow();

        try {
            id = Integer.parseInt(RecordTable.getValueAt(selectedRows, 0).toString());

            deletItem = JOptionPane.showConfirmDialog(null,"confirm if you want to delete item", "Warning", JOptionPane.YES_NO_OPTION);
            if (deletItem == JOptionPane.YES_OPTION){
                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlCon = DriverManager.getConnection(url, username,password);
                pst = sqlCon.prepareStatement("delete from students where id =?");

                pst.setInt(1,id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Record updated");
                upDateDB();

                textField_matrNr.setText("");
                textField_name.setText("");
                textField_vorname.setText("");
                textField_email.setText("");
                textField_phone.setText("");
                textField_strasse.setText("");
                textField_hausenummer.setText("");
                textField_ort.setText("");
                textField_plz.setText("");

            }
        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(studentsPage.class.getName()).log(Level.SEVERE,null,ex);
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(studentsPage.class.getName()).log(Level.SEVERE,null,ex);
        }



    }

    /**Rest button functionality**/
    public void restbtnActionPerformed(ActionEvent e){

        textField_matrNr.setText("");
        textField_name.setText("");
        textField_vorname.setText("");
        textField_email.setText("");
        textField_phone.setText("");
        textField_strasse.setText("");
        textField_hausenummer.setText("");
        textField_ort.setText("");
        textField_plz.setText("");

    }

    /**update button functionality**/
    public void updatebtnActionPerformed(ActionEvent e){

        DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
        int selectedRows = table.getSelectedRow();

        try {
            id = Integer.parseInt(RecordTable.getValueAt(selectedRows, 0).toString());
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlCon = DriverManager.getConnection(url, username, password);
            pst = sqlCon.prepareStatement("update students set matrNr =?, name =?, vorname =?,email =?, phone =?, strasse =?, hausenummer =?, plz =? ,ort =?  where id = ?");


            //insert into students(matrNr,name,vorname,email,phone,strasse,hausenummer,plz,ort) value (?,?,?,?,?,?,?,?,?)

            pst.setString(1,textField_matrNr.getText());
            pst.setString(2,textField_name.getText());
            pst.setString(3,textField_vorname.getText());
            pst.setString(4,textField_email.getText());
            pst.setString(5,textField_phone.getText());
            pst.setString(6,textField_strasse.getText());
            pst.setString(7,textField_hausenummer.getText());
            pst.setString(8,textField_plz.getText());
            pst.setString(9,textField_ort.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Records Updated");
            upDateDB();

        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(studentsPage.class.getName()).log(Level.SEVERE,null,ex);
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(studentsPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void upDateDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlCon = DriverManager.getConnection(url, username,password);
            pst = sqlCon.prepareStatement("select * from students ");
            rs = pst.executeQuery();
            ResultSetMetaData stDate = rs.getMetaData();

            q = stDate.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);

                    while (rs.next()){
                        Vector columnData  = new Vector();

                        for (i = 1; i <= q; i++){
                            columnData.add(rs.getString("matrNr"));
                            columnData.add(rs.getString("name"));
                            columnData.add(rs.getString("vorname"));
                            columnData.add(rs.getString("email"));
                            columnData.add(rs.getString("phone"));
                            columnData.add(rs.getString("strasse"));
                            columnData.add(rs.getString("hausenummer"));
                            columnData.add(rs.getString("plz"));
                            columnData.add(rs.getString("ort"));



                        }
                        RecordTable.addRow(columnData);
                    }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex);
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
}
