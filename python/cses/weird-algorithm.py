# https://cses.fi/problemset/task/1068

n = int(input())
print(n, end=' ')
while n > 1:
    n = n // 2 if n % 2 == 0 else (n * 3) + 1
    print(n, end=' ')
