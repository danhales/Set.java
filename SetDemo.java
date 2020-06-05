import java.util.ArrayList;

public class SetDemo
{
	public static void main(String[] args)
	{
		// testNoArgConstructor();
		// testArrayConstructor();
		// testArrayListConstructor();
		// testContains();
		// testIsSubset();
		// testIsSuperset();
		// testSetConstructor();
		// testEquals();
		// testUnion();
		// testIntersection();
		// testDifference();
		// testSymmetricDifference();
	}

	public static void testNoArgConstructor()
	{
		System.out.println("Testing Set()");
		Set mySet = new Set();
		System.out.println(mySet);
	}

	public static void testArrayConstructor()
	{
		System.out.println("Testing Set(int[])");
		// set is {1, 2, 5, 3, 7, 8}
		Set mySet = new Set(new int[] {1,2,5,5,3,2,3,7,8,2});
		System.out.println(mySet);
	}

	public static void testArrayListConstructor()
	{
		System.out.println("Testing the Set(ArrayList<Integer>)");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(6);
		nums.add(3);
		nums.add(1);
		nums.add(0);
		nums.add(2);

		Set mySet = new Set(nums);

		System.out.println(mySet);
	}

	public static void testSetConstructor()
	{
		System.out.println("Testing Set(Set)");
		Set parent = new Set(new int[] {1, 3, 5, 7, 9});
		Set child = new Set(parent);
		System.out.println(parent);
		System.out.println(child);
		System.out.println("Objects equal? " + parent.equals(child));

	}

	public static void testContains()
	{
		System.out.println("Testing contains(int)");

		// empty set
		Set mySet = new Set();
		System.out.println(mySet + " contains 5? " +  mySet.contains(5));

		// non-empty set
		mySet.add(5);
		mySet.add(7);
		System.out.println(mySet + " contains 5? " +  mySet.contains(5));
		System.out.println(mySet + " contains 2? " +  mySet.contains(2));

		// does it work after you discard the value?
		mySet.discard(5);
		System.out.println(mySet + " contains 5? " +  mySet.contains(5));
	}

	public static void testEquals()
	{
		System.out.println("Testing equals(Set)");
		Set a = new Set(new int[] {1, 3, 5, 7});
		Set b = new Set(new int[] {3, 7, 5, 1});
		Set c = new Set(new int[] {1, 2, 3, 4});

		System.out.println(a + " equals " + a + "? " + a.equals(a));
		System.out.println(a + " equals " + b + "? " + a.equals(b));
		System.out.println(a + " equals " + c + "? " + a.equals(c));
		System.out.println(b + " equals " + a + "? " + b.equals(a));
		System.out.println(b + " equals " + b + "? " + b.equals(b));
		System.out.println(b + " equals " + c + "? " + b.equals(c));
		System.out.println(c + " equals " + a + "? " + c.equals(a));
		System.out.println(c + " equals " + b + "? " + c.equals(b));
		System.out.println(c + " equals " + c + "? " + c.equals(c));
	}

	public static void testIsSubset()
	{
		System.out.println("Testing isSubset(Set)");
		Set a = new Set(new int[] {1, 2, 3, 4});
		Set b = new Set(new int[] {1, 2, 3, 4, 6});
		Set c = new Set(new int[] {1, 3, 5});

		System.out.println(a + " subset of " + a + "? " + a.isSubset(a));
		System.out.println(a + " subset of " + b + "? " + a.isSubset(b));
		System.out.println(a + " subset of " + c + "? " + a.isSubset(c));
		System.out.println(b + " subset of " + a + "? " + b.isSubset(a));
		System.out.println(b + " subset of " + b + "? " + b.isSubset(b));
		System.out.println(b + " subset of " + c + "? " + b.isSubset(c));
		System.out.println(c + " subset of " + a + "? " + c.isSubset(a));
		System.out.println(c + " subset of " + b + "? " + c.isSubset(b));
		System.out.println(c + " subset of " + c + "? " + c.isSubset(c));
	}

