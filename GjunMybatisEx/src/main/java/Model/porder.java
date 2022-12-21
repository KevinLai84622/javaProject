package Model;

public class porder {
	private Integer id;
	private String desk;
	private Integer A;
	private Integer B;
	private Integer C;
	private Integer sum;
	
	public porder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public porder(String desk, Integer a, Integer b, Integer c) {
		super();
		this.desk = desk;
		A = a;
		B = b;
		C = c;
		sum = A*120 + B*135 + C*150;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesk() {
		return desk;
	}

	public void setDesk(String desk) {
		this.desk = desk;
	}

	public Integer getA() {
		return A;
	}

	public void setA(Integer a) {
		A = a;
	}

	public Integer getB() {
		return B;
	}

	public void setB(Integer b) {
		B = b;
	}

	public Integer getC() {
		return C;
	}

	public void setC(Integer c) {
		C = c;
	}

	public Integer getSum() {
		sum = A*120 + B*135 + C*150;
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	
	
}
