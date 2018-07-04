package org;
import java.io.FileInputStream; 
import java.io.IOException;
import java.io.InputStream;  

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span;  
public class NameEntityReco {
	public static void main(String args[]) throws Exception{
		try{
			System.out.println("----------------Finding entities belonging to category : person name ------------");
			new NameEntityReco().findName();
			System.out.println( );
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			System.out.println("----------------Finding entities belonging to category : location name ------------");
			new NameEntityReco().findLocation();
			System.out.println( );
			
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			System.out.println("----------------Finding entities belonging to category : Date ------------");
			new NameEntityReco().findDate();
			System.out.println( );
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	     
	} 

	private void findDate() throws IOException {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream("en-ner-date.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
		NameFinderME nameFinder = new NameFinderME(model);
		
		String[] sentence = new String[]{
				"All",
				"the",
				"letters",
				"were",
				"dated",
				"between",
				"1900",
				"and",
				"January",
				"of",
				"1901",
				"."
		};
		Span nameSpans[] = nameFinder.find(sentence);
		//namespans contains all the possible entities detected
		for(Span s :nameSpans){
			System.out.print(s.toString());
			System.out.print(" : ");
			
			for(int index = s.getStart(); index <s.getEnd();index++){
				System.out.print(sentence[index]+" ");
			}
			System.out.println();
		}
	}

	private void findLocation() throws IOException {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream("en-ner-location.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
		NameFinderME nameFinder = new NameFinderME(model);
		
		String[] sentence = new String[]{
				"James",
				"Bond",
				"is",
				"from",
				"America",
				"."
		};
		Span nameSpans[] = nameFinder.find(sentence);
		//namespans contains all the possible entities detected
		for(Span s :nameSpans){
			System.out.print(s.toString());
			System.out.print(" : ");
			
			for(int index = s.getStart(); index <s.getEnd();index++){
				System.out.print(sentence[index]+" ");
			}
			System.out.println();
		}
		
	}

	private void findName() throws IOException {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream("en-ner-person.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
		NameFinderME nameFinder = new NameFinderME(model);
		
		String[] sentence = new String[]{
				"James",
				"Bond",
				"is",
				"standing",
				"next",
				"to",
				"bus",
				"stop",
				"and",
				"waiting",
				"for",
				"Mike",
				"."
		};
		Span nameSpans[] = nameFinder.find(sentence);
		//namespans contains all the possible entities detected
		for(Span s :nameSpans){
			System.out.print(s.toString());
			System.out.print(" : ");
			
			for(int index = s.getStart(); index <s.getEnd();index++){
				System.out.print(sentence[index]+" ");
			}
			System.out.println();
		}
	} 
	 
    

}
