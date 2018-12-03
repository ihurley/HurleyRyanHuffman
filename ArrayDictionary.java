import com.sun.xml.internal.xsom.impl.Ref;

/**
 * Name: Izzy Hurley
 * Lab Name: ArrayDictionary
 * Lab Purpose: The goal of ArrayDictionary is to create a program
 * Date: 9/25/18
 * Collaborators: None
 * ON MY HONOR: IH
 */
import java.util.ArrayList;
import java.util.Collection;
public class ArrayDictionary<E,T> {
    /*  A Java dictionary should use generics for the
 *  types of both key and value. E and T here.
 */
    private ArrayList<E> keys;
    private ArrayList<T> values;

    public ArrayDictionary() {
        keys = new ArrayList<E>();
        values = new ArrayList<T>();
    }

    public void put(E key, T value) {
        boolean breaker = false;
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                breaker = true;
            }
        }

            if (!breaker) keys.add(key);
            values.add(value);

    }

    //get the value associated with a given key
    public T get(E key) {
        return values.get(keys.indexOf(key));
    }

    //remove a key-value pair and return its value
    public T remove(E key) {
        int index = keys.indexOf(key);
        T store = values.get(index);
        keys.remove(index);
        values.remove(index);
        return store;
    }

    //returns true if the given key has an associated value
    public boolean contains(E key) {
        return keys.indexOf(key) + 1 >= values.size();
    }

    //returns true if the dictionary is empty
    boolean isEmpty() {
        return (keys.size() > 0);
    }

    //returns the number of key-value pairs in the dictionary
    int size() {
        return keys.size();
    }

    //returns a Collection¹ of keys
    public Collection<E> keys() {
        ArrayList k = new ArrayList();
        for (int i = 0; keys.size() > i; i++) {
            k.add(keys.get(i));
        }
        return k;
    }

    //returns a Collection of values
    public Collection<T> values() {
        ArrayList v = new ArrayList();
        for (int i = 0; keys.size() > i; i++) {
            v.add(values.get(i));
        }
        return v;
    }

    @Override
    public String toString() {
        String s = new String();
        for(int i=0;i<size();i++){
            s += (keys.get(i)+" = "+ values.get(i)+"\n");
        }
        return s;
    }
    public int valuesSize(){
        int sum=0;
        for(int i=0;i<size();i++){
            sum+=((String)values.get(i)).length();
        }
        return sum;
    }
}