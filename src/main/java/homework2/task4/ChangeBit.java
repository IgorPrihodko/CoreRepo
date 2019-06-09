package homework2.task4;

public class ChangeBit {

    public int flipBit(int value, int bitIndex) {
        return value ^ (1 << bitIndex - 1);
    }
}
