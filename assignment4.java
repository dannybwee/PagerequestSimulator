/**
 *
 * @author Daniel Bui
 * 
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class assignment4{

	public static void main(String[] args) throws IOException{

		int pgs = 0;
		int frm = 0;
		int rqsts = 0;
		ArrayList<Integer> pageNums = new ArrayList<Integer>();
		try{
			Scanner file = new Scanner(new File("input.txt")); 
			pgs = file.nextInt();//pages
			frm = file.nextInt();//frames
			rqsts = file.nextInt();//page requests
			
			while(file.hasNext()){
				String pageReqs = file.next();
				int pgRqs = Integer.parseInt(pageReqs);
				pageNums.add(pgRqs);
			}
		
		file.close();
		}
		catch(NumberFormatException e){
			System.err.println(e.getMessage());
		}
		
		//display the size if it the set is not empty
		if(!pageNums.isEmpty()){
		   int size = pageNums.size();
		}

		//converting the arraylist to an array
		Integer pageReqs[] = new Integer[pageNums.size()];
			pageReqs = pageNums.toArray(pageReqs);
			
			int p = pageReqs[0];
			int requests = pageReqs[1];
			int pgrqs = pageReqs[2];
			
		   FIFO fifo = new FIFO(pageReqs, pgrqs, rqsts);
		   fifo.fifotest();
		   LRU lru = new LRU(pageReqs, pgrqs, rqsts);
		   lru.lrutest();
		   
		   //My attempt at OPT
		  //OPT opt = new OPT(pageReqs, pgrqs, rqsts);
		  /// opt.opttest();
	}

}