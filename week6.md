# Đáp án bài tập Quicksort – Mục 2.3

> Các đáp án dưới đây bám theo cách cài đặt `Quick.sort()` trong *Algorithms, 4th Edition* của Sedgewick & Wayne: chọn phần tử đầu làm pivot sau khi bỏ qua bước shuffle, và dùng phương pháp `partition()` hai đầu.

---

## 2.3.2 – Trace Quicksort cho `E A S Y Q U E S T I O N`

Mảng ban đầu:

```text
E A S Y Q U E S T I O N
```

Bỏ qua bước random shuffle.

Các trạng thái của mảng **ngay sau mỗi lần partition**:

| Bước | Pivot | Vị trí pivot | Mảng sau partition |
|---:|:---:|---:|:---|
| 1 | E | 2 | `E A E Y Q U S S T I O N` |
| 2 | E | 1 | `A E E Y Q U S S T I O N` |
| 3 | Y | 11 | `A E E N Q U S S T I O Y` |
| 4 | N | 4 | `A E E I N U S S T Q O Y` |
| 5 | O | 10 | `A E E I N O S S T Q U Y` |
| 6 | Q | 5 | `A E E I N O S S T Q U Y` |
| 7 | S | 7 | `A E E I N O Q S S T U Y` |
| 8 | S | 9 | `A E E I N O Q S S T U Y` |

Cuối cùng:

```text
A E E I N O Q S S T U Y
```

### Cây đệ quy

```text
E
├── A
└── Y
    ├── N
    │   ├── I
    │   └── O
    └── (phần còn lại)
        ├── Q
        └── S
            └── S
```

Ý chính: sau mỗi lần `partition`, pivot được đưa về vị trí cuối cùng của nó; sau đó Quicksort tiếp tục đệ quy trên hai đoạn bên trái và bên phải pivot.

---

## 2.3.3 – Phần tử lớn nhất có thể bị đổi chỗ bao nhiêu lần?

**Đáp án:**

\[
\boxed{\left\lceil\frac{N-1}{2}\right\rceil}
\]

lần.

### Giải thích

Gọi phần tử lớn nhất là `M`.

Trong mỗi lần partition, để `M` tiếp tục bị đổi chỗ, nó phải nằm ở phía trái của đoạn đang xét và được đổi với một phần tử nhỏ hơn ở phía bên phải.

Mỗi lần đổi chỗ như vậy làm cho `M` chuyển sang phía bên phải của đoạn.

Để `M` được đổi chỗ nhiều nhất, ta muốn mỗi lần partition làm kích thước đoạn chứa `M` giảm ít nhất có thể. Khi đó số lần tối đa là:

\[
\boxed{\left\lceil\frac{N-1}{2}\right\rceil}
\]

Ví dụ với `N = 10`:

\[
\left\lceil\frac{10-1}{2}\right\rceil=5
\]

Vậy phần tử lớn nhất có thể bị đổi chỗ tối đa **5 lần**.

---

## 2.3.4 – Sáu mảng độ dài 10 có số phép so sánh lớn nhất

Bỏ qua bước random shuffle. Pivot luôn là phần tử đầu tiên của đoạn.

Muốn đạt worst-case, mỗi lần partition phải tạo ra:

```text
0 phần tử bên trái + N-1 phần tử bên phải
```

hoặc ngược lại.

Khi đó:

\[
C(N)=C(N-1)+(N-1)
\]

suy ra:

\[
C(N)=1+2+\cdots +(N-1)
=\frac{N(N-1)}2
\]

Với `N = 10`:

\[
C(10)=\frac{10\cdot9}{2}=\boxed{45}
\]

### Sáu ví dụ

Tất cả các mảng dưới đây đều có thể tạo ra trường hợp xấu nhất:

```text
1.  1  2  3  4  5  6  7  8  9  10

2.  10  9  8  7  6  5  4  3  2  1

3.  1  10  9  8  7  6  5  4  3  2

4.  10  1  2  3  4  5  6  7  8  9

5.  1  2  10  9  8  7  6  5  4  3

6.  10  9  1  2  3  4  5  6  7  8
```

