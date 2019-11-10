import java.util.ArrayList;
import java.util.BitSet;

//Решето Эратосфена
public class Generator {
	
	public static ArrayList<Integer> gen(String args) {
		ArrayList<Integer> prime_numbers = new ArrayList<>();//Массив для простых чисел
		int len;
		try {
			len = Integer.valueOf(args);
		}
		catch (NumberFormatException e) {
			return null;
		}
		 if (len < 3){
			return null;
		}
		else {
			prime_numbers.add(2);//Начальное простое число - 2
			BitSet primal = new BitSet(len);//Создаётся битовый массив со значениями 0 (false)
			
			for (int number = 3; number < len; number += 2) {//перебор нечётных чисел с 3
				if (primal.get(number)) {
					continue;//пропускаем отмеченное число
				}
				prime_numbers.add(number);//выписываем простое число
			
				//начало блока исключения чисел кратных текущему простому числу
				int multiple = number;
				for (int steps = len / number - 1; steps > 0; steps--) {
					multiple += number;
					primal.set(multiple, true);//отмечаем кратные простому числу
				}
				//конец блока
			}
		}
		return prime_numbers;
	}
}