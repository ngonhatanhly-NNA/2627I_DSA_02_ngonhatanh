Viết một chương trình nhận input là một mảng gồm các giá trị phân biệt kiểu int sắp xếp giảm dần và xác định xem mảng có chưa một giá trị int cho trước hay không. Bạn chỉ được dùng các phép cộng, trừ và một lượng bộ nhớ phụ là hằng số. Thời gian chạy của chương trình cần tỷ lệ thuận với log N trong trường hợp tồi nhất.

Gợi ý: Thay vì tìm kiếm chia đôi thông thường, hãy sử dụng các số Fibonacci (dãy này cũng tăng theo lũy thừa. Giữ khoảng tìm kiếm hiện hành luôn là [i, i + Fk] và dùng 2 biến để lưu Fk, Fk-1. Tại mỗi bước, tính Fk-2 bằng phép trừ, kiểm tra phần tử có chỉ số i+Fk-2, và chỉnh khoảng tìm kiếm thành [i, i + Fk-2] hoặc [i+Fk-2, i+Fk-2 + Fk-1].)



THay vì minh chia đôi như binary search, thì mình chia thành các đoạn của fibo

xét N = 13, size, lấy fibo >= N -> 13 = 8 + 5 chia đọn thành đoạn 8, và 5 xem nằm ở bên nào, nếu lớn hơn hay nhỏ hơn dihcj sang bỏ đoạn còn lại và 8 thì thàn 5 - 3, 5 thì thành 2 - 3 cứ tương tự cho tường hợp xấu nhatats là đên 0 1 thì đến giá trị cần tìm -> bản hcaats binary search là chia đôi còn này là chia thành các đoạn có tính quy luật 