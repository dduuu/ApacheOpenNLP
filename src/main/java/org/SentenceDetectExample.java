package org;
import java.io.FileInputStream; 
import java.io.IOException;
import java.io.InputStream;  

import javax.activity.InvalidActivityException;

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;
public class SentenceDetectExample {
	 public static void main(String args[]) throws Exception{
		 
			try{
				
				new SentenceDetectExample().sentenceDetect();
				System.out.println( );
				
			}catch(Exception e){
				e.printStackTrace();
			}
}

	private void sentenceDetect() throws InvalidFormatException , IOException {
		// TODO Auto-generated method stub
		String paragraph = "Mike, 61 years old, will join the board as a nonexecutive director Nov. 29. Mr. Mike is chairman of Elsevier N.V., the Dutch publishing group. Rudolph Agnew, 55 years old and former chairman of Consolidated Gold Fields PLC, was named a director of this British industrial conglomerate.";
		InputStream is = new FileInputStream("en-sent.bin");
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);
		 
		String sentences[] = sdetector.sentDetect(paragraph);
		for (int i= 0; i< sentences.length; i++){
			System.out.println(sentences[i]);
		}
		is.close();
	}
	
	
}
