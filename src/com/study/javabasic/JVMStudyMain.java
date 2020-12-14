package com.study.javabasic;

public class JVMStudyMain {
    int AAA; // instance valiable
    int BBB;

    static int CCC;

    int method(){ // instance method
        return AAA + BBB + CCC;
    } // end instance method

    static int add(int AAA, int BBB){ // class method
        return AAA + BBB + CCC;
    }

} // Class Area

/**
 * Class Methods can only use class variables
 * Instance Methods can use Class Methods and Instance valiables
 * */