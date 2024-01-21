'''The nfa2dfa function converts an NFA to a DFA. '''

def epsilon_edge(nfa, S):
    ''' returns all states reachable from a state in S by an edge labeled epsilon '''
    return {e[1] for e in nfa['edges'] if e[0] in S and e[2] == 'epsilon'}

def closure(nfa, S):
    ''' returns set of states reachable from a state in S following epsilon edges'''
    T = S
    next_states = epsilon_edge(nfa, S)
    print('epsilon edges', T, 'epsilon', T.union(next_states))
    while not next_states.issubset(T):
        T = T.union(next_states)
        next_states = epsilon_edge(nfa, T)
        print('epsilon edges', T, 'epsilon', T.union(next_states))
    return T

def dfa_edge(nfa, s, c):
    ''' returns closure of all states reachable from a state in s by an edge labeled c '''
    s1 = frozenset({e[1] for e in nfa['edges'] if e[0] in s and e[2] == c})
    s2 = closure(nfa, s1)
    return s2

def is_final(nfa, state):
    ''' return True if the nfa state is a final state '''
    return len(state.intersection(nfa['final'])) > 0

def nfa_accepts(nfa, chars):
    ''' returns True if the nfa accepts the string of chars '''
    state = closure(nfa, {nfa['start']})
    for c in chars:
        state1 = state
        state = dfa_edge(nfa, state, c)
        print('dfa_edge', state1, c, state)
    return is_final(nfa, state)

def nfa2dfa(nfa):
    dfa = {}  # DFA transitions
    start_state = closure(nfa, frozenset({nfa['start']}))  # Start state of DFA
    dfa[start_state] = {}  # Initialize DFA with start state

    unmarked_states = [start_state]  # Unmarked states of DFA
    while unmarked_states:
        current_state = unmarked_states.pop(0)  # Get next unmarked state
        for symbol in nfa['alphabet']:
            next_state = dfa_edge(nfa, current_state, symbol)  # Move to next state
            if next_state:
                next_state = closure(nfa, next_state)  # Epsilon closure
                if next_state not in dfa:
                    dfa[next_state] = {}  # Add new state to DFA
                    unmarked_states.append(next_state)  # Mark new state
                dfa[current_state][symbol] = next_state  # Add transition

    return dfa

if __name__ == "__main__":
    nfa1 = {'alphabet': {'a', 'b', 'c'}, 'start': 0, 'final': {0, 2}, 'edges': {(0, 1, 'a'), (1, 0, 'b'), (1, 0, 'c'), (1, 2, 'b'), (2, 0, 'c')}}
    dfa1 = nfa2dfa(nfa1)
    print(dfa1)
