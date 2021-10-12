package nms.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PowerConsumption {
	String date ;
	int machineNo ;
	int consumptionInHp ;
	
	public PowerConsumption( String date , int machineNo , int consumptionInHp )
	{
		this.date = date ;
		this.machineNo = machineNo ;
		this.consumptionInHp = consumptionInHp ;
	}
	
	public String toString()
	{
		StringBuffer str = new StringBuffer() ;
		str.append( date );
		str.append( "\t\t" );
		str.append( String.valueOf( machineNo ) );
		str.append( "\t\t" );
		str.append( String.valueOf( consumptionInHp ) );
		return str.toString() ;
	}
	
	public static void main( String ar[] )
	{
		PowerConsumption p[] = new PowerConsumption[6] ;
		p[0] = new PowerConsumption ( "10.05.08" , 10 , 100 ) ;
		p[1] = new PowerConsumption ( "10.05.08" , 11 , 120 ) ;
		p[2] = new PowerConsumption ( "10.05.08" , 12 , 125 ) ;
		p[3] = new PowerConsumption ( "11.05.08" , 10 , 145 ) ;
		p[4] = new PowerConsumption ( "11.05.08" , 11 , 155 ) ;
		p[5] = new PowerConsumption ( "12.05.08" , 12 , 165 ) ;
		System.out.println("Date\t\tMachine\t\tConsumption");
		for( int i = 0 ; i < p.length ; i++ ) {
		System.out.println(p[i]) ;
		}
		
		int[] col = new int[] {10,11,12};
		String[] rows = new String[] {"10.05.08","11.05.08","12.05.08"};
		
		
		HashMap<String, Integer> data = new HashMap<>();
		for(PowerConsumption pc : p) {
			String k = String.valueOf(pc.machineNo) + pc.date;
			data.put(k, pc.consumptionInHp);
		}
		
		
		List<List<Integer>> pb = new ArrayList<>();
		for(int i = 0; i < col.length; i++) {
			int tot = 0;
			List<Integer> t = new ArrayList<>();
			for(int j = 0; j < rows.length; j++) {
				String k = String.valueOf(col[i]) + rows[j];				
				if(data.containsKey(k)) {
					tot += data.get(k);
					t.add(data.get(k));
				}
				else t.add(0);
			}
			t.add(tot);
			pb.add(t);
		}
		System.out.println("\n\n");
		
		System.out.println("Machine/Date\t10.05.08\t11.05.08\t12.05.08\tTotal");
		int[] l = new int[4];
		for(int  i = 0; i < 3; i++) {
			System.out.print(col[i] + "\t\t");
			List<Integer> d = pb.get(i);
			for(int j  = 0; j < d.size(); j++) {
				System.out.print(d.get(j) + "\t\t");
				l[j] += d.get(j);
			}
			System.out.println();
		}
		System.out.print("Total\t\t");
		for(int i : l) System.out.print(i + "\t\t");
	}
}
