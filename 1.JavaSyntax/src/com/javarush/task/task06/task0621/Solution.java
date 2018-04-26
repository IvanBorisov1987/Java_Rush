package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
Родственные связи кошек
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName, null, null);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName, null, null);


        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother, null);


        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentMother;
        private Cat parentFather;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentMother, Cat parentFather) {
            this.name = name;
            this.parentMother = parentMother;
            this.parentFather = parentFather;
        }

        @Override
        public String toString() {
            if (parentMother == null && parentFather == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (parentFather == null)
                return "Cat name is " + name + ", no father, mother is " + parentMother.name;
            else if (parentMother == null)
                return "Cat name is " + name + ", no mother, father is " + parentFather.name;
            else
                return "Cat name is " + name + ", mother is " + parentMother.name + ", father is " + parentFather.name;
        }
    }
}