
name = 'asdfasdfasf'

def n(nums, N):
    if nums is None or N is None or len(nums) == 0:
        return

    summ = 0
    j = 0
    for i in range(len(nums)):
        while j < len(nums) and sum < N:
            summ += nums[j]
            j += 1

        if summ == N:
            return (i, j-1)
        else:
            if abs(summ - N) < abs(summ + nums[j] - N):
                return (i, j-1)
            else:
                return (i,j)

nums = [3,4,5,6,7]
print(n(nums,14))
            
