# https://cses.fi/problemset/task/1083

n = int(input())
nums = list(map(int, input().split()))
expected_sum = int(((1 + n) / 2) * n)
print(expected_sum - sum(nums))
