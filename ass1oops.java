package assignment1oops;

import java.util.*;

class addvaccine{
		
		String vaccine_name;
		int noofdoses;
		int gapbtwdoses;
		
		public static final HashMap<String, Integer> vacc_dos = new HashMap<String, Integer>();
		public static final HashMap<String, Integer> vacc_gap = new HashMap<String, Integer>();
		public static final ArrayList<String> vaccine=new ArrayList<String>();
		
		public void addvaccine() {
			Scanner sc=new Scanner(System.in);
			System.out.print("Vaccine name: ");
			vaccine_name=sc.nextLine();
			vaccine.add(vaccine_name);
			System.out.print("Number of doses: ");
			noofdoses=sc.nextInt();
			
			vacc_dos.put(vaccine_name,noofdoses);
			
			System.out.print("gap between two doses: ");
			gapbtwdoses=sc.nextInt();
			
			vacc_gap.put(vaccine_name, gapbtwdoses);
			
			System.out.println();
			System.out.println("Vaccine Name: "+vaccine_name);
			System.out.println("Number of doses: "+noofdoses);
			System.out.println("Gap between two doses: "+gapbtwdoses);
			
		}	
		public List<String> getMyList() {
            return vaccine;
      }   
 	}

	

	class hospital{
		
		String name;
		Long pin;
		int uniid;
				
		public static final HashMap<String, Long> hos_pin = new HashMap<String, Long>();
		public static final HashMap<String, Integer> hos_id = new HashMap<String, Integer>();
		
		
		public void hospital() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Hospital name: ");
			name=sc.nextLine();
			System.out.println("Pincode: ");
			pin=sc.nextLong();
			
			hos_pin.put(name, pin);
			
			Random rnd = new Random();
		    int uniid = rnd.nextInt(999999);
		    
		    hos_id.put(name, uniid);
		    
		    System.out.println();
		    System.out.println("Hospital Name: "+name);
		    System.out.println("Pincode: "+pin);
		    System.out.println("Unique Id: "+uniid);
			
		}		
	}
	
	class person extends hospital{
		String cname;
		int age;
		Long dn;
				
		public static final HashMap<String, Integer> citi_age = new HashMap<String, Integer>();
		public static final HashMap<String, Long> citi_id = new HashMap<String, Long>();
		
		public void person() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Citizen name: ");
			cname=sc.nextLine();
			
			System.out.println("Age: ");
			age=sc.nextInt();

			citi_age.put(cname, age);

			System.out.println("Unique Id(12 digits): ");
			dn=sc.nextLong();
			
			citi_id.put(cname, dn);
			
			System.out.println();
			System.out.println("citizen name: "+cname);
			System.out.println("Age: "+age);
			System.out.println("Unique Id: "+dn);
			
			
			if(age<18) {
				System.out.println();
				System.out.println("Only above 18 are allowed");
			}
		}
		
	}
	
	
	class vaccination extends addvaccine{
		
		int id;
		int slots;
		int day;
		int quan;
		int vac;
		
		public static final HashMap<Integer, Integer> hos_slot = new HashMap<Integer, Integer>();
		public static final HashMap<Integer, Integer> hos_day = new HashMap<Integer, Integer>();
		public static final HashMap<Integer, Integer> day_quan = new HashMap<Integer, Integer>();
		public static final HashMap<String, Integer> slot_vac = new HashMap<String, Integer>();
				
		
		void vaccination() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Hospital ID: ");
			id=sc.nextInt();
			
			System.out.println("Enter number of Slots to be added: ");
			slots=sc.nextInt();
			
			hos_slot.put(id,slots);
			
			for(int i=0;i<slots;i++) {
				System.out.println("enter day number: ");
				day=sc.nextInt();
				
				hos_day.put(id, day);
				
				System.out.println("Enter Quantity: ");
				quan=sc.nextInt();
				
				day_quan.put(day, quan);
				
				//vaccine from option 1 are not getting stored here
				System.out.println("Select Vaccine ");
				 for (int j=0;j<vaccine.size(); j++) {
			            System.out.println(j+". "+vaccine.get(j) + " ");       
			    }
				vac=sc.nextInt();
				System.out.println("Slot added by Hospital "+id+" for Day "+day+" ,Available Quatity: "+quan+ " of vaccine "+vaccine.get(vac));
			}
		}
	}
	
	class vaccinday extends person{
		 int docno;
		 int option;
		 int pin;
		 int id;
		 String vac;
		 int slot;
		
		 
		 public vaccinday() {
			 Scanner sc=new Scanner(System.in);
			 System.out.println("Enter patient Unique ID: ");
			 docno=sc.nextInt();
			 
			 
			 System.out.println("1. Search by area\r\n"
			 		+ "2. Search by Vaccine\r\n"
			 		+ "3. Exit");
			 option=sc.nextInt();
			 
			 if(option==1) {
				 System.out.println("Enter Pincode ");
				 pin=sc.nextInt();
				 
				 boolean a=hos_pin.containsKey(pin);
				 if(a==true) {
				 System.out.println(hos_pin.get(pin));
				 System.out.println("Enter Hospital id ");
				 id=sc.nextInt();
				 System.out.println("Choose slot ");
				 slot=sc.nextInt();
				 System.out.println(citi_id.get(docno) +" vaccinated with vaccine");
				 
				 }else {
					 System.out.println("Nothing by this");
				 }
				 
			 }
			 if(option==2) {
				 System.out.println("Enter Vaccine name ");
				 sc.nextLine();
				 vac=sc.nextLine();
				 
				 System.out.println("Enter Hospital id ");
				 id=sc.nextInt();
				 System.out.println(hos_id.containsKey(id));
				 
				 System.out.println("choose slot ");
				 slot=sc.nextInt();
				 
				 System.out.println(citi_id.get(docno) +" vaccinated with "+vac);
			 }
			 
}
		 
		
	}
	
	class searchbyhospital extends vaccination{
		int hosid;
		
		void search() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Hospital Id");
			hosid=sc.nextInt();
			System.out.println("Done");
			
			
		}
	}
	
	class vaccstatus{
		int docid;
		
		public vaccstatus() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter patient id ");
			docid=sc.nextInt();
			String[] s = {"Vaccinated","Not Vaccinated","Partially Vaccinated"};

			Random ran = new Random();
			String s_r = s[ran.nextInt(s.length)];
			System.out.println(s_r);
			
			System.out.println("no of doses given ");
			
			if(s_r=="Vaccinated") {
				System.out.println(2);
			}else if(s_r=="Not Vaccinated") {
				System.out.println(0);
			}else {
				System.out.println(1);
			}

			if(s_r=="Vaccinated") {
				System.out.println("Vaccinated");
			}else if(s_r=="Not Vaccinated") {
				System.out.println("Not Vaccinated");
			}else {
				System.out.println("Partially Vaccinated");
			}
		}
	}

