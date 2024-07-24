def solution(sum,coins):
    dp = [0] * (sum+1)
    dp[0] = 1
    for coin in coins:
        for i in range(coin, sum+1):
            dp[i] += dp[i-coin]
    return dp[sum]

# 테스트
tests = [
    (4,[1,2,3],4),
    (10,[2,5,3,6],5)
]

for test in tests:
    sum, coins,result = test
    print(f"sum: {sum},coins[] = {coins}")
    print(f"에상결과: {result}")
    print(f"결과: {solution(sum,coins)}")
