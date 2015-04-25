package descartes.ia.deas.bpp;

public class Main {
	
	public static void main(String[] args) throws PancakeException {
		Pan p = new Pan(8);
		AI ai = new AI(p);
		
		System.out.println("*****Beautiful sorted pancake stack*****");
		p.show();
		//randomResolve(p, ai);
		
		System.out.println("\n*****Let's mix a bit !*****");
		p.mix(6);
		
		System.out.println("\n*****Now it's big mess...*****");
		p.show();
		
		System.out.println("\n***** We'll see if the algo is good enought to sort it quickly !*****");
		ai.resolve(30);
		
		System.out.println("\n******Let's see the actions he did to organise it  ******");
		System.out.println(ai.getActions().size() + " actions :" + ai.getActions().toString());
		ai.redevelop();
	}
	
	public static void randomResolve(Pan p, AI ai) {
		int i=0;
		do {
			i++;
			p.mix(1);
			p.show();
			System.out.println("i:"+i+" h:"+p.getHeuristic());
			System.out.println(p.isCorrect());
			
		} while (p.isBunrtCorrect() == false);
	}
}
