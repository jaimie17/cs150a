from longest_match import longest_match
from nfa2dfa import nfa2dfa
from tokenizer import tokenizer

dfa1 = {'start':0,'final':{0},'edges':{(0,1,'a'),(1,0,'b'),(1,0,'c')}}
dfa2 = {'start':0,'final':{0,1},'edges':{(0,1,'a'),(1,0,'b'),(1,0,'c')}}

print("1. Testing longest_match: input with prefix match")
# Test longest_match
# Test input with prefix match
assert longest_match(dfa1, 'abcdef') == ('ab', 0)

print("2. Testing longest_match: empty input.")
# Test empty input
assert longest_match(dfa1, '') == ('', -1)

print("3. Testing longest_match: no matches.")
# Test no matches
assert longest_match(dfa1, '1223') == ('', -1)

print("4. Testing longest_match: full string match.")
# Test full string match
assert longest_match(dfa1, 'ababac') == ('ababac', 0)

print("5. Testing longest_match: multiple matches.")
# Test multiple matches
assert longest_match(dfa2, 'ababac') == ('ababac', 0)

print("-------------------------------------")

print("Testing tokenizer: ")
# Test tokenizer
print("1. Testing tokenizer: input with one match.")
# Test input with one match
assert tokenizer(dfa1, "abcdef") == [('ab', 0), ('c', -1), ('d', -1), ('e', -1), ('f', -1)]

print("2. Testing tokenizer: empty input.")
# Test empty input
assert tokenizer(dfa1, "") == []

print("3. Testing tokenizer: no matches.")
# Test full string match
assert tokenizer(dfa1, "ababac") == [("ababac", 0)]

print("4. Testing tokenizer: multiple matches.")
# Test multiple matches
assert tokenizer(dfa2, "ababac") == [("ababac", 0)]

print("-------------------------------------")

print("Testing nfa2dfa: ")
# Test nfa2dfa

print("1. Testing nfa2dfa: input with one match.")
# Test input with one match
nfa = {
        'alphabet': {'a', 'b'},
        'states': {0, 1, 2},
        'start': 0,
        'final': {2},
        'edges': {(0, 1, 'a'), (1, 2, 'b')}
    }
dfa = nfa2dfa(nfa) # Convert the NFA to a DFA
expected_dfa = { # Define the expected DFA
    frozenset({0}): {'a': frozenset({1})},
    frozenset({1}): {'b': frozenset({2})},
    frozenset({2}): {}
}
assert dfa == expected_dfa, f"Expected {expected_dfa}, but got {dfa}" # Assert that the converted DFA matches the expected DFA

print("2. Testing nfa2dfa: empty input.")
# Test empty input
nfa = {
        'alphabet': {'a', 'b'},
        'states': {0, 1, 2},
        'start': 0,
        'final': {2},
        'edges': {(0, 1, 'a'), (1, 2, 'b')}
    }
dfa0 = nfa2dfa(nfa) # Convert the NFA to a DFA
expected_dfa0 = { # Define the expected DFA
    frozenset({0}): {'a': frozenset({1})},
    frozenset({1}): {'b': frozenset({2})},
    frozenset({2}): {}
}
assert dfa0 == expected_dfa0, f"Expected {expected_dfa0}, but got {dfa0}" # Assert that the converted DFA matches the expected DFA