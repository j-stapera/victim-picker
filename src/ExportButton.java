import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportButton extends JButton implements ActionListener {
    VictimPicker victimPicker;
    ExportButton(VictimPicker vp){
        victimPicker = vp;
        this.setBounds(1035,0,200,50);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Export");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            Actions.exportExportables(victimPicker);
            //action to export all necessary info to file(s)
        }
    }
}