Lý do: ở mỗi mức đệ quy, phần tử đầu tiên của đoạn hiện tại luôn là phần tử nhỏ nhất hoặc lớn nhất của đoạn đó.

---

## 2.3.5 – Sắp xếp mảng chỉ có hai giá trị

Giả sử mảng chỉ chứa hai giá trị `A` và `B`, với:

```text
A < B
```

Có thể dùng hai con trỏ `lo` và `hi`.

- `i` quét từ trái sang phải.
- Nếu gặp `A` thì đưa về đầu.
- Nếu gặp `B` thì đưa về cuối.
- Mỗi phần tử chỉ cần được xử lý một số lần hữu hạn.

### Pseudocode

```text
lo = 0
hi = N - 1
i = 0

while i <= hi:
    if a[i] == A:
        swap(a[lo], a[i])
        lo++
        i++
    else:
        swap(a[i], a[hi])
        hi--
```

Sau khi kết thúc:

```text
A A A A ... A B B B B ... B
```

### Độ phức tạp

```text
Thời gian: O(N)
Bộ nhớ phụ: O(1)
```

---

## 2.3.7 – Số mảng con kích thước 0, 1 và 2

Với Quicksort trên `N` phần tử có **các giá trị phân biệt**, cần tính số mảng con kích thước:

- 0
- 1
- 2

Gọi lần lượt là:

\[
C_0(N),\quad C_1(N),\quad C_2(N)
\]

Vì vị trí pivot sau partition có thể xuất hiện ở mọi vị trí với xác suất như nhau:

\[
C(N)=\frac{2}{N}\sum_{k=0}^{N-1}C(k)
\]

Từ truy hồi:

\[
C(N)=\frac{N+1}{N}C(N-1)
\]

### Kết quả

Với mảng con kích thước 0:

\[
\boxed{C_0(N)=\frac{N+1}{3}}
\]

Với mảng con kích thước 1:

\[
\boxed{C_1(N)=\frac{N+1}{3}}
\]

Với mảng con kích thước 2:

\[
\boxed{C_2(N)=\frac{N+1}{6}}
\]

với `N` đủ lớn.

### Kết luận

Trung bình:

```text
Số mảng con kích thước 0 ≈ (N + 1) / 3
Số mảng con kích thước 1 ≈ (N + 1) / 3
Số mảng con kích thước 2 ≈ (N + 1) / 6
```

---

## 2.3.8 – Quicksort khi tất cả phần tử bằng nhau

Giả sử:

```text
a[0] = a[1] = ... = a[N-1]
```

Khác với trường hợp các giá trị phân biệt, pivot không tạo ra đoạn rỗng và đoạn `N-1`.

Trong partition, hai con trỏ quét vào giữa và các phần tử bằng pivot được xử lý theo cách khiến mảng được chia thành hai phần có kích thước gần bằng nhau.

Do đó có truy hồi gần dạng:

\[
T(N)=2T(N/2)+\Theta(N)
\]

Suy ra:

\[
\boxed{T(N)=\Theta(N\log N)}
\]

Vì vậy Quicksort trong cách cài đặt này **không bị rơi xuống O(N²)** chỉ vì tất cả phần tử bằng nhau.

---

## 2.3.9 – Quicksort với 2 hoặc 3 giá trị phân biệt

### Trường hợp chỉ có 2 giá trị

Ví dụ:

```text
A A A B B B
```

Nếu pivot là `A`, một phía của phép partition có thể chứa gần như toàn bộ các phần tử `B`, trong khi phía còn lại chứa các phần tử `A`.

Với cách partition của Quicksort cơ bản, các phần tử có cùng giá trị với pivot được xử lý theo cơ chế dừng của hai phép quét.

Kết quả là Quicksort vẫn có thể đạt khoảng:

\[
\boxed{\Theta(N\log N)}
\]

trong trường hợp phân hoạch tương đối cân bằng.

Tuy nhiên, nếu thay đổi cách xử lý phần tử bằng pivot như câu 2.3.11 thì tình hình sẽ khác và có thể trở thành:

\[
\boxed{\Theta(N^2)}
\]

### Trường hợp có 3 giá trị

Với 3 giá trị phân biệt, Quicksort cơ bản không khai thác trực tiếp việc chỉ có 3 giá trị.

