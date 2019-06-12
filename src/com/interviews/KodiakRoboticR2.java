package com.interviews;

public class KodiakRoboticR2 {

//	Given a string, find the first unique character.
//
//	Example string:
//	“HELLO BERTHA”


	class Solution{
	  public char findUnique(String input){
	    
	    int j;
	    char ch;
	    for(int i = 0; i<input.length(); i++){ //O(n^2) 
	      ch = input.charAt(i);
	      for(j = 0; j<input.length(); j++){
	        if(i==j)
	          continue;
	        else if(input.charAt(j) == ch);
	          break;
	      }
	      if(j==input.length()){
	        return ch;
	      }        
	    }
	    return '0';
	  }
	}

	//frequency map
	// O(n)



//	Let’s write a low level driver for a SD card!
//
//	We have:
//	An SD card can only read and write full blocks at 8192 byte boundaries ( a “page”).
//	Every block needs to be erased with `EraseBlock(size_t page_nr)` before being written.
//	A block can be read with `ReadBlock(size_t page_nr, ByteArray target_buffer);`
//	A block can be written with `WriteBlock(size_t page_nr, ByteArray source_buffer);`
//
//	class SDCard {
//	  public int GetPageSize() {
//	    return 8192;
//	  }
//	  void EraseBlock(int page_nr);
//	  void ReadBlock(int page_nr, ByteArray target_buffer);
//	  void WriteBlock(int page_nr, ByteArray source_buffer);
//	};
//
//	Task:
//	Write the function `WriteBytes(size_t offset, ByteArray source_data);`
//
//
//	********|********|********|***...
//	****OOOO|OOOO****|********|***...
//
//	  offset = 5
//	  size = 8
	  
	  
	class DataWriter {
	  
	  SDCard target;
	  public DataWriter(SDCard target) {
	    this.target = target;
	  }
	  
	  public void Write(int offset, Byte[] data) {
	    int dataSize = data.length;
	    int pageSize = target.getPageSize();
	    
	    //102937
	    ///8192
	    //
	    
	    int pageNr = offset / pageSize;
	    int startPt = offset % pageSize;
	    
	    // read that page
	    // new data to be written = []
	    // erase 
	    // write
	    
	    int remainingData = dataSize;
	    int count
	    while(remainingData > 0){
	      Byte[] readData = target.ReadBlock(pageNr, target);
	      int count = 0;
	      int loopSize = Math.min(pageSize, startPt + remainingData);
	      for(int i = startPt; i<loopSize; i++){
	        readData[i] = data[dataSize - remainingData + i];
	        count++;
	      }
	      target.EraseBlock(pageNr);
	      target.WriteBlock(pageNR, readData);
	      pageNr++;
	      remainingData -= count;
	      startPt = 0;
	    }
	  }
	}



}