	public static void testIsSuperset()
	{
		System.out.println("Testing isSuperset(Set)");
		Set a = new Set(new int[] {1, 2, 3, 4});
		Set b = new Set(new int[] {1, 2, 3, 4, 6});
		Set c = new Set(new int[] {1, 3, 5});

		System.out.println(a + " superset of " + a + "? " + a.isSuperset(a));
		System.out.println(a + " superset of " + b + "? " + a.isSuperset(b));
		System.out.println(a + " superset of " + c + "? " + a.isSuperset(c));
		System.out.println(b + " superset of " + a + "? " + b.isSuperset(a));
		System.out.println(b + " superset of " + b + "? " + b.isSuperset(b));
		System.out.println(b + " superset of " + c + "? " + b.isSuperset(c));
		System.out.println(c + " superset of " + a + "? " + c.isSuperset(a));
		System.out.println(c + " superset of " + b + "? " + c.isSuperset(b));
		System.out.println(c + " superset of " + c + "? " + c.isSuperset(c));
	}

	public static void testUnion()
	{
		System.out.println("Testing Set.union(Set, Set)");
		Set a = new Set(new int[] {1, 3, 5, 7, 9});
		Set b = new Set(new int[] {3, 4, 5, 6, 7});
		System.out.println("The union of " + a + " and " + b + " is...");
		System.out.println("static: " + Set.union(a,b));
		System.out.println("instance a: " + a.union(b));
		System.out.println("instance b: " + b.union(a));
		System.out.println("Are the three sets above equal? " +
			Set.union(a,b).equals(a.union(b)) + "\t" +
			Set.union(a,b).equals(b.union(a)) + "\t" +
			a.union(b).equals(b.union(a)));
	}

	public static void testIntersection()
	{
		System.out.println("Testing Set.intersection(Set, Set)");
		Set a = new Set(new int[] {1, 3, 5, 7, 9});
		Set b = new Set(new int[] {3, 4, 5, 6, 7});
		System.out.println("The intersection of " + a + " and " + b + " is...");
		System.out.println("Static: " + Set.intersection(a,b));
		System.out.println("Instance a " + a.intersection(b));
		System.out.println("Instance b " + b.intersection(a));
		System.out.println("Are the three sets above equal? " +
			Set.intersection(a,b).equals(a.intersection(b)) + "\t" +
			Set.intersection(a,b).equals(b.intersection(a)) + "\t" +
			a.intersection(b).equals(b.intersection(a)));
	}

	public static void testDifference()
	{
		System.out.println("Testing Set.difference(Set, Set)");
		Set a = new Set(new int[] {1, 3, 5, 7, 9});
		Set b = new Set(new int[] {3, 4, 5, 6, 7});
		System.out.println("The difference of " + a + " and " + b + " is...");
		System.out.println(Set.difference(a,b));

		System.out.println("The difference of " + b + " and " + a + " is...");
		System.out.println(Set.difference(b,a));
	}

	public static void testSymmetricDifference()
	{
		System.out.println("Testing Set.symmetricDifference(Set, Set)");
		Set a = new Set(new int[] {1, 3, 5, 7, 9});
		Set b = new Set(new int[] {3, 4, 5, 6, 7});
		System.out.println("The symmetric difference of " + a +
						   " and " + b + " is...");
		System.out.println(Set.symmetricDifference(a,b));

		System.out.println("The symmetric difference of " + b +
						   " and " + a + " is...");
		System.out.println("Static: " + Set.symmetricDifference(b,a));
		System.out.println("Calling on a: " + a.symmetricDifference(b));
		System.out.println("Calling on b: " + b.symmetricDifference(a));

		System.out.println("Are these the same?" +
			"\nstatic: " +
			Set.symmetricDifference(a,b).equals(Set.symmetricDifference(b,a)) +
			"\ninstance: " +
			a.symmetricDifference(b).equals(b.symmetricDifference(a)) +
			"\nstatic and instance a: " +
			Set.symmetricDifference(a,b).equals(a.symmetricDifference(b)) +
			"\nstatic and instance b: " +
			Set.symmetricDifference(a,b).equals(b.symmetricDifference(a)));
	}
}
