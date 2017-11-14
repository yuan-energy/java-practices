public class Sequence extends Element {
	public Element _e;
	public Sequence _next;


	public Sequence(){}
	public Sequence(Element other_e, Sequence other_next){
		_e = other_e ;
		_next = other_next ;
	}
	public void Print(){
		System.out.print("[");
		for (Sequence p = this ; p != null ; p = p._next) {
			System.out.print(" ");
			p._e.Print();
		}
		System.out.print(" ]");
	}

	public Element first(){
		return _e;
	}

	public Sequence rest(){
		return _next;
	}

	public int length(){
		int size = 0;
		Sequence p = this;
		while( null != p ){
			p = p._next;
			size++ ;
		}
		return size ; 
	}

	public void add(Element elm, int pos){
		if ( 0 == pos ) {
			if( null != this._e ){
				this._next = new Sequence(this._e, this._next);
			}
			this._e = elm ;
			return;
		}

		int i = 0;
		Sequence p = this ;
		Sequence prev = null;
		while( i++ < pos){
			if ( null == p ) {
				System.out.println("ERROR in Sequence::add, pos exceeds seq!");
				return;
			}
			prev = p;
			p = p._next;
		}

		prev._next = new Sequence(elm, p);

	}

	public void delete(int pos){
		Sequence p = this ; 
		Sequence prev = null;
		int i = 0; 
		while( i++ < pos ){
			if ( null == p ) {
				System.out.println("ERROR in Sequence::add, pos exceeds seq!");
				return;
			}
			prev = p ;
			p = p._next ; 
		}

		if ( null != p ) {
			if ( null != prev ) {
				prev._next = p._next;
			}else{
				this._e = this._next._e;
				this._next = this._next._next;
			}
		}
	}

	public Element index ( int pos ) {
		if ( !( pos >=0 && pos < this.length() ) ) {
			System.err.println("ERROR !! in Sequence::index pos exceeds seq!");
			return null;
		}

		Sequence p = this;
		int i = 0; 
		while( i++ < pos ){
			p = p._next;
		}
		return p._e ;
	}

	public Sequence index_next( int pos ){
		if ( !( pos >=0 && pos < this.length() ) ) {
			System.err.println("ERROR !! in Sequence::index pos exceeds seq!");
			return null;
		}

		Sequence p = this;
		int i = 0; 
		while( i++ < pos ){
			p = p._next;
		}
		return p ;
	}
	
	public Sequence flatten(){
		Sequence ans = new Sequence();
		if ( (this._e) instanceof Sequence) {
			ans = ((Sequence)(this._e)).flatten();
		}else{
			ans._e = (this._e);
		}

		if ( null != this._next ) {
			int sz = ans.length() ;
			(ans.index_next(sz-1))._next = this._next.flatten();
		}
		return ans;
	}

	public Sequence copy(){
		Sequence ans = new Sequence();
		Sequence p = this;
		int pos = 0; 
		while( null != p ){
			Element cur = p._e ;
			if( cur instanceof MyChar ){
				MyChar node = new MyChar( ((MyChar)cur).Get() ) ;
				ans.add(node, pos++);
			}else if ( cur instanceof MyInteger ){
				MyInteger node = new MyInteger( ((MyInteger)cur).Get() ) ; 
				ans.add(node, pos++);
			}else{
				Sequence list = new Sequence();
				list = ((Sequence)cur).copy();
				ans.add(list, pos++);
			}
			p = p._next ;
		}
		return ans;
	}



	public Sequence _end_it;
	SequenceIterator begin(){
		MyInteger special = new MyInteger(Integer.MAX_VALUE);
		if ( null == _end_it ) {
			_end_it = new Sequence(special, null);
		}
		add(_end_it, length()) ; 

		SequenceIterator ans = new SequenceIterator();
		ans._cur = this;
		return ans;
	}

	SequenceIterator end(){
		SequenceIterator ans = new SequenceIterator();
		int sz = this.length() ; 
		ans._cur = this.index_next( sz - 1 ) ;
		return ans;
	}



}