class Solution:
    def closestMeetingNode(self, E: List[int], n1: int, n2: int) -> int:
        def dist(n):
            D, d = {}, 0
            while n != -1 and n not in D:
                D[n] = d
                n, d = E[n], d + 1
            return D
        D1, D2 = dist(n1), dist(n2)
        return min((max(D1[i], D2[i]), i) for i in D1.keys() & D2.keys())[1] if D1.keys() & D2.keys() else -1
