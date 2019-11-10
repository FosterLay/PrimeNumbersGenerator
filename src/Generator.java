import java.util.ArrayList;
import java.util.BitSet;

//������ ����������
public class Generator {
	
	public static ArrayList<Integer> gen(String args) {
		ArrayList<Integer> prime_numbers = new ArrayList<>();//������ ��� ������� �����
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
			prime_numbers.add(2);//��������� ������� ����� - 2
			BitSet primal = new BitSet(len);//�������� ������� ������ �� ���������� 0 (false)
			
			for (int number = 3; number < len; number += 2) {//������� �������� ����� � 3
				if (primal.get(number)) {
					continue;//���������� ���������� �����
				}
				prime_numbers.add(number);//���������� ������� �����
			
				//������ ����� ���������� ����� ������� �������� �������� �����
				int multiple = number;
				for (int steps = len / number - 1; steps > 0; steps--) {
					multiple += number;
					primal.set(multiple, true);//�������� ������� �������� �����
				}
				//����� �����
			}
		}
		return prime_numbers;
	}
}