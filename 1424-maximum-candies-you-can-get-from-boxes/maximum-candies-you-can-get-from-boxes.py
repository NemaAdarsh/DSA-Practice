class Solution:
    def maxCandies(self, status, candies, keys, containedBoxes, initialBoxes):
        v = [0]*len(status)
        k = set()
        b = set(initialBoxes)
        q = deque(i for i in initialBoxes if status[i])
        r = 0
        while True:
            c = False
            while q:
                i = q.popleft()
                if v[i]: continue
                v[i] = 1
                r += candies[i]
                for x in keys[i]:
                    if x not in k:
                        k.add(x)
                        if x in b and not v[x]: q.append(x)
                for x in containedBoxes[i]:
                    if x not in b:
                        b.add(x)
                        if status[x] or x in k: q.append(x)
                c = True
            for i in b:
                if not v[i] and (status[i] or i in k): q.append(i)
            if not c: break
        return r
