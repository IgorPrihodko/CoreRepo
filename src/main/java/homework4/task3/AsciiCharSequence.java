package homework4.task3;

public class AsciiCharSequence implements CharSequence {

    private byte[] mass;

    public AsciiCharSequence(byte[] mass) {
        this.mass = mass;
    }

    public int length() {
        return mass.length;
    }

    public char charAt(int index) {
        return (char)(mass[index] & 0xff);
    }

    public CharSequence subSequence(int start, int end) {
        int length = end - start;
        byte[] bytes = new byte[length];
        for (int i = 0, j = start; i < length; i++, j++) {
            bytes[i] = mass[j];
        }
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        return new String(mass);
    }
}
