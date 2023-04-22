def get_frequencies(line):
  frequencies = dict()
  for char in line:
    ascii_code = ord(char)
    if ascii_code in frequencies.keys():
      frequencies[ascii_code] += 1
    else:
      frequencies[ascii_code] = 1
  return frequencies

def get_sorted_frequencies_by_frequency(frequencies):
  sorted_frequencies = dict()
  for ascii_code, frequency in frequencies.items():
    if frequency in sorted_frequencies.keys():
      sorted_frequencies[frequency].append(ascii_code)
    else:
      sorted_frequencies[frequency] = [ascii_code]
  return sorted(sorted_frequencies.items(), key=lambda item: item[0])

def sort_frequencies_by_higher_ascii_code(sorted_frequencies):
  for i in range(len(sorted_frequencies)):
    sorted_frequencies[i][1].sort(reverse=True)

def print_sorted_frequencies(sorted_frequencies):
  for frequency, ascii_codes in sorted_frequencies:
    for ascii_code in ascii_codes:
      print(ascii_code, frequency)

is_first_input = True
while True:
  try:
    line = input()
    if not is_first_input:
      print()
    frequencies = get_frequencies(line)
    sorted_frequencies = get_sorted_frequencies_by_frequency(frequencies)
    sort_frequencies_by_higher_ascii_code(sorted_frequencies)
    print_sorted_frequencies(sorted_frequencies)
    is_first_input = False
  except EOFError:
    break