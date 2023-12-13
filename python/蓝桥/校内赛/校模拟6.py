x = int(input())
# result = x[1:] + x[:1]
result = (x % 100000) * 10 + x//100000
# print(int(result))
print(result)