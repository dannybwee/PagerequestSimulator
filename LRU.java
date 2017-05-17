/**
 *
 * @author Daniel Bui
 * 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LRU {

	private Integer[] page;
	private int frm;
	private int requests;

	public LRU (Integer[] page, int frm, int requests){
		this.page = page;
		this.frm = frm;
		this.requests = requests;
	}
	
	public void lrutest() throws IOException {
		int []frame = new int[10];
		int []used = new int[10];
		int index = 0;
		int currentFrm = 0;
		int i,j,k,m,temp;
		int available = 0;
		int count = 0;

		BufferedWriter write2 = new BufferedWriter(new FileWriter("LRUResultsDbui.txt"));
		PrintWriter out2 = new PrintWriter(write2);
		System.out.println("\nLRU");

		int numOfFrames = frm;
		int pageFaults = 0;
		for(i=0; i<requests; i++){
			available = 0;
			for(j = 0; j < numOfFrames; j++){
				if(frame[j] == page[i]){
					System.out.printf("Page " + page[i] + " already in Frame " + (j+1)%numOfFrames + "\n");
					out2.printf("Page " + page[i] + " already in Frame " + (j+1)%numOfFrames + "\n");					
					available = 1;
					break;
				}
			}
			
			if(available == 0){
				for(j = 0; j < numOfFrames; j++)
					used[j] = 0;
				try{
					for(j = 0,temp=i-1; j < numOfFrames-1; j++,temp--){
						for(k = 0; k < numOfFrames; k++){
							if(frame[k] == page[temp])
								used[k] = 1;
						}
					}
				}catch(ArrayIndexOutOfBoundsException e){
				}
				for(j = 0,m = numOfFrames-1;j < numOfFrames;j++,m--)
					if(used[j] == 0){
						index = j;
						currentFrm = m;
					}
				if(i == requests){
					count = 0;
				}
				if(count == numOfFrames){
					System.out.printf("Page " + frame[index] + " unloaded from Frame " + currentFrm + ", ");
					out2.printf("Page " + frame[index] + " unloaded from Frame " + currentFrm + ", ");
					count--;
				}
				frame[index] = page[i];
				count++;
				System.out.printf("Page " + frame[index] +  " loaded into Frame " + currentFrm + "\n");
				out2.printf("Page " + frame[index] + " loaded into Frame " + currentFrm + "\n");
				pageFaults++;
			}
		}
		//close 2 and write 2
		out2.close();
		write2.close();
		System.out.println("Page faults: " + pageFaults);
	}
}
