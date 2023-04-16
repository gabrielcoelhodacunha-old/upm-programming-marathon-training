from math import ceil

def split_input_and_convert_to_int():
  return [ int(i) for i in input().split(" ") ]

def calculate_average(array):
  return sum(array) / len(array)

def get_unique_values(array):
  return set(array)

current_followers, minimum_followers_required = split_input_and_convert_to_int()
subscribers_per_day = split_input_and_convert_to_int()

average_subscribers = 0
days_to_reach_minimum_followers_required = 0
while (len(get_unique_values(subscribers_per_day)) != 1
       and current_followers < minimum_followers_required):
  average_subscribers = ceil(calculate_average(subscribers_per_day))
  subscribers_per_day.append(average_subscribers)
  subscribers_per_day.pop(0)
  days_to_reach_minimum_followers_required += 1
  current_followers += average_subscribers

if (current_followers < minimum_followers_required):
  followers_to_reach_minimum_required = minimum_followers_required - current_followers
  average_subscribers = ceil(calculate_average(subscribers_per_day))
  days_to_reach_minimum_followers_required += ceil(followers_to_reach_minimum_required / average_subscribers)

print(days_to_reach_minimum_followers_required)