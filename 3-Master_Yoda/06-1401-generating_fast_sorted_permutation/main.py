from itertools import permutations

strings_to_read = int(input())
while strings_to_read > 0:
  string = input()
  for permutation in sorted(set(permutations(string))):
    print(''.join(permutation))
  print()
  strings_to_read -= 1