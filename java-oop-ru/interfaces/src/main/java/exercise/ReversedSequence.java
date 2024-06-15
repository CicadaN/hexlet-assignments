package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final String original;
    private final String reversed;

    public ReversedSequence(String original) {
        this.original = original;
        this.reversed = new StringBuilder(original).reverse().toString();
    }

    @Override
    public int length() {
        return reversed.length();
    }

    @Override
    public char charAt(int index) {
        return reversed.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reversed.subSequence(start, end);
    }

    @Override
    public String toString() {
        return reversed;
    }

}
// END
