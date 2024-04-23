import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportButton extends JButton implements ActionListener {

    ImportButton(){
        this.setBounds(0,0,200,50);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Import");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            //action to import stuff to file(s)
        }
    }
}
