package Y;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a resizable array.
   The dictionary is sorted and has distinct search keys. Search keys and
   associated values are not null.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SortedArrayDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
	private Entry<K, V>[] dictionary; // Array of entries sorted by search key
	private int numberOfEntries; 
    private boolean integrityOK = false;
	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

    public SortedArrayDictionary()
    {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayDictionary(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
        dictionary = tempDictionary;
        numberOfEntries = 0;
        integrityOK = true;
    }

    public V add(K key, V value)
    {
        checkIntegrity();
        if ((key == null) || (value == null))
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        else
        {
            V result = null;
            int keyIndex = locateIndex(key);
            if ((keyIndex < numberOfEntries) && key.equals(dictionary[keyIndex].getKey()))
            {
                result = dictionary[keyIndex].getValue();
                dictionary[keyIndex].setValue(value);
            }
            else
            {
                makeRoom(keyIndex);
                dictionary[keyIndex] = new Entry<K, V>(key, value);
                numberOfEntries++;
                ensureCapacity();
            }
            return result;
        }
    }

    private int locateIndex(K key)
    {
        int index = 0;
        while ((index < numberOfEntries) && key.compareTo(dictionary[index].getKey()) > 0)
        {
            index++;
        }
        return index;
    }

    private void makeRoom(int keyIndex)
    {
        for (int index = numberOfEntries - 1; index >= keyIndex; index--)
        {
            dictionary[index + 1] = dictionary[index];
        }
    }

    public V remove(K key)
    {
        checkIntegrity();
        V result = null;
        int keyIndex = locateIndex(key);
        if ((keyIndex < numberOfEntries) && key.equals(dictionary[keyIndex].getKey()))
        {
            result = dictionary[keyIndex].getValue();
            removeArrayEntry(keyIndex);
            numberOfEntries--;
        }
        return result;
    }

    private void removeArrayEntry(int keyIndex)
    {
        for (int fromIndex = keyIndex + 1; fromIndex < numberOfEntries; fromIndex++)
        {
            dictionary[fromIndex - 1] = dictionary[fromIndex];
        }
        dictionary[numberOfEntries - 1] = null;
    }

    public V getValue(K key)
    {
        checkIntegrity();
        V result = null;
        int keyIndex = locateIndex(key);
        if ((keyIndex < numberOfEntries) && key.equals(dictionary[keyIndex].getKey()))
        {
            result = dictionary[keyIndex].getValue();
        }
        return result;
    }

    public boolean contains(K key)
    {
        return locateIndex(key) < numberOfEntries;
    }

    public Iterator<K> getKeyIterator()
    {
        return new KeyIterator<>();
    }

    public Iterator<V> getValueIterator()
    {
        return new ValueIterator<>();
    }

    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    public int getSize()
    {
        return numberOfEntries;
    }

    public void clear() 
    {
        numberOfEntries = 0;
    }

    private void ensureCapacity()
    {
        if (numberOfEntries >= dictionary.length - 1)
        {
            int newLength = 2 * dictionary.length;
            checkCapacity(newLength);
            dictionary = Arrays.copyOf(dictionary, newLength);
        }
    }

    public void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a dictionary array whose capacity"
                    + " exceeds allowed maximum of "
                    + MAX_CAPACITY);
    }

    public void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("Dictionary object is corrupt.");
    }

    private class Entry<K, V>
    {
        private K key;
        private V value;

        private Entry(K searchKey, V dataValue)
        {
            key = searchKey;
            value = dataValue;
        }

        private K getKey()
        {
            return key;
        }

        private V getValue()
        {
            return value;
        }

        private void setValue(V newValue)
        {
            value = newValue;
        }
    }

    private class EntryIterator<Entry> implements Iterator<Entry>
    {
        private int nextIndex;

        private EntryIterator()
        {
            nextIndex = 0;
        }

        public boolean hasNext()
        {
            return nextIndex < numberOfEntries;
        }

        public Entry next()
        {
            if (hasNext())
            {
                @SuppressWarnings("unchecked")
                Entry result = (Entry) dictionary[nextIndex];
                nextIndex++;
                return result;
            }
            else
                throw new NoSuchElementException();
        }
    }

    private class KeyIterator<K> implements Iterator<K>
    {
        private Iterator<Entry<K, V>> entryIterator;

        private KeyIterator()
        {
            entryIterator = new EntryIterator<Entry<K,V>>();
        }

        public boolean hasNext()
        {
            return entryIterator.hasNext();
        }

        public K next()
        {
            Entry<K, V> nextEntry = entryIterator.next();
            return nextEntry.getKey();
        }
    }

    private class ValueIterator<K> implements Iterator<K>
    {
        private Iterator<Entry<K, V>> entryIterator;

        private ValueIterator()
        {
            entryIterator = new EntryIterator<Entry<K,V>>();
        }

        public boolean hasNext()
        {
            return entryIterator.hasNext();
        }

        public K next()
        {
            Entry<K, V> nextEntry = entryIterator.next();
            return nextEntry.getKey();
        }
    }
} // end SortedArrayDictionary
