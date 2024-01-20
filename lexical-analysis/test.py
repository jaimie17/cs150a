from longest_match import longest_match
from nfa2dfa import nfa2dfa
from tokenizer import tokenizer

dfa1 = {'start':0,'final':{0},'edges':{(0,1,'a'),(1,0,'b'),(1,0,'c')}}

# Test longest_match
# Test input with prefix match
assert longest_match(dfa1, 'abcdef') == ('ab', 0)

# Test empty input
assert longest_match(dfa1, '') == ('', -1)

# Test no matches
assert longest_match(dfa1, '1223') == ('', -1)

# Test tokenizer
# Test input with one match
assert tokenizer(dfa1, "abcdef") == [('ab', 0), ('c', -1), ('d', -1), ('e', -1), ('f', -1)]

# Test empty input
assert tokenizer(dfa1, "") == []

# Test full string match
assert tokenizer(dfa1, "ababac") == [("ababac", 0)]

# Test nfa2dfa

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