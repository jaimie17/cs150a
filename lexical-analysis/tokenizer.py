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

def main():
        dfa1 = {'start':0,'final':{0},'edges':{(0,1,'a'),(1,0,'b'),(1,0,'c')}}
        tokens = tokenizer(dfa1,'ababac')
        print(tokens)

main()