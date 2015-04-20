package descartes.ia.deas.bpp;

import java.util.Vector;

public class Main {
	
	public static void main(String[] args) throws PancakeException {
		Pan p = new Pan(5);
		AI ai = new AI(p);
		
		System.out.println("*****Beautiful pancakes stack sorted*****");
		p.showForHuman(0);
		//randomResolve(p, ai);
		
		System.out.println("\n*****Let's mix a bit !*****");
		p.mix(15);
		
		System.out.println("\n*****Now it's big mess...*****");
		p.showForHuman(0);
		
		System.out.println("\n***** We'll see if the algo is good enought to sort it quickly !*****");
		ai.resolve(30);
		
		System.out.println(ai.getActions().size() + " actions :" + ai.getActions().toString());
		System.out.println("Let's see the actions !");
		for(int action : ai.getActions()) {
			p.showForHuman(0);
			System.out.println();
			p.flip(action);
		}
	}
	
	public static void randomResolve(Pan p, AI ai) {
		int i=0;
		do {
			i++;
			p.mix(1);
			p.showForHuman(0);
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
