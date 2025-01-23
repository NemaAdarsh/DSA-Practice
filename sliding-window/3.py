'''
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

'''

'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        current_window = set()
        result = 0

        for end in range(len(s)):
            while s[end] in current_window:
                current_window.remove(s[start])
                start += 1

            
            current_window.add(s[end])
            result = max(result,end - start +1)

        return result 
'''


def lengthOfLongestSubstring(s):
    left = 0
    right = 0
    max_len = 0
    char_set = set()
    while right < len(s):
        if s[right] not in char_set:
            char_set.add(s[right])
            max_len = max(max_len, right - left + 1)
            right += 1
        else:
            char_set.remove(s[left])
            left += 1
    return max_len