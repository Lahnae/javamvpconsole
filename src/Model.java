public class Model {
    private String inputField;
    private String cmdcommand;
    
    public Model() {
        inputField = null;
        cmdcommand = null;
    }
    
    public void setInputField(String input) {
        inputField = input;
    }
    
    public String getInputField() {
        return inputField;
    }
    
    public void setCmdcommand(String command){
    	cmdcommand = command;
    }
    public String getCmdcommand(){
    	return cmdcommand;
    }
}
