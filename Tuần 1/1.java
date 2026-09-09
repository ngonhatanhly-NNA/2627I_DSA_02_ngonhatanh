// size n: 0 1 2 3 4 5 6 7 8 9
// union p q: thỏa mãn có liên kết các phần từ, hàm union hợp lệ với quickfind, 
// nhưng hàm find sẽ gây sai xót do chưa thể tham chiếu đến leader gốc 

class Solution {
	public void union (int p, int q){
		for (int i = 0; i < leader.length; i++){
			if (leader[i] == leader[p]){
				leader[i] = leader[q];
			}
		}
	}
	
	public void find(int p){
		return leader[i]	
	}
	
	public void connected(int p, int q){
		return find(p) == find(q);
	}
	
	public void unionFix (int p, int q){
		int rootP = leader[p];
		int rootQ = leader[q];
		
		for (int i = 0; i < leader.length; i++){
			if (leader[i] == rootP){
				leader[i] = rootQ;
			}
		}
	}
}


// Lỗi: trong hàm union, nếu p là thứ tụ root cuối cùng thì thuật toan sẽ chạy thành công, nhưng nếu nó cùng root 
// với 1 số node có thứ tự ở sau, thì khi này, i đã chạy qua p -> leader p bị thay đổi nhưng các gốc sau chưa bị đổi thành qua
// dẫn đến việc bị ngắt liên kết 

// VD: root -> 0 0 2 | union 0 2 | code gốc: 2 0 2 -> k thể gắn 0 thứ 2  -> 2 do p đã bị đổi
// 