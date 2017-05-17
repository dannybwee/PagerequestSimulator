/**
 *
 * @author Daniel Bui
 * 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FIFO {


	private Integer[] pages;
	private int frame;
	private int requests;

	public FIFO(Integer[] pages, int frame, int requests){
		this.pages = pages;
		this.frame = frame;
		this.requests = requests;
	}
	
	public void fifotest() throws IOException {
		int [] pageReqs = new int[25];
		int i;
		int j; 
		int available; 
		int currentFrame = 0; 
		int count = 0;
		int oldFrame = pages[0];
		int pageFaults = 0;
		
		BufferedWriter write = new BufferedWriter(new FileWriter("FIFOResultsDbui.txt"));
		PrintWriter out = new PrintWriter(write);
		
		System.out.printf("\nFIFO");
		
		int numOfFrames = frame;
		
		for(i = 0;i < numOfFrames; i++){
			pageReqs[i]= -1;
		}
		
		System.out.printf("\n");
		//checks for any duplicate values.
		for(i=0; i<requests; i++){
			available = 0;
			for(j = 0; j < numOfFrames; j++)
				if(pageReqs[j] == pages[i]){
					System.out.printf("Page " + pages[i] + " already in Frame " + j + "\n");
					out.printf("Page "+ pages[i] + " already in Frame " + j + "\n");
					available = 1;
					break;
			}
			if(available == 0){
				if(count == numOfFrames){
					System.out.printf("Page " + oldFrame + " unloaded from Frame " + currentFrame + ", ");
					out.printf("Page" + oldFrame + " unloaded from Frame " + currentFrame +  ", ");
					oldFrame=pageReqs[(currentFrame+1)%numOfFrames];
					count--;
				}
				pageReqs[currentFrame]=pages[i];
				System.out.printf("Page " + pages[i] + " loaded into Frame " + currentFrame + "\n");
				out.printf("Page " + pages[i] + " loaded into Frame " + currentFrame + "\n");
				currentFrame = (currentFrame + 1) % numOfFrames;
				count++;
				pageFaults++;
			}
		}
	//close 1 and write 1
	out.close();
	write.close();
	System.out.println("Page faults: " + pageFaults);
	}
}
