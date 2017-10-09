

public class lazy implements unionFind {
	public int id[];
	
	public lazy(int n){
		id = new int[n];
		for(int i=0;i<n;i++){
			id[i]=i;
		}
	}
	private int root(int n){
		
		while(id[n]!=n){
			n = id[n];
			
		}
		return n;
		
	}
	@Override
	public void union(int n, int m) {
		// TODO Auto-generated method stub
		int rootn = root(n);
		int rootm = root(m);
		id[rootn] = rootm;
		
	}

	@Override
	public boolean intersected(int n, int m) {
		// TODO Auto-generated method stub
		int rootn = root(n);
		int rootm = root(m);
		return (rootn==rootm);
	}

}
