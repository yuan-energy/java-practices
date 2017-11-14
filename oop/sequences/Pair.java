public class Pair extends Element{
	public MyChar _key ; 
	public Element _value ;

	Pair( MyChar key, Element value ){
		_key = key ;
		_value = value ; 
	}

	public void Print(){
		System.out.print("(");
		_key.Print();
		System.out.print(" ");
		_value.Print() ; 
		System.out.print(")");
	}
}