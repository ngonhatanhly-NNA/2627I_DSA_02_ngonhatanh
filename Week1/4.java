// 0: 0, 1, 2, 3  	size: 4
// 4: 4 5 6 7  		size: 4			size: 1
// ?: 8 9 			size: >=2


// Loại 1, 2, 3, 5,6, 7, 9 do đã là con của các root khác -> còn lại 0, 4, 8
// TH 8: Hợp lệ
// TH 4: gốc 8 < gốc 4 -> Hợp lệ
// TH 0: gốc 8 < gốc 0 -> Hợp lệ