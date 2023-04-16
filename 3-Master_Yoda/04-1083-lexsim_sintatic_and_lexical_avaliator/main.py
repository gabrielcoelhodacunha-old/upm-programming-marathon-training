OPERATORS = {
  "(": 0, "|": 1, ".": 2, ">": 3, "<": 3, "=": 3,
  "#": 3, "+": 4, "-": 4, "*": 5, "/": 5, "^": 6
}
X = "X"

def has_lexical_error(token):
  if (token.isalnum()
      or token in "()"
      or token in OPERATORS.keys()):
    return False
  return True

def is_operator_between_values(expression_evaluator):
  return (expression_evaluator[-1].isalnum()
          and expression_evaluator[-2] in OPERATORS.keys()
          and expression_evaluator[-3].isalnum())

def is_value_between_parenthesis(expression_evaluator):
  return (expression_evaluator[-1] == ")"
          and expression_evaluator[-2].isalnum()
          and expression_evaluator[-3] == "(")

def evaluate_without_precedence(token, expression_evaluator):
  expression_evaluator.append(token)
  while (len(expression_evaluator) > 2
        and (is_operator_between_values(expression_evaluator)
              or is_value_between_parenthesis(expression_evaluator))):
    [expression_evaluator.pop() for _ in range(3)]
    expression_evaluator.append(X)

def has_syntactical_error(expression_evaluator):
  if len(expression_evaluator) == 1 and expression_evaluator[0].isalnum():
    expression_evaluator.pop()
  return len(expression_evaluator) > 0

def convert_to_postfix(token, expression_in_postfix, operations):
  if token.isalnum():
    expression_in_postfix.append(token)
  elif token == "(":
    operations.append(token)
  elif token == ")":
    last_token = operations.pop()
    while last_token != "(":
      expression_in_postfix.append(last_token)
      last_token = operations.pop()
  else:
    while (len(operations) > 0
            and OPERATORS[operations[-1]] >= OPERATORS[token]):
      expression_in_postfix.append(operations.pop())
    operations.append(token)

def empty_operations(operations, expression_in_postfix):
  while len(operations) > 0:
    expression_in_postfix.append(operations.pop())


while True:
  try:
    expression = input()
    expression_evaluator = []
    expression_in_postfix = []
    operations = []
    for token in expression:
      if has_lexical_error(token):
        raise ValueError
      evaluate_without_precedence(token, expression_evaluator)
      convert_to_postfix(token, expression_in_postfix, operations)
    empty_operations(operations, expression_in_postfix)
    if has_syntactical_error(expression_evaluator):
      raise IndexError
    print(''.join(expression_in_postfix))
  except ValueError:
    print("Lexical Error!")
  except IndexError:
    print("Syntax Error!")
  except EOFError:
    break