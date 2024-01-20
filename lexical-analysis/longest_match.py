'''Modifies the accepts function to longest_match function, which returns the longest prefix of chars accepted by the DFA'''

def edge(dfa,state,c):
    ''' return the next state, or 'error' if there is no next state'''
    next_states = [e[1] for e in dfa['edges'] if e[0]==state and e[2]==c]
    if len(next_states)== 0:
        return 'error' #returns ‘error’ only when there are no valid transitions,
    elif len(next_states) > 1:
        #  if there are multiple transitions for the same character from the same state, it raises a ValueError
        raise ValueError(f"Invalid DFA: multiple transitions for character '{c}' from state {state}")
    else:
        return next_states[0]
    
def accepts(dfa,chars):
    ''' return True if the dfa accepts the string of chars '''
    state = dfa['start']
    for i in range(len(chars)):
        c = chars[i]
        state1 = edge(dfa,state,c)
        print('traverse edge',state,c,state1)
        if state1=='error':
            return False
        else:
            state=state1
    return state in dfa['final']

def longest_match(dfa,chars):
    ''' return the longest prefix of chars accepted by the dfa and the accepting state'''
    if not chars:
        return ('',-1)
    state = dfa['start']
    for i in range(len(chars)):
        c = chars[i]
        state1 = edge(dfa,state,c)
        print('traverse edge',state,c,state1)
        if state1=='error':
            if state in dfa['final'] and chars[:i] != '':
                return (chars[:i],state)
            else:
                return ('',-1)
        else:
            state=state1
    return (chars,state)

if __name__ == "__main__":
    '''represent a dfa by a dictionary giving the start state, final states, and a set of edges, then run longest_match on the dfa and a string'''
    dfa1 = {'start':0,'final':{0},'edges':{(0,1,'a'),(1,0,'b'),(1,0,'c')}}
    print(longest_match(dfa1,'abcdef'))
    