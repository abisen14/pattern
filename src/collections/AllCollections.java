package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class AllCollections {
    //Array List
    static List<Integer> integerList = new ArrayList();
    //Insert
    //integerList.add(index, element);
    //Removing elements
    //removeRange(int fromIndex, int toIndex)
    // removeAll(Collection<?> c)
    //clear() to remove the list
    //To update an element in ArrayList, the set(int index, E e)

    //hasNext() - This method returns true if there are more elements in the list; otherwise, it returns false.
    //
    //next() - This method returns the next element in the list. Before calling next(), we should always call hasNext() to verify that there is an element;
    // otherwise, NoSuchElementException will be thrown.
    //
    //remove() - This method removes the last element returned by the iterator. It can be called only once per call to the next().
    //
    //forEachRemaining(Consumer<? super E> action) - This method was introduced in Java 8. It performs the given action for each
    // remaining element until all elements have been processed or the action throws an exception.
    // This method’s benefit is that we do not need to check if there is a next element every time.

    // Getting ListIterator
    //	ListIterator<Integer> listIterator = list.listIterator();

    //hasNext() - This method is used to check if there is a next element in the list when the list is iterated in the forward direction.
    //
    //next() - This method returns the next element in the list and advances the cursor position.
    //
    //hasPrevious() - This method is used to check if there is a next element in the list when the list is iterated in the backward direction.
    //
    //previous() - This method returns the previous element in the list and moves the cursor position backward.
    //
    //nextIndex() - This method returns the index of the element that would be returned by a subsequent call to next(). It returns the list size if the list iterator is at the end of the list.
    //
    //previousIndex() - This method returns the index of the element that would be returned by a subsequent call to previous(). It returns -1 if the list iterator is at the beginning of the list.
    //
    //remove() - This method removes the last element that was returned by next() or previous() from the list. This call can only be made once per call to next() or previous().
    // It can be made only if add() has not been called after the last call to next() or previous().
    //
    //set(E e) - This method replaces the last element returned by next() or previous() with the specified element. This call can be made only if neither remove() nor add() have been called after the last call to next() or previous().
    //
    //add(E e) - This method inserts the specified element into the list. The element is inserted immediately before the element that would be returned by next(), if any, and after the element that would be returned by previous(), if any.

    // List<Integer> sortedList = list.stream()
    //				.sorted(Comparator.reverseOrder())
    //				.collect(Collectors.toList());

    //If we use the Collections.sort(List<T> list) method to sort an ArrayList, then the class whose objects are stored in the ArrayList must implement the Comparable interface.
    // If the ArrayList stores an Integer, a Long, or a String, then we don’t need to worry as these classes already implement the Comparable interface.
    // But if the ArrayList stores a custom class object,
    // then that class must implement the Comparable interface.
    class Employee implements Comparable<Employee> {

        String name;
        int age;

        public Employee(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Employee emp) {
            //We will sort the employee based on age in ascending order
            //returns a negative integer, zero, or a positive integer as this employee age
            //is less than, equal to, or greater than the specified object.
            return (this.age - emp.age);
        }
    }

    //If we need some flexibility in sorting, we should use the Comparator interface instead of the Comparable interface.
    // The Comparator interface has a method, compare(T o1, T o2), which takes two objects, o1 and o2 as parameters.
    // It returns -1 if o1 << o2, 1 if o1 >> o2 and 0 if o1 is equal to o2.

    public class BrandComparator implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.brand.compareTo(o2.brand);
        }
    }

    public class MakeYearComparator implements Comparator<Vehicle>{

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.makeYear.compareTo(o2.makeYear);
        }
    }

    //Collections.sort(list, new MakeYearComparator());
    //Collections.sort(list, new BrandComparator());

    //-----------------------------------------------------------------//

    //The LinkedList class in Java implements the List and the Deque interface.
    //To insert a single element at the end, we can use the add(E e) or addLast(E e) method
    //We can use the add(int index, E element) method to insert an element at a particular index

    //getFirst(), getLast(), get(int index)

    //---------------------------------------------------------------------//
    //Now, if we want to use a list in a multi-threaded environment, we have few options.
    // The first option is using a Vector. The Vector is a legacy class in which all the methods are synchronized.
    // Since for each operation,
    // such as add or remove, the entire list is locked, it is slow. Hence it is no longer used.
    //
    //The second option is making our list thread-safe by using the Collections.synchronizedList() method, which we have already discussed in this lesson.
    // The problem with this method is that it also locks the entire list for each operation. So, there is no performance benefit.


   // CopyOnWriteArrayList was introduced. This is a thread-safe list with high performance.

    //The one last thing that we need to discuss is why the iterator of CopyOnWriteArrayList does not have the remove method.
    // Firstly it is not needed as in a CopyOnWriteArrayList we can directly remove the element from the List without fearing any exception. Secondly, if there was a remove method in the iterator() then it will not be very useful. It will remove the element from the snapshot that is created for iteration.
    // The actual array which holds the data will not be changed.

    //The iterator() method returns an iterator that provides a snapshot of the state of the list when the iterator was constructed. No synchronization is needed while
    // traversing the iterator because the iteration is being done on a snapshot.

    //List<String> list = new CopyOnWriteArrayList<>();
    //		list.add("Apple");
    //		list.add("Banana");
    //		list.add("Orange");
    //
    //		//Created an iterator
    //		Iterator<String> itr = list.iterator();
    //		//Adding elements after creating iterator. ConcurrentModificationException will not be thrown.
    //		list.add("Papaya");

    //------------------------------------------------------------------------//

    //HashSet is a class in the java.utils package which implements the Set interface.
    // Some of the features of HashSet are:
    //
    //HashSet does not allow duplicate elements.
    //HashSet allows only one null element.
    //The elements are inserted in random order in a HashSet.
    //A HashSet is internally backed by a HashMap.

    // Set<Integer> set= new HashSet<>();
    // This constructor creates a HashSet with an initial capacity of 16 and a load factor of 0.75.

    // for(int i : set) {
    //			System.out.println(i);
    //		}

    //Iterator<Integer> itr = set.iterator();
    //
    //		while(itr.hasNext()) {
    //			System.out.println(itr.next());
    //		}

    // set.forEach(System.out::println);

    //---------------------------------------------------------------------------//

    //The HashSet allows one null element, whereas a TreeSet does not allow a null element.
    //The elements are stored in random order in a HashSet, whereas it is stored in sorted order in TreeSet.
    //HashSet is faster than Treeset for the operations like add, remove, contains, size, etc.

    //Set<Integer> set= new TreeSet<>();
    //// This TreeSet will store the elements in reverse order.
    //		TreeSet<Integer> reverseSet = new TreeSet<>(Comparator.reverseOrder());

    // System.out.println("Fetching the first element in TreeSet " + set.first());
    // System.out.println("Fetching the last element in TreeSet " + set.last());
    // System.out.println("Fetching all the elements less than 40 " + set.headSet(40));
    // System.out.println("Fetching all the elements greater than 40 " + set.tailSet(40));

    // System.out.println("Removing 100 from TreeSet " + set.remove(new Integer(100)));
    // System.out.println("Checking if TreeSet contains 44: " + set.contains(new Integer(44)));

    //-------------------------------------------------------------------------------//

    //Some of the features of HashMap are:
    //
    //The keys should be unique.
    //HashMap allows only one null key.
    //The values can be null or duplicate.
    //The keys are stored in random order.

    //Map<String, Integer> map = new HashMap<>();

    //The getOrDefault(Object key, V defaultValue) method is useful if we want to insert a default value in the Map that isn’t already present.

    //This method will return the value for a given key, and if the key is not present, then it will insert the key with a default value

    //// Using the replaceAll() method to add 10 to the price of each stock.
    //		stockPrice.replaceAll((k,v) -> v + 10);
    //        System.out.println(stockPrice);

    //Set<String> keys = stockPrice.keySet();

    //Collection<Integer> values = stockPrice.values();

    //// This will increment the value of India by 1 as it is present in the Map
    //		map.compute("India", (k, v) -> v == null ? 10 : v + 1);
    //
    //		// This will insert Vietnam in the Map with default value of 10.
    //		map.compute("Vietnam", (k, v) -> v == null ? 10 : v + 1);

    //map.computeIfAbsent("Vietnam", k -> k.length());

    //Map<String, Integer> map1 = new HashMap<>();
    //		map1.put("Jay", 5000);
    //		map1.put("Rahul", 3000);
    //		map1.put("Nidhi", 4500);
    //		map1.put("Amol", 60000);
    //
    //		Map<String, Integer> map2 = new HashMap<>();
    //		map2.put("Jay", 7000);
    //		map2.put("Rahul", 4500);
    //		map2.put("Nidhi", 1200);
    //		map2.put("Saurav", 25000);
    //
    //		map1.forEach((key,value) -> map2.merge(key, value, (v1, v2) -> v1 + v2));


    //It is not mandatory for a HashMap key to be immutable, but it is suggested that key objects are immutable.
    // Immutability allows us to get the same hash code every time for a key object.
    //
    //All the wrapper classes such as String, Integer, etc., are immutable, so they are considered good key candidates.

    // Iteration
    //Map<String, Integer> stockPrice = new HashMap<>();
    //Set<Entry<String, Integer>> entrySet = stockPrice.entrySet();

    //for (Entry<String, Integer> entry : entrySet) {
    //			System.out.println("Company Name: " + entry.getKey() + " Stock Price: " + entry.getValue());
    //		}

    //Set<Entry<String, Integer>> entrySet = stockPrice.entrySet(); // Returns a Set of Entries
    //
    //		Iterator<Entry<String, Integer>> itr = entrySet.iterator(); //Getting the iterator

    //Map<String, Integer> stockPrice = new HashMap<>();
    //stockPrice.forEach((key, value) -> System.out
    //				.println("Company Name: " + key + " Stock Price: " + value));

    //To remove itr.remove

    //---------------------------------------------------------------------------------//

    //TreeMap is a class in the java.utils package that stores the keys in sorted order. Some of the features of TreeMap are:
    //
    //The entries in TreeMap are sorted in the natural ordering of its keys.
    //
    //It does not allow null keys, however there can be null values.
    //
    //The TreeMap is not thread-safe, although it can be made thread-safe using the synchronizedMap() method of the Collections class.

    //Since a TreeMap stores the keys in sorted order, the objects that we are storing in the TreeMap should either
    // implement the Comparable interface or we should pass a Comparator while creating the TreeMap object.

    //TreeMap<String, Integer> reverseMap = new TreeMap<>(Comparator.reverseOrder());

    //Sort by values :
    public static TreeMap<String, Integer> sortByValues(TreeMap<String, Integer> map) {

        Comparator<String> valueComparator = (k1, k2) -> {

            int comp = map.get(k1).compareTo(map.get(k2));
            if (comp == 0)
                return 1;
            else
                return comp;
        };

        TreeMap<String, Integer> mapSortedByValues = new TreeMap<>(valueComparator);

        mapSortedByValues.putAll(map);
        return mapSortedByValues;

    }

    // Sorting hashmap
    //Either Treemap or ArrayList of ketset sort
    //or
    //Map<Integer, String> employeeMap = new HashMap<>();
    //		employeeMap.put(123, "Alex");
    //		employeeMap.put(342, "Ryan");
    //		employeeMap.put(143, "Joe");
    //		employeeMap.put(234, "Allen");
    //		employeeMap.put(432, "Roy");
    //
    //		System.out.println("Sorting by key");
    //		employeeMap.entrySet()
    //		.stream()
    //		.sorted(Map.Entry.<Integer, String>comparingByKey())
    //		.forEach(System.out::println);
    //
    //		System.out.println("Sorting by value");
    //		employeeMap.entrySet()
    //		.stream()
    //		.sorted(Map.Entry.comparingByValue())
    //		.forEach(System.out::println);
    //
    //	}

    //-------------------------------------------------------------------------------------//
    //We have already discussed that a HashMap does not maintain insertion order and TreeMap stores the elements in sorted order. Now, if we want to store the elements in a Map in insertion order, then a LinkedHashMap can be used. LinkedHashMap is a class in the java.utils package that implements the Map interface and extends the HashMap class. It is similar to HashMap with the additional feature of maintaining the order of elements inserted into it.
    //
    //Some of the important features of a LinkedHashMap are:
    //
    //It does not allow duplicate keys.
    //It may have one null key and multiple null values.
    //It is non-synchronized.

    //LinkedHashMap(int capacity, float loadFactor)

    //In the below example, we have created a LinkedHashMap with the access order flag as true.
    // Now the elements that were accessed most recently will be kept at the last position.
    //Map<String, Integer> stocks = new LinkedHashMap<>(16, 0.75f, true);

    //The internal workings of a LinkedHashMap are similar to the internal workings of HashMap with one major difference. In LinkedHashMap, each Entry maintains the record of the Entry that was inserted before it and after it.
    //
    //If we look at the Entry class of LinkedHashMap, then we can see that it has two extra fields in comparison to the Entry class of HashMap. These extra fields are before and after. For a given Entry, the before field points to the Entry that was inserted prior to this Entry.
    // The after field points to the Entry that was inserted after this Entry.

    //static class Entry<K,V> extends HashMap.Node<K,V> {
    //    Entry<K,V> before, after;
    //    Entry(int hash, K key, V value, Node<K,V> next) {
    //        super(hash, key, value, next);
    //        }
    //    }

    //----------------------------------------------------------------------------------//

    //Let’s discuss some of the differences between a ConcurrentHashMap and a SynchronizedMap.
    //
    //In a SynchronizedMap, the entire Map is locked. So every read/write operation needs to acquire a lock, which makes it very slow. On the other hand in a ConcurrentHashMap, only a segment of the Map is locked. Two parallel threads can access or update elements in a different segment, so it performs better.
    //
    //SynchronizedMap returns Iterator, which fails fast on concurrent modification. ConcurrentHashMap doesn’t throw a ConcurrentModificationException if one thread tries to modify it while another is iterating over it.
    //
    //ConcurrentHashMap does not allow null keys or null values while SynchronizedMap allows one null key.

    //ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    //Let’s say we have created a collection where we have added some important data.
    // We want others to read this data, but they should not be allowed to modify the data in this Collection.
    // The Collections class provides certain methods that can be used to make our Collection unmodifiable.
    // These methods return a collection in which if someone tries to add or remove an element, then UnsupportedOperationException is thrown.

    //unmodifiableList(List<? extends T> list)
    //unmodifiableSet(Set<? extends T> s)
    //unmodifiableMap(Map<? extends K, ? extends V> m)
    //unmodifiableCollection(Collection<? extends T> c)
    //unmodifiableSortedMap(SortedMap<K,? extends V> m)
    //unmodifiableSortedSet(SortedSet<T> s)


}
