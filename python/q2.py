def calculate_number_of_characters(width_per_character, total_width):
    return total_width // width_per_character

width_per_character = 10
total_width = 30 * 10  # 30个字 * 10像素/字

number_of_characters = calculate_number_of_characters(width_per_character, total_width)

print("一行可以放下 {} 个字。".format(number_of_characters))

