// 1. Vong lặp chạy từ 10 -> n + 5 => ((n + 5) - 10) / 2 ~ n / 2 - Tidle: n/2 - Theta: O(n)
// 2. vòng lặp chạy theo i *= 2 -> Tilde : logx(n^3) = 3logx(n) - Theta: O(logn)
// 3. Tidle: 100n - O(n)
// 4. Tilde: sprt(n)*log3(n) - O(sprt(n).logn)
// 5. Tilde: n * log(n) - O(nlogn)/
// 6. Tilde: (n(n+1)/2)*100*n = 50n^2(n+1) -> O(n^3)