/*
 * sep 20, cci 3.4 Tower of Hanoi
 */

public class Hanoi {
	class Tower {
		Stack<Integer> disc;
		int num;

		public Tower() {
			disc = new Stack<Integer>();
			num = 0;
		}

		public Tower(int num) {
			disc = new Stack<Integer>();
			this.num = num;

			for(int i = num; i > 0 ; i--)
				disc.push(i);
		}

		public void add(int i) {
			disc.push(i);
			num++;
		}

		public int remove() {
			num--;
			return disc.pop();
		}
	}

	private Tower t1;
	private Tower t2;
	private Tower t3;

	public Hanoi() {
		t1 = new Tower(10);
		t2 = new Tower();
		t3 = new Tower();
	}

	public void move() {
		moveDisc(t1, t3, t2, t1.num);
	}

	public void check() {
		while(!t3.disc.isEmpty())
			System.out.println(t3.remove());
	}

	private void moveDisc(Tower towerFrom, Tower towerTo, Tower towerBy, int num) {
		if(num == 0)
			return;	
		
		moveDisc(towerFrom, towerBy, towerTo, num - 1);
		towerTo.add(towerFrom.remove());
		moveDisc(towerBy, towerTo, towerFrom, num - 1);

		towerTo.num = towerTo.num + num;
		towerFrom.num = towerFrom.num - num;
	}

	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
	
		hanoi.move();

		hanoi.check();
	}
}	
