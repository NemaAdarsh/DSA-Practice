class Solution:
    def scoreOfString(self, s: str) -> int:
        total_score = 0
        for i in range(len(s) - 1): 
            current = s[i]
            next = s[i + 1]
            difference = abs(ord(current) - ord(next))
            total_score += difference
        return total_score

        