package com.baz.app;
import com.baz.app.facebook.easy.*;
import com.baz.app.facebook.easy.BinaryTreePaths;
import com.baz.app.facebook.easy.DiameterOfBinaryTree;
import com.baz.app.google.easy.*;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.MouseEvent;

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

        ImplementStrStr implementStrStr = context.getBean(ImplementStrStr.class);
        implementStrStr.test();
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