
public class wordle1 {

	public static void main(String[] args) {
		//
		String p1= "TINGA";
		String p2= "KANPA";
		
		//
		for (int i = 0; i < 5; i++) {
			if(p1.charAt(i)==p2.charAt(i)) {
				System.out.print("Verde");
			}else {
				if(p1.indexOf(p2.charAt(i))!=-1) {
					System.out.print("Amarillo");
				}else {
					System.out.print("Rojo");
				}
			}
		}
		

	}

}
