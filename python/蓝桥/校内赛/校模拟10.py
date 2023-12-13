n, k = map(int, input().split())
arr = list(map(int, input().split()))

max_sum = float('-inf')
start = 0
for i in range(n - k + 1):
    current_sum = sum(arr[i:i+k])
    if current_sum > max_sum:
        max_sum = current_sum
        start = i

print(arr[start+1:start+k])
