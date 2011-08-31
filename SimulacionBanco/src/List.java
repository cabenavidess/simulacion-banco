

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public interface List {

	public boolean add(Object arg0);

	public void add(int arg0, Object arg1);

	//public boolean addAll(Collection arg0);

	//public boolean addAll(int arg0, Collection arg1);

	public void clear();

	public boolean contains(Object arg0);

	//public boolean containsAll(Collection arg0);

	public Object get(int arg0);

	public int indexOf(Object arg0);

	public boolean isEmpty();

	//public Iterator iterator();

	public int lastIndexOf(Object arg0);

	//public ListIterator listIterator();

	//public ListIterator listIterator(int arg0);

	public boolean remove(Object arg0);

	public Object remove(int arg0);

	//public boolean removeAll(Collection arg0);
	
	//public boolean retainAll(Collection arg0);

	public Object set(int arg0, Object arg1);

	public int size();

	public List subList(int arg0, int arg1);

	public Object[] toArray();

	public Object[] toArray(Object[] arg0);}
