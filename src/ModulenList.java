import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;

public class ModulenList extends JFrame {

    /**SQL's values**/
    private String url = "jdbc:mysql://localhost:3306/student_manager";
    private String username = "root";
    private   String password = "";

    Connection sqlCon = null;
    ResultSet rs = null;
    /** END SQL's values**/

    private JPanel contentPane, panel_1,panel_1_1,panel_1_2;
    private JTable table;
    private JButton homeBtn, sem1,sem2,sem3,sem4,sem5,sem6;
    private DefaultTableModel model;
    private JLabel moduleLab,lblSws,lblCrp;


    /**Class constructor**/
    ModulenList(){

        /**JFrame**/
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 988, 401);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        /**JPanel **/
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 988, 36);
        panel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panel);
        panel.setLayout(null);

        /**Home Button**/
        homeBtn = new JButton("");
        homeBtn.addActionListener(this::homeBtnActionPerformed);
        homeBtn.setIcon(new ImageIcon("/Users/nabil/eclipse-workspace/student_management/icon/216242_home_icon_copy.png"));
        homeBtn.setBackground(Color.GRAY);
        homeBtn.setOpaque(true);
        homeBtn.setBounds(0, 0, 48, 36);
        panel.add(homeBtn);
        homeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));

        /**sem1 Button**/
        sem1 = new JButton("Semester 1");
        sem1.addActionListener(this::sem1BtnActionPerformed);
        sem1.setOpaque(true);
        sem1.setBackground(Color.LIGHT_GRAY);
        sem1.setBounds(73, 0, 121, 36);
        panel.add(sem1);

        /**sem2 Button**/
        sem2 = new JButton("Semester 2");
        sem2.addActionListener(this::sem2BtnActionPerformed);
        sem2.setOpaque(true);
        sem2.setBackground(Color.LIGHT_GRAY);
        sem2.setBounds(225, 0, 121, 36);
        panel.add(sem2);

        /**sem3 Button**/
        sem3 = new JButton("Semester 3\n");
        sem3.addActionListener(this::sem3BtnActionPerformed);
        sem3.setOpaque(true);
        sem3.setBackground(Color.LIGHT_GRAY);
        sem3.setBounds(369, 0, 121, 36);
        panel.add(sem3);

        /**sem4 Button**/
        sem4 = new JButton("Semester 4");
        sem4.addActionListener(this::sem4BtnActionPerformed);
        sem4.setOpaque(true);
        sem4.setBackground(Color.LIGHT_GRAY);
        sem4.setBounds(519, 0, 121, 36);
        panel.add(sem4);

        /**sem5 Button**/
        sem5 = new JButton("Semester 5");
        sem5.addActionListener(this::sem5BtnActionPerformed);
        sem5.setOpaque(true);
        sem5.setBackground(Color.LIGHT_GRAY);
        sem5.setBounds(675, 0, 121, 36);
        panel.add(sem5);

        /**sem6 Button**/
        sem6 = new JButton("Semester 6\n");
        sem6.addActionListener(this::sem6BtnActionPerformed);
        sem6.setOpaque(true);
        sem6.setBackground(Color.LIGHT_GRAY);
        sem6.setBounds(833, 0, 121, 36);
        panel.add(sem6);

        /**table  JTable **/
        table = new JTable(){

            /**This function is used to modify the colors of the rows.**/
            public Component prepareRenderer(TableCellRenderer renderer,
                                             int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);
                Color color1 = new Color(220,220,220);
                Color color2 = Color.WHITE;
                if(!c.getBackground().equals(getSelectionBackground())) {
                    Color coleur = (row % 2 == 0 ? color1 : color2);
                    c.setBackground(coleur);
                    coleur = null;
                }
                return c;
            }


        };

        table.setBounds(38, 108, 900, 160);
        contentPane.add(table);


        /**Model and Table declaration **/
        model = new DefaultTableModel();
        Object [] colum = {"MODUL","SWS","CrP"};
        Object [] row = new Object[0];
        model.setColumnIdentifiers(colum);
        table.setModel(model);

        /**JPanel panel_1**/
        panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(38, 86, 299, 21);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        /**Modul JLabe**/
        moduleLab = new JLabel("MODUL");
        moduleLab.setForeground(Color.BLACK);
        moduleLab.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        moduleLab.setBounds(6, 0, 73, 21);
        panel_1.add(moduleLab);

        /**JPanel panel_1_1**/
        panel_1_1 = new JPanel();
        panel_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_1_1.setBackground(Color.LIGHT_GRAY);
        panel_1_1.setBounds(338, 86, 299, 21);
        contentPane.add(panel_1_1);
        panel_1_1.setLayout(null);

        /**Sws JLabe**/
        lblSws = new JLabel("SWS");
        lblSws.setForeground(Color.BLACK);
        lblSws.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblSws.setBounds(6, 0, 73, 21);
        panel_1_1.add(lblSws);

        /**JPanel panel_1_2**/
        panel_1_2 = new JPanel();
        panel_1_2.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_1_2.setBackground(Color.LIGHT_GRAY);
        panel_1_2.setBounds(638, 86, 299, 21);
        contentPane.add(panel_1_2);
        panel_1_2.setLayout(null);

        /**crp JLabe**/
        lblCrp = new JLabel("CrP");
        lblCrp.setForeground(Color.BLACK);
        lblCrp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblCrp.setBounds(6, 0, 73, 21);
        panel_1_2.add(lblCrp);

    }

    /**home button functionality**/
    public void homeBtnActionPerformed(ActionEvent e) {

        if (e.getSource() == homeBtn){
            MainPage mp = new MainPage();
            mp.show();
            dispose();
        }
    }

    /**sem1 button functionality**/
    public void sem1BtnActionPerformed(ActionEvent e) {

        if (e.getSource() == sem1){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlCon = DriverManager.getConnection(url, username,password);
                Statement st = sqlCon.createStatement();


                rs = st.executeQuery("select * from sem1 ");

                DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
                RecordTable.setRowCount(0);

                while (rs.next()){
                    Vector columnData  = new Vector();


                    String modul = (rs.getString("MODUL"));
                    String sws = (rs.getString("SWS"));
                    String crp = (rs.getString("Crp"));



                    columnData.add(modul);
                    columnData.add(sws);
                    columnData.add(crp);




                    RecordTable.addRow(columnData);
                }



                sqlCon.close();

            }catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

    }

    /**sem2 button functionality**/
    public void sem2BtnActionPerformed(ActionEvent e) {

        if (e.getSource() == sem2){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlCon = DriverManager.getConnection(url, username,password);
                Statement st = sqlCon.createStatement();


                rs = st.executeQuery("select * from sem2 ");

                DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
                RecordTable.setRowCount(0);

                while (rs.next()){
                    Vector columnData  = new Vector();


                    String modul = (rs.getString("MODUL"));
                    String sws = (rs.getString("SWS"));
                    String crp = (rs.getString("Crp"));



                    columnData.add(modul);
                    columnData.add(sws);
                    columnData.add(crp);




                    RecordTable.addRow(columnData);
                }



                sqlCon.close();

            }catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

    }

    /**sem3 button functionality**/
    public void sem3BtnActionPerformed(ActionEvent e) {
        if (e.getSource() == sem3){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlCon = DriverManager.getConnection(url, username,password);
                Statement st = sqlCon.createStatement();


                rs = st.executeQuery("select * from sem3 ");

                DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
                RecordTable.setRowCount(0);

                while (rs.next()){
                    Vector columnData  = new Vector();


                    String modul = (rs.getString("MODUL"));
                    String sws = (rs.getString("SWS"));
                    String crp = (rs.getString("Crp"));



                    columnData.add(modul);
                    columnData.add(sws);
                    columnData.add(crp);




                    RecordTable.addRow(columnData);
                }



                sqlCon.close();

            }catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

    }

    /**sem4 button functionality**/
    public void sem4BtnActionPerformed(ActionEvent e) {
        if (e.getSource() == sem4){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlCon = DriverManager.getConnection(url, username,password);
                Statement st = sqlCon.createStatement();


                rs = st.executeQuery("select * from sem4 ");

                DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
                RecordTable.setRowCount(0);

                while (rs.next()){
                    Vector columnData  = new Vector();


                    String modul = (rs.getString("MODUL"));
                    String sws = (rs.getString("SWS"));
                    String crp = (rs.getString("Crp"));



                    columnData.add(modul);
                    columnData.add(sws);
                    columnData.add(crp);




                    RecordTable.addRow(columnData);
                }



                sqlCon.close();

            }catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

    }

    /**sem5 button functionality**/
    public void sem5BtnActionPerformed(ActionEvent e) {

        if (e.getSource() == sem5){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlCon = DriverManager.getConnection(url, username,password);
                Statement st = sqlCon.createStatement();


                rs = st.executeQuery("select * from sem5 ");

                DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
                RecordTable.setRowCount(0);

                while (rs.next()){
                    Vector columnData  = new Vector();


                    String modul = (rs.getString("MODUL"));
                    String sws = (rs.getString("SWS"));
                    String crp = (rs.getString("Crp"));



                    columnData.add(modul);
                    columnData.add(sws);
                    columnData.add(crp);




                    RecordTable.addRow(columnData);
                }



                sqlCon.close();

            }catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

    }

    /**sem6 button functionality**/
    public void sem6BtnActionPerformed(ActionEvent e) {

        if (e.getSource() == sem6){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlCon = DriverManager.getConnection(url, username,password);
                Statement st = sqlCon.createStatement();


                rs = st.executeQuery("select * from sem6 ");

                DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
                RecordTable.setRowCount(0);

                while (rs.next()){
                    Vector columnData  = new Vector();


                    String modul = (rs.getString("MODUL"));
                    String sws = (rs.getString("SWS"));
                    String crp = (rs.getString("Crp"));



                    columnData.add(modul);
                    columnData.add(sws);
                    columnData.add(crp);




                    RecordTable.addRow(columnData);
                }



                sqlCon.close();

            }catch (Exception ex){

                System.out.println(ex.getMessage());

            }
        }

    }

    /**showsem1 Table functionality. This function displays the content of the table (sem1)
     * and is used in the mainPage class to display the table whenever we press modul on the main page.**/
    public void showSem1() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlCon = DriverManager.getConnection(url, username,password);
            Statement st = sqlCon.createStatement();


            rs = st.executeQuery("select * from sem1 ");

            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()){
                Vector columnData  = new Vector();


                String modul = (rs.getString("MODUL"));
                String sws = (rs.getString("SWS"));
                String crp = (rs.getString("Crp"));



                columnData.add(modul);
                columnData.add(sws);
                columnData.add(crp);




                RecordTable.addRow(columnData);
            }



            sqlCon.close();

        }catch (Exception ex){

            System.out.println(ex.getMessage());

        }
    }
    }

