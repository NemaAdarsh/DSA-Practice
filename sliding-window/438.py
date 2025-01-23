'''
Given two strings s and p, return an array of all the start indices of p's 
anagrams
 in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
'''

'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        start = 0
        result = []
        current_window = Counter()
        p_count = Counter(p)

        for end in range(len(s)):
            current_window[s[end]] += 1

        
            while end - start + 1 > len(p):
                if current_window[s[start]] == 1:
                    del current_window[s[start]]
                else:
                    current_window[s[start]] -= 1
                start += 1
            
            if current_window == p_count:
                result.append(start)
    
        return result
'''




def findAnagrams(s, p):
    if len(p) > len(s):
        return []

    p_map = {}
    for c in p:
        if c in p_map:
            p_map[c] += 1
        else:
            p_map[c] = 1

    s_map = {}
    result = []
    for i in range(len(s)):
        if s[i] in s_map:
            s_map[s[i]] += 1
        else:
            s_map[s[i]] = 1

        if i >= len(p):
            if s_map[s[i - len(p)]] == 1:
                del s_map[s[i - len(p)]]
            else:
                s_map[s[i - len(p)]] -= 1

        if s_map == p_map:
            result.append(i - len(p) + 1)

    return result