Gọi:

$$ m=\min(a) $$ $$ M=\max(a) $$

Với mọi cặp a[i], a[j], ta có:

$$ m\leq a[i],a[j]\leq M $$

Suy ra:

$$ -M\leq a[i]-a[j]\leq M-m $$

Cách viết trên chưa đủ chính xác nếu m có thể âm, nên ta xét trực tiếp:

Vì cả hai số đều nằm trong đoạn [m, M], khoảng cách giữa chúng không thể vượt quá độ dài đoạn:

$$ |a[i]-a[j]|\leq M-m $$

Mặt khác, cặp (m, M) tồn tại trong mảng và có:

$$ |M-m|=M-m $$

Do đó:

$$ \boxed{\max_{i,j}|a[i]-a[j]|=M-m} $$

Thuật toán trả về đúng một farthest pair.