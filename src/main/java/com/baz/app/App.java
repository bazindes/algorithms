package com.baz.app;
import com.baz.app.TwoSigma.easy.IntersectionOfTwoArrays;
import com.baz.app.TwoSigma.hard.BasicCalculator;
import com.baz.app.TwoSigma.hard.MedianOfTwoSortedArray;
import com.baz.app.TwoSigma.hard.RegularExpressionMatching;
import com.baz.app.TwoSigma.medium.FriendCircles;
import com.baz.app.TwoSigma.medium.LongestChain;
import com.baz.app.TwoSigma.medium.ReverseLinkedListII;
import com.baz.app.TwoSigma.medium.WordLadder;
import com.baz.app.easy.SumOfTwoIntegers;
import com.baz.app.facebook.easy.ReverseLinkedList;
import com.baz.app.facebook.hard.LRUCache;
import com.baz.app.facebook.hard.MinimumWindowSubString;
import com.baz.app.facebook.medium.*;
import com.baz.app.google.easy.HouseRobber;
import com.baz.app.google.easy.NumberOfConnectedComponents;
import com.baz.app.google.hard.Calculator;
import com.baz.app.google.medium.*;
import com.baz.app.medium.CombinationSum;
import com.baz.app.medium.CombinationSumII;
import com.baz.app.medium.CombinationSumIII;
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

        RotateImage rotateImage = context.getBean(RotateImage.class);
        rotateImage.test();
