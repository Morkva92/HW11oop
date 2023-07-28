package sample;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			String spec = "https://dou.ua/";
		    String htmlText = "";
		    
		    try {
		      htmlText = NetworkService.getStringFromURL(spec, "UTF-8");
		      
		      
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    NetworkService.allLinksToFile(spec);
		    
	}}	
	    

	    	
		

		



