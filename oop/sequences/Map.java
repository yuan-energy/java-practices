public class Map extends Sequence{
	MapIterator begin(){
		MyInteger special = new MyInteger(Integer.MAX_VALUE);
		if ( null == _end_it ) {
			_end_it = new Sequence(special, null);
		}
		add(_end_it, length()) ; 

		MapIterator ans = new MapIterator();
		ans._cur = this;
		return ans;
	}
	MapIterator end(){
		MapIterator ans = new MapIterator();
		int sz = this.length() ; 
		ans._cur = this.index_next( sz - 1 ) ;
		return ans;
	}

	public void add(Pair p){
		int id = 0; 
		int key_value = p._key.Get() ;
		if( super.length() > 0 ){
			while( id < super.length() && (super.index(id) instanceof Pair) ){
				if(  key_value < ((Pair)(super.index(id)))._key.Get() ){
					break;
				}
				id++;
			}
		}
		super.add(p, id);
	}

	public MapIterator find(MyChar key){
		for (MapIterator it = begin() ; !it.equal(end()) ; it.advance() ) {
			if ( key.Get() == it.get()._key.Get() ) {
				return it;
			}
		}
		return this.end();
	}
}