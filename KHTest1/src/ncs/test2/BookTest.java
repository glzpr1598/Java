package ncs.test2;

public class BookTest {

	public static void main(String[] args) {
		
		Book bookArray[] = new Book[5];

		// Book 객체를 5개 생성하여 배열에 넣는다 .
		bookArray[0] = new Book("IT", "SQL Plus", 50000, 5);
		bookArray[1] = new Book("IT", "Java 2.0", 40000, 3);
		bookArray[2] = new Book("IT", "JSP Servlet", 60000, 6);
		bookArray[3] = new Book("Nobel", "davincicode", 30000, 10);
		bookArray[4] = new Book("Nobel", "cloven hoof", 50000, 15);

		// 배열에 있는 객체 정보를 실행결과 형식으로 모두 출력한다. – for loop를 이용할 것
		for (Book temp : bookArray) {
			System.out.println(temp.getCategory() + " " + temp.getBookName() + " " + temp.getBookPrice() + "원 " + temp.getBookDiscountRate() + "%");
		}
		
		// 합계를 출력한다 .
		double sum = 0;
		for  (Book temp : bookArray) {
			sum += temp.getBookPrice();
		}
		System.out.println();
		System.out.println("책 가격의 합: " + sum);

	}

}
