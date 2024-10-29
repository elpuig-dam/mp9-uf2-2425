package s3.cursarelleus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Carrera {

	public static void main(String[] args) throws InterruptedException {
		
		Testimoni equip1 = new Testimoni("FCB");
		Testimoni equip2 = new Testimoni("RSO");
		Testimoni equip3 = new Testimoni("GIR");
		Testimoni equip4 = new Testimoni("MAD");
		
		
		Atleta[] atEquip1 = new Atleta[4];
		Atleta[] atEquip2 = new Atleta[4];
		Atleta[] atEquip3 = new Atleta[4];
		Atleta[] atEquip4 = new Atleta[4];
		
		//Instàncies dells atletes al Array
		for(int i=0;i<4;i++) {
			atEquip1[i] = new Atleta(equip1);
			atEquip2[i] = new Atleta(equip2);
			atEquip3[i] = new Atleta(equip3);
			atEquip4[i] = new Atleta(equip4);
		}

		//Donem nom als atletes
		for(int i=0;i<4;i++) {
			atEquip1[i].setName(equip1.getNom() + "-Atl-" + i);
			atEquip2[i].setName(equip2.getNom() + "-Atl-" + i);
			atEquip3[i].setName(equip3.getNom() + "-Atl-" + i);
			atEquip4[i].setName(equip4.getNom() + "-Atl-" + i);
		}

		//Comença la cursa
		for(int i=0;i<4;i++) {
			atEquip1[i].start();
			atEquip2[i].start();
			atEquip3[i].start();
			atEquip4[i].start();
		}

		//Esperem a que tots acabin
		for(int i=0;i<4;i++) {
			atEquip1[i].join();
			atEquip2[i].join();
			atEquip3[i].join();
			atEquip4[i].join();
		}

		//Imprimim el campió
		List<Testimoni> temps = new ArrayList<>();
		temps.add(equip1);
		temps.add(equip2);
		temps.add(equip3);
		temps.add(equip4);

		Collections.sort(temps, new Comparator<Testimoni>() {
			@Override
			public int compare(Testimoni o1, Testimoni o2) {
				if(o1.getTemps()<o2.getTemps()) return -1;
				else return 1;
			}
		});
		System.out.println("\nClassificació");
		temps.forEach((e) -> System.out.println(e.getNom() + " : " + e.getTemps()));

		
	}

}
