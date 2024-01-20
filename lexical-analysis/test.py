import longest_match
import nfa2dfa
import tokenizer

# Test case 1: Basic input
assert longest_match("abcdef", ["ab", "cd", "ef"]) == ["ab", "cd", "ef"]

# Test case 2: Empty input
assert longest_match("", ["ab", "cd", "ef"]) == []

# Test case 3: No matches
assert longest_match("abcdef", ["xy", "zz"]) == []

# Test case 4: Partial match
assert longest_match("abcdef", ["ab", "cd", "efg"]) == ["ab", "cd"]

# Test case 5: Multiple matches
assert longest_match("ababab", ["ab"]) == ["ab", "ab", "ab"]

# Test case 6: Case-insensitive match
assert longest_match("ABCDEF", ["ab", "cd", "ef"], case_sensitive=False) == ["AB", "CD", "EF"]

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