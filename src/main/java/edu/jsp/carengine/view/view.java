package edu.jsp.carengine.view;
import edu.jsp.carengine.controller.DriverClass;
import java.util.Scanner;

public class view {


	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		do {

			System.out.println("Choose which operation u want to do ");
			System.out.println("Add ");
			System.out.println("Read");
			System.out.println("Update");
			System.out.println("Remove");
			String choseoperation = sc.nextLine();

			if (choseoperation.equals("Add")) {
				System.out.println("Choose the what u want to add");
				System.out.println("press 1 for the add Car with Engine");
				System.out.println("press 2 for the add only Car ");
				System.out.println("press 3 for the add only Engine");
				int num = sc.nextInt();
				sc.nextLine();
				if (num == 1) {

					System.out.println("Enter the engine id");
					int eid = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter the cc of engine u want");
					float ecc = sc.nextFloat();
					sc.nextLine();

					System.out.println("Which engine u waant to add petrol or disel");
					String etype = sc.nextLine();

					System.out.println("Enter the carid");
					int cid = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter the carname");
					String cname = sc.nextLine();
					DriverClass.storetheCarwithEngine( eid, ecc, etype,cid , cname);
				}
				if (num == 2) {
					System.out.println("Enter the carid");
					int cid = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter the carname");
					String cname = sc.nextLine();
					
					DriverClass.storeCarOnly(cid,cname);
				}
				if (num == 3) {
					System.out.println("Enter the engine id");
					int eid = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter the cc of engine u want");
					float ecc = sc.nextFloat();
					sc.nextLine();

					System.out.println("Which engine u waant to add petrol or disel");
					String etype = sc.nextLine();
				DriverClass.storeEngineOnly(eid, ecc, etype);

				}
			}
			if (choseoperation.equals("Read")) {
				System.out.println("press 1 to want get info car along the engine");
				System.out.println("press 2 to want get info of car only");
				System.out.println("press 3 to want get info of Engine only");
				int num1 = sc.nextInt();
				sc.nextLine();
				if (num1 == 1) {
                 System.out.println("Enter the Carid u want to get info");
                 int cid=sc.nextInt();
                 sc.nextLine();
                 DriverClass.readCarEngine(cid);
				}
				if (num1 == 2) {
	                 System.out.println("Enter the Carid u want to get info");
	                 int cid=sc.nextInt();
	                 sc.nextLine();
	                 DriverClass.readCarOnly(cid);
					}
				if (num1 == 3) {
	                 System.out.println("Enter the Engineid u want to get info");
	                 int eid=sc.nextInt();
	                 sc.nextLine();
	                 DriverClass.readEngineOnly(eid);
					}

			}
			if (choseoperation.equals("Update")) {
				System.out.println("press 1 to update the carname ");
				System.out.println("press 2 to update the CarEngine by new Engine");
				System.out.println("press 3 to update  Engine only");
				int num1 = sc.nextInt();
				sc.nextLine();
				if (num1 == 1) {
                 System.out.println("Enter the Carid u want to update");
                 int cid=sc.nextInt();
                 sc.nextLine();
                 System.out.println("Enter the New Carname u want to update on previous");
                 String cname=sc.nextLine();
                 DriverClass.updateCar(cid, cname);
				}
				if (num1 == 2) {
	                 System.out.println("Enter the Carid u want to get info");
	                 int cid=sc.nextInt();
	                 sc.nextLine();
	             	System.out.println("Enter the engine id");
					int eid = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter the cc of engine u want");
					float ecc = sc.nextFloat();
					sc.nextLine();

					System.out.println("Which engine u waant to add petrol or disel");
					String etype = sc.nextLine();
				    
	                 
	                 DriverClass.updateCarsEngine(cid,eid, ecc, etype);
					}
				if (num1 == 3) {
	                 System.out.println("Enter the Engineid u want to get info");
	                 int eid=sc.nextInt();
	                 sc.nextLine();
	                
						System.out.println("Enter the cc of engine u want to update");
							float ecc = sc.nextFloat();
							sc.nextLine();
	                   System.out.println("Which engine u waant to add petrol or disel");
							String etype = sc.nextLine();
	                 DriverClass.updateEngine(eid, ecc, etype);
					}

			}
			if (choseoperation.equals("Remove")) {
				System.out.println("press 1 to want remove engine");
				System.out.println("press 2 to want to remove car ");
				System.out.println("press 3 to want to remove an engine attached to a car without deleting the car");
				int num1 = sc.nextInt();
				sc.nextLine();
				if (num1 == 1) {
                 System.out.println("Enter the engineid u want to remove");
                 int eid=sc.nextInt();
                 sc.nextLine();
                 DriverClass.deleteEngine(eid);;
				}
				if (num1 == 2) {
	                 System.out.println("Enter the Carid u want remove");
	                 int cid=sc.nextInt();
	                 sc.nextLine();
	                 DriverClass.deleteCar(cid);;
					}
				if (num1 == 3) {
	                 System.out.println("Enter the Engineid u want to get remove from car");
	                 int eid=sc.nextInt();
	                 sc.nextLine();
	                 DriverClass.removeEngineFromCar(eid);;
					}

			}

		} while (true);

//		
}
}