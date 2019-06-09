package homework4.task4;

class SpamAnalyzer extends KeywordAnalyzer {

    private String[] keywords;
    private Label label = Label.SPAM;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    public String[] getKeywords() {
        return keywords;
    }
    @Override
    protected Label getLabel() {
        return label;
    }

    @Override
    public Label processText(String text) {
        return super.processText(text);
    }
}
