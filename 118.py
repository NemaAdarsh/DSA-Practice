class Solution:
  def generate(self, numRows: int) -> List[List[int]]:
    Sol = []

    for i in range(numRows):
      Sol.append([1] * (i + 1))

    for i in range(2, numRows):
      for j in range(1, len(Sol[i]) - 1):
        Sol[i][j] = Sol[i - 1][j - 1] + Sol[i - 1][j]

    return Sol