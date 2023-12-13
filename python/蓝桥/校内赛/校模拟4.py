def count_divisors(num):
    count = 0
    for i in range(1, int(num**0.5) + 1):
        if num % i == 0:
            count += 1
            if i != num // i:
                count += 1
    return count

# 给定的数
numbers = [
    393353, 901440, 123481,
    850930, 423154, 240461,
    373746, 232926, 396677,
    486579, 744860, 468782,
    941389, 777714, 992588,
    343292, 385198, 876426,
    483857, 241899, 544851,
    647930, 772403, 109929,
    882745, 372491, 877710,
    340000, 659788, 658675,
    296521, 491295, 609764,
    718967, 842000, 670302
]

max_divisors = 0
max_divisors_number = 0

# 遍历每个数，计算约数个数并更新最大值
for num in numbers:
    divisors_count = count_divisors(num)
    if divisors_count > max_divisors:
        max_divisors = divisors_count
        max_divisors_number = num

print(max_divisors_number)
print(max_divisors)