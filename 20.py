'''
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
'''

'''
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            if i == '(' or i == '[' or i == '{':
                stack.append(i)
            elif i == ')' and len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            elif i == ']' and len(stack) > 0 and stack[-1] == '[':
                stack.pop()
            elif i == '}' and len(stack) > 0 and stack[-1] == '{':
                stack.pop()
            else:
                return False
        return len(stack) == 0
'''



def isValid(s):
    stack = []
    for i in s:
        if i == '(' or i == '[' or i == '{':
            stack.append(i)
        elif i == ')' and len(stack) > 0 and stack[-1] == '(':
            stack.pop()
        elif i == ']' and len(stack) > 0 and stack[-1] == '[':
            stack.pop()
        elif i == '}' and len(stack) > 0 and stack[-1] == '{':
            stack.pop()
        else:
            return False
    return len(stack) == 0
# Time complexity: O(n)
# Space complexity: O(n)
