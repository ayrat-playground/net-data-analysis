from math import *
import random
from numpy import *
graph=[]

num_nodes=1000
total_degree=0
seed_size=3
degree_list=[]
fixed_hand=2
outfile=open("barabasi_degree_ji.txt","w")

a=[]
for i in range(seed_size):       #a complete graph
    for j in range(seed_size):
        if i!=j:
            a.append(j)
            total_degree+=1
    graph.append(a)
    degree=len(a)
    degree_list.append(degree)
    a=[]
random.randint(1,total_degree)
sum=0

print range(seed_size,num_nodes)

for current_node in range(seed_size,num_nodes):    #barabasi generate

    nodes_to_connected=[]
    while len(nodes_to_connected)<fixed_hand:
        rand=random.randint(1,total_degree)
        sum=0
        for i in range(len(degree_list)):

            sum+=degree_list[i]
            #print 'sum',sum
            if rand<=sum:

                node_to_connect=i
                break
        if node_to_connect in nodes_to_connected:
            continue
        else:

            nodes_to_connected.append(node_to_connect)
            graph[i].append(current_node)  #old node
            degree_list[node_to_connect]=degree_list[node_to_connect]+1

    graph.append(nodes_to_connected) #new node
    degree_list.append(fixed_hand)
    total_degree+=fixed_hand*2

degree_list.sort()  #rearrange the data in ascending order

degree_array=array(degree_list) # converting list to array

count_degree=bincount(degree_array) # count the repeated element



degree_array=unique(degree_array) #it delete the repeated element

print 'degree_array' ,degree_array,
print 'count_degree ',count_degree,

count_for_probability=array([])


for i in count_degree:
    if i!=0:
        count_for_probability=append(count_for_probability, i/float(num_nodes))


for i in range(degree_array.size):
    outfile.write(' %d   %lf\n' %(degree_array[i],count_for_probability[i]))