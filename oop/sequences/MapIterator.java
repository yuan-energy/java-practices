public class MapIterator extends SequenceIterator{
	
	public MapIterator advance(){
		super.advance() ; 
		return this ;
	}

	public Pair get(){
		return (Pair)(super.get()) ; 
	}

}