package dd_05_02_��ά����;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		char[][] a = {
				{'��','��','��','��','��'},
				{'��','��','��','��','��'},
				{'ҹ','��','��','��','��'},
				{'��','֪','��','��','��'}
		};
		for(int i=0; i<a[0].length; i++) {
			for(int j=a.length-1; j>=0; j--) {
				System.out.print(a[j][i]);
			}
			System.out.println();
		}
	}
	
}
