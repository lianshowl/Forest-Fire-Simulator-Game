// sturdy tree is harder to burn-- takes 2 tries

class SturdyTree extends Tree{

	SturdyTree(int x){
		super(x);
	}

	int type = 2;
	void ignite() {
		if(this.status==2){
			this.status = 1;
			this.standing = true;
			this.burning = true;
			this.stump = false;
		}
	}

	void update() {
		if(this.status == 1){
			this.status = 0;
			this.standing = false;
			this.burning = false;
			this.stump = true;
		}
	}

	public boolean getStump(){
		boolean s = false;
		if(this.status==0){
			s = true;
		}
	return s;
	}

	public int getType(){
		return 2;
	}

}