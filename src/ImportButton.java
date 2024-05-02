import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportButton extends JButton implements ActionListener {
    VictimPicker vp;
    QuestionPicker qp;
    ImportButton(VictimPicker vp, QuestionPicker qp){
        this.vp = vp;
        this.qp = qp;
        this.setBounds(0,0,200,50);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("Import");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            Actions.importVictims(vp);
            Actions.importQuestions(qp);
            //action to import stuff to file(s)
        }
    }
}
