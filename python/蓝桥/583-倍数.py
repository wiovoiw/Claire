count = 0
for i in range(1, 2021):
    if (i % 4 == 0) and (i % 6 == 0):
        count += 1
print(count)
