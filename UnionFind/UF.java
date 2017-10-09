

public class UF implements unionFind {
	public int id[];

	public UF(int n) {
		// TODO Auto-generated constructor stub
		id = new int[n];
		//set id of each object itself
		for(int i=0;i<n;i++){
			id[i] = i;
		}
	}

	@Override
	public void union(final int n,final int m) {
		// TODO Auto-generated method stub
		int nid = id[n];
		int mid = id[m];
		for(int i=0;i<id.length;i++){
			if(id[i]==nid){
				id[i] = mid;
			}
		}
		
	}

	@Override
	public boolean intersected(final int n,final int m) {
		// TODO Auto-generated method stub
		return (id[n]==id[m]);
	}
		
	}



