package homework4.task4;

class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords = {":(", "=(", ":|"};
    private Label label = Label.NEGATIVE_TEXT;
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
