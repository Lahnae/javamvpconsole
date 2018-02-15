import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Presenter {

	private View view;
	private Model model;

	public Presenter(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	   public void saveAs() {
		      FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
		      final JFileChooser saveAsFileChooser = new JFileChooser();
		      saveAsFileChooser.setApproveButtonText("Save");
		      saveAsFileChooser.setFileFilter(extensionFilter);
		      int actionDialog = JFileChooser.SAVE_DIALOG;
		      if (actionDialog != JFileChooser.APPROVE_OPTION) {
		         return;
		      }

		      // !! File fileName = new File(SaveAs.getSelectedFile() + ".txt");
		      File file = saveAsFileChooser.getSelectedFile();
		      if (!file.getName().endsWith(".txt")) {
		         file = new File(file.getAbsolutePath() + ".txt");
		      }

		      BufferedWriter outFile = null;
		      try {
		         outFile = new BufferedWriter(new FileWriter(file));

		         //textArea.write(outFile);

		      } catch (IOException ex) {
		         ex.printStackTrace();
		      } finally {
		         if (outFile != null) {
		            try {
		               outFile.close();
		            } catch (IOException e) {}
		         }
		      }
		   }
	
	/*
	 * public void login(String pass) { String result = "Incorrect password";
	 * 
	 * if (model.getPassword().equals(pass)) { result = "Correct password"; }
	 * view.updateStatusLabel(result); }
	 */
	public void cmdcommand(String command) {
		model.setCmdcommand(command);
		if (model.getCmdcommand() != null)
			try {
				Process process = Runtime.getRuntime().exec("cmd /c " + command);
				//System.out.println("the output stream is " + process.getOutputStream());
				view.updatecommandoutputField(command);
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String s;
				while ((s = reader.readLine()) != null) {
					view.updatecommandoutputField(s);
				}
				reader.close();
				//System.out.println("Reader Closed");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}