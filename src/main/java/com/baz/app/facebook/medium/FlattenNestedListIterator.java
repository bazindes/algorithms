package com.baz.app.facebook.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {

    private class NestedInteger{
        Integer i;
        List<NestedInteger> list;

        public Integer getInteger(){
            return i;
        }

        public List<NestedInteger> getList(){
            return list;
        }

        public boolean isInteger(){
            if( i != null )
                return true;
            else
                return false;
        }

        public NestedInteger(){
            i = 0;
            list = new ArrayList<>();
        }

        public NestedInteger(Integer i, List<NestedInteger> list){
            this.i = i;
            this.list = list;
        }
    }


    Stack<NestedInteger> stack;
    public FlattenNestedListIterator(){}

    public void set(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0 ; i--) {
            stack.push(nestedList.get(i));
        }
    }

    public Integer next() {
        return stack.pop().getInteger();
    }


    public boolean hasNext() {
        while (!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if(cur.isInteger()){
                return true;
            }
            stack.pop();
            for (int i = cur.getList().size() - 1; i >=0 ; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }

    public void test(FlattenNestedListIterator flattenNestedListIterator){
        List<NestedInteger> index0List = new ArrayList<>();
        NestedInteger index0i0 = new NestedInteger(1, null);
        NestedInteger index0i1 = new NestedInteger(1, null);
        index0List.add(index0i0);
        index0List.add(index0i1);
        NestedInteger index0 = new NestedInteger(null, index0List);
        NestedInteger index1 = new NestedInteger(2, null);
        List<NestedInteger> index2List = new ArrayList<>();
        NestedInteger index2i0 = new NestedInteger(1, null);
        NestedInteger index2i1 = new NestedInteger(1, null);
        index2List.add(index2i0);
        index2List.add(index2i1);
        NestedInteger index2 = new NestedInteger(null, index2List);
        List<NestedInteger> list = new ArrayList<>();
        list.add(index0);
        list.add(index1);
        list.add(index2);

        flattenNestedListIterator.set(list);
        while (flattenNestedListIterator.hasNext()){
            System.out.println(flattenNestedListIterator.next());
        }
    }

}
