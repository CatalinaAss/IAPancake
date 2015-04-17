package descartes.ia.deas.bpp;
public class Main {
	
	public static void main(String[] args) {
		Pan p = new Pan(7);
		AI ai = new AI(p);
		p.showForHuman();
		
		ai.show();

	}
	
	public static void randomResolve(Pan p) {
		int i=0;
		do {
			p.mix(1);
			i++;
			p.showForHuman();
			System.out.print(p.isCorrect()+" i :"+i+"\n");
		} while (p.isCorrect() == false);
	}
}
