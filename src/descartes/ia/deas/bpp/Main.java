package descartes.ia.deas.bpp;
public class Main {
	
	public static void main(String[] args) throws PancakeException {
		Pan p = new Pan(15);
		AI ai = new AI(p);
		
		p.showForHuman();
		//randomResolve(p, ai);
		p.mix(15);
		p.showForHuman();
		ai.resolve(30);
		//System.out.println(ai.getActions());
	}
	
	public static void randomResolve(Pan p, AI ai) {
		int i=0;
		do {
			i++;
			p.mix(1);
			p.showForHuman();
			System.out.println("i:"+i+" h:"+p.getHeuristic());
			System.out.println(p.isCorrect());
			System.out.println(p.isBunrtCorrect()+"\n\n");
			
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		} while (p.isBunrtCorrect() == false);
	}
}
