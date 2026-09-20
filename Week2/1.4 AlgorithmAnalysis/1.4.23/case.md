1.4.23. Binary search for a fraction. Để tìm một phân số p/q sao cho 0 < p < q < N. 
Hãy thiết kế một hàm sử dụng các câu hỏi dạng “số đó có nhỏ hơn x không?” và sử dụng số câu hỏi là hàm loại logN. 
Gợi ý: hai phân số có mẫu số nhỏ hơn N không thể có hiệu lớn hơn 1/N2.


Theo gợi ý: 2 phân số có mẫu số nhỏ hơn N, k thể có hiệu lớn hơn 1/N^2
-> |p/q - r/s| = |pq-rs|qs, 2 phân số kahcs nhau -> pq - rs > 1 vì q, s < N2
-> qs < N^2, 