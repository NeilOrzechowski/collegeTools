package gpa;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GPA_UI extends JApplet {

	private JTextField[] percentages = new JTextField[12];
	private JTextField[] grades = new JTextField[12];
	// declares text inputs
	private double[] userInputPercentages = new double[12];
	private double[] userInputGrades = new double[12];
	// declares arrays to hold input
	private JTextArea feedback;
	// declares place to provide results
	private JScrollPane scroller;

	private int numOfPercentEntries = 0;
	private int numOfGradeEntries = 0;
	
	private boolean firstTimeMode = true;

	// defines counter to keep track of how many fields/percentages entered.
	public void init() {

		// "getContentPane()" is the region of the screen in which components appear.
		Container contentPane = getContentPane();

		for (int i = 0; i < percentages.length; i++) {
			percentages[i] = new JTextField(5);
			grades[i] = new JTextField(5);
		}
		feedback = new JTextArea(10, 50);
		JButton calcGrade = new JButton("calculateGrade( )");
		contentPane.add(calcGrade);
		contentPane.setLayout(new FlowLayout());
		// Some messages for the top of the Applet:

		contentPane.add(new Label("First enter the percentages on the left and the grade you have receieve for every percentage but the one(s) you want to calculate on the right"));
		addLine(Color.blue);
		contentPane.add(new Label("percentage"));
		contentPane.add(new Label(" ::: "));
		contentPane.add(new Label("grade received"));

		addLine(Color.blue);
		for (int i = 0; i < percentages.length; i++) {
			contentPane.add(percentages[i]);
			percentages[i].setText("?");
			contentPane.add(grades[i]);
			grades[i].setText("?");
			addNewLine();
		}
		// A TextArea at the bottom to write messages:
		addLine(Color.blue);
		addNewLine();
		feedback.setEditable(false);
		feedback.append("I am ready for your first action.\n");
		// Incorporate the TextArea in the ScrollPane:
		scroller = new JScrollPane(feedback, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroller);

		// Tell the Buttons what they should do when they are clicked:
		calcGrade.addActionListener(new CalculateListener());
		firstTimeMode=false;
		// TODO add a button (and listener) for instructions
	}

	class SizeListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			feedback.append("");
		}
	}

	class CalculateListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				for (int i = 0; i < percentages.length; i++) {
					if (percentages[i].getText().toCharArray().length > 0)
						if (percentages[i].getText().toCharArray()[0] == '?') {
							break;
						} else {
							numOfPercentEntries++;
							userInputPercentages[i] = Double.parseDouble(percentages[i].getText());
						}
				}
				for (int i = 0; i < numOfPercentEntries; i++) {
					if (grades[i].getText().toCharArray().length > 0)
						if (grades[i].getText().toCharArray()[0] == '?') {
							break;
						} else {
							numOfGradeEntries++;
							userInputGrades[i] = Double.parseDouble(grades[i].getText());
						}
				}
				feedback.append(calculate(userInputGrades, userInputPercentages, numOfPercentEntries, numOfGradeEntries));
			} catch (NumberFormatException e) {
				feedback.append("error reading number!!\n");
			}
			
		}

		public void reset() {

			for (int i = 0; i < percentages.length; i++) {
				userInputPercentages[i]=0;
				userInputGrades[i]=0;
			}

		}

		private String calculate(double[] grades, double[] percents, int numPercents, int numGrades) {
			double overallGrade = 0;
			for (int i = 0; i < numGrades; i++) {
				overallGrade += grades[i];
			}
			overallGrade /= (double) numGrades;
			String complete = "";
			double totalPercentage = getTotalPercentage(percents, numPercents);
			if (totalPercentage > 100) {
				// throw grade exception
			} else if (totalPercentage < 100) {
				if (calculateRemainder(70, overallGrade) < 100) {
					complete = "The minimum grade you need on the remainder of your entries in order to get:\n";
					complete += "...a C(>70) is " + calculateRemainder(70, overallGrade) + "%\n";
					if (calculateRemainder(80, overallGrade) < 100) {
						complete += "...a B(>80) is " + calculateRemainder(80, overallGrade) + "%\n";
						if (calculateRemainder(90, overallGrade) < 100) {
							complete += "..an A (>90)is " + calculateRemainder(90, overallGrade) + "%\n";
						}
					}
				} else {
					complete = "you're not the greatest student, but keep trying your hardest!\n";
				}
			} else if (totalPercentage == 100) {
				complete = "your total grade is : " + overallGrade + "%\n";
			}
			return complete;
		}

		private double getTotalPercentage(double[] percentages, int size) {
			double total = 0;
			for (int i = 0; i < size; i++) {
				total += percentages[i];
			}
			return total;
		}

		private double calculateRemainder(double grade, double received) {
			return (2 * grade) - received;
		}
	}

	private void addLine(Color c) {
		Canvas line = new Canvas();
		line.setSize(10000, 1);
		line.setBackground(c);
		getContentPane().add(line);
	}

	private void addNewLine() {
		addLine(getBackground());
	}
}