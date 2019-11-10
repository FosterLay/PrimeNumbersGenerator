import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

//������ ����������
public class Generator {
	
	public static ArrayList<Integer> gen(int edge) {
		ArrayList<Integer> prime_numbers = new ArrayList<>();//������ ��� ������� �����
		 if (edge < 3){
			return null;
		}
		else {
			prime_numbers.add(2);//��������� ������� ����� - 2
			BitSet primal = new BitSet(edge);//�������� ������� ������ �� ���������� 0 (false)
			
			for (int number = 3; number < edge; number += 2) {//������� �������� ����� � 3
				if (primal.get(number)) {
					continue;//���������� ���������� �����
				}
				prime_numbers.add(number);//���������� ������� �����
			
				//������ ����� ���������� ����� ������� �������� �������� �����
				int multiple = number;
				for (int steps = edge / number - 1; steps > 0; steps--) {
					multiple += number;
					primal.set(multiple, true);//�������� ������� �������� �����
				}
				//����� �����
			}
		}
		return prime_numbers;
	}
	//���������� ����� ��� �������
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