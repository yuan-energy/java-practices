class Matrix extends Sequence {
	public int _Nrow; 
	public int _Ncol; 

	public Matrix(int rowsize, int colsize){
		_Nrow = rowsize ;
		_Ncol = colsize ;
		int id = 0; 
		for (int i = 0; i < _Nrow ; i++ ) {
			for ( int j = 0 ; j < _Ncol ; j++ ) {
				MyInteger node =  new MyInteger() ; 
				super.add(node, id++);
			}
		}
	}

	void Set( int row, int col, int value){
		int id = _Ncol * row + col ; 
		Element node = super.index(id);
		((MyInteger)node).Set(value) ; 
	}

	int Get( int row, int col ){
		int id = _Ncol * row + col ; 
		Element node = super.index(id);
		return ((MyInteger)node).Get();
	}

	Matrix Sum(Matrix mat){
		Matrix ans = new Matrix( _Nrow, _Ncol );
		for ( int r = 0 ; r < this._Nrow ; r++ ) {
			for ( int c = 0 ; c < this._Ncol ; c++ ) {
			    int sum =  this.Get(r,c) + mat.Get(r,c) ;
				ans.Set(r,c,sum);
			}
		}
		return ans;
	}

	Matrix Product(Matrix mat){
		if ( _Ncol != mat._Nrow) {
			System.out.println("Matrix dimensions incompatible for Product");
			System.exit(0);
		}
		Matrix ans = new Matrix( _Nrow, mat._Ncol );
		for ( int r = 0 ; r < this._Nrow ; r++ ) {
			for ( int c = 0 ; c < mat._Ncol ; c++ ) {
				int sum = 0 ;
				for ( int i = 0 ; i < this._Ncol ; i++ ) {
					sum = sum + ( this.Get(r,i) * mat.Get(i,c) );
				}
				ans.Set(r,c,sum);
			}
		}
		return ans;
	}
	public void Print(){
		int id = 0; 
		for (int i = 0 ; i < _Nrow ; i++ ) {
			System.out.print("[ ");
			for (int j = 0 ; j< _Ncol ; j++ ) {
				Element node = super.index(id++);
				((MyInteger)node).Print();
				System.out.print(" ");
			}
			System.out.print("]\n");
		}
	}
}