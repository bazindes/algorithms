//第一题是： stick cut， 就是给一个数组，每次用最小那个数字作为baseline，对剩余的数字做减法。
//每次记录剩下的数字个数。写了两个解法： TreeMap直接做以及sort过后用queue做，比较简单
//1. cut sticks 很简单  给一堆火柴 各有长度   每次选取最短的长度len  然后所有火柴都剪去len
//直到没有为止  记录每次剩余的火柴数量
//TreeMap<Integer,Integer> map=new HashMap<>();
//
//
//
//第二题就有点坑爹了，想了好久：movie ratings。给一个数组有正有负，在其中挑选一些数组成的和要求最大，
//前提是不能连续跳过两个数，
//比如【-3， 2， 4， -1， -2， -5】就取2 + 4 + -2 = 4。反过来想，就是house robber，还是折腾了一会儿。
//Movie Ratings： 用 dp做，每次都选择前一个或者前第二个的值的最大值。最后返回Math.max(dp[n], dp[n-1]);
//
//
//2. zombies   和lc的friend circle类似
//dfs直接解决
//第二题是 graph connected components ，直接给了 matrix ， dfs 解决。题目描述故弄玄虚，套了个僵尸的情景
// -。- 楼主看到这种情景有点莫名方，
//gg 也是挂在披着复杂场景的皮的简单题上，看来心理不够强大，还是要多面-。-
//
//
//我的第一题，给一个数组，求出所有subarray的和。注意别超时，我找了找规律写了个O(n)的；
//https://www.geeksforgeeks.org/sum-of-all-subarrays/
//
//第二题，给一个array，里面会有重复，你要消除重复，并且在保证每个数都是unique的情况下，找出这个array的和的最小值；
//
//
//我朋友的第一题，给一个name list，去重，去重的方法就是给后面加上数字后缀。
//比如第一个alex就是alex，第二个出现的alex就是alex1，以此类推；
//
//第二题，permutation变种，只不过要求输出结果中奇数不能和奇数相邻，偶数不能和偶数相邻，
//同时要满足lexicographical从小到大排列，时间复杂度没要求（或者你也可以自己提高要求
//
//我的解法就是sort一遍数组，然后从小到大看是否和前一位重复/小，
//如果是这样的情况，就直接变成前一个数+1的大小，这样能保证最终结果一定是维持总和最小
//
//第一题 蠡口 鹅灵
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
//determine if the input string is valid.
//An input string is valid if:
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.
//
//第二题 给个数组存在重复元素 调整个别元素的值
//使整个数组元素都唯一并且让总和尽可能小 最后返回最小值。
//
//第二题是 返回数组的最大差值 就是找到最大减去最小
//
//
//1. 求所有子序列的加和
//2. 第二道有点绕，给一个 array，每个值是所在组的人数，相同人数的组按坐标升序分组，
//输出每个组对应的人的 index
//
//subarray sum: 求 sum(sum(subarr) for subarr of arr)
//
//
//Monsoon Umbrellas:
//给定一个 int 和一个 list[int], 让你用 list 里的数来组合出所求的 int, 最少需要多少个
//比如 4, [2,4], 可以用 (2,2) 或者 (4) 来组合，最少就是 1 个
//一维 dp 跑一遍即可
//有可能是overflow了，虽然最后的return type的long，但是中间的计算结果也可能Overflow，所以中间计算的时候就要cast成long来计算
//
//sort arr by frequency
//array里面取数字，不能连续跳过两个及以上，求最大sum。house robber互补版本。
//
//dp(i) = max(dp(i - 1), dp(i - 2)) + nums(i)，结果是max(dp(n - 1), dp(n - 2))
//
//或者做一遍求min的house robber，表示所有被跳过的数的和，sum(arr)-min就是这题结果
//
//1. 给一个无序的list和target int，判断int在不在list里；
//2. 给一个range闭区间，打印之间所有的odd numbers；
//3. 选择题，在下面各个sort algorithm里找时间复杂度最小的。
//
//第一题是出现过的，按数字出现频率和大小排序，最后打印出来。
//第二题是 graph connected components ，直接给了 matrix ， dfs 解决。
//题目描述故弄玄虚，套了个僵尸的情景 -。- 楼主看到这种情景有点莫名方，gg 也是挂在披着复杂场景的皮的简单题上，看来心理不够强大，还是要多面-。-
//
//第一道判断给的括号序列是否“平衡”，具体细节如本文。
//第二道题好像叫什么parity permutation, 给你一个整数n, 你被要求返回List<List<Integer>>, 每个List<Integer> 都由1到n组成并且奇偶相间, 按照"lexicographic order"排好。
//例：
//n = 4. you should return:
//[[1,2,3,4],
//[1,4,3,2],
//[2,1,4,3],
//[2,3,4,1],
//[3,2,1,4],
//[3,4,1,2],
//[4,1,2,3],
//[4,3,2,1]]
//不仅要奇偶相间而且要从小到大排列所有符合的List<Integer>.
//
//第一题是String Shifting，有leftShift和rightShift的操作，需要求最终所有shift操作都完成后的String。
//
//input的参数为（String，leftShift，rightShift）
//leftShift 2位：   “abcd” ----》 “cdab”
//rightShift1位：    “cdab” ----》  “bcda”.
//
//最终的结果就是“bcda”
//
//第二题就是常规Two Sum
//
//第一题是 substring中字典序最大[color=rgba(0, 0, 0, 0.87)]. 一开始做的时候想的简单了，结果有几个testcase没过，后来想到了
//给个提示：当string是 “ggaggggg 时。第二题是 利口 三恶恶
//
//
//
//第一题比较简单，给定一个string s, 两个integer L和R，先把s往左shift L次，再把s往右shift R次；举例说的话就是s = 'abcd', L = 1, R = 2, 输出结果就是'bcda'
//第二题给定一个数组counts, 每个index代表一个ID，每个element代表ID所在的组的大小，组里只能有element这么多个ID，把element一样的ID归到一个或多个组里，按从小到大顺序输出所有组
//
//举例说明：
//| 0 | 1 | 2 | 3 | 4 | 5 | 6 |
//| 3 | 3 | 3 | 3 | 3 | 1 | 3 |
//
//上面一排是index也就是ID
//下面一排是ID所在的组的大小
//
//输出结果就是
//0 1 2
//3 4 6
//5
//
//因为组里最多只能放3个，但是一共有6个3，所以要把6个IDs放到两个组里，必须按照从小到大的顺序形成组，输出的时候组内组间都必须按照从小到大的顺序排列。
//
//0 1 3
//2 4 6
//5
//
//就不行，因为第一个组里2 < 3，所以3的位置必须放2
//
//3 4 6         5
//0 1 2   or   0 1 2
//5               3 4 6
//
//也不行，因为输出顺序不是从小到大排列的
//
//默认给的数组一定有解。
//
//
//第1道: shifting string给一个string，左移步数，右移步数，返回最终结果。
//
//我用了做差后加上长度，取关于长度余数得到了左移步数，然后就是部分reverse再整体reverse. 一亩-三分-地，独家发布
//
//
//第2道：simple queries
//
//2个乱序的数组，对于第二个数组中的每一个数找到第一个数组中不大于这个数的个数。
//
//我是对2个数组排序，遍历第二个数组，用二分法在第一个数组里找到第一个不大于这个数的位置，得到个数。
//中间会用map把得到的结果存下来了，减少重复操作。
//
//
//第一题数组排序，先按照频率，后按照数值，
//第二题数组求最大和，最多允许跳过一个连续的元素，不能一次跳两个以上，比如【9，-1，-3，5，6】输出19
//
//1. 有很多火柴棍，每一次扔掉所有最小的棍子，然后剩余的棍子都减去扔掉的棍子，求直到没有棍子的时候每次剩余棍子的数量
//2. permutation，不过奇数和偶数不能放在一起，加一个条件检查就可以了
//
//第一题是给一个字符串 把它所有的substring按照字母序排序 返回最后一个substring. 一
//
//第二题，给一个list，对其中一样的数字increment by 1，直到没有重复的数字为止。：[1,2,2,3,3]->[1,2,3,4,5]。
//
//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
//Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
//Examples :
//Input : arr = {2, 3, 10, 6, 4, 8, 1}
//Output : 8
//Explanation : The maximum difference is between 10 and 2.
//
//Input : arr = {7, 9, 5, 6, 3, 2}
//Output : 2
//Explanation : The maximum difference is between 9 and 7.
//
//1： can you sort?给一个矩阵，要求按照矩阵的数字出现的频率，从低到高打印出来。
