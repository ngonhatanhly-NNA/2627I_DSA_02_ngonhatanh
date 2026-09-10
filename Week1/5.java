// Không thể xây dựng biểu diễn parent-link từ từ weighted quick union, '

// Khi gộp, gộp theo quy tắc quy về cái có size lớn hơn, ta có trước khi union(0, 5):
// 0: 4 + 2 (root 6) + 1 (root 3)
// 5: 3 + 1 (root 7)

// -> khi nối union, thì 5 phải có roots là 0 mà trong biểu diễn 0 là con của 5 -> biểu dienx k hợp lệ