public class ass1oops {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
        
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("            *** CoWin Portal initialized ***");
        System.out.println("--------------------------------------------------------------------------------");
		System.out.println("1. Add Vaccine");
		System.out.println("2. Register Hospital");
		System.out.println("3. Register Citizen");
		System.out.println("4. Add Slot for Vaccination");
		System.out.println("5. Book Slot for Vaccination");
		System.out.println("6. List all slots for a hospital");
		System.out.println("7. Check Vaccination Status");
		System.out.println("8. Exit");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Enter your Option No. ");
		int n=sc.nextInt();
		
		while(n!=8) {
			if(n==1) {
				addvaccine a=new addvaccine();
				a.addvaccine();				
				System.out.println("----------------------------------");
				n=sc.nextInt();
			}
			if(n==2) {
				hospital h=new hospital();
				h.hospital();
				System.out.println("----------------------------------");
				n=sc.nextInt();
			}
			if(n==3) {
				person p=new person();
				p.person();
				System.out.println("----------------------------------");
				n=sc.nextInt();
			}
			if(n==4) {
				vaccination v=new vaccination();
				v.vaccination();
				System.out.println("----------------------------------");
				n=sc.nextInt();
			}
			if(n==5) {
				new vaccinday();
				System.out.println("----------------------------------");
				n=sc.nextInt();
			}
			if(n==6) {
				searchbyhospital s=new searchbyhospital();
				s.search();
				System.out.println("----------------------------------");
				n=sc.nextInt();
			}
			if(n==7) {
				new vaccstatus();
				System.out.println("----------------------------------");
				n=sc.nextInt();
			}
			if(n==8) {
				System.out.println("----------------------------------");
				return;
				
			}else {
				System.out.println("Invalid option. Try Again");
				n=sc.nextInt();
			}
			
			
		}
		
		
		
	}

}
