package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class NetworkService {
	
	public static String getStringFromURL(String spec, String code) throws IOException {
	    URL url = new URL(spec);
	    URLConnection connection = url.openConnection();
	    String result = "";
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), code))) {
	      String temp = "";
	      for (;;) {
	        temp = br.readLine();
	        if (temp == null) {
	          break;
	        }
	        result += temp + System.lineSeparator();
	      }
	    }
	    return result;
	  }
public static void allLinksToFile(String spec) {
	String line = "";
	String links = "";
	
	StringBuilder buf = new StringBuilder();
	  try {
			
			URL url = new URL(spec);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			BufferedReader bf = new BufferedReader(new InputStreamReader(http.getInputStream()));
			while ((line = bf.readLine()) != null) {
				buf.append(line + "\n");

			}
			while (true) {
				if (buf.indexOf("https://") < 0) {
					break;
				} else {
					buf.delete(0, buf.indexOf("https://") - 1);
					links += buf.substring(buf.indexOf("https://"), buf.indexOf(" ")) + "\n";
					buf.delete(buf.indexOf("https://"), buf.indexOf(" "));
				}
				System.out.println(links);
			}
			saveToFile(links);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
public static void saveToFile(String a) {
	try (PrintWriter pw = new PrintWriter("Link.txt")) {
		pw.write(a + System.lineSeparator());
	} catch (IOException e) {
		// TODO: handle exception
	}
}
}



