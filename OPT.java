/**
 *
 * @author Daniel Bui
 * 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class OPT {
	private Integer[] pages;
	private int frm;
	private int requests;
	private int[] pR;
	private int[][] frames;

	public OPT (Integer[] pages, int frm, int requests){
		this.pages = pages;
		this.frm = frm;
		frames = new int [frm][2];
		this.requests = requests;
	}
	
	
	public int getFuture(){
		return frm;
	
	}
	
	public void opttest() throws IOException{
		int []frame = new int[10];
		int []used = new int[10];
		int index = 0;
		int currentFrm = 0;
		int i,j,k,m,temp;
		int available = 0;
		int count = 0;
		int pageFaults = 0;
		int num;
		
		BufferedWriter write3 = new BufferedWriter(new FileWriter("OPTResults.txt"));
		PrintWriter out3 = new PrintWriter(write3);
		System.out.println("\nOPT");
		
		int numOfFrames = frm;
		for(i=0; i<requests; i++){
			available = 0;
			num = pages[i];
		//checks for any duplicate values.
		for(j = 0; j<numOfFrames; j++){
			if(frame[j] == pages[i]){
				
				System.out.printf("Page " + pages[i] + " already in Frame " + (j+1)%numOfFrames + "\n");
				out3.printf("Page " + pages[i] + " already in Frame " + (j+1)%numOfFrames + "\n");					
				available = 1;
				break;
			}
		
	
	}
		}
	}
}

