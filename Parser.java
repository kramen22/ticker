// This is a test comment
package javastuff;

import java.net.*;
import java.io.*;
import org.apache.commons.io.*;

public class Parser{

    private String completeURL, returndata;

    private URL url;

    public Parser(String str) throws IOException{
	completeURL = str;
	url = new URL(str);
	returndata = IOUtils.toString(url);
    }

    public void printstuff(){
	System.out.print(returndata);

	return;
    }
}
