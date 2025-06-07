class Solution:
    def longestPalindrome(self, s: str) -> str:
        r = ''
        for i in range(len(s)):
            for j in (0, 1):
                l, k = i, i + j
                while l >= 0 and k < len(s) and s[l] == s[k]:
                    if k - l + 1 > len(r): r = s[l:k+1]
                    l -= 1; k += 1
        return r
