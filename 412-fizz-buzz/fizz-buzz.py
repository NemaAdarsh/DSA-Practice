class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        return ["FizzBuzz"*(i%15==0) or "Fizz"*(i%3==0) or "Buzz"*(i%5==0) or str(i) for i in range(1,n+1)]
