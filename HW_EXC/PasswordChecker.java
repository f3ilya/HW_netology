public class PasswordChecker {
    private int minLength = -1;
    private int maxRepeats = -1;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Значение не должно быть отрицательным!");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Значение должно быть больше 0!");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLength == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Значение minLength или maxRepeats не были установлены!");
        }
        char[] chars = password.toCharArray();
        int max = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }
        return password.length() >= minLength && count <= maxRepeats;
    }
}
