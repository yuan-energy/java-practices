public class MyInteger extends Element {
	private int _v = 0 ;

	public MyInteger(){}
	public MyInteger( int other){
		_v = other ;
	}

	public int Get(){
		return _v;
	}

	public void Set(int other){
		_v = other ;
	}

	public void Print(){
		System.out.print(_v);
	}




}