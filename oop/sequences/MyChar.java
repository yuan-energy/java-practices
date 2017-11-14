public class MyChar extends Element {
	private char _c = '0' ;

	public MyChar(){}
	public MyChar( char other){
		_c = other ;
	}

	public char Get(){
		return _c;
	}

	public void Set(char other){
		_c = other ;
	}

	public void Print(){
		System.out.print("'" + _c + "'");
	}
}