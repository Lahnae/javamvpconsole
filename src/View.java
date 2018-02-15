import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View {
	private JFrame frame;
	private Presenter presenter;
	private JScrollPane scrollPane;
	private JTextArea outputField;
	private JLabel commandLabel;
	private JTextField commandinputField;
	private JButton commandButton;
	private JButton clearButton;
	private JButton saveasButton;
	private final static String newline = "\n";

	public View() {
		createUI();
	}

	private void createUI() {

		// JFrame
		frame = new JFrame("Swing CommandLine");
		
		//ScrollPane
		scrollPane = new JScrollPane(outputField);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		// Labels
	
		commandLabel = new JLabel("Command:");
		
		// Fields
		
		outputField = new JTextArea(20, 45);
		outputField.setEditable(false);
		commandinputField = new JTextField(30);
		
		// Buttons
		
		clearButton = new JButton("Clear");
		commandButton = new JButton("Command");
		saveasButton = new JButton("Save As..");

		// ActionListenerit

		 clearButton.addActionListener((ActionEvent e) -> {
		  outputField.setText("");}
		 );

		commandButton.addActionListener((ActionEvent e) -> {
			presenter.cmdcommand(commandinputField.getText());
			commandinputField.setText("");
		});

		// TopBox Layouts
		Box topBox = Box.createHorizontalBox();
		topBox.add(outputField);
		topBox.add(Box.createHorizontalStrut(5));
		topBox.add(scrollPane,BorderLayout.CENTER);
		topBox.add(Box.createHorizontalStrut(5));

		// CommandBox Layouts
		Box commandBox = Box.createHorizontalBox();
		commandBox.add(commandLabel);
		commandBox.add(Box.createHorizontalStrut(5));
		commandBox.add(commandinputField);
		commandBox.add(Box.createHorizontalStrut(5));
		commandBox.add(commandButton);
		commandBox.add(Box.createHorizontalStrut(5));
		commandBox.add(clearButton);
		commandBox.add(Box.createHorizontalStrut(5));
		commandBox.add(saveasButton);

		((JPanel) frame.getContentPane()).setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(topBox, BorderLayout.NORTH);
		frame.add(commandBox, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	//Set presenter
	
	public void setPresenter(Presenter pres) {
		presenter = pres;
	}

	// called by the presenter to update the commandoutputField.

	public void updatecommandoutputField(String command) {
		outputField.append(command + newline);
		scrollPane.setViewportView(outputField);
	}
}