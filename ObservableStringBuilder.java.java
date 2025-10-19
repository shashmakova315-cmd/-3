
import .util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {

    private final StringBuilder stringBuilder;
    private final List<Observer> observers = new ArrayList<>();

    public ObservableStringBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public ObservableStringBuilder(int capacity) {
        this.stringBuilder = new StringBuilder(capacity);
    }

    public ObservableStringBuilder(CharSequence seq) {
        this.stringBuilder = new StringBuilder(seq);
    }

    public ObservableStringBuilder(String str) {
        this.stringBuilder = new StringBuilder(str);
    }

    // Методы делегированные StringBuilder и уведомляющие наблюдателей

    public ObservableStringBuilder append(Object obj) {
        stringBuilder.append(obj);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(StringBuffer sb) {
        stringBuilder.append(sb);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(CharSequence s) {
        stringBuilder.append(s);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(CharSequence s, int start, int end) {
        stringBuilder.append(s, start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(char[] str) {
        stringBuilder.append(str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(char[] str, int offset, int len) {
        stringBuilder.append(str, offset, len);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(boolean b) {
        stringBuilder.append(b);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(char c) {
        stringBuilder.append(c);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(int i) {
        stringBuilder.append(i);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(long lng) {
        stringBuilder.append(lng);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(float f) {
        stringBuilder.append(f);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(double d) {
        stringBuilder.append(d);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder appendCodePoint(int codePoint) {
        stringBuilder.appendCodePoint(codePoint);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder deleteCharAt(int index) {
        stringBuilder.deleteCharAt(index);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int index, CharSequence s) {
        stringBuilder.insert(index, s);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int index, CharSequence s, int start, int end) {
        stringBuilder.insert(index, s, start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int dstOffset, char[] str) {
        stringBuilder.insert(dstOffset, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, char[] str, int index, int len) {
        stringBuilder.insert(offset, str, index, len);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, boolean b) {
        stringBuilder.insert(offset, b);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, char c) {
        stringBuilder.insert(offset, c);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, int i) {
        stringBuilder.insert(offset, i);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, long l) {
        stringBuilder.insert(offset, l);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, float f) {
        stringBuilder.insert(offset, f);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, double d) {
        stringBuilder.insert(offset, d);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder reverse() {
        stringBuilder.reverse();
        notifyObservers();
        return this;
    }

    // Методы делегированные StringBuilder без уведомления (только чтение/получение информации)

    public int capacity() {
        return stringBuilder.capacity();
    }

    public char charAt(int index) {
        return stringBuilder.charAt(index);
    }

    public int codePointAt(int index) {
        return stringBuilder.codePointAt(index);
    }

    public int codePointBefore(int index) {
        return stringBuilder.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return stringBuilder.codePointCount(beginIndex, endIndex);
    }

    public int compareTo(StringBuilder sb) {
        return stringBuilder.compareTo(sb);
    }

    public int indexOf(String str) {
        return stringBuilder.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return stringBuilder.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str) {
        return stringBuilder.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return stringBuilder.lastIndexOf(str, fromIndex);
    }

    public int length() {
        return stringBuilder.length();
    }

    public IntStream codePoints() {
        return stringBuilder.codePoints();
    }

    public IntStream chars() {
        return stringBuilder.chars();
    }

    public String substring(int start) {
        return stringBuilder.substring(start);
    }

    public String substring(int start, int end) {
        return stringBuilder.substring(start, end);
    }

    public CharSequence subSequence(int start, int end) {
        return stringBuilder.subSequence(start, end);
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public void trimToSize() {
        stringBuilder.trimToSize();
    }

    public void ensureCapacity(int minimumCapacity) {
        stringBuilder.ensureCapacity(minimumCapacity);
    }

    public void setLength(int newLength) {
        stringBuilder.setLength(newLength);
        notifyObservers();
    }

    public void setCharAt(int index, char ch) {
        stringBuilder.setCharAt(index, ch);
        notifyObservers();
    }

    // Методы для работы с наблюдателями

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    // Интерфейс наблюдателя
    public interface Observer {
        void update(ObservableStringBuilder stringBuilder);
    }

    public static void main(String[] args) {
        ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder("Hello");

        // Создаем наблюдателя
        Observer observer = new Observer() {
            @Override
            public void update(ObservableStringBuilder stringBuilder) {
                System.out.println("StringBuilder has changed: " + stringBuilder.toString());
            }
        };

        // Добавляем наблюдателя
        observableStringBuilder.addObserver(observer);

        // Вносим изменения, которые вызовут уведомление наблюдателя
        observableStringBuilder.append(" World!");
        observableStringBuilder.insert(5, ",");
        observableStringBuilder.delete(12, 13);
        observableStringBuilder.setCharAt(0, 'h');

        // Удаляем наблюдателя
        observableStringBuilder.removeObserver(observer);

        //Еще одно изменение после удаления наблюдателя
        observableStringBuilder.append(" - no one will know!");
    }
}
