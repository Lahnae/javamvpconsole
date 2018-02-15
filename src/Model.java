public class Model {
    //private String password;
    private String cmdcommand;
    
    public Model() {
        //password = "password"; //just set a default password.
        cmdcommand = null;
    }
    /*
    public void setPassword(String pass) {
        password = pass;
    }
    
    public String getPassword() {
        return password;
    }
    */
    public void setCmdcommand(String command){
    	cmdcommand = command;
    }
    public String getCmdcommand(){
    	return cmdcommand;
    }
}
