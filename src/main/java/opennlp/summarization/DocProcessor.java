package opennlp.summarization;
import java.util.List;

import opennlp.tools.stemmer.Stemmer;

public interface  DocProcessor {
    /* Extract sentences from a string representing an article.*/
    public List<Sentence> getSentencesFromStr(String text) ;
    /* Utility method to parse out words from a string.*/
    public String[] getWords(String sent);
    /* Provide a stemmer to stem words*/
    public Stemmer getStemmer();
}

