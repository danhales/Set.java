/**
 * The Set class is capable of holding an unordered collection of unique
 * whole numbers.
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Set implements Iterable<Integer>
{
	// we will store our values here
	private ArrayList<Integer> set;

	/**
		No-arg constructor initializes an empty list.
	*/
	public Set()
	{
		set = new ArrayList<Integer>();
	}

	/**
		this constructor accepts an array of ints
		@param values an array of ints
	*/
	public Set(int[] values)
	{
		set = new ArrayList<Integer>();
		for (int i = 0; i < values.length; i++)
		{
			add(values[i]);
		}
	}

	/**
		This constructor accepts an ArrayList of Integers, and adds the
		unique values to set using the add method, which ensures no duplicates
		are added.
		@param values an ArrayList of Integers to add to the set
	*/
	public Set(ArrayList<Integer> values)
	{
		set = new ArrayList<Integer>();

		for (Integer value : values)
		{
			add(value);
		}
	}

	/**
		copy constructor accepts a Set object and clones its set attribute.
		@param parent a Set to copy
	*/
	@SuppressWarnings("unchecked")
	public Set(Set parent)
	{
		this.set = (ArrayList<Integer>) parent.set.clone();
	}

	/**
		add an element to the set.
		this method has no effect if the element is already present.
		this will be our most powerful and useful method.
		@param new_value
	*/
	public void add(int new_value)
	{
		if (!contains(new_value))
			set.add((int)(Math.random()*size()), new_value);
	}

	/**
		checks to see if the set contains the passed value
		@param value a number that could be in the set
		@return true if value is in the set, false otherwise
	*/
	public boolean contains(int value)
	{
		return set.contains(value);
	}

	/**
		static method for taking the difference left - right
		returns only the values in left that are not in right.
		@param left a Set object
		@param right a Set object
		@return a Set object containing the values in left that are
				not also in right
	*/
	public static Set difference(Set left, Set right)
	{
		Set diff = new Set();

		for (Integer element : left)
		{
			if (!right.contains(element))
			{
				diff.add(element);
			}
		}

		return diff;
	}

	/**
		instance method for taking the difference this - other
		@param other a Set object
		@return a Set object containing all of the elements in this.set that
				are not in other.set
	*/
	public Set difference(Set other)
	{
		return Set.difference(this, other);
	}

	/**
		removes an element from the set if it is a member.
		this method has no effect if the element is not present.
	*/
	public void discard(int value)
	{
		for (int i = 0; i < set.size(); i++)
		{
			if (set.get(i) == value)
			{
				set.remove(i);
			}
		}
	}

	/**
		equals method checks if calling object and argument are both subsets
		of each other.
		note that this method returns true if this and other contain the same
		elements, regardless of the order in which they appear.
		@param other the other set to compare
		@return true if this is a subset of other and other is subset of this
	*/
	public boolean equals(Set other)
	{
		return this.isSubset(other) && other.isSubset(this);
	}

	/**
		static method for taking the intersection of two sets.
		returns a Set of elements that are in BOTH setA AND setB.
		@param setA a Set object
		@param setB a Set object
		@return a set containing only elements in both setA and setB
	*/
	public static Set intersection(Set setA, Set setB)
	{
		Set setIntersection = new Set();

		for (Integer element : setA)
		{
			if (setB.contains(element))
			{
				setIntersection.add(element);
			}
		}

		return setIntersection;
	}

	/**
		instance method for taking the intersection of this and other.
		returns a set containing only the elements in this and other.
		@param other a Set object
		@return a Set object containing only the elements in both sets.
	*/
	public Set intersection(Set other)
	{
		return Set.intersection(this, other);
	}

	/**
		checks to see if the calling object is a subset of the argument object
		@param other another set
		@return true if every object in this set is in the other set
	*/
	public boolean isSubset(Set other)
	{
		for (Integer element : set)
		{
			if (!other.contains(element))
			{
				return false;
			}
		}

		return true;
	}

	/**
		checks to see if the calling object is a superset of the argument object
		@param other another set
		@return true if every element of other is an element of this
	*/
	public boolean isSuperset(Set other)
	{
		for (Integer element : other)
		{
			// if any element in this set is not found in the other set
			if (!this.contains(element))
			{
				return false;
			}
		}

		return true;
	}

	/**
		Allows us to iterate over the set, and gain access to individual
		elements.
	*/
	@Override
	public Iterator<Integer> iterator()
	{
		return set.iterator();
	}

	/**
		pop removes and returns a random element from the set.
		@return an element from the set
	*/
	public int pop()
	{
		return set.remove((int)(Math.random() * set.size()));
	}

	/**
		size method returns the size of the set.
		@return the number of elements in the set
	*/
	public int size()
	{
		return set.size();
	}

	/**
		static method for taking the symmetric difference of setA and setB.
		this method returns the elements that are in only setA or only setB.
		@param setA a Set object
		@param setB a Set object
		@return a Set object containing elements unique to setA or unique to
				setB
	*/
	public static Set symmetricDifference(Set setA, Set setB)
	{
		return Set.difference(Set.union(setA, setB),
							  Set.intersection(setA, setB));
	}

	/**
		instance method for taking the symmetric difference of this and other
		@param other a Set object
		@return a Set object containing elements unique to this or unique to
				other
	*/
	public Set symmetricDifference(Set other)
	{
		return Set.symmetricDifference(this, other);
	}

	/**
		static method for taking the union of two sets.
		returns a Set that contains all elements in setA, setB, or both
		@param setA a Set object
		@param setB a Set object
		@return a set containing all elements in setA, setB, or both
	*/
	public static Set union(Set setA, Set setB)
	{
		Set setUnion = new Set();

		for (Integer element : setA)
		{
			setUnion.add(element);
		}

		for (Integer element: setB)
		{
			setUnion.add(element);
		}

		return setUnion;
	}

	/**
		instance method for taking the union of this and other.
		returns a Set that contains all elements in this and other.
		@param other a Set object
		@return a Set object containing all elements in this, other, or both.
	*/
	public Set union(Set other)
	{
		return Set.union(this, other);
	}

	/**
		toString method returns a String containing the elements of the set
		as a list enclosed with curly braces.
		@return a String representation of the set.
	*/
	@Override
	public String toString()
	{
		String str = "{";

		for (int i = 0; i < set.size(); i++)
		{
			str += set.get(i);

			if (i + 1 < set.size())
			{
				str += ", ";
			}
		}

		return str + "}";
	}
}
