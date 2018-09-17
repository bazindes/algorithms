package com.baz.app;
import com.baz.app.TwoSigma.easy.IntersectionOfTwoArrays;
import com.baz.app.TwoSigma.hard.MedianOfTwoSortedArray;
import com.baz.app.TwoSigma.medium.FriendCircles;
import com.baz.app.TwoSigma.medium.LongestChain;
import com.baz.app.TwoSigma.medium.ReverseLinkedListII;
import com.baz.app.TwoSigma.medium.WordLadder;
import com.baz.app.easy.SortLinkedList;
import com.baz.app.easy.SumOfTwoIntegers;
import com.baz.app.facebook.easy.*;
import com.baz.app.facebook.hard.*;
import com.baz.app.facebook.medium.*;
import com.baz.app.facebook.medium.Permutations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* <h1>Main Class</h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-18
*/
class App{

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        FindAllAnagramsInAString findAllAnagramsInAString = context.getBean(FindAllAnagramsInAString.class);
        findAllAnagramsInAString.test();
//        DecodeWays decodeWays = context.getBean(DecodeWays.class);
//        decodeWays.test();
//        PalindromePairs palindromePairs = context.getBean(PalindromePairs.class);
//        palindromePairs.test();
//        CountAndSay countAndSay = context.getBean(CountAndSay.class);
//        countAndSay.test();
//        BinaryTreeVerticalOrderTraversal binaryTreeVerticalOrderTraversal = context.getBean(BinaryTreeVerticalOrderTraversal.class);
//        binaryTreeVerticalOrderTraversal.test();
//        NQueens nQueens = context.getBean(NQueens.class);
//        nQueens.test();
//        MedianOfTwoSortedArray medianOfTwoSortedArray = context.getBean(MedianOfTwoSortedArray.class);
//        medianOfTwoSortedArray.test();
//        BinaryTreePaths binaryTreePaths = context.getBean(BinaryTreePaths.class);
//        binaryTreePaths.test();
//        RegularExpressionMatching regularExpressionMatching = context.getBean(RegularExpressionMatching.class);
//        regularExpressionMatching.test();
//        TaskScheduler taskScheduler = context.getBean(TaskScheduler.class);
//        taskScheduler.test();
//        TopKFrequentWords topKFrequentWords = context.getBean(TopKFrequentWords.class);
//        topKFrequentWords.test();
//        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = context.getBean(BinaryTreeMaximumPathSum.class);
//        binaryTreeMaximumPathSum.test();
//        ValidateBinarySearchTree validateBinarySearchTree = context.getBean(ValidateBinarySearchTree.class);
//        validateBinarySearchTree.test();
//        BasicCalculator basicCalculator = context.getBean(BasicCalculator.class);
//        basicCalculator.test();
//        GenerateParentheses generateParentheses = context.getBean(GenerateParentheses.class);
//        generateParentheses.test();
//        ReverseNodesInKGroup reverseNodesInKGroup = context.getBean(ReverseNodesInKGroup.class);
//        reverseNodesInKGroup.test();
//        PlusOne plusOne = context.getBean(PlusOne.class);
//        plusOne.test();
//        Permutations permutations = context.getBean(Permutations.class);
//        permutations.test();
//        DevideTwoIntegers devideTwoIntegers = context.getBean(DevideTwoIntegers.class);
//        devideTwoIntegers.test();
//        DecodeWays decodeWays = context.getBean(DecodeWays.class);
//        decodeWays.test();
//        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = context.getBean(RemoveNthNodeFromEndofList.class);
//        removeNthNodeFromEndofList.test();
//        IntegerToEnglishWords integerToEnglishWords = context.getBean(IntegerToEnglishWords.class);
//        integerToEnglishWords.test();
//        SortLinkedList sortLinkedList = context.getBean(SortLinkedList.class);
//        sortLinkedList.test();
//        Permutations permutations = context.getBean(Permutations.class);
//        permutations.test();
//        ReorderList reorderList = context.getBean(ReorderList.class);
//        reorderList.test();
//        LongestPalindromicSubstring longestPalindromicSubstring = context.getBean(LongestPalindromicSubstring.class);
//        longestPalindromicSubstring.test();
//        SpiralMatrix spiralMatrix = context.getBean(SpiralMatrix.class);
//        spiralMatrix.test();
//        NextPermutation nextPermutation = context.getBean(NextPermutation.class);
//        nextPermutation.test();
//        ValidNumber validNumber = context.getBean(ValidNumber.class);
//        validNumber.test();
//        LongestIncreasingSubSequence longestIncreasingSubSequence = context.getBean(LongestIncreasingSubSequence.class);
//        longestIncreasingSubSequence.test();
//        MeetingRoomsII meetingRoomsII = context.getBean(MeetingRoomsII.class);
//        meetingRoomsII.test();
//        FirstMissingPositive firstMissingPositive = context.getBean(FirstMissingPositive.class);
//        firstMissingPositive.test();
//        TopKFrequentElements topKFrequentElements = context.getBean(TopKFrequentElements.class);
//        topKFrequentElements.test();
//        GroupAnagrams groupAnagrams = context.getBean(GroupAnagrams.class);
//        groupAnagrams.test();
//        ReverseWrodsInAString reverseWrodsInAString = context.getBean(ReverseWrodsInAString.class);
//        reverseWrodsInAString.test();
//        WordBreak wordBreak = context.getBean(WordBreak.class);
//        wordBreak.test();
//        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = context.getBean(LetterCombinationsOfAPhoneNumber.class);
//        letterCombinationsOfAPhoneNumber.test();
//        FizzBuzz fizzBuzz = context.getBean(FizzBuzz.class);
//        fizzBuzz.test();
//        ProductOfArrayExceptSelf productOfArrayExceptSelf = context.getBean(ProductOfArrayExceptSelf.class);
//        productOfArrayExceptSelf.test();
//        StringToInteger stringToInteger = context.getBean(StringToInteger.class);
//        stringToInteger.test();
//        MachineTasks machineTasks = context.getBean(MachineTasks.class);
//        machineTasks.test();
//        RegularExpressionMatching regularExpressionMatching = context.getBean(RegularExpressionMatching.class);
//        regularExpressionMatching.test();
//        IntegerToEnglishWords integerToEnglishWords = context.getBean(IntegerToEnglishWords.class);
//        integerToEnglishWords.test();
//        ReverseString reverseString = context.getBean(ReverseString.class);
//        reverseString.test();
//        MergeKSortedList mergeKSortedList = context.getBean(MergeKSortedList.class);
//        mergeKSortedList.test();
//        MyCalendarII myCalendarII = context.getBean(MyCalendarII.class);
//        myCalendarII.test(myCalendarII);
//        RotateImage rotateImage = context.getBean(RotateImage.class);
//        rotateImage.helper();
//        CoinChange coinChange = context.getBean(CoinChange.class);
//        coinChange.helper();
//        NumberOfConnectedComponents numberOfConnectedComponents = context.getBean(NumberOfConnectedComponents.class);
//        numberOfConnectedComponents.helper();
//        ContainerWithMostWater containerWithMostWater = context.getBean(ContainerWithMostWater.class);
//        containerWithMostWater.helper();
//        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = context.getBean(LongestSubstringWithoutRepeatingCharacters.class);
//        longestSubstringWithoutRepeatingCharacters.helper();
//        LongestIncreasingSubSequence longestIncreasingSubSequence = context.getBean(LongestIncreasingSubSequence.class);
//        longestIncreasingSubSequence.helper();
//        Calculator calculator = context.getBean(Calculator.class);
//        calculator.helper();
//        MinimumWindowSubString minimumWindowSubString = context.getBean(MinimumWindowSubString.class);
//        minimumWindowSubString.helper();
//        SumOfTwoIntegers sumOfTwoIntegers = context.getBean(SumOfTwoIntegers.class);
//        sumOfTwoIntegers.helper();
//        LongestChain longestChain = context.getBean(LongestChain.class);
//        longestChain.helper();
//        IntersectionOfTwoArrays intersectionOfTwoArrays = context.getBean(IntersectionOfTwoArrays.class);
//        intersectionOfTwoArrays.helper();
//        FriendCircles friendCircles = context.getBean(FriendCircles.class);
//        friendCircles.helper();
//        MinimumSubSetSum minimumSubSetSum = context.getBean(MinimumSubSetSum.class);
//        minimumSubSetSum.helper();
//        WordLadder wordLadder = context.getBean(WordLadder.class);
//        wordLadder.helper();
//        ReverseLinkedListII reverseLinkedListII = context.getBean(ReverseLinkedListII.class);
//        reverseLinkedListII.helper();
//        BasicCalculator basicCalculator = context.getBean(BasicCalculator.class);
//        basicCalculator.helper();
//        CombinationSumIII combinationSumIII = context.getBean(CombinationSumIII.class);
//        combinationSumIII.helper();
//        CombinationSumII combinationSumII = context.getBean(CombinationSumII.class);
//        combinationSumII.helper();
//        CombinationSum combinationSum = context.getBean(CombinationSum.class);
//        combinationSum.helper();
//        Permutations permutations = context.getBean(Permutations.class);
//        permutations.helper();
//        Combinations combinations = context.getBean(Combinations.class);
//        combinations.helper();
//        HouseRobberIII houseRobberIII = context.getBean(HouseRobberIII.class);
//        houseRobberIII.helper();
//        HouseRobberII houseRobberII = context.getBean(HouseRobberII.class);
//        houseRobberII.helper();
//        HouseRobber houseRobber = context.getBean(HouseRobber.class);
//        houseRobber.helper();
//        RegularExpressionMatching regularExpressionMatching = context.getBean(RegularExpressionMatching.class);
//        regularExpressionMatching.helper();
//        LRUCache lruCache = context.getBean(LRUCache.class);
//        lruCache.helper();
//        MedianOfTwoSortedArray medianOfTwoSortedArray = context.getBean(MedianOfTwoSortedArray.class);
//        medianOfTwoSortedArray.helper();
//        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = context.getBean(RemoveDuplicatesFromSortedArrayII.class);
//        removeDuplicatesFromSortedArrayII.helper();
//        H_Index h_index = context.getBean(H_Index.class);
//        h_index.helper();
//        CustomSortString customSortString = context.getBean(CustomSortString.class);
//        customSortString.helper();
//        PowerXToTheN powerXToTheN = context.getBean(PowerXToTheN.class);
//        powerXToTheN.helper();
//        BestTimeToBuyAndSellStockWithTransectionFee bestTimeToBuyAndSellStockWithTransectionFee = context.getBean(BestTimeToBuyAndSellStockWithTransectionFee.class);
//        bestTimeToBuyAndSellStockWithTransectionFee.helper();
//        CourseScheduleII courseScheduleII = context.getBean(CourseScheduleII.class);
//        courseScheduleII.helper();
//        IncreasingTripletSubsequence increasingTripletSubsequence = context.getBean(IncreasingTripletSubsequence.class);
//        increasingTripletSubsequence.helper();
//        CombinationSumIV combinationSumIV = context.getBean(CombinationSumIV.class);
//        combinationSumIV.helper();
//        SubSetsII subSetsII = context.getBean(SubSetsII.class);
//        subSetsII.helper();
//        BrickWall brickWall = context.getBean(BrickWall.class);
//        brickWall.helper();
//        SimplifyPath simplifyPath = context.getBean(SimplifyPath.class);
//        simplifyPath.helper();
//        InsertDeleteGetRandom insertDeleteGetRandom = context.getBean(InsertDeleteGetRandom.class);
//        insertDeleteGetRandom.helper(insertDeleteGetRandom);
//        PalindromicSubStrings palindromicSubStrings = context.getBean(PalindromicSubStrings.class);
//        palindromicSubStrings.helper();
//        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = context.getBean(BinaryTreeLevelOrderTraversal.class);
//        binaryTreeLevelOrderTraversal.helper();
//        ImplementTrie implementTrie = context.getBean(ImplementTrie.class);
//        implementTrie.helper();
//        MinimumSizeSubarraySum minimumSizeSubarraySum = context.getBean(MinimumSizeSubarraySum.class);
//        minimumSizeSubarraySum.helper();
//        TotalHammingDistance totalHammingDistance = context.getBean(TotalHammingDistance.class);
//        totalHammingDistance.helper();
//        RandomPickIndex randomPickIndex = context.getBean(RandomPickIndex.class);
//        randomPickIndex.helper();
//        IsGraphBipartite isGraphBipartite = context.getBean(IsGraphBipartite.class);
//        isGraphBipartite.helper();
//        TargetSum targetSum = context.getBean(TargetSum.class);
//        targetSum.helper();
//        WordSearch wordSearch = context.getBean(WordSearch.class);
//        wordSearch.helper();
//        GroupAnagrams groupAnagrams = context.getBean(GroupAnagrams.class);
//        groupAnagrams.helper();
//        ContinuousSubarraySum continuousSubarraySum = context.getBean(ContinuousSubarraySum.class);
//        continuousSubarraySum.helper();
//        MaximumSwap maximumSwap = context.getBean(MaximumSwap.class);
//        maximumSwap.helper();
//        SearchInRotatedSortedArray searchInRotatedSortedArray = context.getBean(SearchInRotatedSortedArray.class);
//        searchInRotatedSortedArray.helper();
//        FriendsOfAppropriateAges friendsOfAppropriateAges = context.getBean(FriendsOfAppropriateAges.class);
//        friendsOfAppropriateAges.helper();
//        SortColors sortColors = context.getBean(SortColors.class);
//        sortColors.helper();
//        RecoverBinarySearchTree recoverBinarySearchTree = context.getBean(RecoverBinarySearchTree.class);
//        recoverBinarySearchTree.helper();
//        DecodeString decodeString = context.getBean(DecodeString.class);
//        decodeString.helper();
//        InsertInterval insertInterval = context.getBean(InsertInterval.class);
//        insertInterval.helper();
//        ProductOfArrayExceptSelf productOfArrayExceptSelf = context.getBean(ProductOfArrayExceptSelf.class);
//        productOfArrayExceptSelf.helper();
//        CardGameII cardGameII = context.getBean(CardGameII.class);
//        cardGameII.helper();
//        WordBreak wordBreak = context.getBean(WordBreak.class);
//        wordBreak.helper();
//        Subsets subsets = context.getBean(Subsets.class);
//        subsets.helper();
//        ValidateBinarySearchTree validateBinarySearchTree = context.getBean(ValidateBinarySearchTree.class);
//        validateBinarySearchTree.helper();
//        MultiplyStrings multiplyStrings = context.getBean(MultiplyStrings.class);
//        multiplyStrings.helper();
//        KthLargestElementInArray kthLargestElementInArray = context.getBean(KthLargestElementInArray.class);
//        kthLargestElementInArray.helper();
//        CloneGraph cloneGraph = context.getBean(CloneGraph.class);
//        cloneGraph.helper();
//        FlattenNestedListIterator flattenNestedListIterator = context.getBean(FlattenNestedListIterator.class);
//        flattenNestedListIterator.helper(flattenNestedListIterator);
//        ZeroOneKnapSack zeroOneKnapSack = context.getBean(ZeroOneKnapSack.class);
//        zeroOneKnapSack.helper();
//        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions = context.getBean(ExclusiveTimeOfFunctions.class);
//        exclusiveTimeOfFunctions.helper();
//        BestTimeToBuyAndSellAStock bestTimeToBuyAndSellAStock = context.getBean(BestTimeToBuyAndSellAStock.class);
//        bestTimeToBuyAndSellAStock.helper();
//        ProjectionAreaOf3DShapes projectionAreaOf3DShapes = context.getBean(ProjectionAreaOf3DShapes.class);
//        projectionAreaOf3DShapes.helper();
//        AddAndSearchWord addAndSearchWord = context.getBean(AddAndSearchWord.class);
//        addAndSearchWord.helper(addAndSearchWord);
//        MergeIntervals mergeIntervals = context.getBean(MergeIntervals.class);
//        mergeIntervals.helper();
//        BinarySearchTreeIterator binarySearchTreeIterator = context.getBean(BinarySearchTreeIterator.class);
//        binarySearchTreeIterator.helper();
//        NumberOfIslands numberOfIslands = context.getBean(NumberOfIslands.class);
//        numberOfIslands.helper();
//        NonDecreasingArray nonDecreasingArray = context.getBean(NonDecreasingArray.class);
//        nonDecreasingArray.helper();
//        BuddyStrings buddyStrings = context.getBean(BuddyStrings.class);
//        buddyStrings.helper();
//        ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = context.getBean(ShortestUnsortedContinuousSubarray.class);
//        shortestUnsortedContinuousSubarray.test();
//        Heaters heaters = context.getBean(Heaters.class);
//        heaters.helper();
//        NthDigit nthDigit = new NthDigit();
//        nthDigit.helper();
//        RepeatedStringMatch repeatedStringMatch = context.getBean(RepeatedStringMatch.class);
//        repeatedStringMatch.helper();
//        MinStack minStack = context.getBean(MinStack.class);
//        minStack.helper();
//        LongestUnivaluePath longestUnivaluePath = context.getBean(LongestUnivaluePath.class);
//        longestUnivaluePath.helper();
//        SubTreeOfAnthoerTree subTreeOfAnthoerTree = context.getBean(SubTreeOfAnthoerTree.class);
//        subTreeOfAnthoerTree.helper();
//        LetterCasePermutation letterCasePermutation = context.getBean(LetterCasePermutation.class);
//        letterCasePermutation.helper();
//        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = context.getBean(AverageOfLevelsInBinaryTree.class);
//        averageOfLevelsInBinaryTree.helper();
//        TwoSumIV twoSumIV = context.getBean(TwoSumIV.class);
//        twoSumIV.helper();
//        ExcelSheetColumnTitle excelSheetColumnTitle = context.getBean(ExcelSheetColumnTitle.class);
//        excelSheetColumnTitle.helper();
//        MissingNumber missingNumber = context.getBean(MissingNumber.class);
//        missingNumber.helper();
//        SumOfLeftLeaves sumOfLeftLeaves = context.getBean(SumOfLeftLeaves.class);
//        sumOfLeftLeaves.helper();
//        PalindromeLinkedList palindromeLinkedList = context.getBean(PalindromeLinkedList.class);
//        palindromeLinkedList.helper();
//        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = context.getBean(RemoveDuplicatesFromSortedArray.class);
//        removeDuplicatesFromSortedArray.helper();
//        HammingDistance hammingDistance = context.getBean(HammingDistance.class);
//        hammingDistance.helper();
//        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = context.getBean(LowestCommonAncestorOfABinarySearchTree.class);
//        lowestCommonAncestorOfABinarySearchTree.helper();
//        ThreeSum threeSum = context.getBean(ThreeSum.class);
//        threeSum.helper();
//        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = context.getBean(SerializeAndDeserializeBinaryTree.class);
//        serializeAndDeserializeBinaryTree.helper();
//        DecodeWays decodeWays = context.getBean(DecodeWays.class);
//        decodeWays.helper();
//        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = context.getBean(LetterCombinationsOfAPhoneNumber.class);
//        letterCombinationsOfAPhoneNumber.helper();
//        TaskScheduler taskScheduler = context.getBean(TaskScheduler.class);
//        taskScheduler.helper();
//        RemoveInvalidParenthese removeInvalidParenthese = context.getBean(RemoveInvalidParenthese.class);
//        removeInvalidParenthese.helper();
//        SqrtX sqrtX = context.getBean(SqrtX.class);
//        sqrtX.helper();
//        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = context.getBean(LongestContinuousIncreasingSubsequence.class);
//        longestContinuousIncreasingSubsequence.helper();
//        GoatLatin goatLatin = context.getBean(GoatLatin.class);
//        goatLatin.helper();
//        ImplementStrStr implementStrStr = context.getBean(ImplementStrStr.class);
//        implementStrStr.helper();
//        CountAndSay countAndSay = context.getBean(CountAndSay.class);
//        countAndSay.helper();
//        ValidParentheses validParentheses = context.getBean(ValidParentheses.class);
//        validParentheses.helper();
//        ReverseLinkedList reverseLinkedList = context.getBean(ReverseLinkedList.class);
//        reverseLinkedList.helper();
//        RomanToInteger romanToInteger = context.getBean(RomanToInteger.class);
//        romanToInteger.helper();
//        MergeSortedArray mergeSortedArray = context.getBean(MergeSortedArray.class);
//        mergeSortedArray.helper();
//        TwoSum twoSum = context.getBean(TwoSum.class);
//        twoSum.helper();
//        ValidPalindrome validPalindrome = context.getBean(ValidPalindrome.class);
//        validPalindrome.helper();
//        BinaryTreePaths binaryTreePaths = context.getBean(BinaryTreePaths.class);
//        binaryTreePaths.helper();
//        ValidPalindromeII validPalindromeII = context.getBean(ValidPalindromeII.class);
//        validPalindromeII.helper();
//        FirstBadVersion firstBadVersion = context.getBean(FirstBadVersion.class);
//        firstBadVersion.helper();
//        DiameterOfBinaryTree diameterOfBinaryTree = context.getBean(DiameterOfBinaryTree.class);
//        diameterOfBinaryTree.helper();
//        AddBinary addBinary = context.getBean(AddBinary.class);
//        addBinary.helper();
//        MoveZeroes moveZeroes = context.getBean(MoveZeroes.class);
//        moveZeroes.helper();
//        MagicSquaresInGrid magicSquaresInGrid = context.getBean(MagicSquaresInGrid.class);
//        magicSquaresInGrid.helper();
//        GuessNumberHigherOrLower guessNumberHigherOrLower = context.getBean(GuessNumberHigherOrLower.class);
//        guessNumberHigherOrLower.helper();
//        FindModeInBinarySearchTree findModeInBinarySearchTree = context.getBean(FindModeInBinarySearchTree.class);
//        findModeInBinarySearchTree.helper();
//        MaximumAverageSubarrayI maximumAverageSubarrayI = context.getBean(MaximumAverageSubarrayI.class);
//        maximumAverageSubarrayI.helper();
//        RepeatedSubstringPattern repeatedSubstringPattern = context.getBean(RepeatedSubstringPattern.class);
//        repeatedSubstringPattern.helper();
//        MaximizeDistanceToClosestPerson maximizeDistanceToClosestPerson = context.getBean(MaximizeDistanceToClosestPerson.class);
//        maximizeDistanceToClosestPerson.helper();
//        LicenseKeyFormatting licenseKeyFormatting = context.getBean(LicenseKeyFormatting.class);
//        licenseKeyFormatting.helper();
//        ReverseVowelsOfAString reverseVowelsOfAString = context.getBean(ReverseVowelsOfAString.class);
//        reverseVowelsOfAString.helper();
//        PowerOfTwo powerOfTwo = context.getBean(PowerOfTwo.class);
//        powerOfTwo.helper();
//        LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers = context.getBean(LargestNumberAtLeastTwiceOfOthers.class);
//        largestNumberAtLeastTwiceOfOthers.helper();
//        AddStrings addStrings = context.getBean(AddStrings.class);
//        addStrings.helper();
//        BinaryTreePaths binaryTreePaths = context.getBean(BinaryTreePaths.class);
//        binaryTreePaths.helper();
//        ReverseStringII reverseStringII = context.getBean(ReverseStringII.class);
//        reverseStringII.helper();
//        BinaryWatch binaryWatch = context.getBean(BinaryWatch.class);
//        binaryWatch.helper();
//        BinaryWatch binaryWatch = new BinaryWatch();
//        binaryWatch.helper();
//        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
//        searchA2DMatrix.helper();
//        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
//        diameterOfBinaryTree.helper();
//        LongestPalindrome longestPalindrome = new LongestPalindrome();
//        longestPalindrome.helper();
//        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
//        backspaceStringCompare.helper();
//        PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();
//        positionsOfLargeGroups.helper();
//        RelativeRanks relativeRanks = new RelativeRanks();
//        relativeRanks.helper();
//        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
//        numberOfBoomerangs.helper();
//        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
//        firstUniqueCharacterInAString.helper();
//        MinimumDistanceBetweenBSTNodes minimumDistanceBetweenBSTNodes = new MinimumDistanceBetweenBSTNodes();
//        minimumDistanceBetweenBSTNodes.helper();
//        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST();
//        minimumAbsoluteDifferenceInBST.helper();
//        SimilarRGBColor similarRGBColor = new SimilarRGBColor();
//        similarRGBColor.helper();
//        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
//        invertBinaryTree.helper();
//        FlippingAnImage flippingAnImage = new FlippingAnImage();
//        flippingAnImage.helper();
//        PascalsTriangle pascalsTriangle = new PascalsTriangle();
//        pascalsTriangle.helper();
//        PathSum pathSum = new PathSum();
//        pathSum.helper();
        // MinimumDepthofBinaryTree minimumDepthofBinaryTree = new MinimumDepthofBinaryTree();
        // minimumDepthofBinaryTree.helper();
        // BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        // balancedBinaryTree.helper();
        // ConvertSortedArraytoBST convertSortedArraytoBST = new ConvertSortedArraytoBST();
        // convertSortedArraytoBST.helper();
        // InnerClassExamples.testHello();
        // BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        // binaryTreeLevelOrderTraversalII.helper();
        // MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        // maximumDepthOfBinaryTree.helper();
        // EliminationGame eliminationGame = new EliminationGame();
        // eliminationGame.helper();
        // SymmetricTree symmetricTree = new SymmetricTree();
        // symmetricTree.helper();
        // SameTree sameTree = new SameTree();
        // sameTree.helper();
        // MergeSortedArray mergeSortedArray = new MergeSortedArray();
        // mergeSortedArray.helper();
        // RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        // removeDuplicatesFromSortedList.helper();
        // RemoveElements removeElements = new RemoveElements();
        // removeElements.helper();
        // MaximumSubarray maximumSubarray = new MaximumSubarray();
        // maximumSubarray.helper();
        // PlusOne plusOne = new PlusOne();
        // plusOne.helper();
        // AddBinary addBinary = new AddBinary();
        // addBinary.helper();
        // ClimbingStairs climbingStairs = new ClimbingStairs();
        // climbingStairs.helper();

    }

}