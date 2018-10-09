package com.baz.app.facebook.hard;

public class ReadNCharsGivenRead4II_CallMultipleTimes {

    /**
     * The API: int read4(char *buf) reads 4 characters at a time from a file.
     * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
     * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
     *
     * Note:
     * The read function may be called multiple times.
     *
     * Example 1:
     * Given buf = "abc"
     * read("abc", 1) // returns "a"
     * read("abc", 2); // returns "bc"
     * read("abc", 1); // returns ""
     * Example 2:
     * Given buf = "abc"
     * read("abc", 4) // returns "abc"
     * read("abc", 1); // returns ""
     */

    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buffer = new char[4];
    public int read(char[] buf, int n){
        // keep tracking #char already read
        int ptr = 0;
        // loop
        while (ptr < n){
            // buffPtr equals to 0 means that nothing in buffer now, need to call read4
            if(buffPtr == 0){
                buffCnt = read4(buffer);
            }
            // buffCnt == 0 means, after calling read4, nothing remained, so, can't read any more
            if(buffCnt == 0) break;
            // loop to read from buffer
            while (ptr < n && buffPtr < buffCnt){
                buf[ptr ++] = buffer[buffPtr ++];
            }
            // after read from buffer, if buffPtr >= buffCnt, asign it to 0
            if(buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }

    public int read4(char[] buff){
        return 0;
    }

}
