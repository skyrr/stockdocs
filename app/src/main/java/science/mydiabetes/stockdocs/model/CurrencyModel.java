package science.mydiabetes.stockdocs.model;

/**
 * Created by sky on 17.03.2017.
 */


public class CurrencyModel {
    private String[] array;

    public CurrencyModel(String[] array) {
        setArray(array);
    }

    public int getCount() {
        int count = 0;
        for (int i = 0; i < this.array.length; i++) {
            count++;
        }
        return count;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String getArrayElement(int i) {
        String element;
        element = this.array[i];
        return element;
    }
}