//        CoinChange coinChange = context.getBean(CoinChange.class);
//        coinChange.test();
//        NumberOfConnectedComponents numberOfConnectedComponents = context.getBean(NumberOfConnectedComponents.class);
//        numberOfConnectedComponents.test();
//        ContainerWithMostWater containerWithMostWater = context.getBean(ContainerWithMostWater.class);
//        containerWithMostWater.test();
//        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = context.getBean(LongestSubstringWithoutRepeatingCharacters.class);
//        longestSubstringWithoutRepeatingCharacters.test();
//        LongestIncreasingSubSequence longestIncreasingSubSequence = context.getBean(LongestIncreasingSubSequence.class);
//        longestIncreasingSubSequence.test();
//        Calculator calculator = context.getBean(Calculator.class);
//        calculator.test();
//        MinimumWindowSubString minimumWindowSubString = context.getBean(MinimumWindowSubString.class);
//        minimumWindowSubString.test();
//        SumOfTwoIntegers sumOfTwoIntegers = context.getBean(SumOfTwoIntegers.class);
//        sumOfTwoIntegers.test();
//        LongestChain longestChain = context.getBean(LongestChain.class);
//        longestChain.test();
//        IntersectionOfTwoArrays intersectionOfTwoArrays = context.getBean(IntersectionOfTwoArrays.class);
//        intersectionOfTwoArrays.test();
//        FriendCircles friendCircles = context.getBean(FriendCircles.class);
//        friendCircles.test();
//        MinimumSubSetSum minimumSubSetSum = context.getBean(MinimumSubSetSum.class);
//        minimumSubSetSum.test();
//        WordLadder wordLadder = context.getBean(WordLadder.class);
//        wordLadder.test();
//        ReverseLinkedListII reverseLinkedListII = context.getBean(ReverseLinkedListII.class);
//        reverseLinkedListII.test();
//        BasicCalculator basicCalculator = context.getBean(BasicCalculator.class);
//        basicCalculator.test();
//        CombinationSumIII combinationSumIII = context.getBean(CombinationSumIII.class);
//        combinationSumIII.test();
//        CombinationSumII combinationSumII = context.getBean(CombinationSumII.class);
//        combinationSumII.test();
//        CombinationSum combinationSum = context.getBean(CombinationSum.class);
//        combinationSum.test();
//        Permutations permutations = context.getBean(Permutations.class);
//        permutations.test();
//        Combinations combinations = context.getBean(Combinations.class);
//        combinations.test();
//        HouseRobberIII houseRobberIII = context.getBean(HouseRobberIII.class);
//        houseRobberIII.test();
//        HouseRobberII houseRobberII = context.getBean(HouseRobberII.class);
//        houseRobberII.test();
//        HouseRobber houseRobber = context.getBean(HouseRobber.class);
//        houseRobber.test();
//        RegularExpressionMatching regularExpressionMatching = context.getBean(RegularExpressionMatching.class);
//        regularExpressionMatching.test();
//        LRUCache lruCache = context.getBean(LRUCache.class);
//        lruCache.test();
//        MedianOfTwoSortedArray medianOfTwoSortedArray = context.getBean(MedianOfTwoSortedArray.class);
//        medianOfTwoSortedArray.test();
//        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = context.getBean(RemoveDuplicatesFromSortedArrayII.class);
//        removeDuplicatesFromSortedArrayII.test();
//        H_Index h_index = context.getBean(H_Index.class);
//        h_index.test();
//        CustomSortString customSortString = context.getBean(CustomSortString.class);
//        customSortString.test();
//        PowerXToTheN powerXToTheN = context.getBean(PowerXToTheN.class);
//        powerXToTheN.test();
//        BestTimeToBuyAndSellStockWithTransectionFee bestTimeToBuyAndSellStockWithTransectionFee = context.getBean(BestTimeToBuyAndSellStockWithTransectionFee.class);
//        bestTimeToBuyAndSellStockWithTransectionFee.test();
//        CourseScheduleII courseScheduleII = context.getBean(CourseScheduleII.class);
//        courseScheduleII.test();
//        IncreasingTripletSubsequence increasingTripletSubsequence = context.getBean(IncreasingTripletSubsequence.class);
//        increasingTripletSubsequence.test();
//        CombinationSumIV combinationSumIV = context.getBean(CombinationSumIV.class);
//        combinationSumIV.test();
//        SubSetsII subSetsII = context.getBean(SubSetsII.class);
//        subSetsII.test();
//        BrickWall brickWall = context.getBean(BrickWall.class);
//        brickWall.test();
//        SimplifyPath simplifyPath = context.getBean(SimplifyPath.class);
//        simplifyPath.test();
//        InsertDeleteGetRandom insertDeleteGetRandom = context.getBean(InsertDeleteGetRandom.class);
//        insertDeleteGetRandom.test(insertDeleteGetRandom);
//        PalindromicSubStrings palindromicSubStrings = context.getBean(PalindromicSubStrings.class);
//        palindromicSubStrings.test();
//        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = context.getBean(BinaryTreeLevelOrderTraversal.class);
//        binaryTreeLevelOrderTraversal.test();
//        ImplementTrie implementTrie = context.getBean(ImplementTrie.class);
//        implementTrie.test();
//        MinimumSizeSubarraySum minimumSizeSubarraySum = context.getBean(MinimumSizeSubarraySum.class);
//        minimumSizeSubarraySum.test();
//        TotalHammingDistance totalHammingDistance = context.getBean(TotalHammingDistance.class);
//        totalHammingDistance.test();
//        RandomPickIndex randomPickIndex = context.getBean(RandomPickIndex.class);
//        randomPickIndex.test();
//        IsGraphBipartite isGraphBipartite = context.getBean(IsGraphBipartite.class);
//        isGraphBipartite.test();
//        TargetSum targetSum = context.getBean(TargetSum.class);
//        targetSum.test();
//        WordSearch wordSearch = context.getBean(WordSearch.class);
//        wordSearch.test();
//        GroupAnagrams groupAnagrams = context.getBean(GroupAnagrams.class);
//        groupAnagrams.test();
//        ContinuousSubarraySum continuousSubarraySum = context.getBean(ContinuousSubarraySum.class);
//        continuousSubarraySum.test();
//        MaximumSwap maximumSwap = context.getBean(MaximumSwap.class);
//        maximumSwap.test();
//        SearchInRotatedSortedArray searchInRotatedSortedArray = context.getBean(SearchInRotatedSortedArray.class);
//        searchInRotatedSortedArray.test();
//        FriendsOfAppropriateAges friendsOfAppropriateAges = context.getBean(FriendsOfAppropriateAges.class);
//        friendsOfAppropriateAges.test();
//        SortColors sortColors = context.getBean(SortColors.class);
//        sortColors.test();
//        RecoverBinarySearchTree recoverBinarySearchTree = context.getBean(RecoverBinarySearchTree.class);
//        recoverBinarySearchTree.test();
//        DecodeString decodeString = context.getBean(DecodeString.class);
//        decodeString.test();
//        InsertInterval insertInterval = context.getBean(InsertInterval.class);
//        insertInterval.test();
//        ProductOfArrayExceptSelf productOfArrayExceptSelf = context.getBean(ProductOfArrayExceptSelf.class);
//        productOfArrayExceptSelf.test();
//        CardGameII cardGameII = context.getBean(CardGameII.class);
//        cardGameII.test();
//        WordBreak wordBreak = context.getBean(WordBreak.class);
//        wordBreak.test();
//        Subsets subsets = context.getBean(Subsets.class);
//        subsets.test();
//        ValidateBinarySearchTree validateBinarySearchTree = context.getBean(ValidateBinarySearchTree.class);
//        validateBinarySearchTree.test();
//        MultiplyStrings multiplyStrings = context.getBean(MultiplyStrings.class);
//        multiplyStrings.test();
//        KthLargestElementInArray kthLargestElementInArray = context.getBean(KthLargestElementInArray.class);
//        kthLargestElementInArray.test();
//        CloneGraph cloneGraph = context.getBean(CloneGraph.class);
//        cloneGraph.test();
//        FlattenNestedListIterator flattenNestedListIterator = context.getBean(FlattenNestedListIterator.class);
//        flattenNestedListIterator.test(flattenNestedListIterator);
//        ZeroOneKnapSack zeroOneKnapSack = context.getBean(ZeroOneKnapSack.class);
//        zeroOneKnapSack.test();
//        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions = context.getBean(ExclusiveTimeOfFunctions.class);
//        exclusiveTimeOfFunctions.test();
//        BestTimeToBuyAndSellAStock bestTimeToBuyAndSellAStock = context.getBean(BestTimeToBuyAndSellAStock.class);
//        bestTimeToBuyAndSellAStock.test();
//        ProjectionAreaOf3DShapes projectionAreaOf3DShapes = context.getBean(ProjectionAreaOf3DShapes.class);
//        projectionAreaOf3DShapes.test();
//        AddAndSearchWord addAndSearchWord = context.getBean(AddAndSearchWord.class);
//        addAndSearchWord.test(addAndSearchWord);
//        MergeIntervals mergeIntervals = context.getBean(MergeIntervals.class);
//        mergeIntervals.test();
//        BinarySearchTreeIterator binarySearchTreeIterator = context.getBean(BinarySearchTreeIterator.class);
//        binarySearchTreeIterator.test();
//        NumberOfIslands numberOfIslands = context.getBean(NumberOfIslands.class);
//        numberOfIslands.test();
//        NonDecreasingArray nonDecreasingArray = context.getBean(NonDecreasingArray.class);
//        nonDecreasingArray.test();
//        BuddyStrings buddyStrings = context.getBean(BuddyStrings.class);
//        buddyStrings.test();
//        ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = context.getBean(ShortestUnsortedContinuousSubarray.class);
//        shortestUnsortedContinuousSubarray.test();
//        Heaters heaters = context.getBean(Heaters.class);
//        heaters.test();
//        NthDigit nthDigit = new NthDigit();
//        nthDigit.test();
//        RepeatedStringMatch repeatedStringMatch = context.getBean(RepeatedStringMatch.class);
//        repeatedStringMatch.test();
//        MinStack minStack = context.getBean(MinStack.class);
//        minStack.test();
//        LongestUnivaluePath longestUnivaluePath = context.getBean(LongestUnivaluePath.class);
//        longestUnivaluePath.test();
//        SubTreeOfAnthoerTree subTreeOfAnthoerTree = context.getBean(SubTreeOfAnthoerTree.class);
//        subTreeOfAnthoerTree.test();
//        LetterCasePermutation letterCasePermutation = context.getBean(LetterCasePermutation.class);
//        letterCasePermutation.test();
//        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = context.getBean(AverageOfLevelsInBinaryTree.class);
//        averageOfLevelsInBinaryTree.test();
//        TwoSumIV twoSumIV = context.getBean(TwoSumIV.class);
//        twoSumIV.test();
//        ExcelSheetColumnTitle excelSheetColumnTitle = context.getBean(ExcelSheetColumnTitle.class);
//        excelSheetColumnTitle.test();
//        MissingNumber missingNumber = context.getBean(MissingNumber.class);
//        missingNumber.test();
//        SumOfLeftLeaves sumOfLeftLeaves = context.getBean(SumOfLeftLeaves.class);
//        sumOfLeftLeaves.test();
//        PalindromeLinkedList palindromeLinkedList = context.getBean(PalindromeLinkedList.class);
//        palindromeLinkedList.test();
//        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = context.getBean(RemoveDuplicatesFromSortedArray.class);
//        removeDuplicatesFromSortedArray.test();
//        HammingDistance hammingDistance = context.getBean(HammingDistance.class);
//        hammingDistance.test();
//        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = context.getBean(LowestCommonAncestorOfABinarySearchTree.class);
//        lowestCommonAncestorOfABinarySearchTree.test();
//        ThreeSum threeSum = context.getBean(ThreeSum.class);
//        threeSum.test();
//        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = context.getBean(SerializeAndDeserializeBinaryTree.class);
//        serializeAndDeserializeBinaryTree.test();
//        DecodeWays decodeWays = context.getBean(DecodeWays.class);
//        decodeWays.test();
//        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = context.getBean(LetterCombinationsOfAPhoneNumber.class);
//        letterCombinationsOfAPhoneNumber.test();
//        TaskScheduler taskScheduler = context.getBean(TaskScheduler.class);
//        taskScheduler.test();
//        RemoveInvalidParenthese removeInvalidParenthese = context.getBean(RemoveInvalidParenthese.class);
//        removeInvalidParenthese.test();
//        SqrtX sqrtX = context.getBean(SqrtX.class);
//        sqrtX.test();
//        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = context.getBean(LongestContinuousIncreasingSubsequence.class);
//        longestContinuousIncreasingSubsequence.test();
//        GoatLatin goatLatin = context.getBean(GoatLatin.class);
//        goatLatin.test();
//        ImplementStrStr implementStrStr = context.getBean(ImplementStrStr.class);
//        implementStrStr.test();
//        CountAndSay countAndSay = context.getBean(CountAndSay.class);
//        countAndSay.test();
//        ValidParentheses validParentheses = context.getBean(ValidParentheses.class);
//        validParentheses.test();
//        ReverseLinkedList reverseLinkedList = context.getBean(ReverseLinkedList.class);
//        reverseLinkedList.test();
//        RomanToInteger romanToInteger = context.getBean(RomanToInteger.class);
//        romanToInteger.test();
//        MergeSortedArray mergeSortedArray = context.getBean(MergeSortedArray.class);
//        mergeSortedArray.test();
//        TwoSum twoSum = context.getBean(TwoSum.class);
//        twoSum.test();
//        ValidPalindrome validPalindrome = context.getBean(ValidPalindrome.class);
//        validPalindrome.test();
//        BinaryTreePaths binaryTreePaths = context.getBean(BinaryTreePaths.class);
//        binaryTreePaths.test();
//        ValidPalindromeII validPalindromeII = context.getBean(ValidPalindromeII.class);
//        validPalindromeII.test();
//        FirstBadVersion firstBadVersion = context.getBean(FirstBadVersion.class);
//        firstBadVersion.test();
//        DiameterOfBinaryTree diameterOfBinaryTree = context.getBean(DiameterOfBinaryTree.class);
//        diameterOfBinaryTree.test();
//        AddBinary addBinary = context.getBean(AddBinary.class);
//        addBinary.test();
//        MoveZeroes moveZeroes = context.getBean(MoveZeroes.class);
//        moveZeroes.test();
//        MagicSquaresInGrid magicSquaresInGrid = context.getBean(MagicSquaresInGrid.class);
//        magicSquaresInGrid.test();
//        GuessNumberHigherOrLower guessNumberHigherOrLower = context.getBean(GuessNumberHigherOrLower.class);
//        guessNumberHigherOrLower.test();
//        FindModeInBinarySearchTree findModeInBinarySearchTree = context.getBean(FindModeInBinarySearchTree.class);
//        findModeInBinarySearchTree.test();
//        MaximumAverageSubarrayI maximumAverageSubarrayI = context.getBean(MaximumAverageSubarrayI.class);
//        maximumAverageSubarrayI.test();
//        RepeatedSubstringPattern repeatedSubstringPattern = context.getBean(RepeatedSubstringPattern.class);
//        repeatedSubstringPattern.test();
//        MaximizeDistanceToClosestPerson maximizeDistanceToClosestPerson = context.getBean(MaximizeDistanceToClosestPerson.class);
//        maximizeDistanceToClosestPerson.test();
//        LicenseKeyFormatting licenseKeyFormatting = context.getBean(LicenseKeyFormatting.class);
//        licenseKeyFormatting.test();
//        ReverseVowelsOfAString reverseVowelsOfAString = context.getBean(ReverseVowelsOfAString.class);
//        reverseVowelsOfAString.test();
//        PowerOfTwo powerOfTwo = context.getBean(PowerOfTwo.class);
//        powerOfTwo.test();
//        LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers = context.getBean(LargestNumberAtLeastTwiceOfOthers.class);
//        largestNumberAtLeastTwiceOfOthers.test();
//        AddStrings addStrings = context.getBean(AddStrings.class);
//        addStrings.test();
//        BinaryTreePaths binaryTreePaths = context.getBean(BinaryTreePaths.class);
//        binaryTreePaths.test();
//        ReverseStringII reverseStringII = context.getBean(ReverseStringII.class);
//        reverseStringII.test();
//        BinaryWatch binaryWatch = context.getBean(BinaryWatch.class);
//        binaryWatch.test();
//        BinaryWatch binaryWatch = new BinaryWatch();
//        binaryWatch.test();
//        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
//        searchA2DMatrix.test();
//        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
//        diameterOfBinaryTree.test();
//        LongestPalindrome longestPalindrome = new LongestPalindrome();
//        longestPalindrome.test();
//        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
//        backspaceStringCompare.test();
//        PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();
//        positionsOfLargeGroups.test();
//        RelativeRanks relativeRanks = new RelativeRanks();
//        relativeRanks.test();
//        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
//        numberOfBoomerangs.test();
//        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
//        firstUniqueCharacterInAString.test();
//        MinimumDistanceBetweenBSTNodes minimumDistanceBetweenBSTNodes = new MinimumDistanceBetweenBSTNodes();
//        minimumDistanceBetweenBSTNodes.test();
//        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST();
//        minimumAbsoluteDifferenceInBST.test();
//        SimilarRGBColor similarRGBColor = new SimilarRGBColor();
//        similarRGBColor.test();
//        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
//        invertBinaryTree.test();
//        FlippingAnImage flippingAnImage = new FlippingAnImage();
//        flippingAnImage.test();
//        PascalsTriangle pascalsTriangle = new PascalsTriangle();
//        pascalsTriangle.test();
//        PathSum pathSum = new PathSum();
//        pathSum.test();
        // MinimumDepthofBinaryTree minimumDepthofBinaryTree = new MinimumDepthofBinaryTree();
        // minimumDepthofBinaryTree.test();
        // BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        // balancedBinaryTree.test();
        // ConvertSortedArraytoBST convertSortedArraytoBST = new ConvertSortedArraytoBST();
        // convertSortedArraytoBST.test();
        // InnerClassExamples.testHello();
        // BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        // binaryTreeLevelOrderTraversalII.test();
        // MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        // maximumDepthOfBinaryTree.test();
        // EliminationGame eliminationGame = new EliminationGame();
        // eliminationGame.test();
        // SymmetricTree symmetricTree = new SymmetricTree();
        // symmetricTree.test();
        // SameTree sameTree = new SameTree();
        // sameTree.test();
        // MergeSortedArray mergeSortedArray = new MergeSortedArray();
        // mergeSortedArray.test();
        // RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        // removeDuplicatesFromSortedList.test();
        // RemoveElements removeElements = new RemoveElements();
        // removeElements.test();
        // MaximumSubarray maximumSubarray = new MaximumSubarray();
        // maximumSubarray.test();
        // PlusOne plusOne = new PlusOne();
        // plusOne.test();
        // AddBinary addBinary = new AddBinary();
        // addBinary.test();        
        // ClimbingStairs climbingStairs = new ClimbingStairs();
        // climbingStairs.test();

    }

}