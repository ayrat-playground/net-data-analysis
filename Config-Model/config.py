__author__ = 'ayrat'

import random as rnd
import matplotlib.pyplot as plt
from networkx import Graph, draw
from itertools import repeat


def configuration_model_from_degree_sequence(k):
    assert ((sum(k) % 2) == 0)
    G = Graph()
    G.add_nodes_from(range(len(k)))
    stubs = [i for i in range(len(k)) for _ in repeat(None, k[i])]
    rnd.shuffle(stubs)
    for (i, j) in zip(stubs[0:: 2], stubs[1:: 2]):
        G.add_edge(i, j)

    return G


k = [2, 3, 2, 3, 1, 1]

G = configuration_model_from_degree_sequence(k)

# k = [ 5, 5, 5, 5,5, 3,5, 5, 5, 5,5, 3,5, 5, 5, 5,5, 3,5, 5, 5, 5,5, 3,5, 5, 5, 5,5, 3,5, 5, 5, 5,5, 3]

G = configuration_model_from_degree_sequence(k)

draw(G)

plt.show()

print (G)
