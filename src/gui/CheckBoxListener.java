package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxListener implements ItemListener {
    public static int whatSelected;

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == ClientGui.rubleCheckBox){
            if(e.getStateChange() == 1){
                System.out.println("Selected ruble");
                ClientGui.dollarCheckBox.setSelected(false);
                ClientGui.euroCheckBox.setSelected(false);
                whatSelected = 1;

            }else{
                System.out.println("Deselected ruble");
            }

        }
        if(e.getSource() == ClientGui.dollarCheckBox){
            if(e.getStateChange() == 1){
                System.out.println("Selected dollar");
                ClientGui.rubleCheckBox.setSelected(false);
                ClientGui.euroCheckBox.setSelected(false);
                whatSelected = 2;
            }else{
                System.out.println("Deselected dollar");
            }
        }
        if(e.getSource() == ClientGui.euroCheckBox){
            if(e.getStateChange() == 1){
                System.out.println("Selected euro");
                ClientGui.dollarCheckBox.setSelected(false);
                ClientGui.rubleCheckBox.setSelected(false);
                whatSelected = 3;
            }else{
                System.out.println("Deselected euro");
            }
        }
        
    }

}
