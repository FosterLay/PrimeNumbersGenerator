import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

//Решето Эратосфена
public class Generator {
	
	public static ArrayList<Integer> gen(int edge) {
		ArrayList<Integer> prime_numbers = new ArrayList<>();//Массив для простых чисел
		 if (edge < 3){
			return null;
		}
		else {
			prime_numbers.add(2);//Начальное простое число - 2
			BitSet primal = new BitSet(edge);//Создаётся битовый массив со значениями 0 (false)
			
			for (int number = 3; number < edge; number += 2) {//перебор нечётных чисел с 3
				if (primal.get(number)) {
					continue;//пропускаем отмеченное число
				}
				prime_numbers.add(number);//выписываем простое число
			
				//начало блока исключения чисел кратных текущему простому числу
				int multiple = number;
				for (int steps = edge / number - 1; steps > 0; steps--) {
					multiple += number;
					primal.set(multiple, true);//отмечаем кратные простому числу
				}
				//конец блока
			}
		}
		return prime_numbers;
	}
	//Консольный вызов для функции
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try{
			int edge = Integer.parseInt(scan.nextLine().trim());
			ArrayList<Integer> numbers = gen(edge);
			if (numbers == null) {
				System.out.println("Null");
			}
			else {
				for (int i = 0; i < numbers.size(); i++) {
					System.out.printf("%d\n",numbers.get(i));
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatError");
		}
		scan.close();
	}
}