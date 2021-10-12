package nms.questions;

import javax.swing.JButton;

public class QuestionNumber4 {

	public static void main(String[] args) {
		JButton button = new JButton() ;
		String name = button.getClass().getName() ;
		System.out.println( name.split("\\.")[name.split("\\.").length - 1] ) ;
		name = button.getClass().getSuperclass().getName();
		System.out.println( name.split("\\.")[name.split("\\.").length - 1] ) ;
	}

}
