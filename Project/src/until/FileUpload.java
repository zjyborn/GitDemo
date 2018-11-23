/**
 * 
 */
package until;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author oracleOAEC
 *
 */
public class FileUpload {
  public  static void upload(String path,String filename){
	
	  try {
		  File file=new File(filename);
		InputStream is=new FileInputStream(file);
		OutputStream os=new FileOutputStream(path+"\\"+file.getName());
		byte buffer[]=new byte[1024];
		int row=0;
		try {
			while((row=is.read(buffer))>0){
			os.write(buffer,0, row);	
			}
			os.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
