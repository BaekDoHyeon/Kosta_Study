package self.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.self.service.BookMgrImpl;
import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookTest {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		BookMgrImpl mgr = BookMgrImpl.getInstance();
		
		aaa : while(true)
		{
			String menu = "";
			menu += "번호를 선택하세요\n";
			menu += "1:데이터 입력 기능\n";
			menu += "2:데이터 전체 검색기능\n";
			menu += "3:isbn으로 정보를 검색하는 기능\n";
			menu += "4:Title로 정보를 검색하는 기능(파라메터로 주어진 제목을 포함하는 모든 정보)\n";
			menu += "5:Book만 검색하는 기능\n";
			menu += "6:Magazine만 검색하는 기능\n";
			menu += "7: Magazine중 올해 잡지만 검색하는 기능\n";
			menu += "8: 출판사로 검색하는 기능\n";
			menu += "9: 가격으로 검색 기능(파라메터로 주어진 가격보다 낮은 도서 정보 검색)\n";
			menu += "10:저장된 모든 도서의 금액 합계를 구하는 기능\n";
			menu += "11:저장된 모든 도서의 금액 평균을 구하는 기능\n";
			menu += "0:끝내기";

			System.out.println(menu);
			int number = sc.nextInt();
			
			switch(number){
			case 0: 
				break aaa;
			case 1:
//				mgr.addBook(new Book("11", "자바", "Alpha", "a.kr", 100, "aaaa"));
//				mgr.addBook(new Magazine("22", "C", "Bravo", "b.kr", 300, "bbbb", 2019, 7));
//				mgr.addBook(new Book("11", "C++", "Charlie", "c.kr", 200, "cccc"));
//				mgr.addBook(new Magazine("44", "자바", "Delta", "d.kr", 50, "dddd", 2020, 2));
//				`
				System.out.println("번호 선택 (1:Book / 2:Magazine) : ");
				int num = sc.nextInt();
//				
//				if(num < 0 || 2 < num)
//					continue;
//					
//				System.out.println("isbn(String) : ");
//				String isbn = sc.next();
//				System.out.println("title(String) : ");
//				String title = sc.next();
//				System.out.println("author(String) : ");
//				String author = sc.next();
//				System.out.println("publisher(String) : ");
//				String publisher = sc.next();
//				System.out.println("price(int) : ");
//				int price = sc.nextInt();
//				System.out.println("desc(String) : ");
//				String desc = sc.next();
				
				
				if(num==1)
				{
//					Book book = new Book(isbn,title,author,publisher,price,desc);
//					mgr.addBook(book);
					mgr.addBook(new Book("11", "자바", "Alpha", "a.kr", 100, "aaaa"));
					mgr.addBook(new Magazine("22", "C1", "Bravo", "b.kr", 300, "bbbb", 2019, 7));
					mgr.addBook(new Book("33", "C++", "Charlie", "c.kr", 200, "cccc"));
					mgr.addBook(new Magazine("44", "자바3", "Delta", "d.kr", 50, "dddd", 2020, 2));
					mgr.addBook(new Book("55", "자바2", "Jone", "e.kr", 400, "eee"));
					mgr.addBook(new Magazine("66", "C2", "Mina", "f.kr", 350, "fff", 2024, 7));
					mgr.addBook(new Magazine("77", "Python", "Zin", "g.kr", 500, "gg", 2024, 3));
					mgr.addBook(new Magazine("88", "C#", "Aami", "h.kr", 1800, "hhh", 2024, 9));
					
				}
				else if(num == 2)
				{
//					System.out.println("year(int) : ");
//					int year = sc.nextInt();
//					System.out.println("month(int) : ");
//					int month = sc.nextInt();
//					
//					Magazine maga = new Magazine(isbn,title,author,publisher,price,desc,year,month);
//					mgr.addBook(maga);
//					
					mgr.addBook(new Book("11", "자바", "Alpha", "a.kr", 100, "aaaa"));
					mgr.addBook(new Magazine("22", "C1", "Bravo", "b.kr", 300, "bbbb", 2019, 7));
					mgr.addBook(new Book("33", "C++", "Charlie", "c.kr", 200, "cccc"));
					mgr.addBook(new Magazine("44", "자바3", "Delta", "d.kr", 50, "dddd", 2020, 2));
					mgr.addBook(new Book("55", "자바2", "Jone", "e.kr", 400, "eee"));
					mgr.addBook(new Magazine("66", "C2", "Mina", "f.kr", 350, "fff", 2024, 7));
					mgr.addBook(new Magazine("77", "Python", "Zin", "g.kr", 500, "gg", 2024, 3));
					mgr.addBook(new Magazine("88", "C#", "Aami", "h.kr", 1800, "hhh", 2024, 9));
				
				}
				
				break;
				
			case 2:
				ArrayList<Book> list=mgr.getAllBook();
				
				//오름차순 정렬 ... -> Comparable 사용
				Collections.sort(list, (o1, o2) -> {
					return o1.getTitle().compareTo(o2.getTitle());
				});
				
				for(Book b : list) {
					System.out.println(b);
				}
				
				break;
			case 3:
				System.out.println("검색할 isbn 입력 : ");
				String name1 = sc.next();				
				System.out.println(mgr.searchBookByIsbn(name1));
				break;
			case 4:
				System.out.println("검색할 title 입력 : ");
				String name2 = sc.next();
				ArrayList<Book> returnList=mgr.searchBookByTitle(name2);
				for(Book b : returnList) System.out.println(b);
				
				break;
			case 5:
				ArrayList<Book> returnList1 = mgr.onlySearchBook();
				for(Book b : returnList1)
					System.out.println(b);
				break;
				
			case 6:
				ArrayList<Book> returnList2=mgr.onlySearchMagazin();
				for(Book b : returnList2) {
					System.out.println(b);
				}
				break;
				
			case 7:
				ArrayList<Magazine> returnList3 = mgr.magazineOfThisYearInfo(2024);
				
				//내림차순 정렬 ... -> Comparable 사용
				Collections.sort(returnList3);
				
				for(Book b : returnList3) {
					System.out.println(b);
				}
				
				break;
			case 8:
				System.out.println("검색할 publisher 입력 : ");
				String name3 = sc.next();
				ArrayList<Book> returnList4=mgr.searchBookByPublish(name3);
				for(Book b : returnList4)System.out.println(b);
				break;
			case 9:
				System.out.println("검색할 가격 입력 : ");
				int num2 = sc.nextInt();
				ArrayList<Book> returnList5=mgr.searchBookByPrice(num2);
				for(Book b : returnList5)System.out.println(b);
				break;
			case 10:
				System.out.println(mgr.getTotalPrice());
				break;
			case 11:
				System.out.println(mgr.getAvgPrice());
				
			}
		}	
	}
}