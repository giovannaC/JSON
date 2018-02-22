// Giovanna Cazelato Pires
// giovannacpires@outlook.com
// DATA: 22/02/2018

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class main {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

        try {         
            URL oracle = new URL("https://jsonplaceholder.typicode.com/users");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine = "";
            while (in.ready()) {
            	inputLine = inputLine + in.readLine();
            }
            System.out.println(inputLine);
            inputLine = inputLine + in.readLine();
            while (in.ready()) { // tive que por esse while aqui dnv porque estava parando no meio. O por que eu nao sei.
            	inputLine = inputLine + in.readLine();
            }
            System.out.println(inputLine);
            JSONArray a = (JSONArray) parser.parse(inputLine);
              
                // Loop through each item
                for (int i=0; i< a.size(); i++) {
                    JSONObject o = (JSONObject) a.get(i);

                    Long id = (Long) o.get("id");
                    System.out.println("ID : " + id);
                    
                    String website = (String) o.get("website");
                    System.out.println("website : " + website);

                    System.out.println("\n");
                }
                
                for (int i=0; i< a.size(); i++) {
                    JSONObject o = (JSONObject) a.get(i);
                    
                    String username = (String) o.get("username");
                    
                    if(username.equals("Samantha")) {
                        System.out.println("username: " + username);
                        
                    	String email = (String) o.get("email");
                    	System.out.println("email : "+ email);
                    	break;
                    }
                }
//                int count = 0;
                
// Não sei porque esta parte está dando errado, pelo o que entendi de JSON
// esse geo seria outro objeto? 
                
/*                for (int i=0; i< a.size(); i++) {
                    JSONObject o = (JSONObject) a.get(i);
                    
                    JSONObject geo = (JSONObject) o.get("geo");
                    
                    String lat = (String) geo.get("lat");
                    System.out.println("lat : "+ lat);
                    
                    int sul = Integer.parseInt(lat);
                    if(sul<0) {
                        count++;
                    	break;
                    }
                }
                System.out.println("Usuarios do sul :" + count);
                */
            
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }   

	}

}
