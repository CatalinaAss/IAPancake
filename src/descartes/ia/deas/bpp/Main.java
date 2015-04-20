package descartes.ia.deas.bpp;
public class Main {
	
	public static void main(String[] args) throws PancakeException {
		Pan p = new Pan(8);
		AI ai = new AI(p);
		
		//p.showForHuman();
		randomResolve(p, ai);
	}
	
	public static void randomResolve(Pan p, AI ai) {
		int i=0;
		do {
			i++;
			p.mix(1);
			p.showForHuman();
			System.out.println("i:"+i+" h:"+ai.getHeuristic());
			System.out.println(p.isCorrect());
			System.out.println(p.isBunrtCorrect()+"\n\n");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while (p.isBunrtCorrect() == false);
	}
}
