package opennlp.summarization;
public interface  Summarizer {
    public String summarize(String article, DocProcessor dp, int maxWords);
}
