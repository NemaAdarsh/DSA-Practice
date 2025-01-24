'''
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
'''

'''
class Solution:
  def eventualSafeNodes(self, graph: list[list[int]]) -> list[int]:
    states = [0] * len(graph) #make sure the states are defined in this way 

    def hasCycle(u: int) -> bool:
      if states[u] != 0:
        return states[u] == 1
      states[u] = 1
      if any(hasCycle(v) for v in graph[u]):
        return True
      states[u] = 2
      return False

    return [i for i in range(len(graph)) if not hasCycle(i)]
    
'''
# time complexity: O(n + e), where n is the number of nodes and e is the number of edges
# space complexity: O(n), where n is the number of nodes


def eventualSafeNodes(graph):
    n = len(graph)
    color = [0] * n

    def safe(node):
        if color[node] != 0:
            return color[node] == 1
        color[node] = 2
        for nei in graph[node]:
            if not safe(nei):
                return False
        color[node] = 1
        return True

    return [i for i in range(n) if safe(i)]