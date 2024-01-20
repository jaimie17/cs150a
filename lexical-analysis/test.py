from longest_match import longest_match
from nfa2dfa import nfa2dfa
from tokenizer import tokenizer

dfa1 = {'start':0,'final':{0},'edges':{(0,1,'a'),(1,0,'b'),(1,0,'c')}}
# Test input with prefix match
assert longest_match(dfa1, 'abcdef') == ('ab', 0)

# Test empty input
assert longest_match(dfa1, '') == ('', -1)

# Test no matches
assert longest_match(dfa1, '1223') == ('', -1)

# Test case 7: Basic input
nfa = {
    "start_state": 0,
    "accept_states": [2],
    "transitions": {
        0: {"a": [1]},
        1: {"b": [2]},
    },
    "alphabet": ["a", "b"],
}
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
assert nfa2dfa(nfa) == dfa

# Test case 8: Empty input
nfa = {
    "start_state": 0,
    "accept_states": [2],
    "transitions": {
        0: {"a": [1]},
        1: {"b": [2]},
    },
    "alphabet": ["a", "b"],
}
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
assert nfa2dfa(nfa) == dfa

# Test case 9: No matches
nfa = {
    "start_state": 0,
    "accept_states": [2],
    "transitions": {
        0: {"a": [1]},
        1: {"b": [2]},
    },
    "alphabet": ["a", "b"],
}
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
assert nfa2dfa(nfa) == dfa

# Test case 10: Partial match
nfa = {
    "start_state": 0,
    "accept_states": [2],
    "transitions": {
        0: {"a": [1]},
        1: {"b": [2]},
    },
    "alphabet": ["a", "b"],
}
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
assert nfa2dfa(nfa) == dfa

# Test case 11: Multiple matches
nfa = {
    "start_state": 0,
    "accept_states": [2],
    "transitions": {
        0: {"a": [1]},
        1: {"b": [2]},
    },
    "alphabet": ["a", "b"],
}
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
assert nfa2dfa(nfa) == dfa

# Test case 12: Case-insensitive match
nfa = {
    "start_state": 0,
    "accept_states": [2],
    "transitions": {
        0: {"a": [1]},
        1: {"b": [2]},
    },
    "alphabet": ["a", "b"],
}
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
assert nfa2dfa(nfa) == dfa

# Test case 13: Basic input
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
tokens = [("ab", 2)]
assert tokenizer(dfa, "ab") == tokens

# Test case 14: Empty input
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
tokens = []
assert tokenizer(dfa, "") == tokens

# Test case 15: No matches
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
tokens = []
assert tokenizer(dfa, "xy") == tokens

# Test case 16: Partial match
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
tokens = [("ab", 2)]
assert tokenizer(dfa, "ab") == tokens

# Test case 17: Multiple matches
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
tokens = [("ab", 2), ("ab", 2), ("ab", 2)]
assert tokenizer(dfa, "ababab") == tokens

# Test case 18: Case-insensitive match
dfa = {
    0: {"a": 1},
    1: {"b": 2},
    2: {},
}
tokens = [("AB", 2)]
assert tokenizer(dfa, "AB") == tokens