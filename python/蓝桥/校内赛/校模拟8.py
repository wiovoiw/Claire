

def digit_product(num):
    while num >= 10:
        product = 1
        for digit in str(num):
            if digit != '0':
                product *= int(digit)
        print(product)
        num = product

num = int(input())
digit_product(num)
