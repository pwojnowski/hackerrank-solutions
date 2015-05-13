(ns poligon.hackerrank-test
  (:require [clojure.test :refer :all]
            [poligon.hackerrank :refer :all]))

(deftest utopian-tree-size-test
  (testing "Size of utopian tree after given number of seasons"
    (are [x y] (= x y)
         1 (utopian-tree-size 0)       ; starts with 1 meter
         2 (utopian-tree-size 1)       ; monsoon season = size * 2
         3 (utopian-tree-size 2)       ; m + s
         6 (utopian-tree-size 3)       ; m + s + m
         7 (utopian-tree-size 4)       ; m + s + m + s
         14 (utopian-tree-size 5))))   ; m + s + m + s + m

(deftest game-of-thrones-test
  (testing "Can create a palindrome from a string"
    (are [expected actual] (= expected actual)
         "YES" (game-of-thrones "a")
         "YES" (game-of-thrones "aa")
         "YES" (game-of-thrones "aaa")
         "YES" (game-of-thrones "aab")
         "YES" (game-of-thrones "aabb")
         "YES" (game-of-thrones "aabbb")
         "NO"  (game-of-thrones "ab")
         "NO"  (game-of-thrones "abc")
         "NO"  (game-of-thrones "abbc")
         "NO"  (game-of-thrones "cdefghmnopqrstuvw")
         "YES" (game-of-thrones "cdcdcdcdeeeef"))))

(deftest is-fibo-test
  (testing "If number is Fibonacci number"
    (are [expected actual] (= expected actual)
         "IsFibo" (is-fibo 0)
         "IsFibo" (is-fibo 1)
         "IsFibo" (is-fibo 2)
         "IsFibo" (is-fibo 3)
         "IsNotFibo" (is-fibo 4)
         "IsFibo" (is-fibo 5)
         "IsNotFibo" (is-fibo 6)
         "IsNotFibo" (is-fibo 7)
         "IsFibo" (is-fibo 8))))

(deftest lonely-integer-test
  (testing "Finding a number without a pair"
    (are [expected actual] (= expected actual)
         "1" (lonely-integer ["1"])
         "2" (lonely-integer ["1" "1" "2"])
         "2" (lonely-integer ["0" "0" "1" "2" "1"]))))

(deftest alternating-characters-test
  (testing "Find minimum number of deletions"
    (are [expected actual] (= expected actual)
         3 (alternating-characters ["AAAA"])
         4 (alternating-characters ["BBBBB"])
         0 (alternating-characters ["ABABABAB"])
         0 (alternating-characters ["BABABA"])
         4 (alternating-characters ["AAABBB"]))))

(deftest flipping-bits-test
  (testing "Flip bits on unsigned number"
    (are [expected actual] (= expected actual)
         2147483648 (flipping-bits 2147483647)
         4294967294 (flipping-bits 1)
         4294967295 (flipping-bits 0))))

(deftest maximizing-xor-test
  (are [expected actual] (= expected actual)
       0 (maximizing-xor 10 10)
       7 (maximizing-xor 10 15)
       15 (maximizing-xor 1 10)))

(deftest angry-professor-test
  (are [expected actual] (= expected actual)
       "YES" (angry-professor 3 [-1 -3 4 2])
       "NO" (angry-professor 2 [0 -1 2 1])))
