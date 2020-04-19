package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		List<Product> product = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");

			System.out.print("Common, used or imported (c/u/i)? ");
			char opcao = sc.next().charAt(0);

			if (opcao == 'i') {
				
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();

				product.add(new ImportedProduct(name, price, customsFee));

			} else if (opcao == 'c') {
				
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();

				product.add(new Product(name, price));

			} else if (opcao == 'u') {

				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY):");
				Date manufactureDate = sdf.parse(sc.next());

				product.add(new UsedProduct(name, price, manufactureDate));
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product list : product) {
			
		System.out.println(list.priceTag());
			
			
		}
		
			
		sc.close();

	}

}
