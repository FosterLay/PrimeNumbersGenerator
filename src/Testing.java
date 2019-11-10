import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
//Список простых чисел для проверки взят из Википедии
//https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%BF%D1%80%D0%BE%D1%81%D1%82%D1%8B%D1%85_%D1%87%D0%B8%D1%81%D0%B5%D0%BB#%D0%9F%D0%B5%D1%80%D0%B2%D1%8B%D0%B5_500_%D0%BF%D1%80%D0%BE%D1%81%D1%82%D1%8B%D1%85_%D1%87%D0%B8%D1%81%D0%B5%D0%BB

class Testing {
	@Test
	void tes1() {
		ArrayList<Integer> numbers = Generator.gen(-100);
		if (numbers!=null) {
			fail();
		}
	}
	@Test
	void test2() {
		ArrayList<Integer> numbers = Generator.gen(2);
		if (numbers!=null) {
			fail();
		}
	}
	@Test
	void test3() {
		ArrayList<Integer> numbers = Generator.gen(3);
		if (numbers.get(0) != 2) {
			fail();
		}
	}
	@Test
	void test5() {
		int[] output = new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,
				73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,
				179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,
				281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,
				401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,
				521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,641,
				643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,
				769,773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,
				907,911,919,929,937,941,947,953,967,971,977,983,991,997,1009,1013,1019,1021,
				1031,1033,1039,1049,1051,1061,1063,1069,1087,1091,1093,1097,1103,1109};
		ArrayList<Integer> numbers = Generator.gen(1111);
		if (output.length != numbers.size()) {
			fail();
		}
		for (int i = 0; i < output.length; i++) {
			if (numbers.get(i) != output[i]) {
				fail();
			}
		}
	}
}
