package Lesson03;

import javax.swing.JOptionPane;

public class Spring {
	
public static void main(String[] args) {
double a;

for(;;){
	try{
		a=Double.valueOf(JOptionPane.showInputDialog("Input doublenumber"));
		break;
		} 
	catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Error number format");
		}
}
System.out.println(a);
}
}