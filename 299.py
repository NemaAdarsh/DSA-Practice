class Solution:
  def getHint(self, secret: str, guess: str) -> str:
    bulls = 0
    cows = 0
    for i in range(len(secret)):
      if secret[i] == guess[i]:  
        bulls += 1
      elif guess[i] in secret:  
        cows += 1

    return f"{bulls}bulls{cows}cows"


  