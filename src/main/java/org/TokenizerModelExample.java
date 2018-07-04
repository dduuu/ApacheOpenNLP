package org;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenizerModelExample {
	public static void main(String[] args) {
		InputStream modelIn = null;
		try {
			modelIn = new FileInputStream("en-token.bin");
			TokenizerModel model = new TokenizerModel(modelIn);
			TokenizerME tokenizer = new TokenizerME(model);
			String tokens[] = tokenizer.tokenize("I don't know that, but it doesn't matter.");
			double tokenProbs[] = tokenizer.getTokenProbabilities();
			
			System.out.println("Token\t: Probability\n-------------------------------");
			for(int i=0;i<tokens.length;i++){
				System.out.println(tokens[i]+"\t: "+tokenProbs[i]);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				}
				catch (IOException e) {
				}
			}
		}
	}
	//http://opennlp.sourceforge.net/models-1.5/
	//https://www.tutorialkart.com/opennlp/apache-opennlp-tutorial/
}
