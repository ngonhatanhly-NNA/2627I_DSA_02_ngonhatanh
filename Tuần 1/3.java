// Cặp (0, 4) có khả năng được nối gần đây nhất, 2 cây trước khi gộp là gốc 0[0, 1, 2, 3] và gốc 4 [4, 5, 6, 7]
// Cả 2 cây đều mang kích thước 4 và chiều cao 2, 4 >= 2^2, gốc 4 trỏ về 0 -> tạo ra kích thước 8, chiều cao tăng thành max(2, 2+1) = 3

// Quy luật weighted quick union, đê xây được 3 tầng cần 2^3 nút -> nếu (6, 4) -> trước đó chỉ có 7 nút 3 tầng 
// -> k thỏa mãn