// a. Chứa 1 thành phần liên thông, các phần từ đều được liên kết với nhau qua 0
// b. với mỗi union(0, x) sẽ chạy O(n) lần, -> với n - 1 lần union thì cần n(n-1) ~ O(n^2) lần cập nhật mảng
// c. O(1)
// d. O(logn) thao táo của cả find và union