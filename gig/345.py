'''
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 
'''

'''
class Solution:
  def reverseVowels(self, s: str) -> str:
    chars, vowels, l, r = list(s), 'aeiouAEIOU', 0, len(s) - 1
    while l < r:
      if chars[l] in vowels and chars[r] in vowels:
        chars[l], chars[r] = chars[r], chars[l]
        l += 1
        r -= 1
      l += chars[l] not in vowels
      r -= chars[r] not in vowels
    return ''.join(chars)

'''

def reverseVowels(s):
    vowels = set('aeiouAEIOU')
    s = list(s)
    i, j = 0, len(s) - 1
    while i < j:
        if s[i] not in vowels:
            i += 1
        elif s[j] not in vowels:
            j -= 1
        else:
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1
    return ''.join(s)
# time complexity: O(n), where n is the length of s
# space complexity: O(1)
