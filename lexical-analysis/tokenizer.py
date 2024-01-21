''' 
The tokenizer function uses the longest_match function to find the longest prefix of the remaining characters that is accepted by the DFA. 
If no prefix is accepted, it adds the first character to the list of tokens with a state of -1 and removes it from the characters. 
If a prefix is accepted, it adds the prefix and the accepting state to the list of tokens and removes the prefix from the characters. 
It continues this process until all characters have been tokenized.
'''

from longest_match import longest_match

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

if __name__ == "__main__":
        dfa1 = {'start':0,'final':{0},'edges':{(0,1,'a'),(1,0,'b'),(1,0,'c')}}
        tokens_dfa1 = tokenizer(dfa1, 'abc')
        print(tokens_dfa1) 
        
        print("-------------------------------------")
        
        dfa2 = {'start': 0, 'final': {0, 1}, 'edges': {(0, 1, 'a'), (1, 0, 'b'), (1, 0, 'c')}}
        tokens_dfa2 = tokenizer(dfa2, 'cbaccabcbabbac')
        print(tokens_dfa2) 

        print("-------------------------------------")

        dfa3 = {'start': 0, 'final': {0, 1}, 'edges': {(0, 1, 'a'), (1, 0, 'b'), (1, 0, 'c'), (0, 2, 'a'), (2, 0, 'b'), (2, 0, 'c')}}
        tokens_dfa3 = tokenizer(dfa3, 'cbaccabcbabbac')
        print(tokens_dfa3) # should give a ValueError: Invalid DFA: multiple transitions for character 'a' from state 0
