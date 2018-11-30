package dna≈≈–Ú;


public class NiXuDui implements Comparable<NiXuDui>{
	private String dna;
	private int count;
	public NiXuDui() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NiXuDui(String dna, int count) {
		super();
		this.dna = dna;
		this.count = count;
	}
	public String getString() {
		return dna;
	}
	public void setString(String s) {
		this.dna = s;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int compareTo(NiXuDui n) {
		if(this.getCount()<n.getCount()) {
			return -1;
		}else if(this.getCount()>n.getCount()) {
			return 1;
		}else {
			return 0;
		}
		
		
	}
	

}
