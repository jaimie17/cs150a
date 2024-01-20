''' 
The tokenizer function uses the longest_match function to find the longest prefix of the remaining characters that is accepted by the DFA. 
If no prefix is accepted, it adds the first character to the list of tokens with a state of -1 and removes it from the characters. 
If a prefix is accepted, it adds the prefix and the accepting state to the list of tokens and removes the prefix from the characters. 
It continues this process until all characters have been tokenized.
'''

import longest_match

def tokenizer(dfa, chars):
    tokens = []
    while chars:
        string, state = longest_match(dfa, chars)
        if state == -1:
            tokens.append((chars[0], -1))
            chars = chars[1:]
        else:
            tokens.append((string, state))
            chars = chars[len(string):]
    return tokens