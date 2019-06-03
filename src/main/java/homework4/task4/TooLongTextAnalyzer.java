package homework4.task4;

class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    public Label processText(String text) {
        if (text.length() <= maxLength) {
            return Label.OK;
        } else {
            return Label.TOO_LONG;
        }
    }
}
