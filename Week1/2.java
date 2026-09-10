// a. Chứa 1 thành phần liên thông, các phần từ đều được liên kết với nhau qua 0
// b. với mỗi union(0, x) sẽ chạy O(n) lần, -> với n - 1 lần union thì cần n(n-1)/2 ~ O(n^2) lần cập nhật mảng
// c. Mỗi lần truy cập thuật toán là n - 1 lần, mỗi lần cập nhật là n - 1  -> tổng số lần là  2(n - 1) + 1 -> O(n)
// d. Do 0 là root gốc của tất cả các val nên dừng ngay tại find(0) chỉ sau 1 lần truy cập mảng