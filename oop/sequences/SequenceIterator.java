class SequenceIterator {
	public Sequence _cur;
	public boolean equal (SequenceIterator other){
		if( this._cur._e == other._cur._e ){
			return true;
		}else{
			return false;
		}
	}

	public SequenceIterator advance(){
		this._cur = this._cur._next;
		return this;
	}

	public Element get(){
		return this._cur._e ; 
	}

}