Nó vẫn thực hiện các phép partition và đệ quy như bình thường.

Nếu phân hoạch tương đối cân bằng:

\[
\boxed{\Theta(N\log N)}
\]

Một thuật toán 3-way Quicksort sẽ phù hợp hơn nhiều khi có nhiều phần tử trùng nhau.

---

## 2.3.11 – Bỏ qua các phần tử bằng pivot thay vì dừng lại

Giả sử trong `partition`, khi gặp:

```text
a[i] == pivot
```

hoặc:

```text
a[j] == pivot
```

ta **không dừng**, mà tiếp tục quét.

Xét mảng chỉ có một giá trị:

```text
A A A A A A A ... A
```

Ở mỗi lần partition:

- pivot = `A`;
- toàn bộ các phần tử đều bằng pivot;
- hai con trỏ vẫn phải quét qua gần như toàn bộ đoạn;
- sau partition, pivot chỉ loại được khoảng một phần tử khỏi bài toán.

Do đó:

\[
T(N)=T(N-1)+\Theta(N)
\]

Suy ra:

\[
T(N)=\Theta(N^2)
\]

### Tổng quát

Nếu mảng chỉ có một số lượng **hằng số** giá trị phân biệt, ví dụ `k = O(1)`, thì sẽ có rất nhiều phần tử bằng pivot.

Mỗi lần partition vẫn phải quét qua một lượng lớn phần tử bằng pivot.

Vì vậy:

\[
\boxed{T(N)=\Theta(N^2)}
\]

---

## 2.3.13 – Độ sâu đệ quy của Quicksort

Độ sâu phụ thuộc vào cách partition chia mảng.

### Trường hợp tốt nhất

Mỗi lần partition chia mảng gần như làm đôi:

```text
N
├── N/2
└── N/2
```

Do đó:

\[
N \rightarrow \frac N2 \rightarrow \frac N4
\rightarrow \cdots \rightarrow 1
\]

Số mức là:

\[
\boxed{\Theta(\log N)}
\]

Nếu tính số lần gọi hàm bao gồm cả lời gọi ban đầu và các lời gọi đến mảng con kích thước 0/1, có thể biểu diễn xấp xỉ:

\[
\boxed{\lfloor\log_2N\rfloor+1}
\]

tùy quy ước đếm depth.

---

### Trường hợp xấu nhất

Mỗi lần partition chỉ tách được một phần tử:

```text
N
├── N-1
│   ├── N-2
│   │   ├── ...
```

Khi đó:

\[
N\rightarrow N-1\rightarrow N-2\rightarrow\cdots\rightarrow1
\]

Độ sâu:

\[
\boxed{\Theta(N)}
\]

Nếu tính số mức đệ quy của các đoạn không rỗng thì tối đa khoảng:

\[
\boxed{N}
\]

---

### Trường hợp trung bình

Với pivot được chọn ngẫu nhiên và các phần tử phân biệt, chiều cao cây đệ quy trung bình là:

\[
\boxed{\Theta(\log N)}
\]

---

## Tổng hợp nhanh

| Câu | Đáp án chính |
|---|---|
| **2.3.2** | `A E E I N O Q S S T U Y` |
| **2.3.3** | Phần tử lớn nhất bị đổi chỗ tối đa \(\lceil(N-1)/2\rceil\) lần |
| **2.3.4** | Worst-case: \(\frac{N(N-1)}2\), với `N=10` là **45** phép so sánh |
| **2.3.5** | Dùng 2 con trỏ, thời gian **O(N)** |
| **2.3.7** | \(C_0=C_1=(N+1)/3,\ C_2=(N+1)/6\) |
| **2.3.8** | Tất cả bằng nhau: **Θ(N log N)** với partition cơ bản |
| **2.3.9** | 2/3 giá trị: cần chú ý các phần tử trùng nhau; 3-way partition hiệu quả hơn |
| **2.3.11** | Bỏ qua các phần tử bằng pivot → **Θ(N²)** với số giá trị phân biệt là hằng số |
| **2.3.13** | Tốt nhất **Θ(log N)**, xấu nhất **Θ(N)**, trung bình **Θ(log N)** |

