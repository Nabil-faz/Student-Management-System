import javax.swing.*;


/**This is the primary class or method that runs the whole application.**/

public class MainFenster {

    public static void main(String[] args) {

        try{
            LoginForm lf = new LoginForm();
            lf.setVisible(true);

        }
        catch (Exception e){

            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

}
