public class ArrayClass<T> {
    private static final int startLenght = 1;
    private int lenght;
    private T[] data;

    public ArrayClass(){
        this.lenght = 0;
        this.data = (T[]) new Object[startLenght];
    }

    public int getLenght(){
        return this.lenght;
    }

    public T[] getData() {
        return this.data;
    }

    public void PrintArray() {
        System.out.print("[");
        for (int i = 0; i < this.getLenght(); i++) {
            if (i != this.getLenght() - 1)
                System.out.print(this.data[i] + ",");
            else
                System.out.print(this.data[i]);
        }
        System.out.print("]\n");
    }

    public void add(T element) {
        if (this.lenght == this.data.length) {
            AddLenth();
        }
        this.data[this.lenght++] = element;
    }

    private void AddLenth() {
        int newlen = this.getLenght() + 1;
        T[] newData = (T[]) new Object[newlen];
        for (int i = 0; i < this.getLenght(); i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public void RemoveByIndex(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx > this.getLenght()) {
            System.out.printf("Index %d out of bounds for length %d\n", idx, this.getLenght());
        } else {
            int newlen = this.getLenght() - 1;
            T[] newData = (T[]) new Object[newlen];
            int i = 0;
            while (i < idx) {
                newData[i] = this.data[i];
                i++;
            }
            i++;
            while (i < this.getLenght()) {
                newData[i - 1] = this.data[i];
                i++;
            }
            this.data = newData;
            this.lenght--;
        }
    }

    public void RemoveData(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                RemoveByIndex(i);
                i--;
            }
        }
    }

    public int FindMinData() {
        int min = (int) this.data[0];
        for (int i = 0; i < data.length; i++) {
            if (min > (int) this.data[i]) {
                min = (int) this.data[i];
            }
        }

        return min;
    }

    public int FindMaxData() {
        int max = (int) this.data[0];
        for (int i = 0; i < data.length; i++) {
            if (max < (int) this.data[i]) {
                max = (int) this.data[i];
            }
        }

        return max;
    }

    public int FindSumData(){
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += (int) this.data[i]; 
        }
        return result;
    }

    public int FindMultData(){
        int result = 1;
        for (int i = 0; i < data.length; i++) {
            result *= (int) this.data[i]; 
        }
        return result;
    }

    public int FindIndex(T element){
        
        int count = 0;
        for (T t : data) {
            if (t == element){
                return count;
            }
            count++;
        }
        return -1;
    }

    public boolean FindData(T element){
        for (T t : data) {
            if (t == element){
                return true;
            }
        }
        return false;
    }

    public void BubbleSort() throws ExceptionClass {
        T tmp = this.data[0];
        if (tmp instanceof Comparable) {
            for (int i = 0; i < this.getLenght() - 1; i++) {
                boolean hasSwap = false;
                
                for (int j = 0; j < this.getLenght() - i - 1; j++) {
                    Comparable<T> elem = (Comparable<T>)this.data[j];
                    T nextElem = this.data[j + 1];
                    if (elem.compareTo(nextElem) > 0) {
                        Swap(j, j + 1);
                        hasSwap = true;
                    }
                }
                
                if (!hasSwap) {
                    break;
                }
            }
        }
        else {
            throw new ExceptionClass(tmp.getClass().getSimpleName());
        }
    }

    public void InsertionSort() throws ExceptionClass {
        T tmp = this.data[0];
        if (tmp instanceof Comparable) {
            for (int i = 1; i < this.getLenght(); i++) {
                for (int j = i; j > 0; j--) {
                    Comparable<T> elem = (Comparable)this.data[j];
                    T prevElem = this.data[j - 1];
                    if (elem.compareTo(prevElem) < 0) {
                        Swap(j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        } else {
            throw new ExceptionClass(tmp.getClass().getSimpleName());
        }
    }

    public void SelectionSort() throws ExceptionClass {
        T min = this.data[0];
        if (min instanceof Comparable) {
            for (int i = 0; i < this.getLenght(); i++) {
                min = this.data[i];
                int min_idx = i;

                for (int j = i; j < this.getLenght(); j++) {
                    Comparable<T> elem = (Comparable<T>)this.data[j];
                    if (elem.compareTo(min) < 0) {
                        min = this.data[j];
                        min_idx = j;
                    }
                }

                if (i != min_idx) {
                    Swap(i, min_idx);
                }                
            }
        } else {
            throw new ExceptionClass(min.getClass().getSimpleName());
        }
    }

    private void Swap(int i, int j) {
        T tmp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = tmp;
    }


}
