class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        a = s.strip()
        b = a.split()
        return len(b[-1])